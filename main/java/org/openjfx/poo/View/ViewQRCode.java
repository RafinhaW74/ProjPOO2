package org.openjfx.poo.View;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ViewQRCode {

    public void viewQrCode(float valor){
        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("Pagamento de Taxa");
        dialog.setHeaderText(null); // Remove o cabeçalho padrão

        Label tituloLabel = new Label("Pague a taxa de importação");
        tituloLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));


        //Label totalLabel = new Label("Total de:");
        //totalLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 14));

        //Label valorLabel = new Label(String.format("R$ %.2f", valor));
        //valorLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        //valorLabel.setStyle("-fx-text-fill: #008000;"); 

        ImageView qrCodeView = new ImageView();
        try {
            Image qrCodeImage = new Image(getClass().getResourceAsStream("/org/openjfx/poo/image/yey.png"));
            qrCodeView.setImage(qrCodeImage);
        } catch (Exception e) {

            Label placeholder = new Label(" [Local para o QR Code] ");
            placeholder.setStyle("-fx-border-color: lightgray; -fx-padding: 20; -fx-alignment: center;");
        }
        qrCodeView.setFitWidth(200);
        qrCodeView.setFitHeight(200);
        qrCodeView.setPreserveRatio(true);


        GridPane totalGrid = new GridPane();
        //totalGrid.add(totalLabel, 0, 0);
        //totalGrid.add(valorLabel, 1, 0);
        totalGrid.setHgap(5);
        totalGrid.setAlignment(Pos.CENTER);

        // Layout principal
        VBox content = new VBox(15); 
        content.setAlignment(Pos.CENTER);
        content.setPadding(new Insets(20));
        content.getChildren().addAll(
                tituloLabel,
                totalGrid,
                qrCodeView
        );

        // Define o conteúdo principal do diálogo
        dialog.getDialogPane().setContent(content);

        // Adiciona um botão de fechar/OK, que é comum em diálogos
        dialog.getDialogPane().getButtonTypes().add(javafx.scene.control.ButtonType.OK);

        // --- 5. Exibir o Diálogo ---
        dialog.showAndWait();
    }
}
