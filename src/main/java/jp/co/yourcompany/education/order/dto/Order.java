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

import java.io.Serializable;

/**
 * 商品と注文情報を管理するオブジェクト
 * @author raita.kuwabara
 *
 */
public class Order implements Cloneable ,Serializable {

	/**
	 * 商品コード
	 */
	private String itemCd;

	/**
	 * 商品名
	 */
	private String itemName;

	/**
	 * 製造元
	 */
	private String manufacturer;

	/**
	 * 数量
	 */
	private Integer quantity;

	/**
	 * 定価
	 * 定価と販売値とカートに入れた販売値は異なります。
	 */
	private Integer listPrice;

	/**
	 * 現在の販売値
	 */
	private Integer nowPrice;

	/**
	 * オーダ日付
	 */
	private java.util.Date orderDate;

	/**
	 * ユーザID
	 */
	private String userId;


	/**
	 * デフォルトコンストラクタ
	 */
	public Order(){
	}


	/**
	 * オブジェクトのコピーを取得する。
	 */
	@Override
    public Order clone() {
		Order copyObj = null;
    	try {
			copyObj = ( Order ) super.clone();
			//ディープコピー オブジェクト型は明示しないと同じインスタンスを指してしまう。
			copyObj.setOrderDate( new java.util.Date( this.getOrderDate().getTime() ) );
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
        return copyObj;
    }


	/**
	 * 商品コードを返す
	 * @return itemCd 商品コード
	 */
	public String getItemCd() {
		return itemCd;
	}


	/**
	 * 商品コードを設定する。
	 * @param itemCd 商品コード
	 */
	public void setItemCd(String itemCd) {
		this.itemCd = itemCd;
	}

	/**
	 * 商品名を返す
	 * @return itemName 商品名
	 */
	public String getItemName() {
		return itemName;
	}


	/**
	 * 商品名を設定する。
	 * @param itemCd 商品名
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * 製造元を返す
	 * @return manufacturer 製造基
	 */
	public String getManufacturer() {
		return manufacturer;
	}


	/**
	 * 製造元を設定する。
	 * @param itemCd 製造元
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	/**
	 * 数量を取得する
	 * @return quantity 数量
	 */
	public Integer getQuantity() {
		return quantity;
	}


	/**
	 * 数量を設定する。
	 * @param quantity 数量
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	/**
	 * 定価を取得する
	 * @return listPrice 定価
	 */
	public Integer getListPrice() {
		return listPrice;
	}


	/**
	 * 定価を取得する
	 * @param listPrice セットする 定価
	 */
	public void setListPrice(Integer listPrice) {
		this.listPrice = listPrice;
	}

	/**
	 * 現在の販売値を返す。
	 * @return nowPrice
	 */
	public Integer getNowPrice() {
		return nowPrice;
	}


	/**
	 * 現在の販売値を設定する。
	 * @param listPrice セットする listPrice
	 */
	public void setNowPrice(Integer nowPrice) {
		this.nowPrice = nowPrice;
	}

	/**
	 * 注文日を取得する。
	 * @return oraderDate 注文日
	 */
	public java.util.Date getOrderDate() {
		return orderDate;
	}


	/**
	 * 注文日を設定する。
	 * @param oraderDate 注文日
	 */
	public void setOrderDate(java.util.Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * 利用者IDを取得する。
	 * @return userId 利用者ID
	 */
	public String getUserId() {
		return userId;
	}


	/**
	 * 利用者IDを設定する。
	 * @param userId 利用者ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * プロパティを文字列として返す。
	 * @return result 全てのプロパティの文字列を返す。
	 */
	public String toString(){

		String result = "";
		result += " [itemCd]:" + getItemCd();
		result += " [listPrice]:" + getListPrice();
		result += " [NowPrice]:" + getNowPrice();
		result += " [orederDdate]:" + getOrderDate();
		result += " [userId]:" + getUserId();
		return result;
	}

}