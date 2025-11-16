/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.poo.Controller;

import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;

/**
 *
 * @author valuc
 */
public class FilterNumberString extends TextFormatter<String>{
    public FilterNumberString() {
        super(
            new StringConverter<String>() {
                @Override
                public String toString(String value) {
                    return value;
                }

                @Override
                public String fromString(String text) {
                    return text;
                }
            },
            "", 
            change -> {
                String newText = change.getControlNewText();
                
                if (newText.matches("\\d*") || newText.isEmpty()) {
                    return change;
                }
                return null;
            }
        );
    }
    
}
