/**
 * Copyright 2017 yourcompany.
 * 本ソースファイルの著作権は株式会社yourcompanyに所属します。
 * 株式会社hogeの許可なくして、本ソースファイルの
 * 配布、改修、コピー、利用を禁止します。
 * 会社名				：株式会社yourcompany
 * 組織名				：システム開発部
 * プロジェクトコード	：education
 * バージョン			：1.0
 * 最終更新日時			：2017/03/09
 */
package jp.co.yourcompany.education.samples;

/**
 * 内部クラスのサンプル
 * @author raita.kuawabara
 */
public class InnerClassSample {

	private int outerCounter = 0;

	/**
	 *  outerCounterのインクリメント
	 */
	public void outerIncrement(){
		outerCounter++;
	}

	/**
	 * outerCounterを取得する
	 * @return outerCounter;
	 */
	public int getOuterCounter(){
		return outerCounter;
	}


	/**
	 * インナークラス
	 * @author 雷太
	 *
	 */
	class InnerClass {
		private int innerCounter = 0;

		/**
		 * インナークラスからouterクラスのインクリメント
		 */
		public void outerIncrementByInner(){
			outerCounter++;
		}
		/**
		 *  innerCounterのインクリメント
		 */
		public void innerIncrement(){
			innerCounter++;
		}
		/**
		 *  innerCounterを取得する
		 *  @return innerCounter
		 */
		public int getInnerCounter(){
			return innerCounter;
		}
	}

	/**
	 * javaコマンドから実行するクラス
	 */
	public static void main( String[] args ){
		//sample
		InnerClassSample sample = new InnerClassSample();
		InnerClass inner = sample.new InnerClass();

		System.out.println("outerCounter:" + sample.getOuterCounter() );
		sample.outerIncrement();
		System.out.println("sample2.outerIncrement();" );
		System.out.println("outerCounter:" + sample.getOuterCounter() );
		inner.outerIncrementByInner();
		System.out.println("inner.outerIncrementByInner();" );
		System.out.println("outerCounter:" + sample.getOuterCounter() );

		System.out.println("innerCounter:" + inner.getInnerCounter() );
		inner.innerIncrement();
		System.out.println("inner.innerIncrement" );
		System.out.println("innerCounter:" + inner.getInnerCounter() );
	}
}
