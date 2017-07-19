/**
 * Copyright 2017 yourcompany.
 * 本ソースファイルの著作権は株式会社yourcompanyに所属します。
 * 株式会社yourcompanyの許可なくして、本ソースファイルの
 * 配布、改修、コピー、利用を禁止します。
 * 会社名				：株式会社yourcomapny
 * 組織名				：システム開発部
 * プロジェクトコード	：education
 * バージョン			：1.0
 * 最終更新日時			：2017/02/10 17:21
 */
package jp.co.yourcompany.education.samples;


/**
 * Stringクラス及び８つのラッパークラスの
 * 操作を学習するためのクラス
 * @author raita.kuwabara
 *
 */
public class StringSamples {


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

	/**
	 * 全てのサンプルを実行する
	 */
	public void execAllSamples(){

		outputCharacterSample();

		outputCharacterComparisonSample();

		outputStringSample();

		outputStringFormatSample();

		outputStringProcessingSample();

		outputStringSearchSample();

		outputStringToNumberSample();

		outputAutoBoxingSample();

	}

	/**
	 * Characterクラスのサンプル
	 */
	public void outputCharacterSample(){
		outputStartMethod( "outputCharacterSample" );

		Character comma = new Character(',');
		Character period = new Character('.');
		Character token = new Character(',');
		Character token2 = comma;

		char commaChar = comma.charValue();
		System.out.println( "Character comma =" + comma );
		System.out.println( "comma.toString() =" + comma.toString() );
		System.out.println( "char commaChar  =" + commaChar );

		if( comma.equals( period ) ){
			System.out.println( " comma is equal to period." );
		} else {
			System.out.println( "comma is not equal to period." );
		}

		//equalsによる比較
		System.out.println( "token.equals(comma) :" + token.equals( comma ) );
		//インスタンスの一致可否
		System.out.println( "token == comma :" + ( token == comma ) );
		//インスタンスの一致可否
		System.out.println( "token2 == comma :" + ( token2 == comma ) );

		//compareToによる比較(不一致のケース)
		System.out.println( "comma.compareTo( period ) :" + comma.compareTo( period ) );
		//compareToによる比較(一致のケース)
		System.out.println( "comma.compareTo( token ) :" + comma.compareTo( token ) );

		outputEndMethod( "outputCharacterSample" );
	}

	/**
	 * Characterクラスのサンプル
	 * @see java.lang.Character
	 */
	public void outputCharacterComparisonSample(){
		outputStartMethod( "outputCharacterSample" );

		Character charValLower = new Character('a');
		Character charValUpper = new Character('A');

		//半角スペース
		Character whiteSpace = new Character( ' ' );
		//全角スペース
		Character whiteSpace_ja = new Character( '　' );
		System.out.println(" charValLower[" + charValLower + "]");
		System.out.println(" charValUpper[" + charValUpper + "]");
		System.out.println(" whiteSpace[" + whiteSpace + "]");
		System.out.println(" whiteSpace[" + whiteSpace_ja + "]");

		System.out.println(" Character.isDigit( charValLower ) :" + Character.isDigit( charValLower ) );
		System.out.println(" Character.isLetter( charValLower ) :" + Character.isLetter( charValLower ) );
		System.out.println(" Character.isLetterOrDigit( charValLower ) :" + Character.isLetterOrDigit( charValLower ) );
		System.out.println(" Character.toLowerCase( charValUpper ) :" + Character.toLowerCase( charValUpper ) );
		System.out.println(" Character.toUpperCase( charValLower ) :" + Character.toUpperCase( charValLower ) );
		System.out.println(" Character.isWhiteSpace( whiteSpace ) :" + Character.isWhitespace( whiteSpace ) );
		System.out.println(" Character.isWhiteSpace( whiteSpace_ja ) :" + Character.isWhitespace( whiteSpace_ja ) );

		outputEndMethod( "outputCharacterSample" );
	}

	/**
	 * Stringクラスのサンプル
	 * コンストラクタ、文字列連結、長さ
	 */
	public void outputStringSample(){
		outputStartMethod( "outputStringConstructSample" );

		String str = new String("日本");
		String str2 = "日本";
	    char[] charArrays = {'日' , '本'};
	    String str3 = new String( charArrays );
	    String str4  = "のおもてなし";

		System.out.println(" new String(\"日本\");" + str );
		System.out.println("\"日本\";" + str2 );
		System.out.println(" new String( {'日','本'} );" + str3 );

		System.out.println("str.legnth:" + str.length() );
		System.out.println("str.getBytes().legnth:" + str.getBytes().length  );

		System.out.println("str + str4:" + str + str4 );
		System.out.println("str.concat( str4: )" + str + str4 );

		outputEndMethod( "outputStringSample" );
	}

	/**
	 * Stringクラスのサンプル
	 * コンストラクタ、文字列連結、長さ
	 */
	public void outputStringFormatSample(){
		outputStartMethod( "outputStringFormatSample" );

		Integer a = new Integer(100);
		Float b = 3.1415f;
		String c = "百十ー";
		java.util.Date now = new java.util.Date();
		String strFormat ="%d is a Integer value.\n %.2f is Float value.\n %s is a String Value.\n Now is %tY年 %tm月 %td日";

		String result = String.format( strFormat , a , b, c  , now , now , now);
		System.out.println( "a=" + a );
		System.out.println( "b=" + b );
		System.out.println( "c=" + c );
		System.out.println( "now=" + now );
		System.out.println( "strFormat=" + strFormat);
		System.out.println( "result=" + result);

		outputEndMethod( "outputStringFormatSample" );
	}

