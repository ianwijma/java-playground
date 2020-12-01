
package bigFileReader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class App extends Application {

    public static void main(String[] args) {
        Application.launch( args );
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene( getEditor() );
        primaryStage.setTitle("BigFileReader");
        primaryStage.show();
    }

    private Scene getEditor() throws IOException {
        URL resourceUrl = getClass().getResource("/Editor.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader( resourceUrl );
        Parent root = fxmlLoader.load();
        return new Scene( root, 800, 600 );
    }

}
