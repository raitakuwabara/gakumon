/**
 * Copyright 2017 yourcompany.
 * 本ソースファイルの著作権は株式会社yourcompanyに所属します。
 * 株式会社yourcompanyの許可なくして、本ソースファイルの
 * 配布、改修、コピー、利用を禁止します。
 * 会社名				：株式会社yourcompany
 * 組織名				：システム開発部
 * プロジェクトコード	：education
 * バージョン			：1.0
 * 最終更新日時			：2017/03/21 20:00
 */
package jp.co.yourcompany.education.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import jp.co.yourcompany.education.log.InitApplication;

/**
 * Filesクラスのメソッド確認用サンプルクラス
 * @author Raita.kuwabara
 */
public class JavaFilesSample {

	private static final Logger log = Logger.getLogger( JavaFilesSample.class.getName() );

	/**
	 * プロジェクトパス
	 */
	private Path projectPath = Paths.get( "C:/projects/education" );

	/**
	 * デフォルトコンストラクタ
	 */
	public JavaFilesSample(){
		InitApplication app = InitApplication.getInstance();
		app.init();
	}

	/**
	 * 全てのサンプルを実行する
	 */
	public void execAllSamples(){
		execCheckMethodSample();

		createEmptyFile();

		copyFile();
		copyFileFromInputStream();
		copyFileToOutputStream();
		renameFile();
		moveFile();
		deleteFile();
		deleteIfExsitFile();

		walkSearchFile();
		findFile();
		walkFileTreeSample();

		readFileByBufferedReader();
		readFileByAllLines();
		readFileByAllLine();

		writeFileByBufferedWriter();
		writeFileByWriteMethod();
	}

	/**
	 * チェック系メソッドを確認する
	 * @see java.nio.file.Files
	 */
	private void execCheckMethodSample(){
		Path path = projectPath.resolve("data/input/sample_data.txt");
		Path path2 = projectPath.resolve("data/input/sample_data2.txt");

		log.info("path.toString:" + path.toString() );
		log.info("path2.toString:" + path2.toString() );
		log.info("Files.exists( path ) is " + Files.exists( path ) );
		log.info("Files.nonExists( path ) is " + Files.notExists( path ) );
		log.info("Files.isDirectory( path ) is " + Files.isDirectory( path ) );
		log.info("Files.isExecutable( path ):" + Files.isExecutable( path ) );
		log.info("Files.isReadable( path ):" + Files.isReadable( path ) );
		//何をもって通常ファイルとする？
		log.info("Files.isRegularFile( path ):" + Files.isReadable( path ) );
		log.info("Files.isSymbolicLink( path ):" + Files.isSymbolicLink( path ) );
		log.info("Files.isWritable( path ):" + Files.isWritable( path ) );

		try {
			log.info("Files.size( path ):" + Files.size( path ) );
		} catch (IOException e) {
			log.log( Level.SEVERE, "ファイル「{0}」に対するsize処理でエラーが発生しました。",
					new String[]{ path.toString()} );
			log.log( Level.SEVERE, "例外内容:", e );
		}

		try {
			log.info("Files.isHidden( path ):" + Files.isHidden( path ) );
		} catch (IOException e) {
			log.log( Level.SEVERE, "ファイル「{0}」に対するisHidden処理でエラーが発生しました。",
					new String[]{ path.toString()} );
			log.log( Level.SEVERE, "例外内容:", e );
		}

		try {
			log.info("Files.isSameFile( path , path2 ) is " + Files.isSameFile( path , path2 ) );
		} catch (IOException e) {
			String[] params = new String[2];
			params[0] = path.toString();
			params[1] = path2.toString();
			log.log( Level.SEVERE, "２つのファイル「{0}」「{1}」の比較でエラーが発生しました。", params );
			log.log( Level.SEVERE, "例外内容:", e );
		}
		log.info("Files.isSymbolicLink( path ) is " + Files.isSymbolicLink( path ) );
	}

	/**
	 * インスタンスの比較用
	 * @param 比較元のパス
	 * @param 比較対象のパス
	 */
	private void checkResult( Path inPath , Path resultPath ){
		if( inPath.equals( resultPath ) ){
			log.info("引数と結果の値は一致しました。");
		} else {
			log.info("引数と結果の値は一致しません。");
		}
		if( inPath == resultPath  ){
			log.info("引数と結果のインスタンスは一致しました。");
		} else {
			log.info("引数と結果のインスタンスは一致しません。");
		}
	}

	//---------------------------------------------------- 新規作成

