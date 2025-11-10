/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package org.openjfx.poo.Controller;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.net.URL;
import org.openjfx.poo.Model.*;
import org.openjfx.poo.Model.Dao.*;
import org.openjfx.poo.View.Alertas;
import javafx.scene.control.Alert.AlertType;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
/**
 * FXML Controller class
 *
 * @author valuc
 */
public class LoginControler implements Initializable {

    @FXML
    private Label rtTitle;
    @FXML
    private RadioButton rbUser;
    @FXML
    private ToggleGroup userType;
    @FXML
    private RadioButton rbAdmin;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private TextField tfIdentificator;
    @FXML
    private Button btnSubmit;
    @FXML
    private Button btnRegister;
        /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    


    private void viewimport(ActionEvent event) {

    }

    private void viewPending(ActionEvent event) {

    }

    private void user(ActionEvent event) {

    }

    @FXML
    private void login(ActionEvent event) {
        String identificador = tfIdentificator.getText();
        String senha = tfPassword.getText();
        
        if (identificador.isEmpty() || senha.isEmpty()) {
            Alertas.mostrarAlerta("Erro de Login", "Os campos não podem estar vazios.", AlertType.ERROR);
            return;
        }
        
        Argon2 argon2 = Argon2Factory.create();
        if (rbUser.isSelected()) {
            if(identificador.length() > 11){
                Empresa_importadora empresa = BuscaEmpresa.buscaEmpresa_importadoraBD(identificador);
                if(empresa == null){
                    Alertas.mostrarAlerta("Erro de Login", "Empresa não encontrada.", AlertType.WARNING);
                    return;
                }
                if(argon2.verify(empresa.getSenha(), senha)){
                    //trocar para tela do alfandegario
                }else{
                    Alertas.mostrarAlerta("Erro de Login", "Senha incorreta.", AlertType.ERROR);
                }
            }else{
                Pessoa_importadora pessoa = BuscaPessoa_importadora.buscaPessoa_importadoraBD(identificador);
                if(pessoa == null){
                    Alertas.mostrarAlerta("Erro de Login", "Usuário não encontrado.", AlertType.WARNING);
                    return;
                }
                if(argon2.verify(pessoa.getSenha(), senha)){
                    //trocar para tela do alfandegario
                }else{
                    Alertas.mostrarAlerta("Erro de Login", "Senha incorreta.", AlertType.ERROR);
                }
            }
        } else if (rbAdmin.isSelected()) {
            Alfandegario alfandegario = BuscaAlfandegario.buscaAlfandegarioBD(identificador);
            if(alfandegario == null){
                Alertas.mostrarAlerta("Erro de Login", "Administrador não encontrado.", AlertType.WARNING);
                return;
            }
            if(argon2.verify(alfandegario.getSenha(), senha)){
                //trocar para tela do alfandegario
            }else{
                Alertas.mostrarAlerta("Erro de Login", "Senha incorreta.", AlertType.ERROR);
            }
        }

    }

    @FXML
    private void register(ActionEvent event) {
    }
    
}
