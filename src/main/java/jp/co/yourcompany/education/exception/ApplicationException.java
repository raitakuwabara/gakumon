/**
 * Copyright 2017 yourcompany.
 * 本ソースファイルの著作権は株式会社yourcompanyに所属します。
 * 株式会社yourcompanyの許可なくして、本ソースファイルの
 * 配布、改修、コピー、利用を禁止します。
 * 会社名				：株式会社yourcompany
 * 組織名				：システム開発部
 * プロジェクトコード	：education
 * バージョン			：1.0
 * 最終更新日時			：2017/03/14 18:00
 */
package jp.co.yourcompany.education.exception;

/**
 * 例外クラスのサンプル
 * @author raita.kuwabara
 */
public class ApplicationException extends Exception{

	/**
	 * デフォルトコンストラクタ
	 */
	public ApplicationException() {
		super();
	}

	/**
	 * デフォルトコンストラクタ
	 * @param e 例外
	 */
	public ApplicationException( Throwable e) {
		super( e );
	}

}
