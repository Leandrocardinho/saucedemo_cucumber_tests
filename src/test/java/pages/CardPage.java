package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CardPage extends CommonPage{

    //construtor
    public CardPage (WebDriver driver){
        super(driver); //chama o construtor da classe pai (CommonPage)
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#checkout")
    private WebElement btnCheckout;

    // Método para encontrar o elemento do produto pelo nome que vem da Feature
    public boolean verificarProdutoNoCarrinho(String nomeProduto){
        // Construção dinâmica do By para localizar o produto pelo nome
        By localizacaoProduto = By.xpath("//div[@class='inventory_item_name' and text()='" + nomeProduto + "']");
        // Verifica se o elemento está presente na página, e verifica a quantidade de elementos encontrados
        return driver.findElements(localizacaoProduto).size() > 0;
    }

    public void clicarBotaoCheckout(){
        btnCheckout.click();
    }
    
}