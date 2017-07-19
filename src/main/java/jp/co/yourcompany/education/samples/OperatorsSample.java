/**
 * Copyright 2017 yourcomapny.
 * 本ソースファイルの著作権は株式会社yourcomapnyに所属します。
 * 株式会社yourcomapnyの許可なくして、本ソースファイルの
 * 配布、改修、コピー、利用を禁止します。
 * 会社名				：株式会社yourcomapny
 * 組織名				：システム開発部
 * プロジェクトコード	：education
 * バージョン			：1.0
 * 最終更新日時			：2017/02/10 17:21
 */

//package宣言部
package jp.co.yourcompany.education.samples;

//import 宣言部


/**
 * Javaプログラムの演算子に関して
 * 利用方法や動作を検証するクラス
 * @author Raita.Kuwabara
 */
public class OperatorsSample extends AbstractSamples{

	//定数宣言部・・なし

	//プロパティ宣言部 ・・なし

	//デフォルトコンストラクタ宣言部・・なし

	/**
	 * 全てのサンプルを実行する。
	 */
	public void execAllSamples() {

		arithmeticOperatorSamples();

		invalidUnaryOperatorSamples();

		unaryOperatorSamples();

		comparisonOperatorSamples();

		logicalOperatorSamples();

		assignmentOperatorSamples();

		ternaryOperatorSamples();

		shiftOperatorSamples();

		binaryOperatorSamples();

	}


	//---------------------------------------- 算術演算子用

	public void arithmeticOperatorSamples(){
		outputStartMethod("arithmeticOperatorSamples");
		int x = 10;
		int y = 3;

		String a = new String( "日本の" );
		String b = new String( "おもてなし" );

		System.out.println( "初期値x =" + x );
		System.out.println( "初期値y =" + y );
		System.out.println( "x + y =" + add( x , y ) );
		System.out.println( "x - y =" + subtract( x , y ) );
		System.out.println( "x * y =" + multiple( x , y ) );
		System.out.println( "x / y =" + divide( x , y ) );
		System.out.println( "x % y =" + reminder( x , y ) );

		System.out.println( "初期値a =" + a );
		System.out.println( "初期値b =" + b );
		System.out.println( "a + b =" + concat( a , b ) );


		System.out.println( "------ CAST SAMPLE ------" );

		int c = Integer.MAX_VALUE;
		int d = Integer.MAX_VALUE;
		System.out.println( "初期値c =" + c );
		System.out.println( "初期値d =" + d );
		System.out.println( "c + d =" + addBigInt( c , d )  );

		short e = Short.MAX_VALUE;
		short f = Short.MAX_VALUE;
		System.out.println( "初期値e =" + e );
		System.out.println( "初期値f =" + f );
		System.out.println( "e + f =" + addShort( e , f )  );

		char charA = 'あ';
		System.out.println( "初期値charA =" + charA );
		System.out.println( "charAのint型 =" + toInt( charA ) );

		int charG = 123;
		System.out.println( "初期値charG =" + charG );
		System.out.println( "charGのchar型 =" + toChar( charG ) );

		float pai = 3.1415f;
		System.out.println( "初期値float型pai =" + pai );
		System.out.println( "初期値int型へキャストしたpai =" + floatToInt( pai ) );


		outputEndMethod("arithmeticOperatorSamples");



	}


	/**
	 * 算出演算子の加算(+)を確かめるメソッド
	 * 指定したパラメータ２つを加算します。
	 * @parma x 加算する値
	 * @param y 加算する値
	 * @return xとyを加算します。
	 */
	public int add( int x , int y ) {
		return x + y ;
	}

	/**
	 * 算出演算子(-)を確かめるメソッド
	 * 指定したパラメータ１つ目から２つ目を減算します。
	 * @param x 減算対象の値
	 * @param y 減算値
	 * @return xからyを減算した値
	 */
	public int subtract( int x , int y ) {
		return x - y ;
	}

	/**
	 * 算出演算子(*)を確かめるメソッド
	 * 指定したパラメータ２つを乗算します。
	 * @param x 乗算する値
	 * @param y 乗算する値
	 * @return xとyを乗算する値
	 */
	public long multiple( int x , int y ) {
		return x * y ;
	}

