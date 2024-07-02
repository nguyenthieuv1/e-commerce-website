/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class ChuanHoa {

    public static String removeComma(String data) {
        String res = data.replaceAll(",", "");
        return res;
    }

    public static Date stringToDate(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if (!dateString.equals("") && dateString!=null) {
            Date date = format.parse(dateString);
            return date;
        }
        return null;
    }

    public static java.sql.Date toSQLdate(Date date) {
        if (date!=null) {
            return new java.sql.Date(date.getTime());
        }
        return null;
    }
}