	/**
	 * Stringクラスのサンプル
	 * コンストラクタ、文字列連結、長さ
	 */
	public void outputStringToNumberSample(){
		outputStartMethod( "outputStringToNumberSample" );

		Byte byteObj = new Byte( "10" );
		Short shortObj = new Short( "10" );
		Integer integerObj = new Integer( "10" );
		Long longObj = new Long( "10" );
		Float floatObj = new Float( "10.001" );
		Double doubleObj = new Double( "10.00001" );

		System.out.println( "Byte:" + byteObj );
		System.out.println( "Short:" + shortObj );
		System.out.println( "Integer:" + integerObj );
		System.out.println( "Long:" + longObj );
		System.out.println( "Float:" + floatObj );
		System.out.println( "Double:" + doubleObj );


		Byte byteObj2 = Byte.valueOf( "10" );
		Short shortObj2 = Short.valueOf( "10" );
		Integer integerObj2 = Integer.valueOf( "10" );
		Long longObj2 = Long.valueOf( "10" );
		Float floatObj2 = Float.valueOf( "10.001" );
		Double doubleObj2 = Double.valueOf( "10.00001" );

		System.out.println("Byte.valueOf( \"10\" )=" + byteObj2 );
		System.out.println("Short.valueOf( \"10\" )=" + shortObj2 );
		System.out.println("Integer.valueOf( \"10\" )=" + integerObj2 );
		System.out.println("Long.valueOf( \"10\" )=" + longObj2 );
		System.out.println("Float.valueOf( \"10.001\" )=" + floatObj2);
		System.out.println("Double.valueOf( \"10.00001\" )=" + doubleObj2);

		byte byteNumber = byteObj.byteValue();
		short shortNumber= shortObj.shortValue();
		int intNumber =  integerObj.intValue();
		long longNumber = longObj.longValue();
		float floatNumber = floatObj.floatValue();
		double dobuleObj = doubleObj.doubleValue();

		System.out.println("byteObj.byteValue()=" + byteNumber );
		System.out.println("shortObj.shortValue()=" + shortNumber );
		System.out.println("integerObj.intValue()=" + intNumber );
		System.out.println("longObj.longValue()=" + longNumber );
		System.out.println("floatNumber=" + floatNumber );
		System.out.println("doubleObj.doubleValue()=" + dobuleObj);

		outputEndMethod( "outputStringToNumberSample" );
	}

	/**
	 * Stringクラスの加工・切り取りサンプル
	 */
	public void outputStringProcessingSample(){
		outputStartMethod( "outputStringProcessingSample" );

		String str = "Javaプログラムは、オブジェクト指向言語であり、大変学習がしやすいです。 " +
	              "JAVAは、英語でジャワ産のコーヒーも意味します。JAvaのロゴが、コーヒーカップだったの理解できます。";

		String newStr  = str.replaceAll("プログラム" ," Program" ) ;
		String newStr2 = str.replaceAll("(?i)JAVA" ,"Java" ) ;
		System.out.println("str:" + str);
		System.out.println("newStr:" + newStr);
		System.out.println("newStr2:" + newStr2);

		String str2 = "Java1.4,JAVA5,JavaSE,JAva,JDK,Java";
		String[] strArrays = str2.split(",");
		String[] strArrays2 = str2.split("(?i)JAVA");

		for( int i = 0 ; i < strArrays.length ; i++ ){
			System.out.println("strArrays[" + i + "]=" + strArrays[i]);
		}

		for( int i = 0 ; i < strArrays2.length ; i++ ){
			System.out.println("strArrays2[" + i + "]=" + strArrays2[i]);
		}

		String userId = "201402054100005";
		UserIdCode userIdCode = new UserIdCode( userId );
		System.out.println( userIdCode.toString() );

		System.out.println( "Java".toUpperCase() );
		System.out.println( "Java".toLowerCase() );

		outputEndMethod( "outputStringProcessingSample" );
	}

	/**
	 * Stringクラスの検索・比較サンプル
	 */
	public void outputStringSearchSample(){
		outputStartMethod( "outputStringSearchSample" );

		System.out.println( "Java".equals( "Java" ) );
		System.out.println( "Java".equals( "JAVA" ) );

		String str = "Javaプログラムは、とても理解し易い言語です。";
		System.out.println( "firstIndex:" + str.indexOf("とても") );
		System.out.println( "firstIndex:" + str.indexOf("very") );

		String str2 = "Java1.4,Java5,JavaSE,JavaEE,Java8";
		System.out.println("lastIndex:" + str2.lastIndexOf("Java") );

		String str3 = "Java1.4,Java5,JavaSE,JavaEE,Java8";
		System.out.println( "str3:" + str3 );
		System.out.println( "str3.charAt( 4 ):" + str3.charAt( 4 ) );

		outputEndMethod( "outputStringSearchSample" );
	}

	/**
	 * Stringクラスの検索・比較サンプル
	 */
	public void outputAutoBoxingSample(){
		outputStartMethod( "outputAutoBoxingSample" );

		//プリミティブ型からラッパークラスの生成
		Integer i = new Integer(100);
		//ラッパークラスからintへの変換
		int i2 = i.intValue();

		//プリミティブ型からラッパークラスの生成
		long l = i2 * i;

		System.out.println( "Integer i :" + i );
		System.out.println( "int i2    :" + i2 );
		System.out.println( "i2 * i    :" + l );

		outputEndMethod( "outputAutoBoxingSample" );
	}


	/**
	 * javaコマンドで実行するサンプル
	 * @param args javaコマンドの引数[不要]
	 */
	public static final void main( String[] args ){

		StringSamples stringSamples = new StringSamples();
		stringSamples.execAllSamples();

	}

}
