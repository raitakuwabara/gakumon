package jp.co.yourcompany.education.samples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	/**
	 *
	 */
	public static final void main(){

		Map<String,String> map = new HashMap<String,String>();
		map.put("first_name", "太郎");
		map.put("last_name", "山田");

		List<String> list = new ArrayList<String>();
		list.add( "山田　太郎");
		list.add( "東京都hoge");

	}

}
