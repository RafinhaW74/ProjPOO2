/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.poo.Model.Service;

import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;

/**
 *
 * @author valuc
 */
public class FilterFloat extends TextFormatter<Float>{
    public FilterFloat() {
        super(
            new StringConverter<Float>() {
                @Override
                public String toString(Float value) {
                    return value == null ? "" : value.toString();
                }

                @Override
                public Float fromString(String text) {
                    if (text == null || text.isEmpty() || text.equals(".")) {
                        return 0f;
                    }
                    return Float.parseFloat(text.replace(',', '.'));
                }
            },
            0f, // valor inicial
            change -> {
                String newText = change.getControlNewText();
                // permite vazio, inteiros e decimais com ponto ou vírgula
                if (newText.matches("\\d*([\\.,]\\d*)?") || newText.isEmpty()) {
                    return change;
                }
                return null;
            }
        );
    }
    
    public FilterFloat(int decimalLimit) {
        super(
            new StringConverter<Float>() {
                @Override
                public String toString(Float value) {
                    return value == null ? "" : value.toString();
                }

                @Override
                public Float fromString(String text) {
                    if (text == null || text.isEmpty() || text.equals(".")) {
                        return 0f;
                    }
                    return Float.parseFloat(text.replace(',', '.'));
                }
            },
            0f, // valor inicial
            change -> {
                String newText = change.getControlNewText();
                
                if (newText.matches("\\d*([\\.,]\\d{0,"+decimalLimit+"})?") || newText.isEmpty()) {
                    return change;
                }
                return null;
            }
        );
    }
}
