package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOverview extends CommonPage  {
    //contrutor
    public CheckOverview (WebDriver driver){
        super(driver); //chama a classe pai
        PageFactory.initElements(driver, this);
    }

//elementos mapeados
    @FindBy(css= "#finish")
    private WebElement btnFinish;
    
    public void clicarBotaoFinish(){
    btnFinish.click();
    }
}