	/**
	 * 空のファイルを新規に作成します。
	 * @see java.nio.file.Files#createFile(Path, java.nio.file.attribute.FileAttribute...)
	 */
	private void createEmptyFile(){

		Path newFilePath = projectPath.resolve("data/output/new_empty.txt");
		Path resultPath = null;

		try {
			//ファイルが存在するとエラーになります。
			resultPath = Files.createFile( newFilePath );

			checkResult( newFilePath , resultPath );

		} catch (IOException e) {
			String path = newFilePath.toString();
			log.log( Level.SEVERE, "ファイル「{0}」の新規作成処理でエラーが発生しました。", new String[]{ path } );
			log.log( Level.SEVERE, "例外内容:", e );
		}
	}

	//---------------------------------------------------- 複製
	/**
	 * ファイルのコピーをPathクラスを利用して行います。
	 * @see java.nio.file.Files#copy(Path, Path, java.nio.file.CopyOption...)
	 */
	private void copyFile(){

		Path fromPath = projectPath.resolve("data/input/sample_data.txt");
		Path toPath = projectPath.resolve("data/output/sample_data.txt");

		try {
			/*
			 * toPathにファイルが存在した場合には、上書きするオプションを指定しています。
			 * このオプションを指定しない場合、copy先にファイルが存在する場合には、
			 *  java.nio.file.FileAlreadyExistsExceptionがthrowされます。
			 */
			Path resultPath = Files.copy( fromPath , toPath , StandardCopyOption.REPLACE_EXISTING);

			checkResult( toPath , resultPath );

		} catch (FileAlreadyExistsException e) {
			log.log( Level.SEVERE, "ファイル「{0}」は存在します。", toPath.toString()  );
			log.log( Level.SEVERE, "例外内容:", e );

		} catch (IOException e) {
			String[] params = new String[2];
			params[0] = fromPath.toString();
			params[1] = toPath.toString();
			log.log( Level.SEVERE, "ファイル「{0}」から「{1}」へのコピー処理でエラーが発生しました。", params );
			log.log( Level.SEVERE, "例外内容:", e );
		}
	}

	/**
	 * ファイルのコピーをInputStream(クラスパス上のファイルを利用)からコピーします。
	 * @see java.nio.file.Files#copy(InputStream, Path, java.nio.file.CopyOption...)
	 */
	private void copyFileFromInputStream(){

		Path toPath = projectPath.resolve("data/output/logging_copy.properties");

		try ( InputStream is = JavaFilesSample.class.getClassLoader().getResourceAsStream( "logging.properties"); ) {

			long resultLong = Files.copy( is , toPath , StandardCopyOption.REPLACE_EXISTING);
			log.info("result copy long result:" + resultLong);

		} catch (IOException e) {
			String[] params = new String[2];
			params[0] = "classpath内のlogging.properties";
			params[1] = toPath.toString();
			log.log( Level.SEVERE, "ファイル「{0}」から「{1}」へのコピー処理でエラーが発生しました。", params );
			log.log( Level.SEVERE, "例外内容:", e );
		}
	}

	/**
	 * ファイルのコピーをOutputStreamにコピーします。
	 * @see java.nio.file.Files#copy(Path, java.io.OutputStream)
	 */
	private void copyFileToOutputStream(){

		Path fromPath = projectPath.resolve("data/input/sample_data.txt");
		Path toPath = projectPath.resolve("data/output/sample_data3.txt");

		try ( OutputStream os =  Files.newOutputStream( toPath  ) ){

			long resultLong = Files.copy( fromPath , os );
			log.info("result copy long result:" + resultLong);

		} catch (IOException e) {
			String[] params = new String[2];
			params[0] = fromPath.toString();
			params[1] = toPath.toString();
			log.log( Level.SEVERE, "ファイル「{0}」から「{1}」へのコピー処理でエラーが発生しました。", params );
			log.log( Level.SEVERE, "例外内容:", e );
		}
	}

	//----------------------------------------------------  名称変更(rename)

	/**
	 * ファイルの名称を変更する
	 * @see java.nio.file.Files#move(Path, Path, java.nio.file.CopyOption...);
	 */
	private void renameFile(){
		Path fromPath = projectPath.resolve("data/input/rename_before.txt");
		Path toPath = projectPath.resolve("data/input/rename_after.txt");

		try {
			Path resultPath = Files.move(fromPath, toPath );
			checkResult( toPath , resultPath );
		} catch (IOException e) {
			String[] params = new String[2];
			params[0] = fromPath.toString();
			params[1] = toPath.toString();
			log.log( Level.SEVERE, "ファイル「{0}」から「{1}」への名称変更処理でエラーが発生しました。", params );
			log.log( Level.SEVERE, "例外内容:", e );
		}
	}

