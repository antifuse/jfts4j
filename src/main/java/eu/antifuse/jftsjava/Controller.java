package eu.antifuse.jftsjava;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

public class Controller extends Application {
    @FXML
    public TextArea outArea;
    @FXML
    public TextField pathField;
    @FXML
    public Button bConvert,bBrowse, bSave;

    @FXML
    public Label errorLabel;

    final FileChooser openChooser = new FileChooser();
    final FileChooser saveChooser = new FileChooser();
    public Converter convert = new Converter();
    public File file;
    public FXMLLoader loader;

    @Override
    public void start(Stage primaryStage) throws Exception {
        loader = new FXMLLoader(Thread.currentThread().getContextClassLoader().getResource("convertergui.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("JFTS Converter");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    public void handleConvert(ActionEvent e) throws JAXBException {
        if (file == null) errorLabel.setVisible(true);
        else outArea.setText(convert.convertFile(file));
    }

    @FXML
    public void handleBrowse(ActionEvent e) throws URISyntaxException, JAXBException {
        errorLabel.setVisible(false);
        openChooser.setTitle("JFLAP-Datei öffnen");
        openChooser.getExtensionFilters().setAll(new FileChooser.ExtensionFilter("JFLAP File", "*.jff"),new FileChooser.ExtensionFilter("XML File", "*.xml"));
        openChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("JFLAP File", "*.jff"));;
        file = openChooser.showOpenDialog(bBrowse.getScene().getWindow());
        if (file != null) {
            pathField.setText(file.getAbsolutePath());
        }
    }

    @FXML
    public void handleSave(ActionEvent e) throws IOException, URISyntaxException {
        saveChooser.setTitle("Skript speichern");
        saveChooser.getExtensionFilters().setAll(new FileChooser.ExtensionFilter("Text File", "*.txt"));
        if (file != null) {
            saveChooser.setInitialDirectory(file.getParentFile());
            saveChooser.setInitialFileName(file.getName().split("\\.")[0]);
        }

        File toSave = saveChooser.showSaveDialog(bSave.getScene().getWindow());
        if (toSave == null) return;
        toSave.createNewFile();
        FileWriter write = new FileWriter(toSave);
        write.append(outArea.getText());
        write.close();
    }

    @FXML
    public void handleSaveJFF(ActionEvent e) throws IOException, JAXBException {
        saveChooser.setTitle("Als JFF speichern");
        saveChooser.getExtensionFilters().setAll(new FileChooser.ExtensionFilter("JFLAP File", "*.jff"), new FileChooser.ExtensionFilter("XML File", "*.xml"));
        if (file != null) {
            saveChooser.setInitialDirectory(file.getParentFile());
            saveChooser.setInitialFileName(file.getName().split("\\.")[0]);
        }

        File toSave = saveChooser.showSaveDialog(bSave.getScene().getWindow());
        if (toSave == null) return;
        convert.convertScript(outArea.getText(), toSave);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        System.exit(0);
    }
}
