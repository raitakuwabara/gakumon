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

//package宣言部
package jp.co.yourcompany.education.samples;

//import 宣言部
/**
 *
 * このクラスは、Javaの全体の構成を分かり易くした
 * 標準出力にメッセージを出力するクラスです。
 *
 * @author Raita.Kuwabara
 *
 */
public class HowToWriteJava {

	//定数宣言部

	/**
	 * デフォルト値として設定されるメッセージ
	 */
	public static final String MESSAGE_DEFAULT_JA = "こんにちは　日本へ";

	/**
	 * エラーメッセージ
	 */
	public static final String MESSAGE_ERROR_JA = "メッセージが指定されていません。";

	/**
	 * 主処理の終了メッセージ
	 */
	public static final String MESSAGE_END_JA = "-------- END outputMessage method------------";

	//static実行部 今は気にしない

	//メンバーフィールド宣言部
	protected String message;

	/**
	 * デフォルトコンストラクタ
	 */
	public HowToWriteJava() {
		message = MESSAGE_DEFAULT_JA;
	}

	/**
	 * デフォルトコンストラクタ
	 * 指定したメッセージをmessageフィールドに初期設定する。
	 *
	 * @param message 出力するメッセージ
	 */
	public HowToWriteJava( String message ) {
		//クラスのメンバフィールドに値を設定しています。
		this.message = message;
	}

	/**
	 * 主処理
	 * messageプロパティに設定されたメッセージを出力します。
	 */
	public void outputMessage() {

		if( isNotNullMessage() ){
			outputCurrentMessage();
		} else {
			outputErrorMessage();
		}
		outputEndMessage();
	}


	/**
	 * メッセージを初期化する。
	 */
	protected void init() {
		message = null;
	}

	/**
	 * メッセージフィールドのメッセージがnullでないことをチェックする。
	 * @return true:値あり false:値なし
	 */
	protected boolean isNotNullMessage() {
		return ( message != null );
	}

	/**
	 * messageフィールドに設定された文字列を出力する。
	 */
	protected void outputCurrentMessage() {
		System.out.println( message );
	}

	/**
	 * エラーメッセージを出力する。
	 */
	protected void outputErrorMessage(){
		System.out.println( MESSAGE_ERROR_JA );
	}

	/**
	 * 主処理終了時のメッセージを出力する。
	 * @return true:値あり false:値なし
	 */
	protected void outputEndMessage() {
		System.out.println( MESSAGE_END_JA );
	}

	/**
	 * 決まったユーティリティのような定型の関数のようなメソッドだけをstaticにする。
	 * クラスメソッド(静的メソッド)の例
	 * クラスの定型メッセージを出力します。
	 */
	public static void outputClassMessage() {
		System.out.println( HowToWriteJava.MESSAGE_DEFAULT_JA );
	}


	/**
	 * javaコマンドで起動されるmainメソッド
	 * @param args javaコマンドで引き渡しされる引数
	 */
	public static void main( String[] args ) {

		//sample1-1 デフォルトのメッセージ
		HowToWriteJava howToWriteJava = new HowToWriteJava();
		howToWriteJava.outputMessage();

		//sample1-2 outputErrorMessageが実行されるケース
		howToWriteJava.init();
		howToWriteJava.outputMessage();

		//sample2 引数を渡すケース
		HowToWriteJava howToWriteJava2 = new HowToWriteJava("インスタンス2のHello");
		howToWriteJava2.outputMessage();

		//sample3
		HowToWriteJava.outputClassMessage();
	}
}