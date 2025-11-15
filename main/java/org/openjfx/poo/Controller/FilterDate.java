/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.poo.Controller;



/**
 *
 * @author valuc
 */

import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import org.openjfx.poo.View.Alertas;

public class FilterDate extends TextFormatter<Date> {
    private static final DateTimeFormatter FORMATTER =DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public FilterDate() {
        super(
                
            new StringConverter<Date>() {

                @Override
                public String toString(Date value) {
                    if (value == null) return "";
                    LocalDate ld = value.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    return ld.format(FORMATTER);
                }

                @Override
                public Date fromString(String text) {
                    if (text == null || text.length() != 10) return null;
                    try {
                        LocalDate ld = LocalDate.parse(text, FORMATTER);
                        return Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    } catch (Exception e) {
                        return null;
                    }
                }
            },

            null, // valor inicial Date

            change -> {
                if(!change.getControlText().equalsIgnoreCase(change.getControlNewText())){
                    int oldCaret = change.getCaretPosition();
                    int moveCaret = 0;

                    String digits = change.getControlNewText().replaceAll("[^0-9]", "");

                    if (digits.length() > 8)
                        return null;

                    // Monta texto formatado
                    StringBuilder sb = new StringBuilder();

                    if (digits.length() > 0){
                        sb.append(digits.substring(0, Math.min(2, digits.length())));
                    }

                    if (digits.length() > 2){
                        sb.append("/").append(digits.substring(2, Math.min(4, digits.length())));
                    }

                    if (digits.length() > 4){
                        sb.append("/").append(digits.substring(4));
                    }

                    String formatted = sb.toString();

                    // Valida se estiver completo
                    if (formatted.length() == 10) {
                        try {
                            LocalDate.parse(formatted, FORMATTER);
                        } catch (Exception e) {
                            Alertas.mostrarAlerta("Campo invalido", "Data inserida Invalida", Alert.AlertType.ERROR);
                            change.setText("");
                            change.setRange(0, change.getControlText().length());
                            return null;
                        }
                    }
                    
                    if(oldCaret > 2){
                        moveCaret++;
                    }
                    if(oldCaret > 4){
                        moveCaret++;
                    }

                    if(change.getControlText().length() > formatted.length() && moveCaret != 0){
                        moveCaret--;
                        if(oldCaret > 4){
                            moveCaret--;
                        }
                    }

                    change.setText(formatted);
                    change.setRange(0, change.getControlText().length());
                    
                    int newCaret = Math.min(oldCaret + moveCaret, formatted.length());                    
                    change.setCaretPosition(newCaret);
                    change.setAnchor(newCaret);
                    return change;
                }else{
                    return change;
                }  
            }
        );
    }
}
