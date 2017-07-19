/**
 * Copyright 2017 yourcompany.
 * 本ソースファイルの著作権は株式会社yourcompanyに所属します。
 * 株式会社yourcompanyの許可なくして、本ソースファイルの
 * 配布、改修、コピー、利用を禁止します。
 * 会社名				：株式会社yourcompany
 * 組織名				：システム開発部
 * プロジェクトコード	：education
 * バージョン			：1.0
 * 最終更新日時			：2017/02/28 18:00
 */

//package宣言部
package jp.co.yourcompany.education.samples;

//import 宣言部
import java.util.ArrayList;
import java.util.List;

/**
*
* このクラスは、Javaの基本構文である
* 分岐構文、ループ構文を学ぶクラスです。
*
* @author Raita.Kuwabara
*
*/
public class JavaSyntaxSamples {

	/**
	 * 全てのサンプルを実行する。
	 */
	public void execAllSamples() {

		execIfSamples();

		execSwitchSamples();

		forSyntaxSample();

		forBreakSyntaxSample();

		forContinueSyntaxSample();

		forEachSyntaxSample();

		doubleLoopSyntaxSample();

		doubleLoopBreakSyntaxSample();

		whileSyntaxSample();

		doWhileSyntaxSample();

	}

	//---------------------------------------- サンプル実行出力開始・終了用

	/**
	 * メソッド共通の開始文の定型出力
	 * @param methodName 出力するメソッド名
	 */
	private void outputStartMethod( String methodName ) {
		System.out.println("----- " + methodName + " START -----");
	}

	/**
	 * メソッド共通の開始文の定型出力
	 * @param methodName 出力するメソッド名
	 */
	private void outputEndMethod( String methodName ) {
		System.out.println("----- " + methodName + " END -----");
	}

	//---------------------------------------------- 条件

	/**
	 * if文の条件節を確かめるサンプルを実行する。
	 */
	public void execIfSamples(){
		outputStartMethod( "execIfSamples" );

		System.out.println( greetingIfSyntax( null ) );
		System.out.println( greetingIfSyntax( "おはよう" ) );
		System.out.println( greetingIfSyntax( "こんにちは" ) );
		System.out.println( greetingIfSyntax( "こんばんは" ) );
		System.out.println( greetingIfSyntax( "今晩は" ) );
		System.out.println( greetingIfSyntax( "よぅ" ) );

		outputEndMethod( "execIfSamples" );
	}

	/**
	 * if文の条件節を確かめるサンプルを実行する。
	 */
	public void execSwitchSamples(){
		outputStartMethod( "execSwitchSamples" );

		System.out.println( greetingSwitchSyntax( null ) );
		System.out.println( greetingSwitchSyntax( "おはよう" ) );
		System.out.println( greetingSwitchSyntax( "こんにちは" ) );
		System.out.println( greetingSwitchSyntax( "こんばんは" ) );
		System.out.println( greetingSwitchSyntax( "今晩は" ) );
		System.out.println( greetingSwitchSyntax( "よぅ" ) );

		outputEndMethod( "execSwitchSamples" );
	}

	/**
	 * if文の条件節を確かめるサンプルメソッド
	 * 入力値に対する英語の挨拶を返す。
	 * @param greetMessage 日本語の挨拶(こんにちは、おはよう等)
	 * @parma result 返答挨拶
	 */
	private String greetingIfSyntax( String greetMessage ) {

		System.out.println( "貴方の挨拶=" + greetMessage );

		//null値は、初期値""にする。
		String str = ( greetMessage == null) ?  "" : greetMessage ;
		String result = "";

		if ( "おはよう".equals( str ) ) {
			result = "Good morning";
		} else if ( "こんちには".equals( str ) ) {
			result = "Hello";
		} else if ( "今晩は".equals( str ) || "こんばんは".equals( str ) ) {
			System.out.println( "Good evening" );
			result = "Good evening";
		} else {
			result = "How are you ?";
		}
		return result;
	}

	/**
	 * switch文の条件節を確かめるサンプルメソッド
	 * 入力値に対する英語の挨拶を返す。
	 * @param greetMessage 日本語の挨拶(こんにちは、おはよう等)
	 * @parma result 返答挨拶
	 */
	private String greetingSwitchSyntax( String greetMessage ) {

		System.out.println( "貴方の挨拶=" + greetMessage );
		String str = ( greetMessage == null) ?  "" : greetMessage ;
		String result = "";

		switch( str ){
			case "おはよう":
				result =  "Good morning";
				break;
			case "こんにちは":
				result = "Hello";
				break;
			case "今晩は":
			case "こんばんは":
				result = "Good evening";
				break;
			default:
				result = "How are you ?";
				break;
		}
		return result;
	}

	/**
	 * for文サンプルメソッド
	 * 配列データをループで全て出力する。
	 */
	public void forSyntaxSample( ) {
		outputStartMethod( "forSyntaxSample" );

		String[] recode = { "カラム01" , "カラム02" , "カラム03" };

		for ( int i = 0 ; i < recode.length ; i++ ) {
			System.out.println("recode[ " + i +"]=" + recode[i] );
		}
		outputEndMethod( "forSyntaxSample" );
	}

	/**
	 * for文内のbreakサンプルメソッド
	 * 配列データをループで全て出力する。
	 */
	public void forBreakSyntaxSample( ) {
		outputStartMethod( "forBreakSyntaxSample" );

		String[] recode = { "カラム01" , "カラム02" , null , "カラム03" };

		for ( int i = 0 ; i < recode.length ; i++ ) {
			if( recode[i] == null){
				System.out.println("【ERROR】recode[ " + i +"]にnullが設定されています。処理を中断します。");
				break;
			}
			System.out.println("recode[ " + i +"]=" + recode[i] );
		}

		outputEndMethod( "forBreakSyntaxSample" );
	}

