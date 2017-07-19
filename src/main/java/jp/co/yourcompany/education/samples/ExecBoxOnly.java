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
 * 何も処理できません。
 *
 * @author Raita.Kuwabara
 *
 */
public class ExecBoxOnly {

	//定数宣言部

	/**
	 * 主処理の終了メッセージ
	 */
	public static final String MESSAGE_END_JA = "-------- END method------------";


	/**
	 * 主処理 BoxOnlyクラスのインスタンスを生成し終了メッセージを出力する。
	 */
	public void executeBoxOnly(){
		initBoxOnly();
		outputEndMessage();
	}
		
	/**
	 * BoxOnlyクラスのインスタンスを作成する。
	 */
	private void initBoxOnly(){
		BoxOnly boxonly = new BoxOnly();
	}
	
	/**
	 * 終了メッセージを出力する。
	 */
	private void outputEndMessage(){
		System.out.println( MESSAGE_END_JA );
	}
	
	
	/**
	 * javaコマンドで起動されるmainメソッド
	 * @param args javaコマンドでこのクラスに引き渡しされる実行引数
	 */
	public static void main( String[] args ) {
		ExecBoxOnly execBoxOnly = new ExecBoxOnly();
		execBoxOnly.executeBoxOnly();
	}
}