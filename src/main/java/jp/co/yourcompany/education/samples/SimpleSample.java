package jp.co.yourcompany.education.samples;

/**
 * 抽象クラスを継承した子クラスのサンプル
 * @author Raita.Kuwabara
 *
 */
public class SimpleSample extends AbstractSamples {

	/**
	 * サンプルを全て実行する。
	 */
	@Override
	public final void execAllSamples() {
		outputStartMethod( "execAllSamples" );
		outputMessage();
		outputStartMethod( "execAllSamples" );
	}

	/**
	 * メッセージを標準出力に出力する。
	 */
	private void outputMessage(){
		System.out.println("SimpleSample.execAllSamples ");
	}

	public static void main(String[] args){
		SimpleSample samples = new SimpleSample();
		samples.execAllSamples();

		//抽象クラスなのでインタタンスは生成できません。
		//以下のコードはNG
		//AbstractSamples abstractSamples = new AbstractSamples();
		//abstractSamples.execAllSamples();
	}
}
