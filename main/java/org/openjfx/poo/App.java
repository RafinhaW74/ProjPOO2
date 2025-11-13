package org.openjfx.poo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import org.openjfx.poo.Model.Dao.*;


import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import java.util.List;
import org.openjfx.poo.Model.*;
import org.openjfx.poo.Model.Dao.*;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("FXLogin"), 1300, 730);//FXLogin   FXImportDetails  
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
     

    public static void main(String[] args) {
        CriaTodasTabelas.CriaTodasTabelasBD();
        PopulaBDteste.populaBD();
        launch(args);
    }

}