package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutYour extends CommonPage{
    public CheckoutYour(WebDriver driver){ 
        super (driver); //chama o construtor da classe pai (CommonPage)
        PageFactory.initElements(driver,this); //inicializa os elementos da página

    }

    //elementos mapeados

    @FindBy(css = ".title")
    private WebElement tituloCheckout;

    @FindBy(id = "first-name")
    private WebElement campoFirstName;

    @FindBy(css = "#last-name")
    private WebElement campoLastName;

    @FindBy(id = "postal-code")
    private WebElement campoPostalCode;

    @FindBy(id = "continue")
    private WebElement botaoContinue;  


public void verificarPaginaCheckoutYour(){
    tituloCheckout.isDisplayed();
    }   
       
public void preencherFirstName(String firstName){
    campoFirstName.sendKeys(firstName);
    }

public void preencherLastName (String lastName){
    campoLastName.sendKeys(lastName);
    }
    
public void preencherPostalCode (String postalCode){
    campoPostalCode.sendKeys(postalCode);       
    }    

public void clicarBotaoContinue(){
    botaoContinue.click();
    }

}