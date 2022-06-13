/**
 * 
 */
package com.insitel.iot.utils;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Agustín Palomino Pardo
 *
 */
public class Utils {

	/**
	 * Método para sumar dias a una fecha de java.sql.date
	 * 
	 * @param fecha
	 * @param dias
	 * @return
	 */
	public static Date sumarDias(Date fecha, int dias) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(fecha);
		cal.add(Calendar.DATE, dias);
		long timeMils = cal.getTimeInMillis();
		Date date1 = new Date(timeMils);
		return date1;
	}


}
