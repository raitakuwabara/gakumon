package jp.co.yourcompany.education.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class JavaPathSample {

	/**
	 * 全てのサンプルクラスを実行する。
	 */
	public void execAllSamples(){
		pathInstanceSample();
		pathSamples();
		pathCompare();
	}

	/**
	 * パスインスタンスの生成
	 */
	private void pathInstanceSample(){

		Path path = Paths.get("C:/projects/education");
		System.out.println( path.getClass().getName() );

	}

	/**
	 * パスの各種メソッドを利用するサンプル
	 */
	private void pathSamples(){

		Path path = Paths.get("C:/projects/education/src");

		System.out.println("toString:" + path.toString());
		System.out.println("getName(0).toString:" + path.getName(0).toString());
		System.out.println("getName(1).toString:" + path.getName(1).toString());
		System.out.println("getName(2).toString:" + path.getName(2).toString());
		System.out.println("getNameCount:" + path.getNameCount());
		System.out.println("getRoot().toString:" + path.getRoot().toString());
		System.out.println("getParent().toString:" + path.getParent().toString());
		System.out.println("getFileName()" + path.getFileName());
		//このメソッド要注意
		System.out.println("subpath(1,3).toString:" + path.subpath( 1 , 3 ).toString() );

		System.out.println("toUri().toString:" + path.toUri().toString());
		System.out.println("resolve(\"main\").toString:" + path.resolve("main").toString());

	}


	/**
	 * ２つのパスの比較
	 */
	private void pathCompare(){

		Path basePath = Paths.get("C:/projects/education/src");
		Path basePath2 = Paths.get("C:/projects/education/src");

		Path path = Paths.get("src");
		if( basePath == basePath2 ){
			System.out.println("basePath instance is equal basePath2 instance" );
		}else{
			System.out.println("basePath instance is not equal basePath2 instance" );
		}

		if( basePath.equals( basePath2 )){
			System.out.println("basePath is equal basePath2" );
		}else{
			System.out.println("basePath is not equal basePath2" );
		}

		if( basePath.startsWith( path )){
			System.out.println("basePath is startsWith src" );
		}else{
			System.out.println("basePath is not startsWith src" );
		}
		if( basePath.startsWith( "C:\\projects" )){
			System.out.println("basePath is startsWith /projects" );
		}else{
			System.out.println("basePath is not startsWith /projects" );
		}

		if( basePath.endsWith( path )){
			System.out.println("basePath is endsWith src" );
		}else{
			System.out.println("basePath is not eWith src" );
		}
	}


	/**
	 * javaコマンドから実行されるmainメソッド
	 */
	public static final void main( String[] args){
		JavaPathSample sample = new JavaPathSample();
		sample.execAllSamples();
	}

}
