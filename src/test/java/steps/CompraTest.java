package steps;

import static org.junit.jupiter.api.Assertions.assertEquals;



import org.openqa.selenium.WebDriver;


import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import pages.Base;
import pages.CardPage;
import pages.CheckOverview;
import pages.CheckoutYour;
import pages.Checkout_complete;
import pages.LoginPage;
import pages.ProdutosPage;

public class CompraTest {
    final WebDriver driver; // Recebe o "passe" da Base e garante que usaremos o mesmo navegador até o fim
    private LoginPage loginPage; //Só para eu usar os métodos da página de login

    public CompraTest(Base base) {
        this.driver = base.driver; // Recebe o "passe" da Base e garante que usaremos o mesmo navegador até o fim   
   
        
}

    //metodos de interação
    @Dado("que estou na página de login {string}")
        public void que_acesso_a_página(String url){
        loginPage = new LoginPage(driver);
        loginPage.acessarPaginaLogin(url);
    }

    @Quando("realizo login com o usuário {string} e senha {string}")
        public void realizo_login_com_o_usuário_e_senha(String usuario, String senha) {
            loginPage.preencherUsuario(usuario);
            loginPage.preencherSenha(senha);
        }
    @Quando("clico no botão de login")
        public void clico_no_botão_de_login() {
            loginPage.clicarBotaoLogin();
        } 
    @Entao("visualizo a página de produtos") //inicio da ProdutosPage
        public void visualizo_a_página_de_produtos() {
         try { Thread.sleep(3000); } catch (InterruptedException e) {}
    
        // Agora sim ele checa se "chegou" na página de produtos
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
            }

   @Quando("adiciono o produto {string} ao carrinho")
    public void adiciono_o_produto_ao_carrinho(String produto) {
        ProdutosPage produtosPage = new ProdutosPage(driver);
        produtosPage.adicionarProduto(produto);
    }

    @Quando("clico no ícone do carrinho de compras")
        public void clico_no_ícone_do_carrinho_de_compras() {
            ProdutosPage produtosPage = new ProdutosPage(driver);
            produtosPage.clicarIconeCarrinho();
    }
  
     @Entao("verifico que o produto {string} está no carrinho")
        public void verifico_que_o_produto_está_presente_no_carrinho(String produto) {
            // validar a URL do carrinho
            assertEquals("https://www.saucedemo.com/cart.html", driver.getCurrentUrl());
            // 2. Agora captura o texto do produto que aparece no site
            String produtoNaTela = driver.findElement(org.openqa.selenium.By.className("inventory_item_name")).getText();
            // 3. Compara se o nome da mochila (ou outro produto) é o mesmo que veio da Feature
            assertEquals(produto, produtoNaTela);

        }      

     @Quando("clico no botão de checkout")
        public void clico_no_botão_de_checkout() {
            CardPage cardPage = new CardPage(driver);
            cardPage.clicarBotaoCheckout();
     }

    @Entao("verifico que estou na página de checkout your information")    
        public void verifico_que_estou_na_página_de_checkout_your_information() {
         assertEquals("https://www.saucedemo.com/checkout-step-one.html", driver.getCurrentUrl());
}
    @Quando("preencho as informações de checkout com nome {string}")
        public void preencho_as_informações_de_checkout_com_nome_sobrenome_e_código_postal(String firstName) {
            CheckoutYour checkoutYour = new CheckoutYour(driver);
            checkoutYour.preencherFirstName(firstName);        
        }
    @Quando("preencho o sobrenome {string}")
        public void preencho_o_sobrenome(String lastName) {
            CheckoutYour checkoutYour = new CheckoutYour(driver);
            checkoutYour.preencherLastName(lastName);        
        }

    @Quando("preencho o código postal {string}")
        public void preencho_o_código_postal(String postalCode) {
            CheckoutYour checkoutYour = new CheckoutYour(driver);
            checkoutYour.preencherPostalCode(postalCode);        
        }
    
    @Entao("clico no botão continuar")
        public void clico_no_botão_continuar() {
            CheckoutYour checkoutYour = new CheckoutYour(driver);
            checkoutYour.clicarBotaoContinue();

        }   

    @Entao("visualizo a página checkout overview")
    public void visualizo_a_página_checkout_overview() {
        assertEquals("https://www.saucedemo.com/checkout-step-two.html", driver.getCurrentUrl());
    }

    @Entao("verifico Payment Information {string}")
    public void verifico_payment_information(String pagamentoEsperado) {
        //usando o findElements, assim vai pegar uma lista, depois pegando o itens 0
        String pagamentoNaTela = driver.findElements(org.openqa.selenium.By.className("summary_value_label")).get(0).getText();
        
        //  Assert compara os texto exato
        assertEquals(pagamentoEsperado, pagamentoNaTela);
    }

    @Quando("clico no botão finalizar")
        public void clico_no_botão_finalizar(){
            CheckOverview checkOverview = new CheckOverview(driver);
            checkOverview.clicarBotaoFinish();

        }
    @Entao ("visualizo a pagina checkout_complete")
        public void  visualizo_a_pagina_checkout_complete(){
           //Valida a url
           assertEquals("https://www.saucedemo.com/checkout-complete.html", driver.getCurrentUrl());
        }
      
    @Entao ("visualizo a mensagem de agradecimento {string}")
        public void visualizo_a_mensagem_de_agradecimento(String mensagemEsperada){
            Checkout_complete checkout_complete = new Checkout_complete(driver);
            String mensagemNaTela = checkout_complete.obterMensagemAgradecimento(); 
        
        //Valida
        assertEquals(mensagemEsperada, mensagemNaTela);

        }
         
}