	/**
	 * for文内のbreakサンプルメソッド
	 * 配列データをループで全て出力する。
	 */
	public void forContinueSyntaxSample() {
		outputStartMethod( "forContinueSyntaxSample" );

		String[] recode = { "カラム01" , "カラム02" , "" , "カラム03" };

		for ( int i = 0 ; i < recode.length ; i++ ) {
			if( recode[i].length() == 0){
				System.out.println("【WARN】recode[ " + i +"]に長さ０の文字列が設定されています。");
				break;
			}
			System.out.println("recode[ " + i +"]=" + recode[i] );
		}

		outputEndMethod( "forContinueSyntaxSample" );
	}

	/**
	 * ２重ループサンプルメソッド
	 * ２次元配列データをループで全て出力する。
	 */
	public void doubleLoopSyntaxSample() {
		outputStartMethod( "doubleLoopSyntaxSample" );

		String[][]personalTable = new String[3][5];
		String[] oneRecode = {"山田" , "太郎" , "ヤマダ" , "タロウ" , "26" , "東京都" };
		String[] towRecode = {"山田" , "花子" , "ヤマダ" , "花子" , "17" , "大阪府" };
		personalTable[0] = oneRecode;
		personalTable[1] = towRecode;

		for ( int i = 0 ; i < personalTable.length ; i++ ) {
			String recode[] = personalTable[i];
			for( int j = 0 ; j < recode.length ; j ++ ){
				System.out.println("personalTable[" + i + "][" + j + "]=" + personalTable[i][j]);
				System.out.println("recode[" + j + "]=" + recode[j]);
			}
		}

		outputEndMethod( "doubleLoopSyntaxSample" );
	}

	/**
	 * ２重ループサンプルメソッド
	 * ２次元配列データをループで全て出力する。
	 */
	public void doubleLoopBreakSyntaxSample() {
		outputStartMethod( "doubleLoopBreakSyntaxSample" );

		String[][]personalTable = new String[3][5];
		String[] oneRecode = {"山田" , "太郎" , "ヤマダ" , "タロウ" , "26" , "東京都" };
		String[] towRecode = {"山田" , "花子" , "ヤマダ" , "花子" , "17" , "大阪府" };
		String[] thirdRecode = {"田中" , "太郎" , "タナカ" , "タロウ" , "48" , "千葉県" };
		personalTable[0] = oneRecode;
		personalTable[1] = towRecode;

		List<String[]> errorRecode = new ArrayList<String[]>();

		recodeLoop:for ( int i = 0 ; i < personalTable.length ; i++ ) {
			String recode[] = personalTable[i];
			columnLoop:for( int j = 0 ; j < recode.length ; j ++ ){

				if( j == 4 ){
					if( Integer.valueOf( recode[4] ).intValue() < 18 ){
						errorRecode.add( recode );
						System.out.println("【ERROR】personalTable[" + i + "]行目は未成年データ" );
						break recodeLoop;
					}
				}

				System.out.println("personalTable[" + i + "][" + j + "]=" + personalTable[i][j] );
				System.out.println("recode[" + j + "]=" + recode[j] );
			}
		}
		outputEndMethod( "doubleLoopBreakSyntaxSample" );
	}

	/**
	 * 拡張for文サンプルメソッド
	 */
	public void forEachSyntaxSample() {
		outputStartMethod( "forEachSyntaxSample" );

		List<String> errorMsgList = new ArrayList<String>();
		errorMsgList.add(" This is a first message ." );
		errorMsgList.add(" This is a secound message ." );
		errorMsgList.add(" This is a third message ." );

		int counter = 0;
		for( String errorMsg : errorMsgList ){
			System.out.println("errroMsgList[" + counter + "]=" + errorMsg );
			counter++;
		}

		outputEndMethod( "forEachSyntaxSample" );
	}

	//-------------------------------------------------- while samples
	/**
	 * while文サンプルメソッド
	 */
	public void whileSyntaxSample() {
		outputStartMethod( "whileSyntaxSample" );

		String[] oneRecode = {"山田" , "太郎" , "ヤマダ" , "タロウ" , "26" , "東京都" };
		int index = 0;
		while( index < oneRecode.length ){
			System.out.println("oneRecode[" + index + "]=" + oneRecode[ index ] );
			index++;
		}
		//このようなケースはfor文を利用すべき。
		//index++をし忘れて無限ループになる間違いが起きやすい
		outputEndMethod( "whileSyntaxSample" );
	}

	/**
	 * dowhile文サンプルメソッド
	 */
	public void doWhileSyntaxSample() {
		outputStartMethod( "doWhileSyntaxSample" );

		String[] oneRecode = {"山田" , "太郎" , "ヤマダ" , "タロウ" , "26" , "東京都" };
		int index = 0;

		//ループの終了条件は index < 0 で終了しますが、dowhile文は必ず1回ループされます。
		do{
			System.out.println("oneRecode[" + index + "]=" + oneRecode[ index ] );
			index++;
		} while ( index <  0);

		outputEndMethod( "doWhileSyntaxSample" );
	}

	/**
	 * Javaコマンドがサンプルを起動する。
	 * @param args 実行引数[指定不要]
	 */
	public static final void main( String[] args ){
		JavaSyntaxSamples javaSyntaxSamples = new JavaSyntaxSamples();
		javaSyntaxSamples.execAllSamples();
	}
}
