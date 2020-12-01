
package bigFileReader;

import bigFileReader.Utilities.FileLineReader;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class App extends Application {

    private static FileLineReader reader;

    public static void main(String[] args) throws IOException {
        Path path = Paths.get( "../../03-writeToFile/.tmp/baconSentences.txt" );
        reader = new FileLineReader( path );

        Application.launch( args );
    }

    @Override
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        String[] lines = reader.getAll();
        textArea.setText( String.join("\n", lines) );


        Group group = new Group(textArea);
        Scene scene = new Scene(group, 500, 150, Color.WHITE);
        primaryStage.setScene( scene );

        primaryStage.setTitle("BigFileReader");
        primaryStage.show();
    }
}
