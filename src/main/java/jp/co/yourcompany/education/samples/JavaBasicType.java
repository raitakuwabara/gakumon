/**
 * Copyright 2017 yourcompany.
 * 本ソースファイルの著作権は株式会社hogeに所属します。
 * 株式会社yourcompanyの許可なくして、本ソースファイルの
 * 配布、改修、コピー、利用を禁止します。
 * 会社名				：株式会社yourcompany
 * 組織名				：システム開発部
 * プロジェクトコード	：education
 * バージョン			：1.0
 * 最終更新日時			：2017/02/22 10:30
 */

//package宣言部
package jp.co.yourcompany.education.samples;


/**
 *
 * このクラスは、Javaのプ８つのリミティブ型の利用方法について
 * 学習するためのクラスです。
 * ８つ＋Stringクラスの標準出力にメッセージを出力するクラスです。
 *
 * @author Raita.Kuwabara
 *
 */
public class JavaBasicType {

	//定数宣言部
	//1.byte型

	/**
	 * byte型最小値 Byte.MIN_VALUEと同値(2<sup>-7</sup>)
	 * @see java.lang.Byte.MIN_VALUE
	 */
	//-129にするとコンパイルエラーが発生します。
	public static final byte BYTE_MIN_VALUE = -128;

	/**
	 * byte型最大値 Byte.MAX_VALUEと同値(2<sup>7</sup> - 1)
	 * @see java.lang.Byte.MAX_VALUE
	 */

	//128にするとコンパイルエラーが発生します。
	public static final byte BYTE_MAX_VALUE = 127;

	/**
	 * byte型２進法サンプル固定値 26
	 */
	public static final byte BYTE_BINARY_SAMPLE_VALUE = 0b11010;

	/**
	 * byte型１０進法サンプル固定値 26
	 */
	public static final byte BYTE_DECIMAL_SAMPLE_VALUE = 26;

	/**
	 * byte型１６進法サンプル固定値 26
	 */
	public static final byte BYTE_HEXADECIMAL_SAMPLE_VALUE = 0x1a;


	//2.short型
	/**
	 * short最小値 Short.MIN_VALUEと同値(2<sup>-15</sup>)
	 * @see java.lang.Short.MIN_VALUE
	 */
	//-32769にするとコンパイルエラーが発生します。
	public static final short SHORT_MIN_VALUE = -32768;

	/**
	 * short最大値 Short.MAX_VALUEと同値(2<sup>15</sup> - 1)
	 * @see java.lang.Short.MAX_VALUE
	 */
	//32768にするとコンパイルエラーが発生します。
	public static final short SHORT_MAX_VALUE = 32767;

	/**
	 * short型２進法サンプル固定値 128(byteでは表現できない値)
	 */
	public static final short SHORT_BINARY_SAMPLE_VALUE = 0b10000000;

	/**
	 * short型１０進法サンプル固定値 128(byteでは表現できない値)
	 */
	public static final short SHORT_DECIMAL_SAMPLE_VALUE = 128;

	/**
	 * shorte型１６進法サンプル固定値 128(byteでは表現できない値)
	 */
	public static final short SHORT_HEXADECIMAL_SAMPLE_VALUE = 0x80;


	//3.int型
	/**
	 * int型最小値 Integer.MIN_VALUEと同値(2<sup>-31</sup>)
	 * @see java.lang.Integer.MIN_VALUE
	 */
	//-2147483649にするとコンパイルエラーが発生します。
	public static final int INT_MIN_VALUE = -2147483648;

	/**
	 * int型最大値 Integer.MAX_VALUEと同値(2<sup>31</sup> - 1)
	 * @see java.lang.Integer.MAX_VALUE
	 */
	//2147483648にするとコンパイルエラーが発生します。
	public static final int INT_MAX_VALUE = 2147483647;

	/**
	 * 符号無しintの最大値(2<sup>32</sup>-1)
	 * このように符号有(標準)のintと符号無(Java8より)のintがプログラム内で混同するのは好ましくありません。
	 * 特定の理由がない限り、long型を利用しましょう。
	 * @see java.lang.Integer.MAX_VALUE
	 */
	//4294967296にするとコンパイルエラーが発生します。
	public static final int UNSIGNED_INT_MAX_VALUE = Integer.parseUnsignedInt("4294967295");

	/**
	 * int型２進法サンプル固定値 32768(shortでは表現できない値)
	 * これは人が理解する表現方法として好ましくありません。
	 */
	public static final int INT_BINARY_SAMPLE_VALUE = 0b1000000000000000;

	/**
	 * int型１０進法サンプル固定値 32768(shortでは表現できない値)
	 */
	public static final int INT_DECIMAL_SAMPLE_VALUE = 32768;

