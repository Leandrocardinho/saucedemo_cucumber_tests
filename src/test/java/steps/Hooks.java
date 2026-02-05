package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Base;

public class Hooks {
    Base base; // Para ter acesso ao driver compartilhado

    // Construtor que recebe a instância da classe Base
    public Hooks(Base base) {
        this.base = base;
    }   

    @Before 
    public void setUp() {
        // aqui posso colocar código de configuração antes de cada cenário
        WebDriverManager.chromedriver().setup();
        base.driver = new ChromeDriver(); 
        base.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50000)); // espera implícita de 30 segundos
        base.driver.manage().window().maximize();

                ChromeOptions options = new ChromeOptions();
    options.addArguments("--guest"); // Abre como convidado (resolve 100% o pop-up de senha)
    options.addArguments("--start-maximized");

    base.driver = new ChromeDriver(options);
    }

    @After
     public void finalizar(){
        base.driver.quit();
     }

}