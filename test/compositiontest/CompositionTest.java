package compositiontest;

import composition.FileProcessor;
import composition.LineCounter;
import composition.StringMatchesCounter;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CompositionTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("\nComposition Tests:");
    }

    @Before
    public void before() {
        System.out.println("\n");
    }

    @Test
    public void testLineCounter() {
        LineCounter lineCounter = new LineCounter();

        FileProcessor fileProcessor = new FileProcessor(lineCounter);
        fileProcessor.processFile("testData/SampleFile.txt");

        System.out.println(fileProcessor.printInfo());
    }

    @Test
    public void testStringMatchesCounter() {
        StringMatchesCounter matchesCounter = new StringMatchesCounter("^l.*");
        FileProcessor fileProcessor = new FileProcessor(matchesCounter);

        fileProcessor.processFile("testData/SampleFile.txt");

        System.out.println(fileProcessor.printInfo());
    }
}