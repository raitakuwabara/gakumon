/**
 * Copyright 2017 yourcompany.
 * 本ソースファイルの著作権は株式会社yourcompanyに所属します。
 * 株式会社hogeの許可なくして、本ソースファイルの
 * 配布、改修、コピー、利用を禁止します。
 * 会社名				：株式会社yourcompany
 * 組織名				：システム開発部
 * プロジェクトコード	：education
 * バージョン			：1.0
 * 最終更新日時			：2017/02/10 17:21
 */
package jp.co.yourcompany.education.log;

import java.util.logging.Level;
import java.util.logging.Logger;;


/**
 * java.util.loggingAPIを利用して、
 * 設定ファイルに指定したログを出力
 * @author raita.kuwabara
 */
public class JavaAPILogSample {

	/**
	 * ロガーインスタンスの生成
	 * このようにロガーは、クラスメンバーフィールド(static)で定義します。
	 */
	public static final Logger log = Logger.getLogger( JavaAPILogSample.class.getName() );

	/**
	 * デフォルトコンストラクタ
	 * アプリケーションの初期化を実施する。
	 */
	public JavaAPILogSample(){
		InitApplication application = InitApplication.getInstance();
		application.init();

	}


	/**
	 * ログ出力サンプルを全て実行する。
	 */
	public void execAllSamples(){

		logExceptionSample();
		logSevere();
		logWarning();
		logInfo();
		logConfig();
		logFine();
		logFiner();
		logFinest();

	}

	/**
	 * 例外の出力例
	 */
	private void logExceptionSample(){
		System.out.println("logExceptionSample START ");
		String test = null;
		//nullポを起こすためのコーディングで本来このような記述はしません。
		try{
			if( test.equals("TEST") ){
				System.out.println(" test is TEST. ");
			}
		} catch( NullPointerException e){
			log.log(Level.SEVERE, "例外発生", e);
		}
		log.severe("logExceptionSample");
		System.out.println("logExceptionSample END ");
	}

	/**
	 * ログの出力レベル:SERVEREの確認
	 */
	private void logSevere(){
		System.out.println("logSevere START ");
		log.severe("LOGLEVEL:SERVERE");
		System.out.println("logSevere END ");
	}

	/**
	 * ログの出力レベル:WARNINGの確認
	 */
	private void logWarning(){
		System.out.println("logWarning START ");
		log.warning("LOGLEVEL:WARNING");
		System.out.println("logWarning END ");
	}

	/**
	 * ログの出力レベル:INFOの確認
	 */
	private void logInfo(){
		System.out.println("logInfo START ");
		log.info("LOGLEVEL:INFO");
		System.out.println("logInfo END ");
	}

	/**
	 * ログの出力レベル:CONFIGの確認
	 */
	private void logConfig(){
		System.out.println("logConfig START ");
		log.config("LOGLEVEL:CONFIG");
		System.out.println("logConfig END ");
	}

	/**
	 * ログの出力レベル:FINEの確認
	 */
	private void logFine(){
		System.out.println("logFine START ");
		log.fine("LOGLEVEL:FINE");
		System.out.println("logFine END ");
	}

	/**
	 * ログの出力レベル:FINERの確認
	 */
	private void logFiner(){
		System.out.println("logFiner START ");
		log.finer("LOGLEVEL:FINER");
		System.out.println("logFiner END ");
	}

	/**
	 * ログの出力レベル:FINESTの確認
	 */
	private void logFinest(){
		System.out.println("logFinest START ");
		log.finest("LOGLEVEL:FINEST");
		System.out.println("logFinest END ");
	}


	/**
	 * javaコマンドから実行されるmainメソッド
	 */
	public static final void main( String[] args ) {
		JavaAPILogSample sample = new JavaAPILogSample();
		sample.execAllSamples();
	}
}
