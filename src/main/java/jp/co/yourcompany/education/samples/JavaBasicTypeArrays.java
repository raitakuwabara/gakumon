/**
 * Copyright 2017 yourcompany.
 * 本ソースファイルの著作権は株式会社yourcompanyに所属します。
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
 * このクラスは、Javaのプ８つのリミティブ型とStringの配列方法について
 * 学習するためのクラスです。
 *
 * @author Raita.Kuwabara
 *
 */
public class JavaBasicTypeArrays {

	//メンバー変数

	private byte[] byteArrays;

	private short[] shortArrays;

	private int[] intArrays;

	private long[] longArrays;

	private float[] floatArrays;

	private double[] doubleArrays;

	private char[] charArrays;

	private boolean[] booleanArrays;

	private String[] stringArrays;



	/**
	 * デフォルトコンストラクタ
	 * 実行順番1-0-0
	 */
	public JavaBasicTypeArrays() {
		//各種配列にサンプルデータを初期設定します。
		init();
	}

	/**
	 * メンバ変数初期設定処理
	 * 実行順番2
	 */
	public void init(){

		setByteSampleArrays();

		setShortSampleArrays();

		setIntSampleArrays();

		setLongSampleArrays();

		setFloatSampleArrays();

		setDoubleSampleArrays();

		setBooleanSampleArrays();

		setCharSampleArrays();

		setStringSampleArrays();

	}

	/**
	 * メンバー変数に設定されている配列の値を全て出力する。
	 */
	public void outputAllArrays(){

		System.out.println(" ----- START [byte型] ------");
		for( int i = 0; i < byteArrays.length ; i++){
			System.out.println("byteArrays[ " + i +" ]=" + byteArrays[i] );
		}

		System.out.println(" ----- START [short型] ------");
		for( int i = 0; i < shortArrays.length ; i++){
			System.out.println("shortArrays[ " + i + " ]=" + shortArrays[i] );
		}

		System.out.println(" ----- START [int型] ------");
		for( int i = 0; i < intArrays.length ; i++){
			System.out.println("intArrays[ " + i +" ]=" + intArrays[i] );
		}

		System.out.println(" ----- START [long型] ------");
		for( int i = 0; i < longArrays.length ; i++){
			System.out.println("longArrays[ " + i +" ]=" + longArrays[i] );
		}

		System.out.println(" ----- START [float型] ------");
		for( int i = 0; i < floatArrays.length ; i++){
			System.out.println("floatArrays[ " + i +" ]=" + floatArrays[i] );
		}

		System.out.println(" ----- START [double型] ------");
		for( int i = 0; i < doubleArrays.length ; i++){
			System.out.println("doubleArrays[ " + i +" ]=" + doubleArrays[i] );
		}

		System.out.println(" ----- START [boolean型] ------");
		for( int i = 0; i < booleanArrays.length ; i++){
			System.out.println("booleanArrays[ " + i +" ]=" + booleanArrays[i] );
		}

		System.out.println(" ----- START [char型] ------");
		for( int i = 0; i < charArrays.length ; i++){
			System.out.println("charArrays[ " + i +" ]=" + charArrays[i] );
		}

		System.out.println(" ----- START [String型] ------");
		for( int i = 0; i < stringArrays.length ; i++){
			System.out.println("stringArrays[ " + i +" ]=" + stringArrays[i] );
		}

	}


	/**
	 * byte型の配列のサンプル値を設定する。
	 */
	private void setByteSampleArrays() {
		byteArrays = new byte[5];
		byteArrays[0] = 0b0001; //1
		byteArrays[1] = 0b0010; //2
		byteArrays[2] = 0b0011; //3
		byteArrays[3] = 0b0100; //4
		byteArrays[4] = 0b0101; //5
	}

	/**
	 * short型の配列のサンプル値を設定する。
	 */
	private void setShortSampleArrays() {
		shortArrays = new short[5];
		shortArrays[0] = 11;
		shortArrays[1] = 12;
		shortArrays[2] = 13;
		shortArrays[3] = 14;
		shortArrays[4] = 15;
	}

	/**
	 * int型の配列のサンプル値を設定する。
	 */
	private void setIntSampleArrays() {
		intArrays = new int[5];
		intArrays[0] = 101;
		intArrays[1] = 102;
		intArrays[2] = 103;
		intArrays[3] = 104;
		intArrays[4] = 105;
	}

	/**
	 * long型の配列のサンプル値を設定する。
	 */
	private void setLongSampleArrays() {
		longArrays = new long[5];
		longArrays[0] = 1001L;
		longArrays[1] = 1002L;
		longArrays[2] = 1003L;
		longArrays[3] = 1004L;
		longArrays[4] = 1005L;
	}

	/**
	 * float型の配列のサンプル値を設定する。
	 */
	private void setFloatSampleArrays() {
		floatArrays = new float[5];
		floatArrays[0] = 0.1f;
		floatArrays[1] = 0.2f;
		floatArrays[2] = 0.3f;
		floatArrays[3] = 0.4f;
		floatArrays[4] = 0.5f;
	}

	/**
	 * double型の配列のサンプル値を設定する。
	 */
	private void setDoubleSampleArrays() {
		doubleArrays = new double[5];
		doubleArrays[0] = 0.01d;
		doubleArrays[1] = 0.02d;
		doubleArrays[2] = 0.03d;
		doubleArrays[3] = 0.04d;
		doubleArrays[4] = 0.05d;
	}

	/**
	 * boolean型の配列のサンプル値を設定する。
	 */
	private void setBooleanSampleArrays() {
		booleanArrays = new boolean[5];
		booleanArrays[0] = true;
		booleanArrays[1] = false;
		booleanArrays[2] = true;
		booleanArrays[3] = false;
		booleanArrays[4] = true;
	}

	/**
	 * char型の配列のサンプル値を設定する。
	 */
	private void setCharSampleArrays() {
		charArrays = new char[5];
		charArrays[0] = 'あ';
		charArrays[1] = 'い';
		charArrays[2] = 'う';
		charArrays[3] = 'え';
		charArrays[4] = 'お';
	}


	/**
	 * String型の配列のサンプル値を設定する。
	 */
	private void setStringSampleArrays() {
		stringArrays = new String[5];
		stringArrays[0] = "配列１番目";
		stringArrays[1] = "配列２番目";
		stringArrays[2] = "配列３番目";
		stringArrays[3] = "配列４番目";
		stringArrays[4] = "配列５番目";
	}

	//---------------- 良く起きるexceptionシリーズ

	/**
	 * javaコマンドで起動されるmainメソッド
	 * JavaBasicTypeのインスタンスを生成し、全てのサンプルを出力する。
	 * @param args javaコマンドで引き渡しされる引数
	 */
	public static void main( String[] args ) {

		JavaBasicTypeArrays javaBasicTypeArrays = new JavaBasicTypeArrays();
		javaBasicTypeArrays.outputAllArrays();

	}
}