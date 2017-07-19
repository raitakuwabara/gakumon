package jp.co.yourcompany.education.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 非同期用カウンタークラス
 */
public class SummaryCounter {

	private AtomicInteger counter = new AtomicInteger( 0 );

	/**
	 * カウンターをインクリメントし、
	 * その値を呼び出し元に戻す。
	 * @return
	 */
	public synchronized int inclrement( ){
		return counter.getAndIncrement();
	}
}
