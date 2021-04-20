package util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {

	public static boolean isNumeric(String str) {
		  NumberFormat formatter = NumberFormat.getInstance();
		  ParsePosition pos = new ParsePosition(0);
		  formatter.parse(str, pos);
		  return str.length() == pos.getIndex();
		}
	
	public static void main(String[] args) {
		SimpleDateFormat formatDay = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat afterFormat = new SimpleDateFormat("E, dd/MM/yyyy");
		Date afterCreatedDate = new Date();
		String Time_Limit = "Tue, 20/04/2021";
		try {
			afterCreatedDate = (Date)afterFormat.parse(Time_Limit);
			System.out.print(afterCreatedDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
