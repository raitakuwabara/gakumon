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

import java.util.List;

import jp.co.yourcompany.education.order.dto.OrderCartItem;
import jp.co.yourcompany.education.order.dto.OrderCheckResult;

/**
 * インターフェイスを理解するための
 * サンプルインターフェイス
 * @author raita.kuwabara
 *
 */
public interface OrderService {

	/**
	 * このサービスのサブシステムコード
	 */
	public static final String SUBSYSTEM_CODE = "order";


	/**
	 * カートに指定された商品の在庫数や購入価格と現在価格の差異のチェックなど
	 * 購入者に警告メッセージが必要な商品の警告を返すサービス
	 * @param itemList 買い物カゴの商品リスト
	 * @return 警告リスト サイズが０の場合には、警告なし
	 */
	public List<OrderCheckResult> checkOrder( List<OrderCartItem> itemList);

}
