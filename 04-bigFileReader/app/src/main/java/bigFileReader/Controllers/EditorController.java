package bigFileReader.Controllers;

import bigFileReader.Utilities.FileLineReader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class EditorController implements Initializable {

    private static FileLineReader reader;

    @FXML
    private TextArea textArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Path path = Paths.get( "../../03-writeToFile/.tmp/baconSentences.txt" );
            reader = new FileLineReader( path );
            textArea.onScrollFinishedProperty();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
