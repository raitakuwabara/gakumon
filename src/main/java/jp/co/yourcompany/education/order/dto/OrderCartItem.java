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

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * カートに入れる商品を示すDtoクラス
 * @author Raita.Kuwabara
 *
 */
public class OrderCartItem extends Order {
	/**
	 * カート設定日
	 */
	private java.util.Date dateInCart;

	/**
	 * カート設定時価格
	 */
	private Integer pirceInCart;

	/**
	 * カート設定を取得する
	 * @return dateInCart カート設定日
	 */
	public java.util.Date getDateInCart() {
		return dateInCart;
	}

	/**
	 * カート設定日を設定する。
	 * @param dateInCart カート設定日
	 */
	public void setDateInCart(java.util.Date dateInCart) {
		this.dateInCart = dateInCart;
	}

	/**
	 * カート設定時価格を設定する。
	 * @return pirceInCart
	 */
	public Integer getPirceInCart() {
		return pirceInCart;
	}

	/**
	 * カート設定時価格を設定する。
	 * @param pirceInCart セットする pirceInCart
	 */
	public void setPirceInCart(Integer pirceInCart) {
		this.pirceInCart = pirceInCart;
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public OrderCartItem(){

	}

	/**
	 * オブジェクトのコピー
	 */
	@Override
	public OrderCartItem clone(){
		OrderCartItem copyObj = null;
		copyObj = ( OrderCartItem ) super.clone();
		copyObj.setDateInCart( new java.util.Date ( this.getDateInCart().getTime() ) );
        return copyObj;
	}

	/**
	 * プロパティの文字列化
	 */
	public String toString(){
		String result = super.toString();
		result += " [dateInCart]:" + getDateInCart();
		result += " [priceInCart]:" + getPirceInCart();

		return result;
	}


	/**
	 * mainメソッド
	 * cloneメソッドのコピーを確認する
	 */
	public static final void main( String[] args ){

		OrderCartItem order1 = new OrderCartItem();
		order1.setItemCd( "000001");
		order1.setListPrice( new Integer( 600 ) );
		order1.setNowPrice( new Integer( 550 ));
		order1.setOrderDate( new java.util.Date() );
		order1.setUserId ( "9999999" );

		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy/MM/dd HH:SS");
		try {
			order1.setDateInCart( sdf.parse("2017/02/28 14:30") );
		} catch (ParseException e) {
			e.printStackTrace();
		}
		order1.setPirceInCart( new Integer( 500 ) );


		System.out.println("-- Order Order1 Instance is --" );
		System.out.println(  order1.toString() );

		System.out.println("-- Order Order2 Instance is --" );
		OrderCartItem order2 = order1.clone();
		System.out.println(  order2.toString() );
		System.out.println( "order1 == order2 is " + ( order1 == order2 ) );
		System.out.println( "order1.getOrderDate == order2.getOrderDate is " + ( order1.getOrderDate() == order2.getOrderDate() ) );
		System.out.println( "order1.getDateInCart == order2.getDateInCart is " + ( order1.getDateInCart() == order2.getDateInCart() ) );

	}

}


