package com.hujianbin.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DateUtil {

	private final static SimpleDateFormat formatyyyymmddhhmmss=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private final static SimpleDateFormat formatyyyymmddhhmmsssss=new SimpleDateFormat("yyyyMMddHHmmssSSS");
	private final static SimpleDateFormat formatyyyymmddhhmmssssssplit=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	private final static SimpleDateFormat formatyyyymmdd=new SimpleDateFormat("yyyy-MM-dd");
	private final static SimpleDateFormat formatyyyymmdd2=new SimpleDateFormat("yyyy/MM/dd");
	private final static SimpleDateFormat formatyyyymmdd3=new SimpleDateFormat("yyyyMMdd");
	private final static SimpleDateFormat formatyyyymm=new SimpleDateFormat("yyyyMM");
	private final static SimpleDateFormat formatyyyy_mm=new SimpleDateFormat("yyyy-MM");
	private final static SimpleDateFormat formathhmm=new SimpleDateFormat("HH:mm");
	private final static SimpleDateFormat formatyyyymmddhhmmsschinese=new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
	private final static SimpleDateFormat formatyyyymmddchinese=new SimpleDateFormat("yyyy年MM月dd日");
	private final static SimpleDateFormat formathhmmsssss=new SimpleDateFormat("HHmmssSSS");
	private final static SimpleDateFormat formatHHmm=new SimpleDateFormat("HHmm");
	private final static SimpleDateFormat formatyyyyMMddEEE= new SimpleDateFormat("yyyy-MM-dd EEE");
	private static Lock dateLock=new ReentrantLock();
	
	public static String getCurrentDateTime(){
		return formatyyyymmddhhmmss.format(new Date());
	}
	
	public static String date2string(Date date){
		if(date==null)
			date=new Date();
		return formatyyyymmddhhmmss.format(date);
	}
	
	public static String date2shortstr(Date date){
		return formatyyyymmdd.format(date);
	}
	
	public static String date2str(Date date){
		return formatyyyymmdd2.format(date);
	}
	
	public static String date2yearMonth(Date date){
		return formatyyyy_mm.format(date);
	}
	
	public static String getBeforeSecondsDateTime(int ss){
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.SECOND, -ss);
		return formatyyyymmddhhmmss.format(cal.getTime());
	}
	
	public static String getCurrentDate(){
		return formatyyyymmdd.format(new Date());
	}
	
	public static String getOrderDate(){
		return formatyyyymmdd3.format(new Date());
	}
	
	public static Date string2Date(String dateStr){
		Date tempDate=null;
		try {
			tempDate=formatyyyymmdd.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempDate;
	}

	public static Date string2DateTime(String dateStr){
		Date tempDate=null;
		try {
			tempDate=formatyyyymmddhhmmss.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempDate;
	}

	public static Date month2Date(String dateStr){
		Date tempDate=null;
		try {
			tempDate=formatyyyymm.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempDate;
	}
	
	public static int parseDate2Int(String date){
		int result=0;
		try {
			dateLock.lock();
			result=(int) (formatyyyymmddhhmmss.parse(date).getTime()/1000);
		} catch (ParseException e) {
			e.printStackTrace();
		} finally{
			dateLock.unlock();
		}
		return result;
	}
	
	public static String parseInt2Date(int i){
		Calendar cal=Calendar.getInstance();
		cal.setTimeInMillis((long)i*1000);
		String date="";
		synchronized (formatyyyymmddhhmmss) {
			date=formatyyyymmddhhmmss.format(cal.getTime());
		}
		return date;
	}
	
	public synchronized static int parseFullDate(String str){
		int result=0;
		try {
			result=(int)(formatyyyymmddhhmmsssss.parse(str).getTime()/1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public synchronized static int parseFullSplitDate(String str){
		int result=0;
		try {
			result=(int)(formatyyyymmddhhmmssssssplit.parse(str).getTime()/1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String getCurrentTime(){
		String t="0";
		synchronized (formathhmmsssss) {
			t=formathhmmsssss.format(new Date());
		}
		return t;
	}
	
	public static int getBlockStartTime(int i,int blockSize,int before){
		int start=24/blockSize*i;
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE,-before);
		cal.set(Calendar.HOUR_OF_DAY, start);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return (int) (cal.getTimeInMillis()/1000);
	}
	
	public static int getBlockEndTime(int i,int blockSize,int before){
		int end=24/blockSize*(i+1);
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE,-before);
		cal.set(Calendar.HOUR_OF_DAY, end);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return (int) (cal.getTimeInMillis()/1000);
	}
	
	public static long getTodayStartTime(){
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTimeInMillis();
	}
	
	public static Date getTodayStartDate(){
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	
	public static String getCurrentMonth(){
		Calendar cal=Calendar.getInstance();
		return formatyyyymm.format(cal.getTime());
	}
	public static String getMonthBeforeDays(int before){
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, -before);
		return formatyyyymm.format(cal.getTime());
	}
	
	public static String getBeforeDay(int before){
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, -before);
		return formatyyyymmdd.format(cal.getTime());
	}
	
	public static String getBeforeDayDateTime(int before){
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, -before);
		return formatyyyymmddhhmmss.format(cal.getTime());
	}
	
	public static String getCurrentHHmm(){
		Calendar cal=Calendar.getInstance();
		return formathhmm.format(cal.getTime());
	}
	
	public static String getCurrentTimeChinese(){
		Calendar cal=Calendar.getInstance();
		return formatyyyymmddhhmmsschinese.format(cal.getTime());
	}
	
	public static String getBeforeDateChinese(int before){
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, -before);
		return formatyyyymmddchinese.format(cal.getTime());
	}
	
	public static String getBeforeDaysMonthEndTime(int before){
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, -before);
		int d=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DATE, d);
		cal.set(Calendar.HOUR_OF_DAY,23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return formatyyyymmddhhmmss.format(cal.getTime());
	}
	
	public static String getCurrentMonthBeginTime(){
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY,0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return formatyyyymmddhhmmss.format(cal.getTime());
	}
	
	public static String getCurrentMonthEndTime(){
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY,23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return formatyyyymmddhhmmss.format(cal.getTime());
	}
	
	public static int getMinutesOfDay(){
		int s=0;
		Calendar cal=Calendar.getInstance();
		s=Integer.parseInt(formatHHmm.format(cal.getTime()));
		return s;
	}
	
	public static Date getCurrentMonday(){
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return cal.getTime();
	}
	
	public static Date getCurrentSunday(){
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}
	
	public static Date getPreSunday(){
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}
	
	public static Date getCurrentSaturday(){
		Calendar cal=Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.SUNDAY);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		return cal.getTime();
	}
	
	public static Date getBeforeDays(int i){
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, i);
		return cal.getTime();
	}
	
	/**
	 * 根据用户生日计算年龄
	 */
	public static int getAgeByBirthday(Date birthday) {
		Calendar cal = Calendar.getInstance();

		if (cal.before(birthday)) {
			throw new IllegalArgumentException(
					"The birthDay is before Now.It's unbelievable!");
		}

		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

		cal.setTime(birthday);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

		int age = yearNow - yearBirth;

		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				// monthNow==monthBirth 
				if (dayOfMonthNow < dayOfMonthBirth) {
					age--;
				}
			} else {
				// monthNow>monthBirth 
				age--;
			}
		}
		return age;
	}
	
    /**
     * 根据日期获得所在周的连续14天日期，
     * 周日 周一 周二 周三 周四 周五 周六
     * 周日 周一 周二 周三 周四 周五 周六 
     * @param mdate
     * @return
     */
    public static List<Date> dateToWeek(Date mdate) {
        int b = getWeekOfDate(mdate) + 1;// +1 后得到的日期为:从上周周日开始，到下周周六
        Date fdate;
        List<Date> list = new ArrayList<Date>();
        Long fTime = mdate.getTime() - b * 24 * 3600000;
        for (int a = 1; a <= 14; a++) {
            fdate = new Date();
            fdate.setTime(fTime + (a * 24 * 3600000));
            list.add(a-1, fdate);
        }
        return list;
    }
    
    /**
     * 根据日期获得所在周的连续14天日期，
     * 周日 周一 周二 周三 周四 周五 周六
     * 周日 周一 周二 周三 周四 周五 周六 
     * @param mdate
     * @return
     */
    public static List<Date> dateToNextWeek(Date mdate) {
        int b = getWeekOfDate(mdate) + 1;// +1 后得到的日期为:从上周周日开始，到下周周六
        Date fdate;
        List<Date> list = new ArrayList<Date>();
        Long fTime = mdate.getTime() - b * 24 * 3600000;
        for (int a = 1; a <= 14; a++) {
            fdate = new Date();
            fdate.setTime(fTime + (a * 24 * 3600000));
            list.add(a-1, fdate);
        }
        List<Date> nextList = list.subList(7, 14);
        return nextList;
    }
    
    /**
     * 
     * @param date
     * @return
     */
    public static int getWeekOfDate(Date date){
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(date);
    	int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
    	if(w < 0){
    		w = 0;
    	}
    	
    	return w;
    }
	
	public static void main(String[] args){
		System.out.println(new Date());
		String month = getCurrentMonth();
		Date d = DateUtil.month2Date(month);
		System.out.println(d);
		System.out.println(getCurrentMonth());
		System.out.println(getCurrentMonday());
		System.out.println(getCurrentSunday());
		System.out.println(getCurrentSaturday());
		System.out.println(MD5.getMD5("1234"));
		System.out.println(date2yearMonth(new Date()));
		System.out.println(date2str(new Date()));
		
		System.out.println("==========");
		
		System.out.println(getAgeByBirthday(string2Date("1993-7-26")));
		System.out.println(string2Date("1993-7-26"));
		System.out.println(string2Date("1993-7-26").getDay());
		
//		System.out.println(DateUtil.getCurrentDate());
//		System.out.println(DateUtil.date2shortstr(DateUtil.getPreSunday()));
		Calendar cal = Calendar.getInstance();
		cal.setTime(string2Date("2015-8-32"));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK)-1);
		System.out.println(DateUtil.string2Date(DateUtil.date2shortstr(new Date())));
		
		Date d2 = DateUtil.string2Date("2015-9-24");
		Date d1 = DateUtil.string2Date(DateUtil.date2shortstr(new Date()));
		Date date = new Date();
		System.out.println("d1= "+d1);
		System.out.println("d2= "+d2);
		System.out.println(date.compareTo(d2));
		
		System.out.println("##################");
		List<Date> dateList = DateUtil.dateToWeek(new Date());
		for (Date date2 : dateList) {
			System.out.println(DateUtil.date2shortstr(date2));
		}
		
		List<Date> nextDateList = DateUtil.dateToNextWeek(new Date());
		for (Date date2 : nextDateList) {
			System.out.println(DateUtil.date2shortstr(date2));
		}
	}
	
}
