package jp.co.yourcompany.education.samples;

/**
 * 従業員の役職を管理するEnum
 * @author 雷太
 *
 */
public enum EmployeePosition {

	//代表取締役
	CEO( "999"  ),
	//役員
	ASSUMPTION( "100" ),
	//執行役員
	EXECUTIVE( "040"  ),
	//部長
	MANAGER( "030" ),
	//課長
	CHIEF( "020" ),
	//正社員
	NORMAL( "010" ),
	//契約社員
	CONTRACT( "009" ) ,
	//アルバイト・パート
	PART( "008" );

	private final String code;

	private EmployeePosition( String code ){
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