	//----------------------------------------------------  移動(move)

	/**
	 * ファイルを移動する。
	 * @see java.nio.file.Files#move(Path, Path, java.nio.file.CopyOption...);
	 */
	private void moveFile(){
		Path fromPath = projectPath.resolve("data/input/move_before.txt");
		Path toPathDir = projectPath.resolve("data/input/moveto");
		Path toPath = toPathDir.resolve("move_before.txt");

		try {
			//このメソッドを実行することで、指定したディレクトリ階層が全て作成されます。
			//Files.createDirectories( toPathDir );

			/**
			 * toPathの保存先のディレクトリは存在する必要があります。
			 */
			Path resultPath = Files.move(fromPath, toPath );
			checkResult( toPath , resultPath );
		} catch (FileAlreadyExistsException e) {
			log.log( Level.SEVERE, "ファイル「{0}」は存在します。", toPath.toString()  );
			log.log( Level.SEVERE, "例外内容:", e );
		} catch (IOException e) {
			String[] params = new String[2];
			params[0] = fromPath.toString();
			params[1] = toPath.toString();
			log.log( Level.SEVERE, "ファイル「{0}」から「{1}」への移動処理でエラーが発生しました。", params );
			log.log( Level.SEVERE, "例外内容:", e );
		}
	}

	//----------------------------------------------------  削除(delete)

	/**
	 * ファイルを削除する。
	 * @see java.nio.file.Files#move(Path, Path, java.nio.file.CopyOption...);
	 */
	private void deleteFile(){
		Path deletePath = projectPath.resolve("data/input/delete/delete1.txt");

		try {
			Files.delete( deletePath );
		} catch (NoSuchFileException e) {
			log.log( Level.SEVERE, "削除ファイル{0}」が存在しません", new String[]{ deletePath.toString() } );
			log.log( Level.SEVERE, "例外内容:", e );

		} catch (IOException e) {
			log.log( Level.SEVERE, "ファイル「{0}」の削除処理でエラーが発生しました。", new String[]{ deletePath.toString() } );
			log.log( Level.SEVERE, "例外内容:", e );
		}
	}

	/**
	 * ファイルを削除する。
	 * @see java.nio.file.Files#move(Path, Path, java.nio.file.CopyOption...);
	 */
	private void deleteIfExsitFile(){
		Path deletePath = projectPath.resolve("data/input/delete/delete1.txt");
		Path deletePath2 = projectPath.resolve("data/input/delete/delete2.txt");

		try {
			//前のメソッドで既に削除されているケース
			boolean result1 = Files.deleteIfExists( deletePath );

			//ファイルが存在するケース
			boolean result2 = Files.deleteIfExists( deletePath2 );

			log.info("元々削除されている場合の結果:=" + result1);
			log.info("ファイルが存在して削除する場合の結果:=" + result2);

		} catch (NoSuchFileException e) {
			log.log( Level.SEVERE, "削除ファイル{0}」が存在しません", new String[]{ deletePath.toString() } );
			log.log( Level.SEVERE, "例外内容:", e );

		} catch (IOException e) {
			log.log( Level.SEVERE, "ファイル「{0}」の削除処理でエラーが発生しました。", new String[]{ deletePath.toString() } );
			log.log( Level.SEVERE, "例外内容:", e );
		}
	}

	//----------------------------------------------------  検索(search)

	/**
	 * ディレクトリ階層の検索を行い、指定したファイルのパスを取得する。
	 * @see java.nio.file.Files#walk(Path, java.nio.file.FileVisitOption...)
	 */
	private void walkSearchFile(){
		Path target = projectPath.resolve("src");

		/*
		 * 探索する階層の深さを制限する場合には、階層数を指定する場合
		 */
		//try ( Stream<Path> stream = Files.walk( target , 5) ) {

		try ( Stream<Path> stream = Files.walk( target ) ) {

			/*
			 * 指定したディレクトリ階層とその配下全てのディレクトリとファイルを出力します。
			 * 出力するとStreamは閉じられます。
			 */
			//stream.forEach( System.out::println  );

			/*
			 * 拡張子がJavaのファイルだけ列挙する
			 * Java8のラムダ式利用
			 *
		  	 * Optional<Path> optPaths = stream
		     *		.filter( entry -> entry.getFileName().toString().endsWith(".java") );
			 */
			//Java8から利用可能 ラムダ式利用
			Optional<Path> optPath = stream
					.filter( entry -> entry.getFileName().toString().equals("JavaFilesSample.java") )
					.findFirst();

			if( optPath.isPresent() ){
				Path resultPath = optPath.get();
				log.info("JavaFileSample.java Find... ");
				log.info( resultPath.toString() );
			}else{
				log.info("JavaFileSample.java ファイルは見つかりませんでした" );
			}
			log.info("---- END walkSearchFile ----" );

		} catch (IOException e) {
			log.log( Level.SEVERE, "ファイル「{0}」のファイル検索(walk)処理でエラーが発生しました。", new String[]{ target.toString() } );
			log.log( Level.SEVERE, "例外内容:", e );
		}
	}