	/**
	 * int型１６進法サンプル固定値 32768(shortでは表現できない値)
	 */
	public static final int INT_HEXADECIMAL_SAMPLE_VALUE = 0x8000;


	//4.long型
	/**
	 * long型最小値 Long.MIN_VALUEと同値(2<sup>-63</sup>)
	 * @see java.lang.Long.MIN_VALUE
	 */

	//-9223372036854775809Lにするとコンパイルエラーが発生します。
	//数値リテラルなので、-2147483648Lの「L」longのリテラルを外すとコンパイルエラーが発生します。
	public static final long LONG_MIN_VALUE = -9223372036854775808L;

	/**
	 * long型最大値 Integer.MAX_VALUEと同値(2<sup>63</sup> - 1)
	 * @see java.lang.Long.MAX_VALUE
	 */
	//9223372036854775808Lにするとコンパイルエラーが発生します。
	public static final long LONG_MAX_VALUE = 9223372036854775807L;

	/**
	 * 符号無しlong型の最大値(2<sup>64</sup>-1)
	 * このように符号有(標準)のlongと符号無(Java8より)のlongがプログラムで混同するのは好ましくありません。
	 * longに収まりきらない値は、オブジェクト型のjava.math.BigIntegerを利用します。
	 * @see java.math.BigInteger
	 */
	//18446744073709551616にするとコンパイルエラーが発生します。
	public static final long UNSIGNED_LONG_MAX_VALUE = Long.parseUnsignedLong("18446744073709551615");

	/**
	 * long型２進法サンプル固定値 32768(shortでは表現できない値)
	 * これは人が理解する表現方法として好ましくありません。
	 */
	public static final long LONG_BINARY_SAMPLE_VALUE = 0b1000_0000_0000_0000_0000_0000_0000_0000L;

	/**
	 * long型１０進法サンプル固定値 2147483648(標準の符号あり整数のintでは表現できない値)
	 */
	public static final long LONG_DECIMAL_SAMPLE_VALUE = 2147483648L;

	/**
	 * long型１６進法サンプル固定値 32768(shortでは表現できない値)
	 */
	public static final long LONG_HEXADECIMAL_SAMPLE_VALUE = 0x80000000L;


	//5.float型
	/**
	 * float型最小値(正) Float.MIN_VALUEと同値(2<sup>-149</sup>)
	 * @see java.lang.Float.MIN_VALUE
	 */

	//1.401298464324816e-46fにするとコンパイルエラーが発生します。
	//数値リテラルなので、1.401298464324816e-45Fの「f」floatのリテラルを外すとコンパイルエラーが発生します。
	public static final float FLOAT_MIN_VALUE = 1.401298464324816e-45f;

	/**
	 * float型最大値(正) Float.MAX_VALUEと同値(2-2<sup>-23</sup>)·2<sup>127</sup>
	 * @see java.lang.Float.MAX_VALUE
	 */
	//3.4028234663852886e+39fにするとコンパイルエラーが発生します。
	//数値リテラルなので、3.4028234663852886e+38fの「f」floatのリテラルを外すとコンパイルエラーが発生します。
	public static final float FLOAT_MAX_VALUE = 3.4028234663852886e+38f;

	/**
	 * float型サンプル固定値 3.1415(円周率)
	 */
	public static final float FLOAT_DECIMAL_SAMPLE_VALUE =  3.1415f;


	//6.double型
	/**
	 * double型最小有限値 Double.MIN_VALUEと同値(2<sup>-1074</sup>)
	 * @see java.lang.Double.MIN_VALUE
	 */

	//4.9406564584124654417656879286822137236505980261432E-325dにするとコンパイルエラーが発生します。
	//浮動小数点の数値リテラルのデフォルトはdoubleのため接尾文字「d」を外してもエラーになりません。
	public static final double DOUBLE_MIN_VALUE = 4.9406564584124654417656879286822137236505980261432e-324d;

	/**
	 * double型最大値(正) Float.MAX_VALUEと同値(2-2<sup>-52</sup>)·2<sup>1023</sup>
	 * @see java.lang.Double.MAX_VALUE
	 */
	//1.7976931348623157E309Dにするとコンパイルエラーが発生します。
	//浮動小数点の数値リテラルのデフォルトはdoubleのため接尾文字「d」を外してもエラーになりません。
	public static final double DOUBLE_MAX_VALUE = 1.7976931348623157E308d;

	/**
	 * doble型サンプル固定値 3.1415....(円周率)
	 */
	public static final double DOUBLE_DECIMAL_SAMPLE_VALUE =  3.14159265358979323846264338327950288419716939937510582097494459230781640628620899d ;

