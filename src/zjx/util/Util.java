package zjx.util;

import java.io.UnsupportedEncodingException;

public class Util {
	public static String convert(String str){
		try {
			str = new String(str.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
}
