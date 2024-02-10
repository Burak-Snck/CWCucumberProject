package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    //Her scenario yada özel tag öncesi yada sonrası çalışan methodların bulunduğu class
    //@Before("@Positive") yanına girilen özel tag ile yalnızca bu scenariolar için çalıştırılabilir.
    //@Before şeklinde tek kullanıldığında tüm scenariolar öncesi çalışır.

    @Before//("@Positive")// --> import io.cucumber.java.Before; !!!!!!!!!!
    public void setUp(Scenario scenario){
        System.out.println("Hooks Class @Before Methodu");
        System.out.println("Scenario ID: "+scenario.getId());
        System.out.println("Scenario Name: "+scenario.getName());
    }

    @After//import io.cucumber.java.After;
    public void tearDown(){
        System.out.println("Hooks Class @After Methodu");
    }


}