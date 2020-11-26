/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package writeToFile;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {

    private static ArrayList<String> getBaconIpsumSentences () throws FileNotFoundException {
        File fBaconFile = new File( "baconipsum.txt" );
        if ( !fBaconFile.exists() ) throw new FileNotFoundException( String.format("Resource not found \"%s\"", fBaconFile.getName())  );
        return extractFilesSentences(fBaconFile);
    }

    private static ArrayList<String> extractFilesSentences ( File fBaconFile ) throws FileNotFoundException {
        ArrayList<String> alBaconSentences = new ArrayList<>();

        Scanner sScanner = new Scanner(fBaconFile);
        while ( sScanner.hasNextLine() ) {
            String sRawLine = sScanner.nextLine();
            String sLine = sRawLine.trim();
            if ( !sLine.isEmpty() ) {
                String[] aSplit = sLine.split("\\.");
                Arrays.stream(aSplit).forEach(s -> alBaconSentences.add(s.trim() + ".\n"));
            }
        }

        sScanner.close();

        return alBaconSentences;
    }

    public static void main(String[] args) throws IOException {
        File fFile = new File( "baconSentences.txt" );
        fFile.createNewFile();

        FileWriter fwWriter = new FileWriter( fFile.getPath() );

        ArrayList<String> alBaconSentences = getBaconIpsumSentences();
        int size = alBaconSentences.size();
        for ( int i = 0; i < size; i++ ) {
            String sBaconSentence = alBaconSentences.get( i );
            String line = String.format("[%d/%d] %s", size, i+1, sBaconSentence);
            fwWriter.append( line );
        }
        fwWriter.close();

        System.out.println("DONE!");
    }
}
