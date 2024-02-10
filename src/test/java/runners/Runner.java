package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",//Feature dosyalarının yolu buraya belirtilmelidir
        glue = "stepdefinitions",//Çalıştırılacak Java classlarının yolu buraya belirtilmelidir
        tags = " @MultiParametersScenarioOutline",//Özel olarak çalıştırılacak Scenario yada Feature Tag'i buraya belirtilir
        dryRun = false//dryRun = true --> Testi çalıştırmaz, eksik step definitionları tespit eder.
)
public class Runner {

}