	//7.char型
	/**
	 * char型の最小値 Character.MIN_VALUEと同値
	 * @see java.lang.Character.MIN_VALUE
	 */

	//'\u0000'を「&yen;u」のどちらかの文字が漏れてもエラーになります。
	//'\u0000'を「0000」の数値桁数を変えるとエラーになります。(Unicodeは１６進数表記４桁のため)
	public static final char CHAR_MIN_VALUE = '\u0000';

	/**
	 * char型の最小値 Character.MAX_VALUEと同値
	 * @see java.lang.Character.MAX_VALUE
	 */
	public static final char CHAR_MAX_VALUE = '\uFFFF';


	/**
	 * char型サンプル１ （&#x00F7;）SJIS表示で除算記号
	 */
	public static final char CHAR_UNICODE_SAMPLE_VALUE = '\u00F7';

	/**
	 * char型サンプル２
	 */
	//char型なので １文字以上指定するとコンパイルエラーになります。
	public static final char CHAR_SAMPLE_VALUE = 'あ';

	/**
	 * char型サンプル３
	 */
	//char型は、unicodeの数値範囲を0～65535(16進法 0000～FFFF)の間が指定できます。
	//65536や-1を指定するとコンパイルエラーになります。
	//\uFFFF と同値です。
	public static final char CHAR_NUMBER_SAMPLE_VALUE = 65535;


	//8.boolean型 固定値省略(false/trueの２択のため)


	//メンバー変数

	//デフォルト値確認用
	private byte byteValue;

	private short shortValue;

	private int intValue;

	private long longValue;

	private float floatValue;

	private double doubleValue;

	private char charValue;

	private boolean booleanValue;

	private String stringValue;



	/**
	 * デフォルトコンストラクタ
	 */
	public JavaBasicType() {
		//doNothing
	}

	/**
	 * [主処理]
	 * ８つの基本型のサンプルデータを順に出力する。
	 * Stringクラスのサンプルを最後に出力する。
	 */
	public void outputAllSamples(){

		outputByteSamples();

		outputShortSamples();

		outputIntSamples();

		outputLongSamples();

		outputFloatSamples();

		outputDoubleSamples();

		outputBooleanSamples();

		outputCharSamples();

		outputStringSamples();

	}


	/**
	 * byte型データ各種表記方法を標準出力にする。
	 */
	public void outputByteSamples(){

		System.out.print( "byte型デフォルト値:");
		System.out.println( getByteValue() );

		System.out.print( "byte型最小値:");
		System.out.println(  JavaBasicType.BYTE_MIN_VALUE );

		System.out.print( "byte型最大値:");
		System.out.println(  JavaBasicType.BYTE_MAX_VALUE );

		System.out.print( "BYTE_BINARY_SAMPLE_VALUE:");
		System.out.println(  JavaBasicType.BYTE_BINARY_SAMPLE_VALUE );

		System.out.print( "BYTE_DECIMAL_SAMPLE_VALUE:");
		System.out.println(  JavaBasicType.BYTE_DECIMAL_SAMPLE_VALUE );

		System.out.print( "BYTE_HEXADECIMAL_SAMPLE_VALUE:");
		System.out.println(  JavaBasicType.BYTE_HEXADECIMAL_SAMPLE_VALUE );

		System.out.println( "----------  END byte METHOD ------------------");

	}


	/**
	 * short型データ各種表記方法を標準出力にする。
	 */
	public void outputShortSamples(){

		System.out.print( "short型デフォルト値:");
		System.out.println( getShortValue() );

		System.out.print( "short型最小値:");
		System.out.println(  JavaBasicType.SHORT_MIN_VALUE );

		System.out.print( "short型最大値:");
		System.out.println(  JavaBasicType.SHORT_MAX_VALUE );

		System.out.print( "SHORT_BINARY_SAMPLE_VALUE:");
		System.out.println(  JavaBasicType.SHORT_BINARY_SAMPLE_VALUE );

		System.out.print( "SHORT_DECIMAL_SAMPLE_VALUE:");
		System.out.println(  JavaBasicType.SHORT_DECIMAL_SAMPLE_VALUE );

		System.out.print( "SHORT_HEXADECIMAL_SAMPLE_VALUE:");
		System.out.println(  JavaBasicType.SHORT_HEXADECIMAL_SAMPLE_VALUE );

		System.out.println( "----------  END short METHOD ------------------");

	}

