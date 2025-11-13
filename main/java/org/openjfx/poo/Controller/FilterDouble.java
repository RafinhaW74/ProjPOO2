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
public class FilterDouble extends TextFormatter<Double>{
    public FilterDouble() {
        super(
            new StringConverter<Double>() {
                @Override
                public String toString(Double value) {
                    return value == null ? "" : value.toString();
                }

                @Override
                public Double fromString(String text) {
                    if (text == null || text.isEmpty() || text.equals(".")) {
                        return 0d;
                    }
                    return Double.parseDouble(text.replace(',', '.'));
                }
            },
            0d, // valor inicial
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
    
    public FilterDouble(int decimalLimit) {
        super(
            new StringConverter<Double>() {
                @Override
                public String toString(Double value) {
                    return value == null ? "" : value.toString();
                }

                @Override
                public Double fromString(String text) {
                    if (text == null || text.isEmpty() || text.equals(".")) {
                        return 0d;
                    }
                    return Double.parseDouble(text.replace(',', '.'));
                }
            },
            0d, // valor inicial
            change -> {
                String newText = change.getControlNewText();
                // permite vazio, inteiros e decimais com ponto ou vírgula
                if (newText.matches("\\d*([\\.,]\\d{0,"+decimalLimit+"})?") || newText.isEmpty()) {
                    return change;
                }
                return null;
            }
        );
    }
}
