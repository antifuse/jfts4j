package eu.antifuse.jftsjava;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class Controller extends Application implements Initializable {
    @FXML
    public TextArea outArea;
    @FXML
    public TextField pathField;
    @FXML
    public Button bConvert,bBrowse, bSave;

    @FXML
    public Label errorLabel;

    public ResourceBundle strings;
    final FileChooser openChooser = new FileChooser();
    final FileChooser saveChooser = new FileChooser();
    public Converter convert = new Converter();
    public File file;
    public FXMLLoader loader;
    public Button bJFF;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Locale locale = Locale.getDefault();
        ResourceBundle resources = ResourceBundle.getBundle("strings", locale);
        loader = new FXMLLoader(Thread.currentThread().getContextClassLoader().getResource("convertergui.fxml"), resources);
        Parent root = loader.load();
        primaryStage.setTitle(resources.getString("ui.title"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    public void handleConvert() throws JAXBException, IOException {
        if (file == null) errorLabel.setVisible(true);
        else if (file.getName().substring(file.getName().lastIndexOf(".") + 1).equalsIgnoreCase("json"))
            outArea.setText(convert.flaciToTMS(file));
        else outArea.setText(convert.jflapToTMS(file));
    }

    @FXML
    public void handleBrowse() throws JAXBException, IOException {
        errorLabel.setVisible(false);
        openChooser.setTitle(strings.getString("chooser.openJFLAP"));
        openChooser.getExtensionFilters().setAll(new FileChooser.ExtensionFilter(strings.getString("chooser.formats.JFLAP"), "*.jff"), new FileChooser.ExtensionFilter(strings.getString("chooser.formats.XML"), "*.xml"),
                new FileChooser.ExtensionFilter(strings.getString("chooser.formats.FLACI"), "*.json"), new FileChooser.ExtensionFilter(strings.getString("chooser.formats.JSON"), "*.json"));
        file = openChooser.showOpenDialog(bBrowse.getScene().getWindow());
        if (file != null) {
            pathField.setText(file.getAbsolutePath());
            handleConvert();
        }
    }

    @FXML
    public void handleSave() throws IOException {
        saveChooser.setTitle(strings.getString("chooser.saveScript"));
        saveChooser.getExtensionFilters().setAll(new FileChooser.ExtensionFilter(strings.getString("chooser.formats.TXT"), "*.txt"));
        if (file != null) {
            saveChooser.setInitialDirectory(file.getParentFile());
            saveChooser.setInitialFileName(file.getName().split("\\.")[0]);
        }

        File toSave = saveChooser.showSaveDialog(bSave.getScene().getWindow());
        if (toSave == null) return;
        if (!toSave.createNewFile()) return;
        FileWriter write = new FileWriter(toSave);
        write.append(outArea.getText());
        write.close();
    }

    @FXML
    public void handleSaveFLACI() throws IOException {
        saveChooser.setTitle(strings.getString("chooser.saveFLACI"));
        saveChooser.getExtensionFilters().setAll(new FileChooser.ExtensionFilter(strings.getString("chooser.formats.FLACI"), "*.json"), new FileChooser.ExtensionFilter(strings.getString("chooser.formats.JSON"), "*.json"));
        if (file != null) {
            saveChooser.setInitialDirectory(file.getParentFile());
            saveChooser.setInitialFileName(file.getName().split("\\.")[0]);
        }

        File toSave = saveChooser.showSaveDialog(bSave.getScene().getWindow());
        if (toSave == null) return;
        convert.tmsToFlaci(outArea.getText(), toSave);
    }

    @FXML
    public void handleSaveJFF() throws JAXBException {
        saveChooser.setTitle(strings.getString("chooser.saveJFF"));
        saveChooser.getExtensionFilters().setAll(new FileChooser.ExtensionFilter(strings.getString("chooser.formats.JFLAP"), "*.jff"), new FileChooser.ExtensionFilter(strings.getString("chooser.formats.XML"), "*.xml"));
        if (file != null) {
            saveChooser.setInitialDirectory(file.getParentFile());
            saveChooser.setInitialFileName(file.getName().split("\\.")[0]);
        }

        File toSave = saveChooser.showSaveDialog(bSave.getScene().getWindow());
        if (toSave == null) return;
        convert.tmsToJflap(outArea.getText(), toSave);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.strings = resources;
    }
}
