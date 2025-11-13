/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package org.openjfx.poo.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;
import org.openjfx.poo.Model.Dao.BuscaImportacaoID;
import org.openjfx.poo.Model.Dao.BuscaNotificacao;
import org.openjfx.poo.Model.Importacao;
import org.openjfx.poo.Model.Notificacoes;

/**
 * FXML Controller class
 *
 * @author valuc
 */
public class ImportActionController implements Initializable {

    @FXML
    private TextField tfImportNumber;
    @FXML
    private TextField tfImporterName;
    @FXML
    private TextField tfImportStatus;
    @FXML
    private TextField tfImporterID;
    @FXML
    private TextField tfProductName;
    @FXML
    private TextField tfProductHeight;
    @FXML
    private TextField tfProductwidth;
    @FXML
    private TextField tfProductRestricted;
    @FXML
    private TextField tfProductManufacturer;
    @FXML
    private TextField tfProdutcLength;
    @FXML
    private TextField tfProductwiegth;
    @FXML
    private TextField tfProductLI;
    @FXML
    private TextArea taProductDescription;
    @FXML
    private TextArea taImportPendig;
    @FXML
    private Button btnDelet;
    @FXML
    private ComboBox<?> cbStatus;
    @FXML
    private StackPane stOutherStatus;
    @FXML
    private TextField tfOutherStatus;
    @FXML
    private ToggleButton tbAlter;

    private Importacao importacao;
    private boolean pending;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setFilter();
        setFilter();
        importacao = BuscaImportacaoID.buscaImportacaoBD(1);

        
        setImportacao(importacao);
        
        

    }    



    @FXML
    private void btnDeletAction(ActionEvent event) {
    }
    
    public void setFilter(){
        tfProductwidth.setTextFormatter(Filter.getFloat(2));
        tfProductHeight.setTextFormatter(Filter.getFloat(2));
        tfProdutcLength.setTextFormatter(Filter.getFloat(2));
        tfProductwiegth.setTextFormatter(Filter.getFloat(2));
    }
    public Importacao getForm(Importacao importacao){
        importacao.getProdutos().setNome(tfProductName.getText());
        importacao.getProdutos().setAltura(Float.parseFloat(tfProductHeight.getText()));
        importacao.getProdutos().setLargura(Float.parseFloat(tfProductwidth.getText()));
        importacao.getProdutos().setComprimento(Float.parseFloat(tfProdutcLength.getText()));
        importacao.getProdutos().setPeso(Float.parseFloat(tfProductwiegth.getText()));
        importacao.getProdutos().setLI(tfProductLI.getText());
        importacao.getProdutos().setFabricante(tfProductManufacturer.getText());
        importacao.getProdutos().setEstado(tfProductRestricted.getText().equalsIgnoreCase("Ativo"));
        importacao.getProdutos().setDescricao(taProductDescription.getText());

        return importacao;
    }

    public void setImportacao(Importacao importacao) {
        if (importacao == null) return;

        // Campos principais da importação
        tfImportNumber.setText(String.valueOf(importacao.getNumero()));
        tfImportStatus.setText(importacao.getSituacao());

        // Importador (pessoa física/jurídica)
        if (importacao.getImportador() != null) {
            tfImporterName.setText(importacao.getImportador().getNome());
            tfImporterID.setText(String.valueOf(importacao.getImportador().getCPF())); 
        } else {
            tfImporterName.setText(importacao.getEmpresa().getNome());
            tfImporterID.setText(importacao.getEmpresa().getCNPJ());
        }

        tfProductName.setText(importacao.getProdutos().getNome());
        tfProductHeight.setText(String.valueOf(importacao.getProdutos().getAltura()));
        tfProductwidth.setText(String.valueOf(importacao.getProdutos().getLargura()));
        tfProdutcLength.setText(String.valueOf(importacao.getProdutos().getComprimento()));
        tfProductwiegth.setText(String.valueOf(importacao.getProdutos().getPeso()));
        tfProductLI.setText(importacao.getProdutos().getLI());
        tfProductManufacturer.setText(importacao.getProdutos().getFabricante());
        tfProductRestricted.setText(importacao.getProdutos().isEstado() ? "Ativo" : "Inativo");
        taProductDescription.setText(importacao.getProdutos().getDescricao());
    }

    public void removeStyleHidden(){
        tfImportNumber.getStyleClass().remove("plain-content");
        tfImporterName.getStyleClass().remove("plain-content");
        tfImportStatus.getStyleClass().remove("plain-content");
        tfImporterID.getStyleClass().remove("plain-content");
        tfProductName.getStyleClass().remove("plain-content");
        tfProductHeight.getStyleClass().remove("plain-content");
        tfProductwidth.getStyleClass().remove("plain-content");
        tfProductRestricted.getStyleClass().remove("plain-content");
        tfProductManufacturer.getStyleClass().remove("plain-content");
        tfProdutcLength.getStyleClass().remove("plain-content");
        tfProductwiegth.getStyleClass().remove("plain-content");
        tfProductLI.getStyleClass().remove("plain-content");
        taProductDescription.getStyleClass().remove("plain-content");
    }

    public void addStyleHidden(){
        tfImportNumber.getStyleClass().add("plain-content");
        tfImporterName.getStyleClass().add("plain-content");
        tfImportStatus.getStyleClass().add("plain-content");
        tfImporterID.getStyleClass().add("plain-content");
        tfProductName.getStyleClass().add("plain-content");
        tfProductHeight.getStyleClass().add("plain-content");
        tfProductwidth.getStyleClass().add("plain-content");
        tfProductRestricted.getStyleClass().add("plain-content");
        tfProductManufacturer.getStyleClass().add("plain-content");
        tfProdutcLength.getStyleClass().add("plain-content");
        tfProductwiegth.getStyleClass().add("plain-content");
        tfProductLI.getStyleClass().add("plain-content");
        taProductDescription.getStyleClass().add("plain-content");
    }

    @FXML
    private void tbAlterAction(ActionEvent event) {
    }
}
