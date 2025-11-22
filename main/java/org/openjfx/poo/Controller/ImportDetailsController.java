/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package org.openjfx.poo.Controller;

import org.openjfx.poo.Model.Service.FilterInt;
import org.openjfx.poo.Model.Service.FilterFloat;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import org.openjfx.poo.Model.Importacao;
import org.openjfx.poo.Model.Notificacoes;
import org.openjfx.poo.Model.Produtos;
import org.openjfx.poo.Model.Dao.BuscaImportacaoID;
import org.openjfx.poo.Model.Dao.BuscaNotificacaoMaisRecente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.openjfx.poo.Model.Dao.AlterarImportacao;
import org.openjfx.poo.Model.Dao.AlterarProduto;
import org.openjfx.poo.Model.Dao.ExcluiImportacao;
import org.openjfx.poo.View.Alertas;
import org.openjfx.poo.View.ViewQRCode;

/**
 * FXML Controller class
 *
 * @author valuc
 */
public class ImportDetailsController implements Initializable {

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
    private TextField tfProductRestricted;
    @FXML
    private TextField tfProductManufacturer;
    @FXML
    private TextField tfProdutcLength;
    @FXML
    private TextField tfProductLI;
    @FXML
    private TextArea taProductDescription;
    @FXML
    private TextArea taImportPendig;
    @FXML
    private Button btnPending;
    @FXML
    private Button btnDelet;
    @FXML
    private ToggleButton tbAlter;
    @FXML
    private TextField tfProductWidth;
    @FXML
    private TextField tfProductWiegth;
    @FXML
    private TextField tfProductAmount;
    @FXML
    private VBox vbPending;
    @FXML
    private Label rtPending;
    
    
        