	/**
	 * ディレクトリ階層の検索を行い、指定したファイルのパスを取得する。
	 * @see java.nio.file.Files#find(Path, int, java.util.function.BiPredicate, java.nio.file.FileVisitOption...)
	 */
	private void findFile( ){
		Path target = projectPath.resolve("src");

		//Integer.MAX_VALUEは階層数が無制限で探索することを意味します。
		//Java8から利用可能 ラムダ式利用
		try ( Stream<Path> stream = Files.find( target , Integer.MAX_VALUE ,
				(file, attrs) -> file.getFileName().toString().equals("JavaFilesSample.java") ) ) {

			log.info("JavaFileSample.java findFile... ");
			stream.forEach( System.out::println );

			log.info("---- END findFile ----" );

		} catch (IOException e) {
			log.log( Level.SEVERE, "ファイル「{0}」のファイル検索(find)処理でエラーが発生しました。", new String[]{ target.toString() } );
			log.log( Level.SEVERE, "例外内容:", e );
		}
	}

	/**
	 * 対象のファイルを検査する
	 * Java8以前でバージョンでstreamやラムダ式が使えない場合の検索方式
	 * @see java.nio.file.Files#walkFileTree(Path, FileVisitor)
	 */
	private void walkFileTreeSample(){

		Path target = projectPath.resolve("src");
		List<Path> resultList = new ArrayList<Path>();
		try {
			Files.walkFileTree(target, new FileVisitor<Path>() {
				// Print information about
				// each type of file.
				@Override
				public FileVisitResult visitFile(Path file,
						BasicFileAttributes attr) {
					if ( file.getFileName().toString().equals("JavaFilesSample.java") ) {
						resultList.add( file );
					}
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult postVisitDirectory(Path dir,
						IOException exc) {
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFileFailed(Path file,
						IOException exc) {
					System.err.println(exc);
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult preVisitDirectory(java.nio.file.Path dir, BasicFileAttributes attrs)
						throws IOException {
					return FileVisitResult.CONTINUE;
				}
			} );

			log.info( "検索ディレクトリ:" + target.toString() );
			log.info( "検索ファイル:JavaFilesSample.java" );
			log.info( "--- walkFileTree結果 START --- " );
			for( Path path : resultList){
				log.info( path.toString() );
			}
			log.info( "--- walkFileTree結果 END --- " );

		} catch (IOException e) {
			log.log( Level.SEVERE, "ファイル「{0}」のファイル検索(walkFreeTree)処理でエラーが発生しました。", new String[]{ target.toString() } );
			log.log( Level.SEVERE, "例外内容:", e );
		}

	}

	//----------------------------------------------------  読取(read)
	/**
	 * newBufferedReaderのサンプルメソッド
	 * @see java.nio.file.Files#newBufferedReader(Path, Charset)
	 */
	private void readFileByBufferedReader(){
		Path path = projectPath.resolve("data/input/sample_data.txt");

		//こちらは日本では利用しない方が良い
		//try( BufferedReader br = Files.newBufferedReader( path ) ){

		try( BufferedReader br = Files.newBufferedReader( path , Charset.forName("UTF-8") ) ){

			String line = null;
			log.info( path.toString() + "ファイルの読取 START");
            while ( ( line = br.readLine() ) !=null){
            	log.info( line );
            }
			log.info( "---- ファイルの読取 END ----");

		} catch (IOException e) {
			log.log( Level.SEVERE, "ファイル「{0}」のファイル読取処理でエラーが発生しました。", new String[]{ path.toString() } );
			log.log( Level.SEVERE, "例外内容:", e );
		}

	}

	/**
	 * Files.readAllLinesのサンプルメソッド
	 * @see java.nio.file.Files#readAllLines(Path, Charset)
	 */
	private void readFileByAllLines(){
		Path path = projectPath.resolve("data/input/sample_data.txt");


		//読取りが終了又は例外発生時にcloseもしてくれる
		List<String> resultList;
		try {
			resultList = Files.readAllLines( path, Charset.forName("UTF-8") );
			log.info( path.toString() + "ファイルの読取[readAllLines] START");
			for( String line : resultList ){
				log.info( line );
			}
			log.info( "---- ファイルの読取 END ----");
		} catch (IOException e) {
			log.log( Level.SEVERE, "ファイル「{0}」のファイル読取処理でエラーが発生しました。", new String[]{ path.toString() } );
			log.log( Level.SEVERE, "例外内容:", e );
		}
	}

	/**
	 * Files.linesのサンプルメソッド
	 * Files.readAllLineよりJava8らしい構文が満載(try-with-resources,ラムダ式,stream)
	 * @see java.nio.file.Files#lines(Path, Charset)
	 */
	private void readFileByAllLine(){
		Path path = projectPath.resolve("data/input/sample_data.txt");

		//こちらは日本では利用しない方が良い
		//try ( Stream<String> stream = Files.lines( path  ) ){

		//読取りが終了又は例外発生時にcloseもしてくれる
		try ( Stream<String> stream = Files.lines( path ,  Charset.forName("UTF-8") ) ){
			log.info( path.toString() + "ファイルの読取[lines] START");
			stream.forEach( System.out::println );
			log.info( "---- ファイルの読取 END ----");
		} catch (IOException e) {
			log.log( Level.SEVERE, "ファイル「{0}」のファイル読取処理(lines)でエラーが発生しました。", new String[]{ path.toString() } );
			log.log( Level.SEVERE, "例外内容:", e );
		}
	}

	//----------------------------------------------------  書き込み(write)
	/**
	 * newBufferedReaderのサンプルメソッド
	 * @see java.nio.file.Files#newBufferedWriter(Path, Charset, java.nio.file.OpenOption...)
	 */
	private void writeFileByBufferedWriter(){
		//存在しないファイル
		Path path = projectPath.resolve("data/output/output1.txt");

		//こちらは日本では利用しない方が良い
		//try( BufferedReader br = Files.newBufferedReader( path ) ){

		//ファイルが既に存在している場合には、先のファイルの内容は上書きされます。
		try( BufferedWriter bw = Files.newBufferedWriter( path , Charset.forName("UTF-8") , StandardOpenOption.CREATE ) ){

			log.info( path.toString() + "ファイルの書き込み START");
			bw.write("指定した文字コード:UTF-8");
			bw.newLine();
			bw.write("改行コードはnewLine任せ。");
			bw.newLine();
			bw.write("書き込み終了");

			log.info( "---- ファイルの書き込み END ----");

		} catch (IOException e) {
			log.log( Level.SEVERE, "ファイル「{0}」のファイル書き込み処理でエラーが発生しました。", new String[]{ path.toString() } );
			log.log( Level.SEVERE, "例外内容:", e );
		}

	}

	/**
	 * writeのサンプルメソッド
	 * @see java.nio.file.Files#write(Path, Iterable, Charset, java.nio.file.OpenOption...)
	 */
	private void writeFileByWriteMethod(){
		//存在しないファイル
		Path path = projectPath.resolve("data/output/output2.txt");
		List<String> writeList = new ArrayList<String>();
		writeList.add("FIles.writeメソッド試験結果");
		writeList.add("２行目の予定");
		writeList.add("最終行：合計３行の予定");

		//こちらは日本では利用しない方が良い
		//Files.write(path, writeList  StandardOpenOption.CREATE);

		//ファイルが既に存在している場合には、先のファイルの内容は上書きされます。
		try{
			log.info( "---- ファイルの書き込み START ----");
			Files.write(path, writeList ,Charset.forName("UTF-8"), StandardOpenOption.CREATE);
			log.info( "---- ファイルの書き込み END ----");

		} catch (IOException e) {
			log.log( Level.SEVERE, "ファイル「{0}」のファイル書き込み処理でエラーが発生しました。", new String[]{ path.toString() } );
			log.log( Level.SEVERE, "例外内容:", e );
		}

	}

	/**
	 * javaコマンドから実行されるmainメソッド
	 * @param 引数不要
	 */
	public static final void main( String[] args){
		JavaFilesSample sample = new JavaFilesSample();
		sample.execAllSamples();
	}

}
