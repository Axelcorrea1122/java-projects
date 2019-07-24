/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.SimpleFormatter;
/**
 *
 * @author Tomy
 */
public class FechaUtils {
    public static String calendarATxt(Calendar fecha)
	{
		return String.format("%02d/%02d/%04d", fecha.get(Calendar.DAY_OF_MONTH), fecha.get(Calendar.MONTH) + 1, fecha.get(Calendar.YEAR));
	}
	
	
	public static Calendar txtACalendar(String txt)
	{
		String[] campos = txt.split("/");
		return new GregorianCalendar(Integer.valueOf(campos[2]), Integer.valueOf(campos[1]) - 1, Integer.valueOf(campos[0]));
	}

   public static Calendar toCalendar(Date date)
    {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(date.getTime());
        
        return calendar;
    }
   
   public static String toString(Calendar cal)
   {
       Date date = cal.getTime();
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       String fec = sdf.format(date);
       return fec;
       
   }

    static boolean equalFecha(Calendar f1, Calendar f2) 
    {
        return f1.get(Calendar.YEAR) == f2.get(Calendar.YEAR) &&
               f1.get(Calendar.MONTH) == f2.get(Calendar.MONTH) && 
               f1.get(Calendar.DAY_OF_MONTH) == f2.get(Calendar.DAY_OF_MONTH);
    }
    
    
}
