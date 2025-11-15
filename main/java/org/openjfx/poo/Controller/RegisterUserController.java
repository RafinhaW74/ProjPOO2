package org.openjfx.poo.Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import org.openjfx.poo.App;
import org.openjfx.poo.View.Alertas;
import org.openjfx.poo.Model.Dao.InserePessoa_importadora;
import org.openjfx.poo.Model.Dao.InsereEmpresa;

/**
 * FXML Controller class
 *
 * @author valuc
 */
public class RegisterUserController implements Initializable {
    @FXML
    private Button btnRegister;
    @FXML
    private GridPane gpNaturalPerson;
    @FXML
    private PasswordField pfPassword;
    @FXML
    private TextField tfPassword;
    @FXML
    private ToggleButton tbPassword;
    @FXML
    private ImageView ivPassword;
    @FXML
    private PasswordField pfCheckPassword;
    @FXML
    private TextField tfCheckPassword;
    @FXML
    private ToggleButton tbCheckPassword;
    @FXML
    private ImageView ivCheckPassword;
    @FXML
    private GridPane gpLegalEntity;
    @FXML
    private ToggleGroup tgType;
    @FXML
    private RadioButton rbNaturalPerson;
    @FXML
    private RadioButton rbLegalEntity;
    @FXML
    private TextField tfPersonDateBirh;
    @FXML
    private TextField tfPersonRG;
    @FXML
    private TextField tfPersonCPF;
    @FXML
    private TextField tfPersonName;
    @FXML
    private TextField tfInterpriseCNPJ;
    @FXML
    private TextField tfInterpriseHabilitation;
    @FXML
    private TextField tfInterpriseName;
    @FXML
    private TextField tfCEP;
    @FXML
    private Button btnLoginBack;
    @FXML
    private TextField tfNeighborhood;
    @FXML
    private TextField tfStreet;
    @FXML
    private TextField tfNumber;

    private Image yey;
    private Image yeyOff;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listenerDateBirh();
        setFilter();
        swichForm();
        tfPersonDateBirh.setTextFormatter(new FilterDate());
        tfPassword.textProperty().bindBidirectional(pfPassword.textProperty());
        tfCheckPassword.textProperty().bindBidirectional(pfCheckPassword.textProperty());
        
        yey = new Image(getClass().getResource("/org/openjfx/poo/image/yey.png").toExternalForm());
        yeyOff = new Image(getClass().getResource("/org/openjfx/poo/image/yeyOff.png").toExternalForm());
        
