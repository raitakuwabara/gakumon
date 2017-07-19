/**
 * Copyright 2017 yourcompany.
 * 本ソースファイルの著作権は株式会社yourcompanyに所属します。
 * 株式会社yourcompanyの許可なくして、本ソースファイルの
 * 配布、改修、コピー、利用を禁止します。
 * 会社名				：株式会社yourcompany
 * 組織名				：システム開発部
 * プロジェクトコード	：education
 * バージョン			：1.0
 * 最終更新日時			：2017/03/14 18:00
 */
package jp.co.yourcompany.education.samples;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import jp.co.yourcompany.education.exception.ApplicationException;
import jp.co.yourcompany.education.log.InitApplication;

/**
 * Java例外処理(try,catch,finally,throw,thorws)学習用のクラス
 * @author raita.kuwabara
 */
public class JavaTrySample {

	/**
	 * 正常データ
	 */
	public static final String TEST_FILE = "c:\\projects\\education\\data\\input\\sample_data.txt";

	/**
	 * 存在しないファイル
	 */
	public static final String VALID_TEST_FILE = "c:\\projects\\education\\data\\input\\invalid_data.txt";

	/**
	 * ファイルのエンコード
	 */
	public static final String FILE_ENCODING = "UTF-8";


	/**
	 * ログ
	 */
	public static final Logger log = Logger.getLogger( JavaTrySample.class.getName() );

	/**
	 * デフォルトコンストラクタ
	 * ログの初期化処理を実施する。
	 */
	public JavaTrySample(){
		InitApplication app = InitApplication.getInstance();
		app.init();
	}

	/**
	 *  全ての例外処理を実行する。
	 */
	public void execAllSample(){

		try{

			log.info("正常ファイルの読取りを行います。");
			fileReadSample( JavaTrySample.TEST_FILE );
			log.info("正常ファイルの読取りが正常に終了しました");

			log.info("存在しないファイルの読取りを行います。");
			fileReadSample( JavaTrySample.VALID_TEST_FILE );
			log.info("存在しないファイルの読取りが正常に終了しました");

		}catch( ApplicationException e ){
			log.severe("例外が発生したため処理を異常終了しました。");
			log.log( Level.SEVERE , "例外内容:" , e );
		}

	}

	/**
	 * ファイルの読見込み処理
	 * @param filePath 読み込むファイルのエラー
	 * @throws ファイルの読み込みエラー、対応していない文字コードエラー、ファイルclose時
	 */
	protected void fileReadSample( String filePath ) throws ApplicationException {

		//アプリケーションが動作するPCに保存されているファイル
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			log.info("STEP1 init Stream");

			fis = new FileInputStream( filePath );
			isr = new InputStreamReader( fis , JavaTrySample.FILE_ENCODING );
			br = new BufferedReader( isr );

			log.info("STEP2 loop start");

			String line;
			while ( ( line = br.readLine() ) != null ) {
				System.out.println(line);
			}

			log.info("STEP3 try block end.");

		} catch (FileNotFoundException e) {
			log.log( Level.SEVERE , "指定されたファイル{0}が存在しません。" , new String[]{ filePath } );
			log.log( Level.SEVERE , "例外内容:" , e );
			throw new ApplicationException( e );
		} catch (UnsupportedEncodingException e) {
			String[] params = { filePath , JavaTrySample.FILE_ENCODING };
			log.log( Level.SEVERE , "指定されたファイル{0}の文字コードが、{1}ではありません。" , params );
			log.log( Level.SEVERE , "例外内容:" , e );
			throw new ApplicationException( e );
		} catch (IOException e) {
			log.log( Level.SEVERE , "指定されたファイル{0}読取時に例外が発生しました。" , new String[] { filePath }  );
			log.log( Level.SEVERE , "例外内容:" , e );
			throw new ApplicationException( e );
		} finally {
			try{
				if( br != null ){
					br.close();
				}
				if( isr != null ){
					isr.close();
				}
				if( fis != null ){
					fis.close();
				}
				log.info("STEP4 finally block end.");
			} catch ( IOException e ){
				log.log( Level.SEVERE , "指定されたファイル{0}のclose時に例外が発生しました。" , new String[]{ filePath } );
				log.log( Level.SEVERE , "例外内容:" , e );
				throw new ApplicationException( e );
			}
		}
	}
}