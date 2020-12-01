package bigFileReader;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;

public class Editor {

    private final Scene scene;

    public Editor() throws IOException {
        URL resourceUrl = getClass().getResource("/Editor.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader( resourceUrl );
        Parent root = fxmlLoader.load();
        this.scene = new Scene( root, 800, 600 );
    }

    public Scene getScene() {
        return scene;
    }

}
