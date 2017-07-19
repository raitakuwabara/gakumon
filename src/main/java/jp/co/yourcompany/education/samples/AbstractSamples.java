/**
 * Copyright 2017 yourcompany.
 * 本ソースファイルの著作権は株式会社yourcompanyに所属します。
 * 株式会社hogeの許可なくして、本ソースファイルの
 * 配布、改修、コピー、利用を禁止します。
 * 会社名				：株式会社yourcompany
 * 組織名				：システム開発部
 * プロジェクトコード	：education
 * バージョン			：1.0
 * 最終更新日時			：2017/02/10 17:21
 */

//package宣言部
package jp.co.yourcompany.education.samples;


/**
 * 抽象クラスサンプル
 * @author Raita.Kuwabara
 *
 */
public abstract class AbstractSamples {

	/**
	 * 継承した子クラスのサンプルを全て実行する
	 */
	protected abstract void execAllSamples();

	//---------------------------------------- サンプル実行出力開始・終了用

	/**
	 * メソッド共通の開始文の定型出力
	 * @param methodName 出力するメソッド名
	 */
	protected void outputStartMethod( String methodName ) {
		System.out.println("----- " + methodName + " START -----");
	}

	/**
	 * メソッド共通の開始文の定型出力
	 * @param methodName 出力するメソッド名
	 */
	protected void outputEndMethod( String methodName ) {
		System.out.println("----- " + methodName + " END -----");
	}
}