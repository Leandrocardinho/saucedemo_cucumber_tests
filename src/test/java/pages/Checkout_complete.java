package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout_complete extends CommonPage{
    //contrutor 
    public Checkout_complete (WebDriver driver){
        super(driver); //puxa o driver da CommonPage
        PageFactory.initElements(driver, this); 
    }

    @FindBy(css=".complete-header")
    private WebElement mensagemAgradecimento; //mapea via css 


    public String obterMensagemAgradecimento(){
        return mensagemAgradecimento.getText(); //Pega a msgSucesso dentro do css

    }   
}