	/**
	 * int型データ各種表記方法を標準出力にする。
	 */
	public void outputIntSamples(){

		System.out.print( "int型デフォルト値:");
		System.out.println( getIntValue() );

		System.out.print( "int型最小値:");
		System.out.println(  JavaBasicType.INT_MIN_VALUE );

		System.out.print( "int型最大値:");
		System.out.println(  JavaBasicType.INT_MAX_VALUE );

		System.out.print( "INT_BINARY_SAMPLE_VALUE:");
		System.out.println(  JavaBasicType.INT_BINARY_SAMPLE_VALUE );

		System.out.print( "INT_DECIMAL_SAMPLE_VALUE:");
		System.out.println(  JavaBasicType.INT_DECIMAL_SAMPLE_VALUE );

		System.out.print( "INT_BINARY_SAMPLE_VALUE:");
		System.out.println(  JavaBasicType.INT_HEXADECIMAL_SAMPLE_VALUE );

		System.out.print( "UNSIGNED_INT_MAX_VALUE:");
		//System.out.printに直接符号無intを代入すると[-1]が表示されます。
		//以下のように記述します。
		System.out.println(  Integer.toUnsignedString( JavaBasicType.UNSIGNED_INT_MAX_VALUE ) );

		System.out.println( "----------  END int METHOD ------------------");

	}

	/**
	 * byte型データ各種表記方法を標準出力にする。
	 */
	public void outputLongSamples(){

		System.out.print( "longデフォルト値:");
		System.out.println( getLongValue() );

		System.out.print( "long型最小値:");
		System.out.println(  JavaBasicType.LONG_MIN_VALUE );

		System.out.print( "long型最大値:");
		System.out.println(  JavaBasicType.LONG_MAX_VALUE );

		System.out.print( "LONG_BINARY_SAMPLE_VALUE:");
		System.out.println(  JavaBasicType.LONG_BINARY_SAMPLE_VALUE );

		System.out.print( "LONG_DECIMAL_SAMPLE_VALUE:");
		System.out.println(  JavaBasicType.LONG_DECIMAL_SAMPLE_VALUE );

		System.out.print( "LONG_HEXADECIMAL_SAMPLE_VALUE:");
		System.out.println(  JavaBasicType.LONG_HEXADECIMAL_SAMPLE_VALUE );

		System.out.print( "UNSIGNED_LONG_MAX_VALUE:");
		//System.out.printに直接符号無longを代入すると[-1]が表示されます。
		//以下のように記述します。
		System.out.println( Long.toUnsignedString( JavaBasicType.UNSIGNED_LONG_MAX_VALUE ) );


		System.out.println( "----------  END long METHOD ------------------");

	}


	/**
	 * float型データ各種表記方法を標準出力にする。
	 */
	public void outputFloatSamples(){

		System.out.print( "float型デフォルト値:");
		System.out.println( getFloatValue() );

		System.out.print( "float型最小値:");
		System.out.println(  JavaBasicType.FLOAT_MIN_VALUE );

		System.out.print( "float型最大値:");
		System.out.println(  JavaBasicType.FLOAT_MAX_VALUE );

		System.out.print( "FLOAT_DECIMAL_SAMPLE_VALUE:");
		System.out.println(  JavaBasicType.FLOAT_DECIMAL_SAMPLE_VALUE );

		System.out.println( "----------  END float METHOD ------------------");

	}

	/**
	 * double型データ各種表記方法を標準出力にする。
	 */
	public void outputDoubleSamples(){

		System.out.print( "double型デフォト値:");
		System.out.println( getFloatValue() );

		System.out.print( "dobule型最小値:");
		System.out.println(  JavaBasicType.DOUBLE_MIN_VALUE );

		System.out.print( "dobule型最大値:");
		System.out.println(  JavaBasicType.DOUBLE_MAX_VALUE );

		System.out.print( "DOUBLE_DECIMAL_SAMPLE_VALUE:");
		System.out.println(  JavaBasicType.DOUBLE_DECIMAL_SAMPLE_VALUE );

		System.out.println( "----------  END double METHOD ------------------");
	}

	/**
	 * boolean型データ各種表記方法を標準出力にする。
	 */
	public void outputBooleanSamples(){

		System.out.print( "boolean型デフォト値:");
		System.out.println( isBooleanValue() );

		System.out.print( "boolean型true:");
		System.out.println(  true );

		System.out.print( "boolean型false:");
		System.out.println( false );

		System.out.println( "----------  END boolean METHOD ------------------");

	}