    private Importacao importacao;
    private Consumer<Importacao> onUpdate;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setFilter();        
    }    


    @FXML
    private void btnPendingAction(ActionEvent event) {
        ViewQRCode qr = new ViewQRCode();
        qr.viewQrCode(10);
    }

    @FXML
    private void btnDeletAction(ActionEvent event) {
        if(Alertas.mostrarAlerta("Confirmar", "Deseja realmete exluir essa importação?", Alert.AlertType.CONFIRMATION)){
            ExcluiImportacao.ExcluiImportacaoBD(importacao);
            importacao.setSituacao("Excluído");
            AlterarImportacao.alteraImportacaoBD(importacao);
            if (onUpdate != null) {
                onUpdate.accept(importacao);
            }
            Alertas.mostrarAlerta("Excluição", "Importacao excluido com sucesso", Alert.AlertType.INFORMATION);
            Stage stage = (Stage)btnDelet.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void tbAlterAction(ActionEvent event) {
        if(tbAlter.isSelected()){
            removeStyleHidden();
            tbAlter.setText("Salvar");
        }else{
            addStyleHidden();
            tbAlter.setText("Editar");
            updateProducImport();
            Alertas.mostrarAlerta("Atualização", "Importacao atualizada com sucesso", Alert.AlertType.INFORMATION);
            if (onUpdate != null) {
                onUpdate.accept(importacao);
            }
        }
    }
    
    public void updateProducImport(){
        importacao = getForm(importacao);
        AlterarProduto.alteraProdutoBD(importacao.getProdutos());
    }

    public void setFilter(){
        tfProductWidth.setTextFormatter(new FilterFloat(2));
        tfProductHeight.setTextFormatter(new FilterFloat(2));
        tfProdutcLength.setTextFormatter(new FilterFloat(2));
        tfProductWiegth.setTextFormatter(new FilterFloat(2));
        tfProductAmount.setTextFormatter(new FilterInt());
    }

    public Importacao getForm(Importacao importacao){
        importacao.getProdutos().setNome(tfProductName.getText());
        importacao.getProdutos().setAltura(Float.parseFloat(tfProductHeight.getText()));
        importacao.getProdutos().setLargura(Float.parseFloat(tfProductWidth.getText()));
        importacao.getProdutos().setComprimento(Float.parseFloat(tfProdutcLength.getText()));
        importacao.getProdutos().setPeso(Float.parseFloat(tfProductWiegth.getText()));
        importacao.getProdutos().setFabricante(tfProductManufacturer.getText());
        importacao.getProdutos().setDescricao(taProductDescription.getText());
        importacao.getProdutos().setQuantidade((int)tfProductAmount.getTextFormatter().getValue());
        importacao.getProdutos().setLI(tfProductLI.getText());

        return importacao;
    }

    public void updateField(Importacao importacao) {
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
        tfProductWidth.setText(String.valueOf(importacao.getProdutos().getLargura()));
        tfProdutcLength.setText(String.valueOf(importacao.getProdutos().getComprimento()));
        tfProductWiegth.setText(String.valueOf(importacao.getProdutos().getPeso()));
        tfProductLI.setText(importacao.getProdutos().getLI());
        tfProductManufacturer.setText(importacao.getProdutos().getFabricante());
        tfProductRestricted.setText(importacao.getProdutos().getLI().isEmpty() ? "Não" : "Sim");
        tfProductAmount.setText(String.valueOf(importacao.getProdutos().getQuantidade()));
        taProductDescription.setText(importacao.getProdutos().getDescricao());
    }

    public void removeStyleHidden(){
        tfProductName.getStyleClass().remove("plain-content");
        tfProductHeight.getStyleClass().remove("plain-content");
        tfProductWidth.getStyleClass().remove("plain-content");
        tfProductManufacturer.getStyleClass().remove("plain-content");
        tfProdutcLength.getStyleClass().remove("plain-content");
        tfProductWiegth.getStyleClass().remove("plain-content");
        tfProductLI.getStyleClass().remove("plain-content");
        tfProductAmount.getStyleClass().remove("plain-content");
        taProductDescription.getStyleClass().remove("plain-content");
        
        tfProductName.setEditable(true);
        tfProductHeight.setEditable(true);
        tfProductWidth.setEditable(true);
        tfProductManufacturer.setEditable(true);
        tfProdutcLength.setEditable(true);
        tfProductWiegth.setEditable(true);
        tfProductLI.setEditable(true);
        tfProductAmount.setEditable(true);
        taProductDescription.setEditable(true);
    }

    public void addStyleHidden(){
        tfProductName.getStyleClass().add("plain-content");
        tfProductHeight.getStyleClass().add("plain-content");
        tfProductWidth.getStyleClass().add("plain-content");
        tfProductManufacturer.getStyleClass().add("plain-content");
        tfProdutcLength.getStyleClass().add("plain-content");
        tfProductWiegth.getStyleClass().add("plain-content");
        tfProductLI.getStyleClass().add("plain-content");
        tfProductAmount.getStyleClass().add("plain-content");
        taProductDescription.getStyleClass().add("plain-content");
        
        tfProductName.setEditable(false);
        tfProductHeight.setEditable(false);
        tfProductWidth.setEditable(false);
        tfProductManufacturer.setEditable(false);
        tfProdutcLength.setEditable(false);
        tfProductWiegth.setEditable(false);
        tfProductLI.setEditable(false);
        tfProductAmount.setEditable(false);
        taProductDescription.setEditable(false);
    }
    
    public void setImportacao(Importacao importacao){
        this.importacao = importacao;
        updateField(importacao);
        setUpdateButton();
        setPending();
    }
    
    public void setPending(){
        Notificacoes notify = BuscaNotificacaoMaisRecente.BuscaNotificacaoMaisRecenteBD(importacao.getNumero());

        if(notify != null && notify.isEstado() && !notify.isResolvido()){
            vbPending.setVisible(true);
            
            rtPending.setText(notify.getTipo());
            
            taImportPendig.setText(notify.getDescricao());
            taImportPendig.setVisible(true);

            if(notify.getTipo().equalsIgnoreCase("Pagamento")){
                btnPending.setText("Pagar");
                btnPending.setVisible(true);
            }
        }else{
            vbPending.setVisible(false);
            vbPending.setManaged(false);
        }
    }
    
    public void setUpdateButton(){
        long dateCriation = importacao.getCriacao().getTime();
        long dateToday = System.currentTimeMillis();
        long oneDayMillis = 24L * 60 * 60 * 1000; // 24h em ms

        if (dateToday - dateCriation >= oneDayMillis) {
            tbAlter.setVisible(false);
        } else {
            tbAlter.setVisible(true);
        }
    }
    
    public void setOnUpdate(Consumer<Importacao> onUpdate) {
        this.onUpdate = onUpdate;
    }
}