	/**
	 * 算出演算子(/)を確かめるメソッド
	 * 指定したパラメータ１つめを２つ目のパラメータから除算します。
	 * @param x 被除数
	 * @param y 除数
	 * @return xとyを除算する値
	 */
	public int divide( int x , int y ) {
		return x / y ;
	}

	/**
	 * 算出演算子(%)を確かめるメソッド
	 * 指定したパラメータ１つめを２つ目のパラメータから除算した余りを算出する。
	 * @param x 被除数
	 * @param y 除数
	 * @return xとyを除算した余り
	 */
	public int reminder( int x , int y ) {
		return x % y ;
	}

	/**
	 * Stringの連結子としての(+)を確かめるメソッド
	 * 指定したパラメータ２つを連結します。
	 * @parma x 連結する文字列
	 * @param y 連結する文字列
	 * @return xとyを連結した文字列
	 */
	public String concat( String x , String y ) {
		return x + y ;
	}

	//------------------------------------------------------ 型キャスト

	/**
	 * 型キャストの例を確かめるメソッド
	 * 指定したパラメータ２つを加算します。
	 * Widening Primitive conversions
	 * @parma x 加算する値
	 * @param y 加算する値
	 * @return xとyを加算します。
	 */
	public long addBigInt( int x , int y ) {
		return (long)x + (long)y ;
	}

	/**
	 * 型キャストの例を確かめるメソッド
	 * 指定したパラメータ２つを加算します。
	 * Widening Primitive conversions
	 * @parma x 加算する値
	 * @param y 加算する値
	 * @return xとyを加算します。
	 */
	public int addShort( short x , short y ) {
		return (int)x + (int)y ;
	}


	/**
	 * 指定したchar型をint型に型キャストする。
	 * Widening Primitive conversions
	 * @parma x char型のサンプル１文字
	 * @return 対応する10進法の数値を返します。
	 */
	public int toInt( char x ) {
		return (int)x ;
	}

	/**
	 * 指定したint型をchar型に型キャスト変換する。
	 * Widening Primitive conversions
	 * @parma x int型(char型に収まる範囲)の数値0～65,535
	 * @return int型からchar型に変換した結果
	 */
	public char toChar( int x ) {
		return (char)x ;
	}

	/**
	 * 指定したfloatをintに変換する。
	 * Narrowing Primitive conversions
	 * 小数点桁数が丸められます。
	 * @param x float型の単数浮動小数点の数値
	 * @param xを丸めたint型の数値
	 */
	public int floatToInt( float x ) {
	 	return (int)x;
	}

	//------------------------------------------------------ インクリメント、ディクリメントサンプル
	/**
	 * インクリメントとディクリメントのサンプル
	 * 前置と後置の制約を無くした場合起こり得る間違いのサンプル
	 * x も yも前置きを期待していたのでは。
	 */
	public void invalidUnaryOperatorSamples() {
		outputStartMethod( "invalidUnaryOperatorSamples" );

		int x = 0;
		int y = 0;

		System.out.println( "x =" + x );
		System.out.println( "++x = " + ++x );
		System.out.println( "x =" + x );

		System.out.println( "y = " + y );
		System.out.println( "y++ = " + y++ );
		System.out.println( "y = " + y );

		outputEndMethod( "invalidUnaryOperatorSamples" );

	}

	/**
	 * インクリメントとディクリメントのサンプル
	 * 処理内に記載するのでは無く処理前後に後置だけを許可したパターン。
	 */
	public void unaryOperatorSamples(){
		outputStartMethod( "unaryOperatorSamples" );

		int x = 1;
		System.out.println( "初期値x = " + x );

		x++;
		System.out.println( "[主文]表現は後置、動作は前置き: x = " + x );
		System.out.println( "処理後x = " + x );

		x = 1;
		System.out.println( "初期値x = " + x );

		System.out.println( "表現は後置、動作は後置き: x = " + x );
		x++;
		System.out.println("処理後x = " + x );

		outputEndMethod( "UnaryOperatorSamples" );
	}

	//--------------------------------------------------  比較演算子サンプル