	/**
	 * char型データ各種表記方法を標準出力にする。
	 */
	public void outputCharSamples(){

		System.out.print( "char型デフォト値:");
		System.out.println( getCharValue() );

		System.out.print( "char型最小値:");
		System.out.println(  JavaBasicType.CHAR_MIN_VALUE );

		System.out.print( "char型最大値:");
		System.out.println(  JavaBasicType.CHAR_MAX_VALUE );

		System.out.print( "CHAR_UNICODE_SAMPLE_VALUE:");
		System.out.println(  JavaBasicType.CHAR_UNICODE_SAMPLE_VALUE );

		System.out.print( "CHAR_SAMPLE_VALUE:");
		System.out.println(  JavaBasicType.CHAR_SAMPLE_VALUE );

		System.out.print( "CHAR_NUMBER_SAMPLE_VALUE:");
		System.out.println( );
		System.out.println( "----------  END char METHOD ------------------");

	}


	/**
	 * char型データ各種表記方法を標準出力にする。
	 */
	public void outputStringSamples(){

		System.out.print( "String型デフォト値:");
		System.out.println( getStringValue() );


		System.out.println( "STRING_SAMPLE_VALUE:");
		System.out.println( "バックスペース前\bバックスラッシュ後");
		System.out.println( "水平タブ前\t水平タブ後");
		System.out.println( "復帰コード前\r復帰コード後");
		System.out.println( "改行コード前\n改行コード後");
		System.out.println( "ダブルクオテーション前\"ダブルクオテーション後");
		System.out.println( "シンルクオテーション前\'シンルクオテーション後");
		System.out.println( "バックスラッシュ前\\バックスラッシュ後");

		System.out.println( "----------  END String METHOD ------------------");
	}

	//プロパティ宣言部

	/**
	 * byte型データを取得する。
	 * @return byteValue byte型データ
	 */
	public byte getByteValue() {
		return byteValue;
	}

	/**
	 * byte型データを設定する。
	 * @param byteValue byte型データ
	 */
	public void setByteValue(byte byteValue) {
		this.byteValue = byteValue;
	}

	/**
	 * short型データを取得する。
	 * @return shortValue short型データ
	 */
	public short getShortValue() {
		return shortValue;
	}

	/**
	 * short型データを設定する。
	 * @param  shortValue short型データ
	 */
	public void setShortValue(short shortValue) {
		this.shortValue = shortValue;
	}

	/**
	 * int型データを取得する。
	 * @return intValue int型データ
	 */
	public int getIntValue() {
		return intValue;
	}

	/**
	 * int型データを設定する。
	 * @param intValue int型データ
	 */
	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}

	/**
	 * long型データを取得する。
	 * @return longValue long型データ
	 */
	public long getLongValue() {
		return longValue;
	}

	/**
	 * long型データを設定する。
	 * @param longValue long型データ
	 */
	public void setLongValue(long longValue) {
		this.longValue = longValue;
	}

	/**
	 * float型データを取得する。
	 * @return floatValue;
	 */
	public float getFloatValue() {
		return floatValue;
	}

	/**
	 * float型データを設定する。
	 * @param floatValue float型データ
	 */
	public void setFloatValue(float floatValue) {
		this.floatValue = floatValue;
	}

	/**
	 * double型データを取得する。
	 * @return doubleValue double型データ
	 */
	public double getDoubleValue() {
		return doubleValue;
	}

	/**
	 * doubleValue型データを設定する。
	 * @param doubleValue double型データ
	 */
	public void setDoubleValue(double doubleValue) {
		this.doubleValue = doubleValue;
	}

	/**
	 * char型データを取得する。
	 * @return charValue char型データ
	 */
	public char getCharValue() {
		return charValue;
	}

	/**
	 * charValue型データを設定する。
	 * @param charValue char型データ
	 */
	public void setCharValue(char charValue) {
		this.charValue = charValue;
	}

	/**
	 * boolean型のデータを取得する。
	 * @return booleanValue boolean型データ；
	 */
	public boolean isBooleanValue() {
		return booleanValue;
	}

	/**
	 * boolean型のデータを設定する。
	 * @param booleanValue boolean型データ
	 */
	public void setBooleanValue(boolean booleanValue) {
		this.booleanValue = booleanValue;
	}

	/**
	 * Stringクラスのデータを取得する。
	 * @return stringValue 文字列
	 */
	public String getStringValue() {
		return stringValue;
	}

	/**
	 * Stringクラスのデータを設定する。
	 * @param stringValue 文字列
	 */
	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	//main

	/**
	 * javaコマンドで起動されるmainメソッド
	 * JavaBasicTypeのインスタンスを生成し、全てのサンプルを出力する。
	 * @param args javaコマンドで引き渡しされる引数
	 */
	public static void main( String[] args ) {

		JavaBasicType javaBasicType = new JavaBasicType();

		javaBasicType.outputAllSamples();

	}
}