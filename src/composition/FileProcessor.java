package composition;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {

    private FileProcessorDependency fileProcessorDependency;

    public FileProcessor(FileProcessorDependency fileProcessorDependency) {
        this.fileProcessorDependency = fileProcessorDependency;
    }

    public void processFile(String filename) {

        BufferedReader bufferedReader = null;

        try {
            fileProcessorDependency.beginFile(filename);

            bufferedReader = new BufferedReader(new FileReader(filename));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileProcessorDependency.beginLine(line);
            }
            fileProcessorDependency.endFile();
            bufferedReader.close();
        }
        catch (IOException e){
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public String printInfo() {
        return fileProcessorDependency.printInfo();
    }
}
