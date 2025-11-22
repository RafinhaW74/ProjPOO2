/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.poo.Model.Service;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author valuc
 */
public class DateManipulation{
    public static Date CreateDate(int year, int month, int day, int hourOfDay, int minute){
        Calendar cal = Calendar.getInstance();
        cal.set(year,month, day, hourOfDay, minute);
        return cal.getTime();
    }
    
    public static Date CreateDate(int year, int month, int day){
        Calendar cal = Calendar.getInstance();
        cal.set(year,month, day);
        return cal.getTime();
    }
    
    public static Date CreateDate(int year, int month, int day, int hourOfDay, int minute, int second){
        Calendar cal = Calendar.getInstance();
        cal.set(year,month, day, hourOfDay, minute,second);
        return cal.getTime();
    }
}