        tgType.selectedToggleProperty().addListener((observer, oldType, newType)->{
            swichForm();
        });
        
        
    }    
 
    @FXML
    private void btnRegisterAction(ActionEvent event) {
        Argon2 argon2 = Argon2Factory.create();
        if(rbNaturalPerson.isSelected()){
            List<TextInputControl> campos = List.of(tfPersonName, tfPersonCPF, tfPersonRG, tfPersonDateBirh, tfCEP, tfNeighborhood, tfStreet, pfCheckPassword, pfPassword);
            if(campos.stream().anyMatch(tf -> tf.getText().trim().isEmpty()) || (int) tfNumber.getTextFormatter().getValue() == 0){
                Alertas.mostrarAlerta("Erro campo vazio", "Todos os campos devem ser preenchidos.", Alert.AlertType.ERROR);
            }else{
                if(!pfCheckPassword.getText().equals(pfPassword.getText())){
                    Alertas.mostrarAlerta("Erro senhas distintas", "As senhas digitadas são diferentes.", Alert.AlertType.ERROR);
                }else{
                    InserePessoa_importadora.inserePessoa_importadoraBD(tfPersonName.getText(), argon2.hash(2, 65536, 2, pfPassword.getText()), tfNeighborhood.getText(), tfStreet.getText(), (int) tfNumber.getTextFormatter().getValue(), tfCEP.getText(), (Date)tfPersonDateBirh.getTextFormatter().getValue(), tfPersonRG.getText(), tfPersonCPF.getText());
                    Alertas.mostrarAlerta("Confirma cadastro", "Cadastro feito com sucesso.", Alert.AlertType.CONFIRMATION);
                    try{
                        App.setRoot("FXLogin");
                    }catch (IOException erro) {
                        System.out.println(erro);
                        Alertas.mostrarAlerta("Erro carregar", "Erro ao carregar a tela de login.", Alert.AlertType.ERROR);
                    }
                }

            }
        }else{
            List<TextInputControl> campos = List.of(tfInterpriseCNPJ, tfInterpriseHabilitation, tfInterpriseName, tfCEP, tfNeighborhood, tfStreet, tfNumber, pfCheckPassword, pfPassword);
            if(campos.stream().anyMatch(tf -> tf.getText().trim().isEmpty())){
                Alertas.mostrarAlerta("Erro campo vazio", "Todos os campos devem ser preenchidos.", Alert.AlertType.ERROR);
            }else{
                if(!pfCheckPassword.getText().equals(pfPassword.getText())){
                    Alertas.mostrarAlerta("Erro senhas distintas", "As senhas digitadas são diferentes.", Alert.AlertType.ERROR);
                }else{
                    InsereEmpresa.insereEmpresaBD(tfInterpriseName.getText(), argon2.hash(2, 65536, 2, pfPassword.getText()), tfNeighborhood.getText(), tfStreet.getText(), (int) tfNumber.getTextFormatter().getValue(), tfCEP.getText(), tfInterpriseCNPJ.getText(), tfInterpriseHabilitation.getText());
                    Alertas.mostrarAlerta("Confirma cadastro", "Cadastro feito com sucesso.", Alert.AlertType.CONFIRMATION);                   
                    try{
                        App.setRoot("FXLogin");
                    }catch (IOException erro) {
                        System.out.println(erro);
                        Alertas.mostrarAlerta("Erro carregar", "Erro ao carregar a tela de login.", Alert.AlertType.ERROR);
                    }
                }
            }
        }
    }

    @FXML
    private void tbPasswordAction(ActionEvent event) {
        if(tbPassword.isSelected()){
            pfPassword.setVisible(false);
            tfPassword.setVisible(true);
            ivPassword.setImage(yey);
        }else{
            pfPassword.setVisible(true);
            tfPassword.setVisible(false);
            ivPassword.setImage(yeyOff);
        }
    }

    @FXML
    private void tbCheckPasswordAction(ActionEvent event) {
        if(tbCheckPassword.isSelected()){
            pfCheckPassword.setVisible(false);
            tfCheckPassword.setVisible(true);
            ivCheckPassword.setImage(yey);
        }else{
            pfCheckPassword.setVisible(true);
            tfCheckPassword.setVisible(false);
            ivCheckPassword.setImage(yeyOff);
        }
    }

    @FXML
    private void btnLoginBackAction(ActionEvent event) {
        try{
            App.setRoot("FXLogin");
        }catch (IOException erro) {
            System.out.println(erro);
            Alertas.mostrarAlerta("Erro carregar", "Erro ao carregar a tela de Login.", Alert.AlertType.ERROR);
        }
    }
    
    public void swichForm(){
        if(rbNaturalPerson.isSelected()){
            gpNaturalPerson.setVisible(true);
            gpNaturalPerson.setManaged(true);

            gpLegalEntity.setVisible(false);
            gpLegalEntity.setManaged(false);
        }else{
            gpNaturalPerson.setVisible(false);
            gpNaturalPerson.setManaged(false);

            gpLegalEntity.setVisible(true);
            gpLegalEntity.setManaged(true);
        }
    }
    
    public void listenerDateBirh(){
        tfPersonDateBirh.focusedProperty().addListener((object, oldValue, newValue) ->{
            if(!newValue){
               String txt = tfPersonDateBirh.getText();

            // Se não estiver completa (10 chars), limpar
            if (txt == null || txt.length() != 10) {
                tfPersonDateBirh.setText("");
            }

            // Se estiver completa mas inválida, limpar
            else {
                try {
                    LocalDate.parse(txt, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                } catch (Exception e) {
                    tfPersonDateBirh.setText("");
                }
            }
            }
        });
    }
    
    public void setFilter(){
        tfPersonDateBirh.setTextFormatter(new FilterDate());
        tfNumber.setTextFormatter(new FilterInt());
        tfPersonRG.setTextFormatter(new FilterInt());
        tfPersonCPF.setTextFormatter(new FilterInt());
        tfInterpriseCNPJ.setTextFormatter(new FilterInt());
    }
}