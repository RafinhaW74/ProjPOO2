package org.openjfx.poo.Controller;


import javafx.scene.control.TextFormatter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author valuc
 */
public class Filter {
    private static TextFormatter<Integer> filterInt;
    private static TextFormatter<Float> filterFloat;
    private static TextFormatter<Double> filterDouble;
    private static TextFormatter<Float> filterFloatLimited;
    
    public static TextFormatter<Double> getDouble(){
        if(filterDouble == null) filterDouble = new FilterDouble();
        return filterDouble;
    }
    
    public static TextFormatter<Integer> getInt(){
        if(filterInt == null) filterInt = new FilterInt();
        return filterInt;
    }

    public static TextFormatter<Float> getFloat(){
        if(filterFloat == null) filterFloat = new FilterFloat();
        return filterFloat;
    }
    
    public static TextFormatter<Float> getFloat(int decimalLimit){
        if(filterFloat == null) filterFloat = new FilterFloat(decimalLimit);
        return filterFloat;
    }
    
    public static TextFormatter<Double> getDouble(int DecimalLimit){
        if(filterDouble == null) filterDouble = new FilterDouble(DecimalLimit);
        return filterDouble;
    }
}
