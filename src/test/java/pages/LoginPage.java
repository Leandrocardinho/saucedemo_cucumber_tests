package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonPage {

    //contrutor
    public LoginPage(WebDriver driver){
        super(driver); //puxa o driver da CommonPage
        PageFactory.initElements(driver, this); //inicializa os elementos da página
    }

    //elementos mapeados da página de login 
    @FindBy(id = "user-name")
    private WebElement campoUsuario;

    @FindBy(id = "password") 
    private WebElement campoSenha;

    @FindBy(id = "login-button")
    private WebElement botaoLogin;


    //métodos de interação da página de login
    public void acessarPaginaLogin(String url){
        driver.get(url);  
    }   

    public void preencherUsuario(String usuario){
        campoUsuario.sendKeys(usuario);
    }

    public void preencherSenha(String senha){
        campoSenha.sendKeys(senha);
    }

    public void clicarBotaoLogin(){
        botaoLogin.click();
    }

   
}
