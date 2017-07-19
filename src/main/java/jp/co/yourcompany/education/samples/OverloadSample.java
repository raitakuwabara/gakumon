/**
 * Copyright 2017 yourcompany.
 * 本ソースファイルの著作権は株式会社yourcompanyに所属します。
 * 株式会社hogeの許可なくして、本ソースファイルの
 * 配布、改修、コピー、利用を禁止します。
 * 会社名				：株式会社yourcompany
 * 組織名				：システム開発部
 * プロジェクトコード	：education
 * バージョン			：1.0
 * 最終更新日時			：2017/03/09
 */
package jp.co.yourcompany.education.samples;

/**
 * オーバロードのサンプルクラス
 * @author raita.kuwabara
 */
public class OverloadSample  extends AbstractSamples {

	/**
	 * 外部から税率を指定されなかった場合の消費税
	 */
	public static final int DEFAULT_TAX = 8;

	/**
	 * 消費税(10進数 8%なら8を指定する)
	 */
	protected int tax;

	/**
	 * 値段
	 */
	protected int price;

	/**
	 * 数量
	 */
	protected int quantity;

	/**
	 * デフォルトコンストラクタ
	 */
	public OverloadSample(){
	}

	/**
	 * デフォルトコンストラクタ
	 * オーバーロードの１つの例
	 * @param price 値段
	 * @param quntity 数量
	 */
	public OverloadSample( int price , int quntity){
		setPrice( price );
		setQuantity( quntity );
	}

	/**
	 * デフォルトコンストラクタ
	 * オーバーロードの１つの例
	 * @param price 値段
	 * @param quntity 数量
	 * @param tax 消費税
	 */
	public OverloadSample( int price , int quntity , int tax){
		this( price , quntity );
		setTax( tax );
	}


	/**
	 * メンバーフィールドに格納した値で消費税額を計算する。
	 * @return 消費税額
	 */
	public int consumptionTax(){
		return ( price * quantity * tax) / 100;
	}

	/**
	 * 消費税額を計算する。
	 * オーバーロードの１つの例
	 * @param price 値段
	 * @param
	 * @return 消費税額
	 */
	public int consumptionTax( int price , int quntity , int tax){
		setPrice( price );
		setQuantity( quntity ) ;
		setTax( tax ) ;
		return this.consumptionTax();
	}

	/**
	 * 消費税額を計算する。
	 * 税率以外は全て引き渡しされた値
	 * @return 消費税額
	 */
	public int consumptionTax( int price , int quntity){
		return this.consumptionTax( price , quntity , OverloadSample.DEFAULT_TAX );
	}


	@Override
	protected void execAllSamples() {
		System.out.println("呼び出し方法の違いのサンプルなのでmainメソッドで確認して下さい。");
	}

	/**
	 * 消費税を取得する
	 * @return tax 消費税
	 */
	public int getTax() {
		return tax;
	}

	/**
	 * 消費税を設定する。
	 * @param tax 消費税
	 */
	public void setTax(int tax) {
		this.tax = tax;
	}

	/**
	 * 値段を取得する
	 * @return price 値段
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 値段を設定する。
	 * @param price 値段
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * 数量を取得する
	 * @return quantity 数量
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * 数量を設定する。
	 * @param quantity 数量
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Javaコマンドから実行されるmainメソッド
	 */
	public static final void main( String[] args){
		//呼び出し方1
		System.out.println("OverloadSample() サンプル1");
		OverloadSample sample = new OverloadSample();
		sample.setPrice( 10000 );
		sample.setQuantity( 1 );
		sample.setTax( OverloadSample.DEFAULT_TAX );
		System.out.println("consumptionTax:" + sample.consumptionTax());

		//呼び出し方2
		System.out.println("OverloadSample() サンプル2");
		//デフォルトの消費税8%が適用
		OverloadSample sample2 = new OverloadSample( 10000 , 1 );
		System.out.println("consumptionTax:" + sample2.consumptionTax());

		//呼び出し方3 税率が変更されたときの呼び出し 消費税10%指定
		System.out.println("OverloadSample() サンプル3");
		OverloadSample sample3 = new OverloadSample( 10000 , 1 , 10);
		System.out.println("consumptionTax:" + sample3.consumptionTax());

		//呼び出し方4　消費税10%指定
		System.out.println("OverloadSample() サンプル4");
		OverloadSample sample4 = new OverloadSample();
		System.out.println("consumptionTax:" + sample4.consumptionTax(498 , 1 , 10));

		//呼び出し方5　デフォルト消費税8%適用
		System.out.println("OverloadSample() サンプル5");
		OverloadSample sample5 = new OverloadSample();
		System.out.println("consumptionTax:" + sample5.consumptionTax(498 , 1 ));


	}

}
