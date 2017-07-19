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
package jp.co.yourcompany.education.order.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jp.co.yourcompany.education.order.dto.OrderCartItem;
import jp.co.yourcompany.education.order.dto.OrderCheckResult;

/**
 * 注文サービス
 * @author raita.kuwabara
 */
public class OrderServiceImpl implements OrderService {

	/**
	 * 買い物カゴの商品をチェックし、チェックした結果を返す。
	 * @param itemList カート商品のリスト
	 * @return resultList 商品チェック結果 配列数０の場合には、警告なし。
	 */

	@Override
	public List<OrderCheckResult> checkOrder(List<OrderCartItem> itemList) {
		List<OrderCheckResult> resultList = new ArrayList<OrderCheckResult>();
		for( OrderCartItem cartItem : itemList ) {
			OrderCheckResult checkResult = null;
			checkResult = checkDifferencePrice( cartItem );
			if( checkResult != null){
				resultList.add( checkResult );
			}
			checkResult = checkStock( cartItem );
			if( checkResult != null){
				resultList.add( checkResult );
			}
		}

		return resultList;
	}

	/**
	 * カート設定時の価格と現在価格を比較し、価格に差異があればエラーメッセージを返す.
	 * @param orderCartItem
	 */
	private OrderCheckResult checkDifferencePrice( OrderCartItem orderCartItem ){
		OrderCheckResult result = null;

		//以下このように値段関係によるチェックを行う。
		if( orderCartItem.getPirceInCart() == orderCartItem.getNowPrice() ){
			result = null;
		} else {
			result = new OrderCheckResult();
			result.setItemCd( orderCartItem.getItemCd() );
			if ( orderCartItem.getPirceInCart() > orderCartItem.getNowPrice() ){
				result.setWarnningCd( "WRN000012");
				result.setWarnningMessage( String.format("商品名[%s]は、ご購入時より販売価格が安くなっております。" , orderCartItem.getItemName() ) );
			} else {
				result.setWarnningCd( "WRN000013");
				result.setWarnningMessage( String.format("商品名[%s]は、ご購入時より販売価格が高くなっております。" , orderCartItem.getItemName() ) );
			}
		}
		return result;

	}

	/**
	 * 現在の在庫数をチェックする。
	 * @param orderCartItem
	 */
	private OrderCheckResult checkStock( OrderCartItem orderCartItem ){
		OrderCheckResult result = null;

		//本来はこのようにdaoに在庫数を求めます。
		//if( orderDao.selectItem( orderCartItem.getItemCd()).getStock() == 0 ){
			if( "000001".equals( orderCartItem.getItemCd() ) ){
				result = new OrderCheckResult();
				result.setItemCd( orderCartItem.getItemCd() );
				result.setWarnningCd("WRN0000101");
				result.setWarnningMessage( String.format("商品名[%s]は、現在販売しておりません。" , orderCartItem.getItemName() ) );
			}
		//}
		return result;

	}

	/**
	 *
	 * @param args
	 */
	public static void main( String[] args){

		//動作確認
		OrderService orderService = new OrderServiceImpl();

		//サンプルデータ1
		OrderCartItem order1 = new OrderCartItem();
		order1.setItemCd( "000001");
		order1.setItemName("チョコアイス５個入り");
		order1.setManufacturer("株式会社アイスメーカ");
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

		OrderCartItem order2 = new OrderCartItem();
		order2.setItemCd( "000002");
		order2.setItemName("いちごアイス");
		order2.setManufacturer("株式会社アイスメーカ");
		order2.setListPrice( new Integer( 100 ) );
		order2.setNowPrice( new Integer( 90 ));
		order2.setOrderDate( new java.util.Date() );
		order2.setUserId ( "9999999" );

		try {
			order2.setDateInCart( sdf.parse("2017/02/28 14:35") );
		} catch (ParseException e) {
			e.printStackTrace();
		}
		order2.setPirceInCart( new Integer( 95 ) );

		List<OrderCartItem> cartList = new ArrayList<OrderCartItem>();
		cartList.add( order1 );
		cartList.add( order2 );
		List<OrderCheckResult> resultList = orderService.checkOrder( cartList );

		for( OrderCheckResult warnItem  : resultList){
			System.out.println( "-----------------------------------------------");
			System.out.println( " warnItem.itemCd " + warnItem.getItemCd());
			System.out.println( " warnItem.warnningCd " + warnItem.getWarnningCd());
			System.out.println( " warnItem.warnningMessage " + warnItem.getWarnningMessage());
		}
	}

}
