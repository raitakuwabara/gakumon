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
 * staticのサンプル1
 * @author raita.kuwabara
 */
public class StaticSample {

	/**
	 * 生成されたインスタンスのカウント
	 */
	private static int staticCount = 0;

	/**
	 * 違いがわかるようにstaticでないカウント
	 */
	private int count = 0;


	/**
	 * デフォルトコンストラクタ
	 */
	public StaticSample(){
		staticIncrement();
		increment();
	}

	/**
	 * staticカウントのインクリメント
	 */
	public void staticIncrement(){
		staticCount++;
	}

	/**
	 * カウントのインクリメント
	 */
	public void increment(){
		count++;
	}

	/**
	 * staticカウンターの取得
	 * @return staticCount
	 */
	public int getStaticCount(){
		return staticCount;
	}


	/**
	 * カウンターの取得
	 * @return count
	 */
	public int getCount(){
		return count;
	}

	/**
	 * javaコマンドから実行されるmainメソッド
	 * @param args 引数不要
	 */
	public static final void main( String[] args ){

		StaticSample sample1 = new StaticSample();
		System.out.println("sample1.staticCounter:" + sample1.getStaticCount() );
		System.out.println("sample2.Counter      :" + sample1.getCount() );

		StaticSample sample2 = new StaticSample();
		System.out.println("sample2.staticCounter:" + sample2.getStaticCount() );
		System.out.println("sample2.Counter      :" + sample2.getCount() );


		System.out.println("incriment counter");
		sample2.staticIncrement();
		sample2.increment();

		System.out.println("sample1.staticCounter:" + sample1.getStaticCount() );
		System.out.println("sample1.Counter      :" + sample1.getCount() );
		System.out.println("sample2.staticCounter:" + sample2.getStaticCount() );
		System.out.println("sample2.Counter      :" + sample2.getCount() );

	}

}
