/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package org.openjfx.poo.Controller;

import org.openjfx.poo.Model.Service.SalvaTelasSobressalentes;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.openjfx.poo.Model.Dao.BuscaImportacaoID;
import org.openjfx.poo.Model.Dao.BuscaNotificacao;
import org.openjfx.poo.Model.Dao.ExcluiImportacao;
import org.openjfx.poo.Model.Importacao;
import org.openjfx.poo.Model.Notificacoes;
import org.openjfx.poo.View.Alertas;
import org.openjfx.poo.Model.Dao.AlterarImportacao;
import org.openjfx.poo.Model.Dao.AlterarProduto;
import org.openjfx.poo.Model.Dao.InsereNotificacao;
import org.openjfx.poo.Model.Dao.BuscaNotificacaoMaisRecente;

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
    private Button btnDelet;
    @FXML
    private ComboBox<String> cbStatus;
    @FXML
    private StackPane stOutherStatus;
    @FXML
    private ToggleButton tbAlter;
    @FXML
    private TextField tfProductWidth;
    @FXML
    private TextField tfProductWiegth;
    @FXML
    private Button btnStatus;
    /**
     * Initializes the controller class.
     */
    
    private Importacao importacao;
    
    
    
    private TextField tfAmount;
    @FXML
    private TextField tfProductAmount;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setFilter();
        
        cbStatus.getItems().add("Requer ação");
        cbStatus.getItems().add("Pagamento pendente");
        cbStatus.getItems().add("Bloqueado");
        cbStatus.getItems().add("Confirmado");
    }    



    @FXML
    private void btnDeletAction(ActionEvent event) {
        if(Alertas.mostrarAlerta("Confirmar", "Deseja realmete exluir essa importação?", Alert.AlertType.CONFIRMATION)){
            ExcluiImportacao.ExcluiImportacaoBD(importacao);
            importacao.setSituacao("Excluído");
            AlterarImportacao.alteraImportacaoBD(importacao);
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
        importacao.getProdutos().setLI(tfProductLI.getText());
        importacao.getProdutos().setFabricante(tfProductManufacturer.getText());
        importacao.getProdutos().setDescricao(taProductDescription.getText());
        importacao.getProdutos().setQuantidade((int)tfProductAmount.getTextFormatter().getValue());

        return importacao;
    }
    
    public void updateField(Importacao importacao){
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

    public void setImportacao(Importacao importacao) {
        this.importacao = importacao;
        updateField(importacao);
        setUpdateButton();
        
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
        tfProductAmount.setEditable(true);
        tfProductManufacturer.setEditable(true);
        tfProdutcLength.setEditable(true);
        tfProductWiegth.setEditable(true);
        tfProductLI.setEditable(true);
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

    @FXML
    private void btnStatusAction(ActionEvent event) {
        if(cbStatus.getValue().equals("Selecione o status")){
            Alertas.mostrarAlerta("Erro atualiza status", "Selecione um status antes de atualiza-lo.", Alert.AlertType.ERROR);
        }else{
            importacao.setSituacao(cbStatus.getValue());
            AlterarImportacao.alteraImportacaoBD(importacao);
            //ImportadorController.removeImport.accept(importacao);
            SalvaTelasSobressalentes.getInstance().fecharTodasJanelasExtras();
        }
    }
    
    public void setUpdateButton(){
        long dateCriation = importacao.getCriacao().getTime();
        long dateToday = System.currentTimeMillis();
        long oneDayMillis = 24L * 60 * 60 * 1000; // 24h em ms

        if (dateToday - dateCriation >= oneDayMillis) {
            tbAlter.setVisible(true);
        } else {
            tbAlter.setVisible(false);
        }
    }

    ///////
    //////
    ///////
    //////
    ////
    ///////
    public void prototipoLancarNotificacao(){//trocar cbStatus pelo combo box novo e correto de notificacao
        if(cbStatus.getValue().equals("Selecione o tipo")){//corrigir para quanto tiver o combo box de tipo de notificacao
            Alertas.mostrarAlerta("Erro atualiza tipo", "Selecione um tipo de notificação antes envia-la.", Alert.AlertType.ERROR);
        }else if(taImportPendig.getText().isEmpty()){
            Alertas.mostrarAlerta("Erro atualiza descricao notiicao", "Faça uma breve descrição da notificação antes envia-la.", Alert.AlertType.ERROR);
        }else{
            InsereNotificacao.insereNotificacaoBD(taImportPendig.getText(), cbStatus.getValue(), importacao.getNumero());
            List<Notificacoes> lista = importacao.getNotificacoes();
            if (lista == null) {
                lista = new ArrayList<>();
            }
            lista.add(BuscaNotificacaoMaisRecente.BuscaNotificacaoMaisRecenteBD(importacao.getNumero()));
            importacao.setNotificacoes(lista);
            AlterarImportacao.alteraImportacaoBD(importacao);
        }
    }
}
