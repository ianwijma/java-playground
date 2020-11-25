/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package listFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Arrays;

public class App {

    private String[] listFileNames ( FilenameFilter filter ) throws FileNotFoundException {
        String homeDir = System.getProperty("user.home");
        File f = new File( homeDir );
        if ( !f.exists() ) { throw new FileNotFoundException("Users home dir does not exists"); }

        File[] files = f.listFiles( filter );
        if ( files == null || files.length == 0 ) { throw new FileNotFoundException("No files found in the users home dir"); }

        String[] fileNames = new String[files.length];
        for ( int i = 0; i < fileNames.length; i++ ) {
            File file = files[i];
            String filename = file.getName();
            if ( file.isDirectory() ) filename += "/";
            fileNames[i] = filename;
        }

        return fileNames;
    }

    public String[] listNonDotFiles() throws FileNotFoundException {
        FilenameFilter filter = new DotFileNameFilter( false );
        return this.listFileNames( filter );
    }

    public String[] listDotFiles() throws FileNotFoundException {
        FilenameFilter filter = new DotFileNameFilter( true );
        return this.listFileNames( filter );
    }

    public static void main(String[] args) {
        try {
            App app = new App();

            System.out.println("List non dot files");
            String[] nonDotFiles = app.listNonDotFiles();
            System.out.println(Arrays.toString( nonDotFiles ) );
            System.out.println("\n");

            System.out.println("List dot files");
            String[] dotFiles = app.listDotFiles();
            System.out.println(Arrays.toString( dotFiles ) );
        } catch ( FileNotFoundException e ) {
            System.err.println( e.getMessage() );
        }
    }


    public static class DotFileNameFilter implements FilenameFilter {

        boolean showDotFiles;

        public DotFileNameFilter ( boolean showDotFiles ) {
            this.showDotFiles = showDotFiles;
        }

        @Override
        public boolean accept(File dir, String name) {
            return this.showDotFiles == name.startsWith(".");
        }
    }
}
