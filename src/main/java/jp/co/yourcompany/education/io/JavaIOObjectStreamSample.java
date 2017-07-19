/**
 * Copyright 2017 yourcompany.
 * 本ソースファイルの著作権は株式会社yourcompanyに所属します。
 * 株式会社yourcompanyの許可なくして、本ソースファイルの
 * 配布、改修、コピー、利用を禁止します。
 * 会社名				：株式会社yourcompany
 * 組織名				：システム開発部
 * プロジェクトコード	：education
 * バージョン			：1.0
 * 最終更新日時			：2017/03/17 14:00
 */
package jp.co.yourcompany.education.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import jp.co.yourcompany.education.exception.ApplicationException;
import jp.co.yourcompany.education.log.InitApplication;
import jp.co.yourcompany.education.order.dto.Order;

/**
 * オブジェクトストリーム(java.io.ObjectOutputStream,java.io.ObjectInputStream)クラスの
 * 学習用サンプルクラス
 * @author raita.kuwabara
 */
public class JavaIOObjectStreamSample {
	/**
	 * ロガーインスタンス
	 */
	public static final Logger log = Logger.getLogger( JavaIOObjectStreamSample.class.getName() );

	/**
	 * educationプロジェクトファイルデータ格納先ディレクトリ
	 */
	public static final String PROJECT_DATA_DIR = "c:/projects/education/data";

	/**
	 * 入力データ格納先ディレクトリ
	 */
	public static final String INPUT_DATA_DIR = JavaIOObjectStreamSample.PROJECT_DATA_DIR  + "/input";


	/**
	 * オブジェクト入出力ファイル
	 */
	final String filePath = INPUT_DATA_DIR + "/object.dat";


	/**
	 * デフォルトコンストラクタ
	 * ログの初期化
	 */
	public JavaIOObjectStreamSample(){
		InitApplication app = InitApplication.getInstance();
		app.init();
	}

	/**
	 * 入出力ファイルのサンプル
	 */
	public void execAllSample(){
		try {
			outputObjectFileSample();
			readObjectFileSample();
		} catch (ApplicationException e) {
			log.severe("オブジェクトデータの操作でエラーが発生したため異常終了しました。");
			log.log( Level.SEVERE , "例外内容" , e );
		}
		log.info("オブジェクトデータの操作は正常終了しました。");
	}

	/**
	 * サンプルオブジェクトをファイルに出力する。
	 * @throws ApplicationException ファイルの例外発生時
	 */
	private void outputObjectFileSample() throws ApplicationException {
		List<Order> resultList = createSampleData();

		try(
			FileOutputStream fos = new FileOutputStream( new File( filePath ) );
			ObjectOutputStream oos = new ObjectOutputStream( fos );
		){
			//firstSample List
			oos.writeObject( resultList );

		} catch (IOException e) {
			log.log( Level.SEVERE , "出力ファイル{0}:" , new String[] { filePath }  );
			log.log( Level.SEVERE , "例外内容" , e );
		}
	}

	/**
	 * サンプルオブジェクトをファイルに出力する。
	 * @throws ApplicationException ファイルの例外発生時
	 */
	private void readObjectFileSample() throws ApplicationException {

		try(
			FileInputStream fis = new FileInputStream( new File( filePath ) );
			ObjectInputStream ois = new ObjectInputStream( fis );
		){
			@SuppressWarnings("unchecked")
			List<Order> resultList = (List<Order>) ois.readObject();

			for( Order order : resultList ){
				System.out.println( order.getUserId() );
				System.out.println( order.getItemCd() );
				System.out.println( order.getItemName() );
				System.out.println( order.getListPrice() );
				System.out.println( order.getNowPrice() );
				System.out.println( order.getOrderDate() );
				System.out.println( order.getQuantity() );
				System.out.println( order.getManufacturer() );
			}

		} catch (ClassNotFoundException e ) {
			log.log( Level.SEVERE , "入力ファイル{0}に存在しないクラスが定義されています。:" , new String[] { filePath }  );
			log.log( Level.SEVERE , "例外内容" , e );

		} catch (IOException e ) {
			log.log( Level.SEVERE , "出力ファイル{0}:" , new String[] { filePath }  );
			log.log( Level.SEVERE , "例外内容" , e );
		}
	}


	/**
	 * サンプルデータの作成
	 * @result resultList 注文オブジェクトのサンプルリスト
	 */
	private List<Order> createSampleData(){
		List<Order> resultList = new ArrayList<Order>();

		Order order1 = new Order();
		order1.setUserId("00000001");
		order1.setItemCd("123456");
		order1.setItemName("チョコケーキ");
		order1.setListPrice( Integer.valueOf( 200 ) );
		order1.setNowPrice( Integer.valueOf( 198 ) );
		order1.setOrderDate( new java.util.Date() );
		order1.setQuantity( Integer.valueOf( 1 ) );
		order1.setManufacturer("hoge製菓株式会社");
		resultList.add( order1 );

		Order order2 = new Order();
		order2.setUserId("00000002");
		order2.setItemCd("012345");
		order2.setItemName("イチゴケーキ");
		order2.setListPrice( Integer.valueOf( 270  ) );
		order2.setNowPrice( Integer.valueOf( 248 ) );
		order2.setOrderDate( new java.util.Date() );
		order2.setQuantity( Integer.valueOf( 1 ) );
		order2.setManufacturer("hoge製菓株式会社");
		resultList.add( order2 );
		return resultList;
	}


	/**
	 * javacコマンドから実行されるメインメソッド
	 * @param arags 引数不要
	 */
	public static final void main( String[] args){
		JavaIOObjectStreamSample sample = new JavaIOObjectStreamSample();
		sample.execAllSample();
	}
}
