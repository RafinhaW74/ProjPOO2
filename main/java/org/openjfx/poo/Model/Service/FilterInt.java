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
public class FilterInt extends TextFormatter<Integer>{
    public FilterInt() {
        super(
            new StringConverter<Integer>() {
                @Override
                public String toString(Integer value) {
                    return value == null ? "" : value.toString();
                }

                @Override
                public Integer fromString(String text) {
                    if (text == null || text.isEmpty()) {
                        return 0;
                    }
                    return Integer.parseInt(text);
                }
            },
            0, // valor inicial
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
