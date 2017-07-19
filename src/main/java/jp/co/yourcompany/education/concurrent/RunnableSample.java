package jp.co.yourcompany.education.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Runnable インターフェイスを学習するためのサンプル
 *
 * @raita.kuwabara
 */
public class RunnableSample implements Runnable {

	/**
	 * private
	 */
	private int id = 0;

	// 0.5秒周期
	private static final long SLEEP_MILLIONS = TimeUnit.MILLISECONDS.convert( 1000, TimeUnit.MILLISECONDS);

	/**
	 * スレッド別カウンター
	 */
	private AtomicInteger counter = new AtomicInteger(0);

	/**
	 * カウンターオブジェクト
	 */
	private SummaryCounter summaryCounter = null;

	/**
	 * コンストラクタ
	 */
	public RunnableSample(SummaryCounter summaryCounter, int id) {
		this.summaryCounter = summaryCounter;
		this.id = id;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep( SLEEP_MILLIONS );
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			increment();
			int summaryCount = summaryIncrement();
			outputCounter(summaryCount);
		}
	}

	/**
	 * それぞれのカウントをインクリメント
	 */
	private void increment() {
		counter.incrementAndGet();
	}

	/**
	 * SampleThreadクラスの全インスタンスのループ総数をインクリメントする。 インクリメントした数を出力する。
	 */
	private int summaryIncrement() {
		return summaryCounter.inclrement();
	}

	/**
	 * 出力
	 */
	private void outputCounter(int summaryCount) {
		System.out.println(Thread.currentThread().getName() + ":id[ " + id + " ] counter:" + counter);
		System.out.println(Thread.currentThread().getName() + ":id[ " + id + " ] summaryCounter:" + summaryCount);
	}

}
