package org.openjfx.poo.Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

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
    private TextField tfEnterpriseCNPJ;
    @FXML
    private TextField tfEnterpriseHabilitation;
    @FXML
    private TextField tfInterpriseName;
    @FXML
    private TextField tfCEP1;
    @FXML
    private TextField tfProductRestrictetfd1;
    @FXML
    private TextField tfStreet1;
    @FXML
    private TextField tfNumber1;

    private Image yey;
    private Image yeyOff;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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


    @FXML
    private void btnRegisterAction(ActionEvent event) {
        System.out.println("Data: "+tfPersonDateBirh.getText());
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
    
}
