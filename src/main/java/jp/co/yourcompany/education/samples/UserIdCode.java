/**
 * Copyright 2017 yourcompany.
 * 本ソースファイルの著作権は株式会社yourcompanyに所属します。
 * 株式会社yourcompanyの許可なくして、本ソースファイルの
 * 配布、改修、コピー、利用を禁止します。
 * 会社名				：株式会社yourcompany
 * 組織名				：システム開発部
 * プロジェクトコード	：education
 * バージョン			：1.0
 * 最終更新日時			：2017/03/05 04:00
 */

package jp.co.yourcompany.education.samples;

/**
 * splitのサンプル
 * @author raita.kuwabara
 */
public class UserIdCode {

	/**
	 * ユーザIDのビジネスロジックは「先頭８桁が入会日(西暦８桁)」
	 */
	public static final int USER_ID_JOIN_DATE_LENGTH = 8;
	/**
	 * ユーザIDの９から１０桁が都道府県コード
	 */
	public static final int USER_ID_PREFECTURES_CD_LENGTH = 2;
	/**
	 * ユーザIDの連番部分は５桁
	 */
	public static final int USER_ID_SEQUENCE_LENGTH = 5;

	/**
	 * 入会日西暦8桁
	 */
	private String joinDateCd = null;
	/**
	 * 都道府県CD2桁
	 */
	private String prefecturesCd = null;
	/**
	 * 連番コード
	 */
	private String sequenceCd = null;

	/**
	 * デフォルトコンストラクタ
	 * @param userId 利用者ID
	 * @return 分割した利用者IDのDTO
	 */
	public UserIdCode( String userId ){
		setJoinDateCd( userId.substring( 0 , UserIdCode.USER_ID_JOIN_DATE_LENGTH  ) );
		setPrefecturesCd( userId.substring( UserIdCode.USER_ID_JOIN_DATE_LENGTH ,
				UserIdCode.USER_ID_JOIN_DATE_LENGTH  + USER_ID_PREFECTURES_CD_LENGTH  ) );
		setSequenceCd( userId.substring( userId.length() -  USER_ID_SEQUENCE_LENGTH ,
				userId.length()  ) );
	}

	/**
	 * ユーザIDを構成する入会日８桁を取得する。
	 * @return joinDateCd 入会日８桁
	 */
	public String getJoinDateCd() {
		return joinDateCd;
	}

	/**
	 * ユーザIDを構成する入会日８桁を設定する。
	 * @return joinDateCd 入会日８桁
	 */
	public void setJoinDateCd(String joinDateCd) {
		this.joinDateCd = joinDateCd;
	}

	/**
	 * ユーザIDを構成する都道府県コード２桁を取得する。
	 * @return prefecturesCd 都道府県コード２桁
	 */
	public String getPrefecturesCd() {
		return prefecturesCd;
	}

	/**
	 * ユーザIDを構成する都道府県コード２桁を設定する。
	 * @param prefecturesCd 都道府県コード２桁
	 */
	public void setPrefecturesCd(String prefecturesCd) {
		this.prefecturesCd = prefecturesCd;
	}

	/**
	 * ユーザIDを構成する連番５桁を取得する。
	 * @return 連番５桁
	 */
	public String getSequenceCd() {
		return sequenceCd;
	}

	/**
	 * ユーザIDを構成する連番５桁を設定する。
	 * @param 連番５桁
	 */
	public void setSequenceCd(String sequenceCd) {
		this.sequenceCd = sequenceCd;
	}

	/**
	 * UserIdCodeのプロパティを全て文字列に変換する。
	 * @return UserIdCodeプロパティの出力
	 */
	public String toString(){
		return "[JoinDateCd]" + getJoinDateCd() +
				"[perfecutresCd]" + getPrefecturesCd() +
				"[sequenceCd]" + getSequenceCd();
	}

}
