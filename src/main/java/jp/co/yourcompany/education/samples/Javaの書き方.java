/**
 * Copyright 2017 hoge.
 * 本ソースファイルの著作権は株式会社hogeに所属します。
 * 株式会社hogeの許可なくして、本ソースファイルの
 * 配布、改修、コピー、利用を禁止します。
 * 会社名				：株式会社hoge
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
public class Javaの書き方 {

	//定数宣言部

	/**
	 * デフォルト値として設定されるメッセージ
	 */
	public static final String 固定値_デフォルト_メッセージ = "こんにちは　日本へ";

	/**
	 * エラーメッセージ
	 */
	public static final String 固定値_エラー_メッセージ = "メッセージが指定されていません。";

	/**
	 * 主処理の終了メッセージ
	 */
	public static final String 固定値_終了_メッセージ = "-------- END outputMessage method------------";


	//static実行部 今は気にしない
	
	//クラスのメンバ変数宣言部
	private String メッセージ;

	/**
	 * デフォルトコンストラクタ
	 */
	public Javaの書き方() {
		メッセージ = 固定値_デフォルト_メッセージ;
	}

	/**
	 * デフォルトコンストラクタ
	 * 指定したメッセージをmessageプロパティに初期設定する。
	 *
	 * @param message 出力するメッセージ
	 */
	public Javaの書き方( String メッセージ ) {
		//クラスのプライベートメソッドに値を設定しています。
		this.メッセージ = メッセージ;
	}

	/**
	 * 主処理
	 * messageプロパティに設定されたメッセージを出力します。
	 */
	public void メッセージ出力() {

		if( メッセージの値設定有() ){
			現状のメッセージ出力();
		} else {
			エラーメッセージ出力();
		}

		終了メッセージ出力();

	}

	
	/**
	 * メッセージを初期化する。
	 */
	private void 初期化(){
		メッセージ = null;
	}

	/**
	 * プライベートプロパティのメッセージがnullでないことをチェックする。
	 * @return true:値あり false:値なし
	 */
	private boolean メッセージの値設定有(){
		return (メッセージ != null);
	}

	/**
	 * messageプロパティに設定された文字列を出力する。
	 */
	private void 現状のメッセージ出力(){
		System.out.println( メッセージ );
	}

	/**
	 * エラーメッセージを出力する。
	 */
	private void エラーメッセージ出力(){
		System.out.println( 固定値_エラー_メッセージ );
	}

	/**
	 * 主処理終了時のメッセージを出力する。
	 * @return true:値あり false:値なし
	 */
	private void 終了メッセージ出力(){
		System.out.println( 固定値_終了_メッセージ );
	}

	/**
	 * 決まったユーティリティのような定型の関数のようなメソッドだけをstaticにする。
	 * クラスメソッド(静的メソッドの例)の例
	 * messageプロパティに設定されたメッセージを出力します。
	 */
	public static void クラスメッセージ出力() {

		System.out.println( Javaの書き方.固定値_デフォルト_メッセージ );

	}
	
	
	/**
	 * javaコマンドで起動されるmainメソッド
	 * @param args
	 */
	public static void main(String[] args) {
		//sample1-1 デフォルトのメッセージ
		Javaの書き方 インスタンス１ = new Javaの書き方( );
		インスタンス１.メッセージ出力();

		//sample1-2 outputErrorMessageが実行されるケース
		インスタンス１.初期化();
		インスタンス１.メッセージ出力();

		//sample2 引数を渡すケース
		Javaの書き方 インスタンス２ = new Javaの書き方("インスタンス2のHello");
		インスタンス２.メッセージ出力();
		
		//sample3
		Javaの書き方.クラスメッセージ出力();
	}
}