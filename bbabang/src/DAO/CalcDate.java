package DAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalcDate {
	public static void main(String[] args) throws Exception {
		String rents = "20181112111411";
		String returns = "20181118160909";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
		Date beginDate = formatter.parse(rents);
		Date endDate = formatter.parse(returns);
		
		long diff = endDate.getTime() - beginDate.getTime();
		
		System.out.println(diff / (24 * 60 * 60 * 1000) + "일");
		System.out.println(diff / (60*60*1000) + "시간");
		System.out.println(diff / (60*1000) + "분");
	}
}
