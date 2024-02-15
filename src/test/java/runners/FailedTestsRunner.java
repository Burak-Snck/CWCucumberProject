package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "pretty",//Scenario steplerini konsola renkli yazdırır
                "html:target/reports/html-reports/default-cucumber-reports.html",//html formatında rapor için
                "rerun:target/failedScenarios.txt"//Fail olan scenarioların kaydını alır ve sadece bu testlerin koşulmasına yardımcı olur.
        },
        features = "@target/failedScenarios.txt",//Fail olan scenarioların tutulduğu text dosyasının yolu
        glue = "stepdefinitions"

)
public class FailedTestsRunner {
}
