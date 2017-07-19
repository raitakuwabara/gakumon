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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import jp.co.yourcompany.education.exception.ApplicationException;
import jp.co.yourcompany.education.log.InitApplication;

/**
 * バイトストリーム(java.io.InputStream,java.io.OutputStream)クラスの
 * 学習用サンプルクラス
 * @author raita.kuwabara
 */
public class JavaIOByteStreamSample {
	/**
	 * ロガーインスタンス
	 */
	public static final Logger log = Logger.getLogger( JavaIOByteStreamSample.class.getName() );

	/**
	 * educationプロジェクトファイルデータ格納先ディレクトリ
	 */
	public static final String PROJECT_DATA_DIR = "c:\\projects\\education\\data";

	/**
	 * 入力データ格納先ディレクトリ
	 */
	public static final String INPUT_DATA_DIR = JavaIOByteStreamSample.PROJECT_DATA_DIR  + "\\input";

	/**
	 * 出力データ格納先ディレクトリ
	 */
	public static final String OUTPUT_DATA_DIR = JavaIOByteStreamSample.PROJECT_DATA_DIR  + "\\output";

	/**
	 * デフォルトコンストラクタ
	 * ログの初期化
	 */
	public JavaIOByteStreamSample(){
		InitApplication app = InitApplication.getInstance();
		app.init();
	}

	/**
	 * 入出力ファイルのサンプル
	 */
	public void execAllSample(){
		try {
			binaryFileSample();
		} catch (ApplicationException e) {
			log.severe("バイナリーデータの操作でエラーが発生したため異常終了しました。");
			log.log( Level.SEVERE , "例外内容" , e );
		}
		log.info("バイナリーデータの操作は正常終了しました。");
	}

	/**
	 * サンプルバイナイリーデータを別ファイルに出力する。
	 * @throws ApplicationException ファイルの例外発生時
	 */
	private void binaryFileSample() throws ApplicationException {
		final String readFile = INPUT_DATA_DIR + "\\java-basic.png";
		final String writeFile = OUTPUT_DATA_DIR + "\\java-basic2.png";

		try(
			FileInputStream fis = new FileInputStream( new File( readFile ) );
			BufferedInputStream bis = new BufferedInputStream( fis );
			FileOutputStream fos = new FileOutputStream( new File( writeFile ) );
			BufferedOutputStream bos = new BufferedOutputStream( fos );
		){

			byte[] buffer = new byte[1024];
			while( bis.read( buffer ) != -1 ) {
				bos.write( buffer );
			}

		} catch (FileNotFoundException e) {
			log.log( Level.SEVERE , "指定されたファイル{0}が存在しません。" , new String[] { readFile }  );
			log.log( Level.SEVERE , "例外内容" , e );
		} catch (IOException e) {
			log.log( Level.SEVERE , "入力ファイル:{0}" , new String[] { readFile }  );
			log.log( Level.SEVERE , "出力ファイル{0}:" , new String[] { writeFile }  );
			log.log( Level.SEVERE , "例外内容" , e );
		}
	}

	/**
	 * javacコマンドから実行されるメインメソッド
	 * @param arags 引数不要
	 */
	public static final void main( String[] args){
		JavaIOByteStreamSample sample = new JavaIOByteStreamSample();
		sample.execAllSample();
	}
}
