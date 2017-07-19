/**
 * Copyright 2017 yourcompany.
 * 本ソースファイルの著作権は株式会社yourcompanyに所属します。
 * 株式会社yourcompanyの許可なくして、本ソースファイルの
 * 配布、改修、コピー、利用を禁止します。
 * 会社名				：株式会社yourcompany
 * 組織名				：システム開発部
 * プロジェクトコード	：education
 * バージョン			：1.0
 * 最終更新日時			：2017/03/07 20:00
 */
package jp.co.yourcompany.education.order.dto;

/**
 * 購入確定前の警告情報１商品分を管理するクラス
 * @author 雷太
 *
 */
public class OrderCheckResult {

	/**
	 * 商品コード
	 */
	private String itemCd;

	/**
	 * 警告コード
	 */
	private String warnningCd;

	/**
	 * 警告情報
	 */
	private String warnningMessage;

	/**
	 * 商品コードを取得する
	 * @return itemCd 商品コード
	 */
	public String getItemCd() {
		return itemCd;
	}

	/**
	 * 商品コードに値を設定する。
	 * @param itemCd 商品コード
	 */
	public void setItemCd(String itemCd) {
		this.itemCd = itemCd;
	}

	/**
	 * 警告コードを取得する
	 * @return warnningCd 警告コード
	 */
	public String getWarnningCd() {
		return warnningCd;
	}

	/**
	 * 警告コードに値を設定する。
	 * @param warnningCd 警告コード
	 */
	public void setWarnningCd(String warnningCd) {
		this.warnningCd = warnningCd;
	}

	/**
	 * 警告情報を取得する
	 * @return warnningMessage 警告情報
	 */
	public String getWarnningMessage() {
		return warnningMessage;
	}

	/**
	 * 警告情報を設定する。
	 * @param warnningMessage 警告情報
	 */
	public void setWarnningMessage(String warnningMessage) {
		this.warnningMessage = warnningMessage;
	}

}
