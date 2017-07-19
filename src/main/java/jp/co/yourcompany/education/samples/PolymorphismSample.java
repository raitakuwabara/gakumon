/**
 * Copyright 2017 yourcompany.
 * 本ソースファイルの著作権は株式会社hogeに所属します。
 * 株式会社hogeの許可なくして、本ソースファイルの
 * 配布、改修、コピー、利用を禁止します。
 * 会社名				：株式会社yourcompany
 * 組織名				：システム開発部
 * プロジェクトコード	：education
 * バージョン			：1.0
 * 最終更新日時			：2017/03/09 00:02
 */
package jp.co.yourcompany.education.samples;

import java.util.ArrayList;
import java.util.List;

/**
 * 多様性の１つであるクラス階層の親クラスを指定して
 * 操作する例
 * @author raita.kuwabara
 *
 */
public class PolymorphismSample extends AbstractSamples{

	/**
	 * サンプルを実行する。
	 */
	@Override
	protected void execAllSamples() {
		polymorphismNumber();
	}

	/**
	 * Number型の多様性を利用したサンプル
	 */
	private void polymorphismNumber(){
		outputStartMethod( "polymorphismNumber");

		//ここも多様性を利用しています。 List <- ArrayList
		List<Number> numberList = new ArrayList<Number>();

		Byte numberByte = new Byte("100");
		Short numberShort = new Short("101");
		Integer numberIntger = new Integer("102");
		Long numberLong = new Long("103");
		Float numberFloat = new Float("104.01");
		Double numberDobule = new Double("105.0001");

		numberList.add( numberByte );
		numberList.add( numberShort );
		numberList.add( numberIntger );
		numberList.add( numberLong );
		numberList.add( numberFloat );
		numberList.add( numberDobule );

		for( Number number : numberList ){
			System.out.println("number.getClass().getName():" +  number.getClass().getName() );
			//toStringはjava.lang.Objectメソッドに定義されて子クラスでオーバライドされている。
			System.out.println("number.toString:" +  number.toString() );
			//intValueはjava.lang.Numberメソッドで定義されて各ラッパークラスでオーバライドされている。
			System.out.println("number.intValue:" +  number.intValue() );
			System.out.println("------------------------");
		}
		outputEndMethod( "polymorphismNumber");
	}

	/**
	 * javaコマンドから実行されるメインメソッド
	 * @param args コマンド引数不要
	 */
	public static final void main( String[] args){

		PolymorphismSample sample = new PolymorphismSample();
		sample.execAllSamples();
	}

}
