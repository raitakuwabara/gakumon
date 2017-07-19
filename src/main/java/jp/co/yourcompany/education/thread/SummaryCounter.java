package jp.co.yourcompany.education.thread;

/**
 * 非同期処理用学習クラス
 */
public class SummaryCounter {
	private int counter = 0;

	public void inclrement( ){
		counter++;
	}

	public int getCounter(){
		return counter;
	}
}
