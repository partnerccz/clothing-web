package com.clothing.web.utils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 描述:
 * 时间工具类
 *
 * @author partner
 * @create 2018-08-01 10:08
 */
public class DateUtil {
    public static final String HOUSE_KEY = "house";

    public static void main(String[] args) {
//        getOrderBill(DateUtil.strToDate("2018-09-13 16:43:14", "yyyy-MM-dd HH:mm:ss"), new Date(),);
        if (true) {
            return;
        }
        String str = "file:\\E:\\ccz\\yundianba-project\\order-service\\ydb-order.jar!\\BOOT-INF\\classes!\\static\\upload\\";
        String substring = str.substring(4, str.length());
        String substring2 = str.substring(6, str.length());
        System.out.println(substring);
        System.out.println(substring2);
//        Double a=10/100.0;
//        System.out.println(a);
//        String test = "2018-09-1 05:20:00";
//        String substring = test.split(" ")[1].substring(3, 5);
//        System.out.println(substring);
//        System.out.println(Integer.parseInt(substring));

        Date date1 = strToDate("2018-09-06 02:49:31", "yyyy-MM-dd HH:mm:ss");
        Date date2 = strToDate("2018-09-06 18:05:38", "yyyy-MM-dd HH:mm:ss");

        Double orderBill = DateUtil.getOrderBill(date1, date2, 1, new Double(3), 10D);

//        Double plat = orderBill*0.2;
//        Double provice = orderBill*0.3;
//        Double city = orderBill*0.1;
//        Double sales =orderBill*0.2;
//        Double shop = orderBill * 0.2;
//        System.out.println("plat="+plat);
//        System.out.println("provice="+provice);
//        System.out.println("city="+city);
//        System.out.println("sales="+sales);
//        System.out.println("shop="+shop);
//        System.out.println("plat="+String.format("%.1f",plat));
//        System.out.println("provice="+String.format("%.1f",provice));
//        System.out.println("city="+String.format("%.1f",city));
//        System.out.println("sales="+String.format("%.1f",sales));
//        System.out.println("shop="+String.format("%.1f",shop));

        System.out.println(orderBill);
        if (true) {
            return;
        }

        List<Map<String, Object>> hourEveryDay = getHourEveryDay(date1, date2, 40);

        Date dateIntervalByMinute = getDateIntervalByMinute(new Date(), -5, "yyyy-MM-dd HH:mm:ss");
        System.out.println(dateIntervalByMinute);
        try {
            Long aLong = TimeDiff("2018-03-22 00:00:00", "2018-03-23 00:00:00", "yyyy-MM-dd hh:mm:ss");
            System.out.println(aLong);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(getNextDay("2018-03-22 12:03:14", "1"));
        System.out.println(getNextDay("2018-03-22 12:03:14", "-2"));
        int i = compare_date("2018-03-24 10:00:00", "2018-03-24 09:59:59", "yyyy-MM-dd hh:mm:ss");
        System.out.println(i);
    }


    /**
     * 得到一个时间延后或前移几天的时间,nowdate为时间,delay为前移或后延的天数
     */
    public static String getNextDay(String nowdate, String delay) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String mdate = "";
            Date d = strToDate(nowdate);
            long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24 * 60 * 60;
            d.setTime(myTime * 1000);
            mdate = format.format(d);
            return mdate;
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 根据传入的时间和要间隔的分钟，
     *
     * @param date           时间
     * @param intervalMinute 间隔
     * @param pattern        时间格式
     * @return
     */
    public static Date getDateIntervalByMinute(Date date, Integer intervalMinute, String pattern) {
        SimpleDateFormat dft = new SimpleDateFormat(pattern);
        Calendar dar = Calendar.getInstance();
        dar.setTime(date);
        dar.add(Calendar.MINUTE, intervalMinute);
        System.out.println(dft.format(dar.getTime()));
        return dar.getTime();
    }

    /**
     * 获取两个时间的间隔小时数
     *
     * @param pBeginTime
     * @param pEndTime
     * @param pattern
     * @return
     */
    public static Long TimeDiff(String pBeginTime, String pEndTime, String pattern) {

        try {
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            Long beginL = format.parse(pBeginTime).getTime();
            Long endL = format.parse(pEndTime).getTime();
            Long day = (endL - beginL) / 86400000;
            Long hour = ((endL - beginL)) / 3600000;
            Long min = ((endL - beginL) % 86400000 % 3600000) / 60000;
            return hour;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Long(0);
    }

    /**
     * 获取两个时间的间隔小时数
     *
     * @param pBeginTime
     * @param pEndTime
     * @param pattern
     * @return
     */
    public static Long TimeDiff2(String pBeginTime, String pEndTime, String pattern) {

        try {
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            Long beginL = format.parse(pBeginTime).getTime();
            Long endL = format.parse(pEndTime).getTime();
            Long day = (endL - beginL) / 86400000;
            Long hour = ((endL - beginL)) / 3600000;
            if ((endL - beginL) % 3600000 != 0) {
                hour += 1;
            }
            Long min = ((endL - beginL)) / 60000;
            return hour;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Long(0);
    }

    public static Double getOrderBill(Date startDate, Date endDate, Integer intervalMinute, Double unitPrice, Double hightPrice) {
        try {
            List<Map<String, Object>> hourEveryDay = getHourEveryDay(startDate, endDate, intervalMinute);
            if (hourEveryDay == null || hourEveryDay.size() <= 0) {
                return new Double(0);
            }
            Double bill = new Double(0);
            Double hightHouse = (new BigDecimal(hightPrice)).divide(new BigDecimal(unitPrice), 1, BigDecimal.ROUND_HALF_UP).doubleValue();

            for (int i = 0; i < hourEveryDay.size(); i++) {
                Map map = hourEveryDay.get(i);

                Double house = Double.parseDouble(map.get(HOUSE_KEY) + "");
                if (house > hightHouse) {
                    house = hightHouse;
                }
                bill += unitPrice * house;
//                bill += (new BigDecimal(unitPrice)).multiply(new BigDecimal(house)).longValue();
            }
            return Double.parseDouble(String.format("%.1f", bill));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("计算费用报错！");
            return new Double(0);
        }
    }

    /**
     * 根据两个时间，算出这个时间段里的免费有多少个小时，并且加上免费时长
     *
     * @param startDate      开始时间
     * @param endDate        结束时间
     * @param intervalMinute 间隔时长，单位是分钟
     * @return 返回每一天的时长
     */
    public static List<Map<String, Object>> getHourEveryDay(Date startDate, Date endDate, Integer intervalMinute) {
        String pattern = "yyyy-MM-dd HH";
        String patternMinute = "yyyy-MM-dd HH:mm";
        String patternShort = "yyyy-MM-dd";
        String patternFull = "yyyy-MM-dd HH:mm:ss";
        Date convertStartDate = getDateIntervalByMinute(startDate, intervalMinute, patternMinute);
        String startDateStrLong = getStringDate(convertStartDate, pattern);
        String startDateStrShort = getStringDate(convertStartDate, patternShort);
        String endDateStrLong = getStringDate(endDate, pattern);
        String endDateStrShort = getStringDate(endDate, patternShort);
        List<Map<String, Object>> mapList = new ArrayList<>();
        int compareResult = DateUtil.compare_date(DateUtil.getStringDate(convertStartDate, patternMinute), DateUtil.getStringDate(endDate, patternMinute), patternMinute);
        if (compareResult >= 0) {
            Map map = new HashMap();
            map.put(HOUSE_KEY, 0);
            mapList.add(map);
            return mapList;
        }
        Long aLong = DateUtil.TimeDiff2(getStringDate(convertStartDate, patternMinute), getStringDate(endDate, patternMinute), patternMinute);
        if (aLong <= 10) {
            Map map = new HashMap();
            map.put(HOUSE_KEY, aLong);
            mapList.add(map);
            return mapList;
        }
        int count = 0;
        while (true) {
            count++;
            if (count == 1) {
                int i = compare_date(endDateStrShort, startDateStrShort, patternShort);
                if (i > 0) {
                    Long house = TimeDiff(startDateStrLong, (getNextDay(startDateStrLong, "1")).split(" ")[0] + " 00", pattern);
                    Map<String, Object> map = new HashMap<>();
                    map.put(HOUSE_KEY, house);
                    mapList.add(map);
                } else {
                    Long house = new Long(0);
                    Integer endMinute = Integer.parseInt(getStringDate(endDate, patternFull).split(" ")[1].substring(3, 5));
                    house = TimeDiff(startDateStrLong, endDateStrLong, pattern);
                    int result = compare_date(getStringDate(convertStartDate, patternFull), getStringDate(endDate, patternFull), patternFull);
                    if (result != 0 && result != 1) {
                        house += 1;
                    }
                    Map map = new HashMap();
                    map.put(HOUSE_KEY, house);
                    mapList.add(map);
                    break;
                }
            } else {
                startDateStrShort = getNextDay(startDateStrLong, "1");
                startDateStrLong = startDateStrShort + " 00";
                int resultCount = compare_date(endDateStrShort, startDateStrShort, patternShort);
                if (resultCount > 0) {
                    Long house = TimeDiff((startDateStrLong.split(" "))[0] + " 00", getNextDay((startDateStrLong.split(" "))[0], "1") + " 00", pattern);
                    Map<String, Object> map = new HashMap<>();
                    map.put(HOUSE_KEY, 24);
                    mapList.add(map);
                } else {
                    Integer endMinute = Integer.parseInt(getStringDate(endDate, patternFull).split(" ")[1].substring(3, 5));
                    Long house = TimeDiff((startDateStrLong.split(" "))[0] + " 00", endDateStrLong, pattern);
                    if (endMinute != 0) {
                        house += 1;
                    }
                    Map<String, Object> map = new HashMap<>();
                    map.put(HOUSE_KEY, house);
                    mapList.add(map);
                    break;
                }
            }
        }
        return mapList;
//        int i = compare_date(stringDate, (stringDate.split(" "))[1] + " 00:00:00", pattern);
//        if (i > 0) {
//
//        }
//        return null;
    }

    /**
     * 比较两个时间
     *
     * @param dt1
     * @param dt2
     * @return 1 第一个比第二个时间大       0 反之
     */
    public static int compare_date(Date dt1, Date dt2) {
        try {
            if (dt1.getTime() > dt2.getTime()) {
                System.out.println("dt1 在dt2前");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                System.out.println("dt1在dt2后");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * 比较两个时间
     *
     * @param DATE1
     * @param DATE2
     * @param pattern
     * @return 1 第一个比第二个时间大        0 反之
     */
    public static int compare_date(String DATE1, String DATE2, String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                System.out.println("dt1 在dt2前");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                System.out.println("dt1在dt2后");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }


    public static Long getTimestamp() {
        return System.currentTimeMillis();
    }

    /**
     * 将短时间格式字符串转换为时间 yyyy-MM-dd
     *
     * @param strDate
     * @return
     */
    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    public static Date strToDate(String strDate, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    /**
     * 获取现在时间
     *
     * @return 返回短时间字符串格式yyyy-MM-dd
     */
    public static String getStringDateShort(Date time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(time);
        return dateString;
    }

    /**
     * 获取现在时间没有“-”格式
     *
     * @return 返回短时间字符串格式yyyy-MM-dd
     */
    public static String getStringDateLong() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmm");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 获取现在时间没有“-”格式
     *
     * @param
     * @return 返回短时间字符串格式yyyy-MM-dd
     */
    public static String getStringDate(Date currentTime, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String dateString = formatter.format(currentTime);
        return dateString;
    }


    /**
     * 获取现在时间没有“-”格式
     *
     * @param
     * @return 返回短时间字符串格式yyyy-MM-dd
     */
    public static String getStringDateLong(Date currentTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmm");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 得到现在的日期
     *
     * @return
     */
    public static String getYear() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        String year;
        year = dateString.substring(0, 4);
        return year;
    }

    /**
     * 得到现在的日期
     *
     * @return
     */
    public static String getMonth() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        String month;
        month = dateString.substring(5, 7);
        return month;
    }

    /**
     * 得到现在的日期
     *
     * @return
     */
    public static String getDay() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        String day;
        day = dateString.substring(8, 10);
        return day;
    }

    /**
     * 得到现在小时
     */
    public static String getHour() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        String hour;
        hour = dateString.substring(11, 13);
        return hour;
    }

    /**
     * 得到现在分钟
     *
     * @return
     */
    public static String getTime() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        String min;
        min = dateString.substring(14, 16);
        return min;
    }

    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
}
