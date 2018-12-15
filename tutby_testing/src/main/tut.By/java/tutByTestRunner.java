import org.testng.TestNG;

import java.util.Arrays;
import java.util.List;

public class tutByTestRunner {

        public static void main(String[] args)
        {
            TestNG testNG = new TestNG();
            List<String> files = Arrays.asList("./src/main/resources/tutBy.xml");
            testNG.setTestSuites(files);
            testNG.run();
        }
    }

