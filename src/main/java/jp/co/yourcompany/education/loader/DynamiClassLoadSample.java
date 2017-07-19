package jp.co.yourcompany.education.loader;

import java.util.logging.Level;
import java.util.logging.Logger;

import jp.co.yourcompany.education.order.dto.Order;

/**
 * 動的にクラスをロードするサンプル
 * @author raita.kuwabara
 */
public class DynamiClassLoadSample {
	/**
	 * ログ
	 */
	private static final Logger log = Logger.getLogger( DynamiClassLoadSample.class.getName() );

	public void execAllSample(){

		Object obj = getInstance( "jp.co.yourcompany.education.order.dto.Order" );
		if( obj != null ){
			log.info(" 動的に生成したインスタンス： " + obj.getClass().getName() );
			Order order = (Order)obj;
			order.setItemName("テスト商品");
			log.info(" 動的に生成したインスタンスのメソッド利用： " + order.getItemName() );
		}
	}

	/**
	 * Javaのクラスを動的にロード(インスタンスを生成)する方法
	 * @parma dynamiClassName 動的にロードするクラスの完全修飾子
	 * @return obj 指定したクラスのインスタンス
	 */
	private Object getInstance( String dynamicClassName ){

		Object obj = null;

		try {
			Class<?> clasz = Class.forName( dynamicClassName );
	        obj = clasz.newInstance();
		} catch (ClassNotFoundException e) {
			log.log( Level.SEVERE, "指定したクラス「{0}」はクラスが存在しません。",
					new String[] { dynamicClassName } );
			log.log( Level.SEVERE, "例外内容:",  e );

		} catch (InstantiationException e) {
			log.log( Level.SEVERE, "指定したクラス「{0}」はクラスのインスタンス生成時に例外が発生しました",
					new String[] { dynamicClassName } );
			log.log( Level.SEVERE, "例外内容:",  e );
		} catch (IllegalAccessException e) {
			log.log( Level.SEVERE, "指定した引数「{0}」はクラスの完全修飾子ではありません。",
					new String[] { dynamicClassName } );
			log.log( Level.SEVERE, "例外内容:",  e );
		}
		return obj;
	}

	/**
	 * javaコマンドから実行されるメインメソッド
	 */
	public static final void main( String[] args ){
		DynamiClassLoadSample sample = new DynamiClassLoadSample();
		sample.execAllSample();
	}

}
