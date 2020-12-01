package bigFileReader.Utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileLineReader {

    private final List<String> fileLines;
    private final int fileLineAmount;

    public int getLineAmount () {
        return this.fileLineAmount;
    }

    public FileLineReader( Path path ) throws IOException {
        if (!Files.exists( path ))
            throw new FileNotFoundException(String.format("File not found: %s", path.toAbsolutePath().toString()));

        fileLines = Files.readAllLines( path );
        this.fileLineAmount = fileLines.size();
    }

    public String getLine ( int lineNr ) {
        if ( lineNr > this.fileLineAmount || lineNr < 0 )
            throw new IndexOutOfBoundsException(String.format("Line number \"%d\" not found", lineNr));

        return fileLines.get( lineNr );
    }

    public String[] getLines ( int lineNr, int lineAmount ) {
        // Check starting line number
        if ( lineNr > this.fileLineAmount || lineNr < 0 )
            throw new IndexOutOfBoundsException(String.format("Line number \"%d\" not found", lineNr));


        int maxLineNr = lineNr + lineAmount;
        if ( maxLineNr > this.fileLineAmount)
            throw new IndexOutOfBoundsException(String.format("Line number \"%d\" not found", maxLineNr));

        String[] lines = new String[lineAmount];
        for ( int i = 0; i < lineAmount; i++ ) {
            lines[i] = this.fileLines.get(i);
        }

        return lines;
    }

    public String[] getAll () {
        String[] lines = new String[this.fileLineAmount];

        for ( int i = 0; i < this.fileLineAmount; i++ ) {
            lines[i] = this.fileLines.get(i);
        }

        return lines;
    }

}
