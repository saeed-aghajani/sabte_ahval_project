/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import com.github.eloyzone.jalalicalendar.DateConverter;
import com.github.eloyzone.jalalicalendar.JalaliDate;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.chrono.IslamicChronology;
import org.joda.time.format.DateTimeFormatter;


/**
 *
 * @author saeed
 */
public class Utility {
    public static String gregorian2hijri(String gregorianDate){
        String[] parts = gregorianDate.split("-");
        Chronology iso = ISOChronology.getInstanceUTC();
        Chronology hijri = IslamicChronology.getInstanceUTC();
        LocalDate todayIso = new LocalDate(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), iso);
        LocalDate todayHijri = new LocalDate(todayIso.toDateTimeAtStartOfDay(), hijri);
        return todayHijri.toString();
    }
    
    public static String hijri2gregorian(String hijriStr) {
        String[] parts = hijriStr.split("-");
        Chronology iso = ISOChronology.getInstanceUTC();
        Chronology hijriChrnlg = IslamicChronology.getInstanceUTC();
        DateTime dtHijri = new DateTime(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), 
                0, 0, hijriChrnlg);//(1436,02,02,22,22,hijri);

        DateTime dtIso = new DateTime(dtHijri, iso);
        return dtIso.getYear() + "-" + dtIso.getMonthOfYear() + "-" + dtIso.getDayOfMonth();
    }
    
    public static String gregorian2hijri(Date gregorianDate){
        String gregorianDateStr = getDateInNumberFormat(gregorianDate);
        String[] parts = gregorianDateStr.split("-");
        Chronology iso = ISOChronology.getInstanceUTC();
        Chronology hijri = IslamicChronology.getInstanceUTC();
        LocalDate todayIso = new LocalDate(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), iso);
        LocalDate todayHijri = new LocalDate(todayIso.toDateTimeAtStartOfDay(), hijri);
        return todayHijri.toString();
    }
    
    public static String gregorian2jalali(String gregorianDate){
        DateConverter dateConverter = new DateConverter();
        String[] parts = gregorianDate.split("-");
        JalaliDate jalaliDate = dateConverter.gregorianToJalali(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
        return jalaliDate.toString();
    }
    
    public static String gregorian2jalali(Date gregorianDate){
        String gregorianDateStr = getDateInNumberFormat(gregorianDate);
        DateConverter dateConverter = new DateConverter();
        String[] parts = gregorianDateStr.split("-");
        JalaliDate jalaliDate = dateConverter.gregorianToJalali(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
        return jalaliDate.toString();
    }
    
    public static String jalali2gregorian(String jalaliDate){
        DateConverter dateConverter = new DateConverter();
        String[] parts = jalaliDate.split("-");
        java.time.LocalDate gregorianDate = dateConverter.jalaliToGregorian(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
        return gregorianDate.toString();
    }
    
    public static String jalali2hijri(String jalaliDate){
        String gregorianDate=jalali2gregorian(jalaliDate);
        return gregorian2hijri(gregorianDate);
    }
    
    public static String hijri2jalali(String hijriDate){
        String gregorianDate=hijri2gregorian(hijriDate);
        return gregorian2jalali(gregorianDate);
    }
    
    public static Date gregorianString2Date(String dateStr){
        String[] parts = dateStr.split("-");
        //Depricated
        //Date date = new Date(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
        return calendar.getTime();
    }
    
    public static Date jalaliString2Date(String dateStr){
        String gregorian = jalali2gregorian(dateStr);
        String[] parts = gregorian.split("-"); 
        Calendar calendar = Calendar.getInstance();//new GregorianCalendar();//
        calendar.set(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])-1, Integer.parseInt(parts[2]),0,0);
        return calendar.getTime();
    }
     
    public static String getDateInNumberFormat(Date date){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
        
        /*Calendar calendar = new GregorianCalendar();
        calendar.setTime(birthcertificate.getBirthdate());
        int year = calendar.get(Calendar.YEAR);
        //Add one to month {0 - 11}
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);*/
    }
    
    public static boolean isNumeric(String str) { 
        try {  
            Double.parseDouble(str);  
            return true;
        } catch(NumberFormatException e){  
            return false;  
        }  
    }
    
    //ByRegularExpression
    public static boolean isNumericAlternative(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
    
    public static boolean containsNumber(String str){
        return str.matches(".*\\d.*");
    }
    
     public static void main(String[] args) {
        
        //String log = EventLogDescription.ADD_USER.name();
        //EventLogDescription eld = EventLogDescription.valueOf(log);
       
         
         
        String ss = jalaliString2Date("1398-11-10").toString();
        jalali2hijri("1398-11-9");
        hijri2jalali("1441-06-03");
        String s = gregorian2jalali("2013-10-5");
        System.out.println(s);
        
        String s2 = gregorian2hijri("2013-10-5");
        System.out.println(s2);
        
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        System.out.println(getDateInNumberFormat(new Date()));
        
         System.out.println(jalali2gregorian("1398-11-3"));
         
         System.out.println(gregorian2jalali(new Date()));
    }
     
     
}
