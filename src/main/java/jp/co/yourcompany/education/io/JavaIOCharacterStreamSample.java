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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import jp.co.yourcompany.education.exception.ApplicationException;
import jp.co.yourcompany.education.log.InitApplication;

/**
 * 文字ストリーム(java.io.Reader,java.io.Writer)クラスの
 * 学習用サンプルクラス
 * @author raita.kuwabara
 */
public class JavaIOCharacterStreamSample{
	/**
	 * ロガーインスタンス
	 */
	public static final Logger log = Logger.getLogger( JavaIOCharacterStreamSample.class.getName() );

	/**
	 * educationプロジェクトファイルデータ格納先ディレクトリ
	 */
	public static final String PROJECT_DATA_DIR = "c:/projects/education/data";

	/**
	 * 入力データ格納先ディレクトリ
	 */
	public static final String INPUT_DATA_DIR = JavaIOCharacterStreamSample.PROJECT_DATA_DIR  + "/input";

	/**
	 * 出力データ格納先ディレクトリ
	 */
	public static final String OUTPUT_DATA_DIR = JavaIOCharacterStreamSample.PROJECT_DATA_DIR  + "/output";

	/**
	 * デフォルトコンストラクタ
	 * ログの初期化
	 */
	public JavaIOCharacterStreamSample(){
		InitApplication app = InitApplication.getInstance();
		app.init();
	}

	/**
	 * 入出力ファイルのサンプル
	 */
	public void execAllSample(){
		try {
			log.info("ファイルエンコード指定なし");
			characterFileSampleByDefault();

			log.info("ファイルエンコード指定あり");
			characterFileSampleByEncoding();

		} catch (ApplicationException e) {
			log.severe("テキストデータの操作でエラーが発生したため異常終了しました。");
			log.log( Level.SEVERE , "例外内容" , e );
		}
		log.info("テキストデータの操作は正常終了しました。");
	}

	/**
	 * サンプルバイナイリーデータを文字コードを指定せずに出力する。
	 * @throws ApplicationException ファイルの例外発生時
	 * @deprecated 文字コードを指定していないので日本語のテキストファイルは化ける。
	 */
	private void characterFileSampleByDefault() throws ApplicationException {
		final String readFile = INPUT_DATA_DIR + "/character.txt";
		final String writeFile = OUTPUT_DATA_DIR + "/character2.txt";

		try(
			FileReader fr = new FileReader( readFile );
			BufferedReader br = new BufferedReader( fr );
			FileWriter fw = new FileWriter( writeFile );
			BufferedWriter bw = new BufferedWriter( fw );
		){

			String line = null;
			while ( ( line = br.readLine() ) !=null){
				bw.write( line );
				bw.newLine();
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
	 * サンプルバイナイリーデータを別ファイルに出力する。
	 * 日本語文字列の無いファイルのみしか適用できない。
	 * @throws ApplicationException ファイルの例外発生時
	 */
	private void characterFileSampleByEncoding() throws ApplicationException {
		final String readFile = INPUT_DATA_DIR + "/character.txt";
		final String writeFile = OUTPUT_DATA_DIR + "/character3.txt";


		try(
			FileInputStream fis = new FileInputStream( readFile );
			BufferedReader br = new BufferedReader(new InputStreamReader( fis , "SJIS") );

			FileOutputStream fos = new FileOutputStream( writeFile );
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter( fos , "SJIS") );

		){

			String line = null;
			while ( ( line = br.readLine() ) !=null){
				bw.write( line );
				bw.newLine();
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
		JavaIOCharacterStreamSample sample = new JavaIOCharacterStreamSample();
		sample.execAllSample();
	}
}
