package inheritancetest;

import inheritance.LineCounter;
import inheritance.StringMatchesCounter;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class InheritanceTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("\nInheritance Tests:");
    }

    @Before
    public void before() {
        System.out.println();
    }

    @Test
    public void testLineCounter() {
        LineCounter lineCounter = new LineCounter();
        lineCounter.processFile("testData/SampleFile.txt");

        System.out.println(lineCounter.printInfo());
    }

    @Test
    public void testStringMatchesCounter() {
        StringMatchesCounter matchesCounter = new StringMatchesCounter("^l.*");
        matchesCounter.processFile("testData/SampleFile.txt");

        System.out.println(matchesCounter.printInfo());
    }
}