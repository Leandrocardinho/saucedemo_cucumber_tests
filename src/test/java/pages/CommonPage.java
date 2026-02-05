package pages;

import org.openqa.selenium.WebDriver;

public class CommonPage {
       public WebDriver driver; // Obj do Selenium WebDriver (bola "controlar quando recebe o passe")

    //Construtor conecta o externo com o interno
    public CommonPage(WebDriver driver) {
        this.driver = driver;
        
    }
    
}
