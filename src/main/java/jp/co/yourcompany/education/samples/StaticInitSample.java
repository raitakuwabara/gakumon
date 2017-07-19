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

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * staticのサンプル2
 * @author raita.kuwabara
 *
 */
public class StaticInitSample {

	/**
	 * ファイル読み込み時にエラーが100件出たらフォーマットエラーとする
	 */
	public static final int LIMIT_FILE_ERROR_COUNT = 100;

	/**
	 * システム間連携のファイルの拡張子
	 */
	public static String SYSTEM_CONNECT_FILE_EXTENSION = null;

	/**
	 * システム間連携のファイルの接頭辞
	 */
	public static String SYSTEM_CONNECT_FILE_PREFIX = null;

	static {
		StaticInitSample.init();
	}

	/**
	 * プロパティファイルのロード処理
	 */
	public static void init(){
		InputStream in = null;
	    try {
	    	in = StaticInitSample.class.getClassLoader().getResourceAsStream("application.properties");
			if (in == null) {
				System.err.println("application.propertiesファイルがクラスパスに存在しません。");
			}
			Properties prop = new Properties();
		    prop.load( in );
			SYSTEM_CONNECT_FILE_EXTENSION = prop.getProperty("system.connect.file.extenstion");
			SYSTEM_CONNECT_FILE_PREFIX = prop.getProperty("system.connect.file.prefix");
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if( in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * javaコマンドから実行されるmainメソッド
	 * @param args 引数不要
	 */
	public static final void main( String[] args ){

		System.out.println("StaticInitSample.LIMIT_FILE_ERROR_COUNT=" +
				StaticInitSample.LIMIT_FILE_ERROR_COUNT );
		System.out.println("StaticInitSample.SYSTEM_CONNECT_FILE_EXTENSION=" + StaticInitSample.SYSTEM_CONNECT_FILE_EXTENSION );
		System.out.println("StaticInitSample.SYSTEM_CONNECT_FILE_PREFIX=" + StaticInitSample.SYSTEM_CONNECT_FILE_PREFIX );
	}

}
