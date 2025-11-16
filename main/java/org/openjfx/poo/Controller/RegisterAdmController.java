/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package org.openjfx.poo.Controller;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.openjfx.poo.App;
import org.openjfx.poo.Model.Dao.BuscaAlfandegario;
import org.openjfx.poo.Model.Dao.InsereAlfandegario;
import org.openjfx.poo.View.Alertas;
import org.openjfx.poo.Model.Alfandegario;

/**
 * FXML Controller class
 *
 * @author valuc
 */
public class RegisterAdmController implements Initializable {

    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu mnName;
    @FXML
    private Menu mnRequestImport;
    @FXML
    private MenuItem miRequest;
    @FXML
    private Menu mnViewPending;
    @FXML
    private MenuItem miViewPending;
    @FXML
    private TextField tfName;
    @FXML
    private Label lbLI;
    @FXML
    private TextField tfSiape;
    @FXML
    private PasswordField pfPassword;
    @FXML
    private TextField tfPassword;
    @FXML
    private TextField tfID;
    @FXML
    private PasswordField pfCheckPassword;
    @FXML
    private TextField tfCheckPassword;
    @FXML
    private Button btnRegister;
    @FXML
    private Button btnLogout;
    @FXML
    private ToggleButton tbPassword;
    @FXML
    private ToggleButton tbCheckPassword;
    @FXML
    private ImageView ivPassword;
    @FXML
    private ImageView ivCheckPassword;

    private Image yey;
    private Image yeyOff;
    private String identificador;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        yey = new Image(getClass().getResource("/org/openjfx/poo/image/yey.png").toExternalForm());
        yeyOff = new Image(getClass().getResource("/org/openjfx/poo/image/yeyOff.png").toExternalForm());
        
        identificador = LoginControler.getIdentificadorGeral();
        mnName.setText(BuscaAlfandegario.buscaAlfandegarioBD(identificador).getNome());
        
        
        tfPassword.textProperty().bindBidirectional(pfPassword.textProperty());
        tfCheckPassword.textProperty().bindBidirectional(pfCheckPassword.textProperty());
    }    

    @FXML
    private void User(ActionEvent event) {
    }

    @FXML
    private void RequestImport(ActionEvent event) {
    }


    @FXML
    private void viewPending(ActionEvent event) {
        try{
            App.setRoot("FXAlfandegario");
        }catch (IOException erro) {
            System.out.println(erro);
            Alertas.mostrarAlerta("Erro carregar", "Erro ao carregar a tela de ADM.", Alert.AlertType.ERROR);
        }
    }


    @FXML
    private void btnRegisterAction(ActionEvent event) {
        Argon2 argon2 = Argon2Factory.create();
        List<TextInputControl> campos = List.of(tfName, tfID, tfSiape, pfCheckPassword, pfPassword);
        if(campos.stream().anyMatch(tf -> tf.getText().trim().isEmpty())){
            Alertas.mostrarAlerta("Erro campo vazio", "Todos os campos devem ser preenchidos.", Alert.AlertType.ERROR);
            return;
        }
        if(!pfCheckPassword.getText().equals(pfPassword.getText())){
            Alertas.mostrarAlerta("Erro senhas distintas", "As senhas digitadas são diferentes.", Alert.AlertType.ERROR);
            return;
        }
        if(tfID.getText().length() != 11){
            Alertas.mostrarAlerta("Erro CPF", "CPF inválido.", Alert.AlertType.ERROR);
            return;
        }
        if(tfSiape.getText().length() != 7){
            Alertas.mostrarAlerta("Erro Siape", "Siape inválido.", Alert.AlertType.ERROR);
            return;
        }
        Alfandegario alf = new Alfandegario(tfName.getText(),argon2.hash(2, 65536, 2, pfPassword.getText()),tfID.getText(),tfSiape.getText()); 
        InsereAlfandegario.insereAlfandegarioBD(alf);
        Alertas.mostrarAlerta("Confirma cadastro", "Cadastro feito com sucesso.", Alert.AlertType.CONFIRMATION);
        try{
            App.setRoot("FXAlfandegario");
        }catch (IOException erro) {
            System.out.println(erro);
            Alertas.mostrarAlerta("Erro carregar", "Erro ao carregar a tela de login.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void logout(ActionEvent event) {
        SalvaTelasSobressalentes.getInstance().fecharTodasJanelasExtras();
        try{
            App.setRoot("FXLogin");
        }catch (IOException erro) {
            System.out.println(erro);
            Alertas.mostrarAlerta("Erro carregar", "Erro ao carregar a tela de login.", Alert.AlertType.ERROR);
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
    
}
