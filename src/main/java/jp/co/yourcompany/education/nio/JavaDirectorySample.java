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

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import jp.co.yourcompany.education.log.InitApplication;

/**
 * java.nio.file.Filesクラスのディレクトリ確認用サンプルクラス
 * @author Raita.kuwabara
 */
public class JavaDirectorySample {

	private static final Logger log = Logger.getLogger( JavaDirectorySample.class.getName() );

	/**
	 * プロジェクトパス
	 */
	private Path projectPath = Paths.get( "C:/projects/education" );
	/**
	 * コピー元となるディレクトリ群
	 */
	private Path inputPath = projectPath.resolve("data/input/copyfrom");
	/**
	 * 出力先となるディレクトリ群
	 */
	private Path outputPath = projectPath.resolve("data/output/copyto");

	/**
	 * デフォルトコンストラクタ
	 */
	public JavaDirectorySample(){
		InitApplication app = InitApplication.getInstance();
		app.init();
	}

	/**
	 * 全てのサンプルを実行する
	 */
	public void execAllSamples(){

		Path newDir = outputPath.resolve("newdir1");
		createOneDirectory( newDir );
		Path newDir2 = outputPath.resolve("newdir2/newdir21");
		createDirectories( newDir2 );

		Path fromDir = inputPath.resolve("src");
		Path toDir1 = outputPath.resolve("copy1");
		copyDirectories( fromDir , toDir1 );

		Path toDir2 = outputPath.resolve("copy2");
		copyDirectoriesByWalk( fromDir , toDir2 );

		Path toDir3 = outputPath.resolve("copy3");
		copyDirectories( fromDir , toDir3 );

		//----- 前提条件
		Path toDir4 = outputPath.resolve("copy4");
		copyDirectories( fromDir , toDir4 );
		Path toDir5 = outputPath.resolve("copy5");
		moveDirectory( toDir4 , toDir5);

		//----- 前提条件
		Path toDir6 = outputPath.resolve("copy6");
		copyDirectories( fromDir , toDir6 );
		Path toDir7 = outputPath.resolve("copy7");
		renameDirecotry( toDir6, toDir7 );


		//----- 前提条件
		Path toDir8 = outputPath.resolve("copy8");
		copyDirectories( fromDir , toDir8 );
		deleteDirectoies( toDir8 );

		//----- 前提条件
		//coディレクトリを探す
		walkSearchDir( toDir1 , "co" );

		//----- 前提条件
		//nioディレクトリを探す
		findSearchDir( toDir1 , "nio" );

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
	 * 空のディレクトリを１つ作成する。
	 * このメソッドはディレクトリが存在した状態は、エラーになります。
	 * @see java.nio.file.Files#createDirectory(Path, java.nio.file.attribute.FileAttribute...)
	 * @param 作成するディレクトリ
	 */
	private void createOneDirectory( Path inPath){

		Path resultPath = null;

		try {
			//ディレクトリが存在するとエラーになります。
			resultPath = Files.createDirectory( inPath );
			log.info( "ディレクトリ「"+ inPath.toString() + "」の作成が終了しました。" );
			checkResult( inPath , resultPath );

		} catch (FileAlreadyExistsException e) {
			log.log( Level.SEVERE, "ディレクトリ「{0}」の新規作成処理でエラーが発生しました。", new String[]{ inPath.toString() } );
			log.severe("指定されたディレクトリは既に作成されています。" );
			log.log( Level.SEVERE, "例外内容:", e );
		} catch (IOException e) {
			log.log( Level.SEVERE, "ディレクトリ「{0}」の新規作成処理でエラーが発生しました。", new String[]{ inPath.toString() } );
			log.log( Level.SEVERE, "例外内容:", e );
		}
	}


	/**
	 * 指定したディレクトリ階層を全て作成します。
	 * このメソッドはディレクトリが存在した状態でもエラーになりません。
	 * @see java.nio.file.Files#createDirectories(Path, java.nio.file.attribute.FileAttribute...)
	 * @param inDir 作成するディレクトリ
	 */
	private void createDirectories( Path inDir){

		Path resultPath = null;

		try {
			//ディレクトリが存在するとエラーになります。
			resultPath = Files.createDirectories( inDir );
			log.info( "ディレクトリ「"+ inDir.toString() + "」の作成が終了しました。" );

			checkResult( inDir , resultPath );
		} catch (FileAlreadyExistsException e) {
			log.log( Level.SEVERE, "ディレクトリ「{0}」の新規作成処理でエラーが発生しました。", new String[]{ inDir.toString() } );
			log.severe("指定されたパス名のファイルが存在しています。" );
			log.log( Level.SEVERE, "例外内容:", e );
		} catch (IOException e) {
			log.log( Level.SEVERE, "ディレクトリ「{0}」の新規作成処理でエラーが発生しました。", new String[]{ inDir.toString() } );
			log.log( Level.SEVERE, "例外内容:", e );
		}
	}
	/**
	 * 指定したディレクトリを指定したディレクトリ配下にコピーする
	 * Java8以前でバージョンでstreamやラムダ式が使えない場合の検索方式
	 * @see java.nio.file.Files#walkFileTree(Path, FileVisitor)
	 * @param fromDir コピー元ディレクトリ
	 * @paam toDir コピー先ディレクトリ
	 */
	private void copyDirectories( Path fromDir , Path toDir ){

		int startIndex = fromDir.getNameCount() -1;
		log.info("---- copyDirectories START ----" );
		log.info( "コピー元ディレクトリ[" + fromDir.toString() + "]から"  );
		log.info( "コピー先ディレクトリ[" + toDir.toString() + "]へコピーします。"  );

		try {
			Files.walkFileTree(fromDir, new FileVisitor<Path>() {

				Path toTarget = null;//コピー先

				@Override
				/**
				 * ファイル名を維持してそのまま出力先ディレクトリにコピーする。
				 */
				public FileVisitResult visitFile(Path file,
						BasicFileAttributes attr) {
					try {
						Files.copy(file, toTarget.resolve( file.getFileName() ));
					} catch (IOException e) {
						log.log( Level.SEVERE, "ファイル「{0}」のファイル複製でエラーが発生しました。", new String[]{ file.toString() } );
						log.log( Level.SEVERE, "例外内容:", e );

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
					return FileVisitResult.CONTINUE;
				}

				@Override
				/**
				 * これから探索するディレクトリを出力先ディレクトリにも作成する。
				 */
				public FileVisitResult preVisitDirectory(java.nio.file.Path dir, BasicFileAttributes attrs)
						throws IOException {
					toTarget =  toDir.resolve( dir.subpath( startIndex  , dir.getNameCount() ) );
					/*
					 * 本当は、このように読取元の属性を維持したディレクトリの作成をしたいが、
					 * Windowsでは、POSIX準拠ではないため属性の指定は、エラーになる。
					 * Set<PosixFilePermission> permissions =  Files.getPosixFilePermissions( dir );
					 * Files.createDirectories( toTarget , PosixFilePermissions.asFileAttribute( permissions ) ) ;
					 */

					Files.createDirectories( toTarget ) ;
					return FileVisitResult.CONTINUE;
				}
			} );
			log.info("---- copyDirectories END ----" );

		} catch (IOException e) {
			log.log( Level.SEVERE, "ディレクトリ「{0}」の複製処理でエラーが発生しました。", new String[]{ fromDir.toString() } );
			log.log( Level.SEVERE, "例外内容:", e );
		}
	}

	/**
	 * ディレクトリコピー(walk版)
	 * Java8以上 try-with-resources,stream
	 * @see java.nio.file.Files#walk(Path,java.nio.file.FileVisitOption...)
	 * @param from コピー元のpath
	 * @param to コピー先のpath
	 */
	private void copyDirectoriesByWalk( Path fromDir , Path toDir){

		int startIndex = fromDir.getNameCount() -1;

		try ( Stream<Path> stream = Files.walk( fromDir ) ) {
			log.info("---- copyDirectoriesByWalk START ----" );

			stream.forEach(new Consumer<Path>() {
				@Override
				public void accept(Path path) {
					Path toTarget =  toDir.resolve( path.subpath( startIndex  , path.getNameCount() ) );
					try {
						if( Files.isDirectory( path ) ){
							Files.createDirectories( toTarget );
						} else {
							if( Files.isRegularFile( path ) ){
								Files.copy( path, toTarget );
							}
						}
					} catch (IOException e) {
						log.log( Level.SEVERE, "ディレクトリ「{0}」の複製処理でエラーが発生しました。", new String[]{ toTarget.toString() } );
						log.log( Level.SEVERE, "例外内容:", e );
					}
				}
			});
			log.info("---- walkSearchFile END ----" );

		} catch (IOException e) {
			log.log( Level.SEVERE, "ディレクトリ「{0}」の複製処理でエラーが発生しました。", new String[]{ fromDir.toString() } );
			log.log( Level.SEVERE, "例外内容:", e );
		}
	}


	//----------------------------------------------------  名称変更(rename)

	/**
	 * ディレクトリの名称変更
	 * @param fromDir 変更前の名称
	 * @param toDir 変更後の名称
	 */
	private void renameDirecotry( Path fromDir , Path toDir) {
		 moveDirectory(  fromDir ,  toDir );
	}


	//----------------------------------------------------  移動(move)

	/**
	 * ディレクトリを移動する又はrenameをする。
	 * @param fromDir 移動前ディレクトリ
	 * @param toDir 移動先ディレクトリ
	 */
	private void moveDirectory( Path fromDir , Path toDir ){

		log.info("---- moveDirectory START ----" );
		try {
			Files.move(fromDir, toDir, java.nio.file.StandardCopyOption.ATOMIC_MOVE );
		} catch (IOException e) {
			log.severe( "ディレクトリ[" + fromDir.toString() + "]から"  );
			log.severe( "ディレクトリ[" + toDir.toString() + "]の移動に失敗しました"  );
			log.log( Level.SEVERE, "例外内容:", e );
		}
		log.info( "ディレクトリ[" + fromDir.toString() + "]から"  );
		log.info( "ディレクトリ[" + toDir.toString() + "]の移動に成功しました。"  );
		log.info("---- moveDirectory END ----" );

	}

	//----------------------------------------------------  削除(delete)

	/**
	 * ディレクトリを削除する。
	 * @parma delPath 削除対象ディレクトリ
	 */
	private void deleteDirectoies( Path delPath ){

		List<Path> dirList = new ArrayList<Path>();

		try ( Stream<Path> stream = Files.walk( delPath ) ) {
			log.info("---- deleteDirectoies START ----" );

			//ファイルは全て削除する。
			stream.forEach(new Consumer<Path>() {
				@Override
				public void accept(Path path) {
					try {
						if( Files.isDirectory( path ) ){
							dirList.add( path );
						} else {
							if( Files.isRegularFile( path ) ){
								Files.deleteIfExists( path );
							}
						}
					} catch (IOException e) {
						log.log( Level.SEVERE, "ディレクトリ「{0}」の削除処理中にエラーが発生しました。", new String[]{ path.toString() } );
						log.log( Level.SEVERE, "例外内容:", e );
					}
				}
			});

			//階層の深い順番にディレクトリを列挙して、削除する。
			Comparator<Path> pathComparetor = (e1, e2) -> Integer.compare(  e2.getNameCount(), e1.getNameCount());
			Stream<Path> streamDir = dirList.stream();
			streamDir.sorted( pathComparetor ).forEach( e -> {
				try {
					Files.deleteIfExists(e);
				} catch (IOException e3) {
					log.log( Level.SEVERE, "ディレクトリ「{0}」の削除処理でエラーが発生しました。", new String[]{ e.toString() } );
					log.log( Level.SEVERE, "例外内容:", e3 );
				}
			} );

			log.info("---- deleteDirectoies END ----" );

		} catch (IOException e) {
			log.log( Level.SEVERE, "ディレクトリ「{0}」の削除処理でエラーが発生しました。", new String[]{ delPath.toString() } );
			log.log( Level.SEVERE, "例外内容:", e );
		}
	}

	/**
	 * ディレクトリ階層の検索を行い、指定したファイルのパスを取得する。
	 * @see java.nio.file.Files#walk(Path, java.nio.file.FileVisitOption...)
	 * @param path ディレクトリの探索場所
	 * @param targetDir ディレクトリ名
	 */
	private void walkSearchDir( Path path , String targetDir){

		log.info("---- START walkSearchDir ----" );

		try ( Stream<Path> stream = Files.walk( path ) ) {

			//Java8から利用可能 ラムダ式利用
			Stream<Path> streamPath = stream
					.filter( entry -> entry.getFileName().toString().equals( targetDir ) );

			streamPath.forEach(  System.out::println );

			log.info("---- END walkSearchDir ----" );

		} catch (IOException e) {
			log.log( Level.SEVERE, "ディレクトリ「{0}」のファイル検索(walk)処理でエラーが発生しました。", new String[]{ targetDir } );
			log.log( Level.SEVERE, "例外内容:", e );
		}
	}

	/**
	 * ディレクトリ階層の検索を行い、指定したディレクトリのパスを取得する。
	 * @see java.nio.file.Files#find(Path, int, java.util.function.BiPredicate, java.nio.file.FileVisitOption...)
	 * @param path 探索するディレクトリ階層
	 * @param targetDir　探索するディレクトリ名
	 */
	private void findSearchDir(  Path path , String targetDir ){

		log.info("---- START findSearchDir ----" );

		//Integer.MAX_VALUEは階層数が無制限で探索することを意味します。
		//Java8から利用可能 ラムダ式利用
		try ( Stream<Path> stream = Files.find( path , Integer.MAX_VALUE ,
				(file, attrs) -> file.getFileName().toString().equals( targetDir ) ) ) {

			stream.forEach( System.out::println );

			log.info("---- END findSearchDir ----" );

		} catch (IOException e) {
			log.log( Level.SEVERE, "ディレクトリ「{0}」のディレクトリ検索(find)処理でエラーが発生しました。", new String[]{ path.toString() } );
			log.log( Level.SEVERE, "例外内容:", e );
		}
	}



	/**
	 * 指定したディレクトリを指定したディレクトリ配下にコピーする
	 * Java8以前でバージョンでstreamやラムダ式が使えない場合の検索方式
	 * @see java.nio.file.Files#walkFileTree(Path, FileVisitor)
	 * @param fromDir コピー元ディレクトリ
	 * @paam toDir コピー先ディレクトリ
	 */
	public void eclipseDirectories( ){

		Path path = Paths.get("C:\\pleiades");

		try {
			Files.walkFileTree(path, new FileVisitor<Path>() {
				int maxLength = 0;
				String maxPath = "";

				@Override
				/**
				 * ファイル名を維持してそのまま出力先ディレクトリにコピーする。
				 */
				public FileVisitResult visitFile(Path file,
						BasicFileAttributes attr) {

					if( file.toString().length() >= maxLength ){
						maxLength =  file.toString().length();
						maxPath = file.toString();
						log.info( "最大長：" + maxLength );
						log.info( "最大長：" + maxPath );
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
					return FileVisitResult.CONTINUE;
				}

				@Override
				/**
				 * これから探索するディレクトリを出力先ディレクトリにも作成する。
				 */
				public FileVisitResult preVisitDirectory(java.nio.file.Path dir, BasicFileAttributes attrs)
						throws IOException {
					return FileVisitResult.CONTINUE;
				}
			} );
			log.info("---- copyDirectories END ----" );

		} catch (IOException e) {
			log.log( Level.SEVERE, "ディレクトリ「{0}」の複製処理でエラーが発生しました。", new String[]{ path.toString() } );
			log.log( Level.SEVERE, "例外内容:", e );
		}

	}

	/**
	 * javaコマンドから実行されるmainメソッド
	 * @param 引数不要
	 */
	public static final void main( String[] args){
		JavaDirectorySample sample = new JavaDirectorySample();
		sample.eclipseDirectories();
	}

}