	/**
	 * 比較演算子を全て実行するサンプルメソッド
	 */
	public void comparisonOperatorSamples(){
		outputStartMethod( "comparisonOperatorSamples" );

		int x = 1;
		int y = 2;
		System.out.println( " 初期値x = " + x );
		System.out.println( " 初期値y = " + y );


		System.out.println( " x == y is " + ( x == y ) );
		System.out.println( " x != y is " + ( x != y ) );
		System.out.println( " x > y  is " + ( x > y ) );
		System.out.println( " x >= y is " + ( x >= y ) );
		System.out.println( " x < y  is " + ( x < y ) );
		System.out.println( " x <= y is " + ( x <= y ) );

		Object z = new Integer(3);

		System.out.println( " 初期値z " + z.toString() );
		System.out.println( " z instanceof Integer is " + ( z instanceof Integer ) );
		System.out.println( " z instanceof Number  is " + ( z instanceof Number ) );
		System.out.println( " z instanceof String  is " + ( z instanceof String  ) );

		String xString = new String( "hoge" );
		String yString = new String( "hoge" );
		String zString = xString;

		System.out.println( " 初期値x = " + zString.toString() );
		System.out.println( " 初期値y = " + yString.toString() );
		System.out.println( " 初期値z = " + zString.toString() );
		System.out.println( " xString == yString is " + ( xString == yString ) );
		System.out.println( " xString == zString is " + ( xString == zString ) );
		System.out.println( " xString.equals( yString ) is " + ( xString.equals( yString ) ) );

		outputEndMethod( "comparisonOperatorSamples" );

	}

	//------------------------------------------------------ 論理演算子サンプル

	/**
	 * 論理演算子を全て実行するサンプルメソッド
	 */
	public void logicalOperatorSamples() {
		outputStartMethod("logicalOperatorSamples");

		boolean a = true;
		boolean b = false;

		System.out.println( " 初期値a = " + a );
		System.out.println( " 初期値b = " + b );
		System.out.println( " a AND b = " + ( a && b  ) );
		System.out.println( " a OR b  = " + ( a || b  ) );
		System.out.println( " NOT a   = " +  !a  );
		System.out.println( " NOT b   = " +  !b  );

		outputEndMethod("logicalOperatorSamples");

	}

	//------------------------------------------------------ 代入演算子サンプル
	/**
	 * 代入演算子を全て実行するサンプルメソッド
	 */
	public void assignmentOperatorSamples() {
		outputStartMethod( "assignmentOperatorSamples" );


		int x = 10;
		int y = 4;

		System.out.println( " 初期値x = " + x );
		System.out.println( " 初期値y = " + y );

		x = y;
		System.out.println( " x = y ");
		System.out.println( " 処理後x = " + x  +  "処理後y = " + y );

		x = 10;
		x += y;
		System.out.println( " x += y ");
		System.out.println( " 処理後x = " + x  +  "処理後y = " + y );

		x = 10;
		x -= y;
		System.out.println( " x -= y ");
		System.out.println( " 処理後x = " + x  +  "処理後y = " + y );

		x = 10;
		x *= y;
		System.out.println( " x *= y ");
		System.out.println( " 処理後x = " + x  +  "処理後y = " + y );

		x = 10;
		x /= y;
		System.out.println( " x /= y ");
		System.out.println( " 処理後x = " + x  +  "処理後y = " + y );

		x = 10;
		y = 4;
		x %= y;
		System.out.println( " x %= y ");
		System.out.println( " 処理後x = " + x  +  "処理後y = " + y );

		byte a = 0b0000_0000;
		byte b = 0b0001_0000;

		a &= b;
		System.out.println( " 初期値a = " + a );
		System.out.println( " 初期値a = " + b );

		System.out.println( " a &= b ");
		System.out.println( " 処理後a = " + a  +  "処理後b = " + b );

		a = 0b0000_0000;
		a |= b ;
		System.out.println( " a |= b ");
		System.out.println( " 処理後a = " + a  +  "処理後b = " + b );

		a = 0b0000_0000;
		a ^= b ;
		System.out.println( " a ^= b ");
		System.out.println( " 処理後a = " + a  +  "処理後b = " + b );

		b <<= 2;
		System.out.println( " b <<= 2");
		System.out.println( "処理後b = " + b );

		b = 0b0001_0000;
		b >>= 2;
		System.out.println( " b >>= 2");
		System.out.println( "処理後b = " + b );


		b = -0b001_0000;
		b >>>= 4;
		System.out.println( " 初期値a = " + b );
		System.out.println( " b >>>= 4");
		System.out.println( "処理後b = " + b );

		outputEndMethod( "assignmentOperatorSamples" );
	}

