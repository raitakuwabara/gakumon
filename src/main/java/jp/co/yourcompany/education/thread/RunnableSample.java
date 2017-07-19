
package jp.co.yourcompany.education.thread;

/**
 * Runnable インターフェイスを学習するためのサンプル
 * @raita.kuwabara
 */
public class RunnableSample implements Runnable {

	/**
	 * カレントスレッド名とidの整合性確認用
	 */
	private int id = -1;

	/**
	 * スレッド別カウンター
	 */
	private int counter = 0;

	/**
	 * カウンターオブジェクト
	 */
	private SummaryCounter summaryCounter = null;

	/**
	 * コンストラクタ
	 */
	public RunnableSample(SummaryCounter summaryCounter , int id ){
		this.summaryCounter = summaryCounter;
		this.id = id;
	}


	@Override
	public void run(){
		for( int i = 0 ; i < 5 ; i++ ){
			increment();
			summaryIncrement();
			outputCounter();
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
	private void summaryIncrement(){
		 summaryCounter.inclrement();
	}

    /**
     * 出力
     */
    private void outputCounter(){
		System.out.println( Thread.currentThread().getName() + ":id[ " + id + " ] counter:" + counter);
    }

	/**
	 * javaコマンドから起動されるmainメソッド
	 */
	public static final void main( String[] args ){

		SummaryCounter summaryCounter = new SummaryCounter();
		int threadCount = 100;
		Thread[] threadList = new Thread[threadCount];
		for( int i = 0 ; i < threadCount ; i ++){
			threadList[ i ] = new Thread( new RunnableSample( summaryCounter, i),  "Thread" + i );
			threadList[ i ].start();
		}
	}
}



