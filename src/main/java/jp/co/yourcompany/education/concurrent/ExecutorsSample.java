package jp.co.yourcompany.education.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * ExecutorsSampleクラスを用いたサンプル
 * @param
 */
public class ExecutorsSample {

	/**
	 * ロガーインスタンスの生成
	 * このようにロガーは、クラスメンバーフィールド(static)で定義します。
	 */
	public static final Logger log = Logger.getLogger( ExecutorsSample.class.getName() );

	/**
	 * 全体のスレッドの実行を管理するtaskを管理するサービス
	 */

	//----------------------------------------------------------------------- Service init


	/**
	 * newSingleThreadExecutorを確認するサンプル
	 * @param factory ThreadFactory(ワーカースレッドを変更したい場合引き渡す。) <br>
	 *         null 指定時には、デフォルトのワーカースレッドが利用されます。
	 */
	public void execSingleThreadExecutor( ThreadFactory factory ) {
		ExecutorService executorService = null;
		log.info("newSingleThreadExecutor START");

		//サイズ制限のない１つのThreadExecutor();
		if( factory == null){
			executorService = Executors.newSingleThreadExecutor();
		} else {
			executorService = Executors.newSingleThreadExecutor( factory );
		}

		SummaryCounter summaryCounter = new SummaryCounter();

		for ( int i = 0 ; i < 100 ; i++ ){
			executorService.execute( new RunnableSample( summaryCounter , i ) );
		}
		log.info("newSingleThreadExecutor runnable");

		//taskが残存していない事を確認してサービスの終了
		if( executorService.isTerminated() ){
			executorService.shutdown();
			log.info("newSingleThreadExecutor ShutDown");
		}
		log.info("newSingleThreadExecutor END");

	}

	//--------------------------------------------------- new singleFactory

	/**
	 * newFixedThreadPool確認用メソッド
	 * スレッド数は、threadCountで変更して下さい。
	 * @param factory ThreadFactory(ワーカースレッドを変更したい場合引き渡す。) <br>
	 *         null 指定時には、デフォルトのワーカースレッドが利用されます。
	 */
	public void execNewFixedThreadPool( ThreadFactory threadFactory) {
		ExecutorService executorService = null;
		log.info("execnewFixedThreadPool START");

		final int  threadCount = 5;

		if( threadFactory == null ){
			executorService = Executors.newFixedThreadPool( threadCount );
		} else {
			executorService = Executors.newFixedThreadPool( threadCount, threadFactory );
		}

		SummaryCounter summaryCounter = new SummaryCounter();
		for ( int i = 0 ; i < 100 ; i++ ){
			executorService.execute( new RunnableSample( summaryCounter , i ) );
		}

		log.info("newSingleThreadExecutor runnable");

		//taskが残存していない事を確認してサービスの終了
		if( executorService.isTerminated() ){
			executorService.shutdown();
			log.info("newSingleThreadExecutor ShutDown");
		}
		log.info("newSingleThreadExecutor END");
	}

	//---------------------------------------------- ScheduledExecutorService

	/**
	 * newScheduledThreadPool確認用メソッド
	 * @param threadFactory
	 */
	public void execScheduledExecutorService( ThreadFactory threadFactory) {
		ScheduledExecutorService scheduledExecutorService = null;

		log.info("execScheduledExecutorService START");

		final int  threadCount = 2;

		if( threadFactory == null ){
			scheduledExecutorService = Executors.newScheduledThreadPool( threadCount );
		} else {
			scheduledExecutorService = Executors.newScheduledThreadPool( threadCount, threadFactory );
		}

		SummaryCounter summaryCounter = new SummaryCounter();

		//３，６、９、１２、１５・・・３０秒の待機時間のタスク
		for ( int i = 0 ; i < 10 ; i++  ) {
			int waitSeconds = 3 * ( 1 + i );
			scheduledExecutorService.schedule( new RunnableSample( summaryCounter , i ), waitSeconds ,  TimeUnit.SECONDS );
		}
		log.info("execScheduledExecutorService runnable");

		if( scheduledExecutorService.isTerminated() ){
			scheduledExecutorService.shutdown();
			log.info("execScheduledExecutorService ShutDown");
		}
		log.info("execScheduledExecutorService END");

	}

	public void sampleCachedThreadPool() {
		execCachedThreadPool( null );
	}
	public void sampleCachedThreadPool( ThreadFactory factory ) {
		execCachedThreadPool( factory );
	}

	/**
	 * cachedTreadPool
	 * @param threadFactory
	 */
	private void execCachedThreadPool( ThreadFactory threadFactory ){
		ExecutorService cachedThreadPool = null;
		log.info("execCachedThreadPool START");

		if( threadFactory == null ){
			cachedThreadPool = Executors.newCachedThreadPool( );
		} else {
			cachedThreadPool = Executors.newCachedThreadPool( threadFactory );
		}

		SummaryCounter summaryCounter = new SummaryCounter();

		for ( int i = 0 ; i < 3 ; i++  ) {
			cachedThreadPool.execute( new RunnableSample( summaryCounter , i ) );
		}

		try {
			//ここの間隔が、60秒以上だとThreadは常に作成される。
			Thread.sleep( 61000 );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for ( int i = 0 ; i < 3 ; i++  ) {
			cachedThreadPool.execute( new RunnableSample( summaryCounter , i ) );
		}
		log.info("execCachedThreadPool runnable");

		try {
			Thread.sleep( 10000 );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if( cachedThreadPool.isTerminated() ){
			cachedThreadPool.shutdown();
			log.info("execCachedThreadPool ShutDown");
		}
		log.info("execCachedThreadPool END");
	}


	public void sampleWorkStealingPool() {
		execWorkStealingPool( 0 );
	}
	public void sampleWorkStealingPool( int parallelism ) {
		execWorkStealingPool( parallelism );
	}

	/**
	 * cachedTreadPool
	 * @param threadFactory
	 */
	private void execWorkStealingPool(   int parallelism ){
		ExecutorService workStealingPool = null;
		log.info("execCachedThreadPool START");

		if( parallelism == 0 ){
			workStealingPool = Executors.newWorkStealingPool( );
		} else {
			workStealingPool = Executors.newWorkStealingPool( parallelism );
		}

		SummaryCounter summaryCounter = new SummaryCounter();
		/**
		 * ここでの遅延時間は、現在時間～指定した感覚まで、scheduedExecutorService.sechdule内のスレッドを待機される。
		 * ※.１タスクの間隔ではない点注意すること。
		 */


		for ( int i = 0 ; i < 100 ; i++  ) {
			workStealingPool.execute( new RunnableSample( summaryCounter , i ) );
		}

		try {
			Thread.sleep( 10000 );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if( workStealingPool.isTerminated() ){
			workStealingPool.shutdown();
			log.info("execCachedThreadPool ShutDown");
		}
		log.info("execCachedThreadPool END");
	}




	class SimpleThreadFactory implements ThreadFactory {
		public Thread newThread(Runnable r) {
			Thread thread = new Thread(r);
			log.info( "new TheadID:" + thread.getId());
			return thread;
		}
	}

	/**
	 *
	 */
	public static final void main ( String[] args){

		ExecutorsSample sample = new ExecutorsSample();
		//sample1
		//sample.sampleSingleThreadExecutor ( );

		//SimpleThreadFactory threadFactory = sample.new SimpleThreadFactory();
		//sample.sampleSingleThreadExecutor ( threadFactory );
		//sample.execNewFixedThreadPool( null );
		//sample.execScheduledExecutorService( null);
		sample.sampleCachedThreadPool( );
		//sample.sampleWorkStealingPool( 5 );

	}



}
