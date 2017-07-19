/**
 * Copyright 2017 yourcompany.
 * 本ソースファイルの著作権は株式会社yourcompanyに所属します。
 * 株式会社hogeの許可なくして、本ソースファイルの
 * 配布、改修、コピー、利用を禁止します。
 * 会社名				：株式会社yourcompany
 * 組織名				：システム開発部
 * プロジェクトコード	：education
 * バージョン			：1.0
 * 最終更新日時			：2017/03/09
 */
package jp.co.yourcompany.education.samples;

/**
 * オーバライドのサンプル
 * @author raita.kuwabara
 */
public class OverrideSample  extends AbstractSamples {

	/**
	 * オーバライドの例(親メソッドの機能の上書き)
	 */
	@Override
	public final void outputStartMethod( String methodName ){
		System.out.println( "サンプルメソッド" + methodName + "を開始します。");
	}

	/**
	 * 抽象クラスのオーバライドの例
	 */
	@Override
	protected void execAllSamples() {
		outputStartMethod( "execAllSamples" );
		System.out.println(" 開始メッセージが日本語になりました。");
		outputEndMethod( "execAllSamples" );
	}

	/**
	 * Java コマンドから実行するmainメソッド
	 */
	public static final void main( String[] args){
		OverrideSample sample = new OverrideSample();
		sample.execAllSamples();
	}
}
