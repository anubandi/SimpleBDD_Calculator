package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        String env = ConfigReader.getProperty("env");
        String appName = ConfigReader.getProperty("app.name");

        String msg = "[" + env + "] " + appName + " | Starting: " + scenario.getName();
        System.out.println(msg); // Prints in IntelliJ Console
        scenario.log(msg);       // Prints inside cucumber-reports.html
    }

    @After
    public void tearDown(Scenario scenario) {
        String msg = "Finished: " + scenario.getName() + " | Status: " + scenario.getStatus();
        System.out.println(msg);
        scenario.log(msg);
    }


    @Before("@negative")
    public void beforeNegativeTests() {
        System.out.println(">> Running a NEGATIVE test case <<");
    }

}
