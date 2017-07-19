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

/**
 * Javaのtry-with-resourcesのサンプル
 * @author raita.kuwabara
 *
 */
public class JavaTryWithSample extends JavaTrySample {

	/**
	 * ログ
	 */
	public static final Logger log = Logger.getLogger( JavaTryWithSample.class.getName() );

	/**
	 * ファイルの読み込み処理をtry-with-resources形式で記述した例
	 * @param filePath 読み込むファイルのエラー
	 * @throws ファイルの読み込みエラー、対応していない文字コードエラー、ファイルclose時
	 */
	@Override
	protected final void fileReadSample( String filePath ) throws ApplicationException {

		log.info("STEP1 init Stream");
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader ( new FileInputStream( filePath ) , JavaTrySample.FILE_ENCODING ) ) ) {
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
			for (Throwable t : e.getSuppressed()) {
				log.log( Level.SEVERE , "例外内容:" , t );
            }
			//close処理は含まれない。但し上記内容で例外はエラーログに出力
			throw new ApplicationException( e );
		}

		log.info("STEP4 method block end.");
	}

	/**
	 * javaコマンドから実行されるmainメソッド
	 * @param args コマンド引数(不要)
	 */
	public static final void main( String[] args){
		JavaTryWithSample sample = new JavaTryWithSample();
		sample.execAllSample();
	}
}
