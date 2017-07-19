package jp.co.yourcompany.education.log;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

/**
 * アプリケーション初期化クラス
 * @author 雷太
 *
 */
public class InitApplication {

	/**
	 * シングルトン
	 */
	private static InitApplication instance = null;

	/**
	 * java.util.log.LogManagerに読み込ませるログプロパティファイル
	 */
	public static final String LOG_PROPERTIES_NAME = "logging.properties";


	/**
	 * InitApplicationのインスタンスを返す。
	 * @return InitApplicationのインスタンス
	 */
	public static InitApplication getInstance(){
		if( instance == null){
			instance = new InitApplication();
		}
		return instance;
	}

	/**
	 * アプリケーションの初期化処理
	 */
	public void init(){
		initLog();
	}

	/**
	 * ログの初期化
	 */
	private void initLog(){

		InputStream in = null;
	    try {
	    	in = InitApplication.class.getClassLoader().getResourceAsStream("logging.properties");
			if (in == null) {
				System.err.println("logging.propertiesファイルがクラスパスに存在しません。");
			}
			LogManager.getLogManager().readConfiguration( in );
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

}