	//------------------------------------------------------------三項演算子サンプル

	/**
	 * 三項演算子のサンプル
	 * @param isAdd true 加算 false 減算
	 * @param x 加算又は減算される基準値
	 * @param y 加算又は減算値
	 * @return 計算結果(isAddがtrueの場合は加算、falseの場合減算)
	 */
	private int  ternaryLogic(boolean isAdd , int x , int y ){
		return  isAdd ?  ( x + y ) :  ( x - y ) ;
	}

	/**
	 * 三項演算子を展開した計算処理
	 * @param isAdd true 加算 false 減算
	 * @param x 加算又は減算される基準値
	 * @param y 加算又は減算値
	 * @return 計算結果(isAddがtrueの場合は加算、falseの場合減算)
	 */
	private int  calc(boolean isAdd , int x , int y ){
		int result = 0;
		if( isAdd ){
			result = x + y;
		} else {
			result = x - y;
		}
		return result;
	}

	/**
	 * 三項演算子のサンプル実行結果を出力する。
	 * if文の記述メソッドと三項演算子のメソッドが同じ結果であることを検証する。
	 */
	public void ternaryOperatorSamples() {
		outputStartMethod( "ternaryOperatorSamples" );

		int x = 10;
		int y = 3;

		System.out.println( " 初期値x = " + x  + " 初期値y = " + y );
		System.out.println( " 三項演算子     trueの場合 =" + ternaryLogic( true , x , y) );
		System.out.println( " if文のメソッド trueの場合 =" + calc( true , x , y ) );
		System.out.println( " 三項演算子    falseの場合 =" + ternaryLogic( false , x , y) );
		System.out.println( " if文のメソッドfalseの場合 =" + calc( false , x , y ) );

		outputEndMethod( "ternaryOperatorSamples" );

	}

	//-------------------------------------------------------------- シフト演算子
	/**
	 * シフト演算子を検証するメソッド
	 */
	public void shiftOperatorSamples() {
		outputStartMethod( "shiftOperatorSamples" );

		//-16を意味
		int a = -0b001_0000;
		int b = a << 4;
		int c = a >> 4;
		int d = a >>> 4;

		System.out.println( "a = " + a );
		System.out.println( "b = " + b );
		System.out.println( "c = " + c );
		System.out.println( "d = " + d );

		outputEndMethod("shiftOperatorSamples");

	}

	//-------------------------------------------------------------- ビット演算子
	/**
	 * ビット演算子を検証するメソッド
	 */
	public void binaryOperatorSamples() {
		outputStartMethod( "binaryOperatorSamples" );

		byte a = 0b00010101;
		byte b = 0b00111010;
		System.out.println(  "初期値a = " + Integer.toBinaryString( a ) );
		System.out.println( " 初期値b = " + Integer.toBinaryString( b ) );

		byte resultAnd = (byte) (a & b);
		System.out.println( " a & b = " + Integer.toBinaryString( resultAnd ) );

		byte resultOR= (byte) (a | b);
		System.out.println( " a | b = " + Integer.toBinaryString( resultOR ) );

		byte resultXOR =  (byte) (a ^ b);
		System.out.println( " a ^ b = " + Integer.toBinaryString( resultXOR ) );

		byte resultNOT =  (byte) ~a;
		System.out.println(" ~a = " + Integer.toBinaryString( resultNOT ) );

		outputEndMethod("binaryOperatorSamples");

	}

	/**
	 * javaコマンドより、本クラスの主メソッドexecAllSamplesを実行する。
	 * @param args javaコマンドより引き渡される引数(指定不要)
	 */
	public static final void main ( String[] args ){

		OperatorsSample opearatorSample = new OperatorsSample();
		opearatorSample.execAllSamples();
	}
}
