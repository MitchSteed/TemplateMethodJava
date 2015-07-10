package inheritance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class FileSkeleton {


    public void processFile(String filename) {

        BufferedReader bufferedReader = null;

        try {
            beginFile(filename);

            bufferedReader = new BufferedReader(new FileReader(filename));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                beginLine(line);
            }
            endFile();
            bufferedReader.close();
        }
        catch (IOException e){
            System.out.println("Exception: " + e.getMessage());
        }
    }

    protected abstract void beginFile(String filename);

    protected abstract void beginLine(String line);

    protected abstract void endFile();

    public abstract String printInfo();
}
