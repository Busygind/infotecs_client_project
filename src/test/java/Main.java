import org.testng.TestNG;
import org.testng.collections.Lists;

import java.util.List;

/**
 * Class to init test-suite
 */
public class Main {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        String suiteFileName = args[0];

        List<String> suites = Lists.newArrayList();
        suites.add(suiteFileName);

        // for local testing
        // suites.add("src/test/resources/testng.xml");

        testNG.setTestSuites(suites);
        testNG.run();
    }
}
