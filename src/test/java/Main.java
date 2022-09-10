import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        ArrayList<String> suitesList = new ArrayList<>();
        suitesList.add("src/test/java/suites/system_test_suite.xml");
        XmlSuite suite = new XmlSuite();
        suite.setSuiteFiles(suitesList);
        ArrayList<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);
        testNG.setXmlSuites(suites);
        testNG.run();
    }
}
