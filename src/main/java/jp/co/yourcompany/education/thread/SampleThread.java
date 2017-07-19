
package jp.co.yourcompany.education.thread;

/**
 * Thread クラスを学習するためのサンプル
 * @raita.kuwabara
 */
public class SampleThread extends Thread {


	/**
	 * スレッドの停止時間(1000ミリ秒 = １秒)
	 */
	private static final long SLEEP_MILLIONS= 1;

	/**
	 * スレッド別カウンター
	 */
	private int counter = 0;

	/**
	 * カウンターオブジェクト
	 */
	private SummaryCounter summaryCounter = null;

	/**
	 * スレッドのコンストラクタ
	 * @param threadName スレッド名
	 * @param 総計用カウンターオブジェクト
	 */
	public SampleThread( String threadName  , SummaryCounter summaryCounter){
		super( threadName );
		this.summaryCounter = summaryCounter;
	}

	@Override
	public void run(){
		try {
			for( int i = 0 ; i < 5 ; i++ ){
				sleep( SLEEP_MILLIONS );
				increment();
				summaryIncrement();
				outputCounter();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * それぞれのカウントをインクリメント
	 */
	private void increment(){
		counter++;
	}

	/**
	 * SampleThreadクラスの全インスタンスのループ総数をインクリメントする。
	 * インクリメントした数を出力する。
	 */
	private  void summaryIncrement(){
		summaryCounter.inclrement();
		System.out.println( getName() + " summaryCounter:" + summaryCounter.getCounter());
	}

	/**
	 * 出力
	 */
	private void outputCounter(){
		System.out.println( getName() + " counter:" + counter);
	}


	/**
	 * javaコマンドから起動されるmainメソッド
	 */
	public static final void main( String[] args ){

		SummaryCounter summaryCounter = new SummaryCounter();
		int threadCount = 100;
		SampleThread[] threadList = new SampleThread[threadCount];
		for( int i = 0 ; i < threadCount ; i ++){
			threadList[ i ] = new SampleThread("Thread" + i , summaryCounter );
			threadList[ i ].start();
		}
	}
}



