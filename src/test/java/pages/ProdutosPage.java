package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProdutosPage extends CommonPage {

    public ProdutosPage(WebDriver driver) { 
        super(driver); 
        PageFactory.initElements(driver, this); 

    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement btnAddtoCard;

    @FindBy(className = "shopping_cart_link")
    private WebElement iconeCarrinho;

    
    public By bylocal(String nomeProduto) {
        return By.xpath("//div[text()='" + nomeProduto + "']/ancestor::div[@class='inventory_item_description']//button"); 
    }

    // Ações da página
    public void adicionarProduto(String nomeProduto) {
        
        driver.findElement(bylocal(nomeProduto)).click();
    }

    public void clicarIconeCarrinho() {
        iconeCarrinho.click();
    }
}