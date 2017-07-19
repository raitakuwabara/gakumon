/**
 * Copyright 2017 yourcompany.
 * 本ソースファイルの著作権は株式会社yourcompanyに所属します。
 * 株式会社yourcompanyの許可なくして、本ソースファイルの
 * 配布、改修、コピー、利用を禁止します。
 * 会社名				：株式会社yourcompany
 * 組織名				：システム開発部
 * プロジェクトコード	：education
 * バージョン			：1.0
 * 最終更新日時			：2017/02/10 17:21
 */
package jp.co.yourcompany.education.samples;

/**
 * このクラスは継承関係を理解するための子クラスです。
 * @author raita.kuwabara
 */
public class ChildSamples extends HowToWriteJava {

	/**
	 * メッセージを親クラスで指定したメッセージで初期化する。
	 */
	public ChildSamples(){
		super();
		System.out.println("子クラスのデフォルトコンストラクタが実行されました");
	}

	/**
	 * デフォルトコンストラクタ
	 * 指定したメッセージを出力する。
	 * @param message メッセージ
	 */
	public ChildSamples( String message ){
		super( message );
		System.out.println("子クラスの引数付きコンストラクタが実行されました");
	}

	/**
	 * javaコマンドで起動されるmainメソッド
	 * @param args javaコマンドで引き渡しされる引数
	 */
	public static void main( String[] args ) {
		//sample1-1 デフォルトのメッセージ
		ChildSamples childSamples = new ChildSamples();
		childSamples.outputMessage();

		//sample1-2 outputErrorMessageが実行されるケース
		childSamples.init();
		childSamples.outputMessage();

		//sample2 引数を渡すケース
		ChildSamples childSamples2 = new ChildSamples("子クラスのインスタンス2のHello");
		childSamples2.outputMessage();

		//sample3
		HowToWriteJava.outputClassMessage();
	}
}
