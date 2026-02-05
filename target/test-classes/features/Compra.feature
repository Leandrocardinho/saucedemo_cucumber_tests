  # language: pt
  Funcionalidade: Compras no Saucedemo

    Esquema do Cenario: Realizar compra com sucesso
      Dado que estou na página de login "https://www.saucedemo.com/"
      Quando realizo login com o usuário "<usuario>" e senha "<senha>"
      E clico no botão de login
      Então visualizo a página de produtos
      Quando adiciono o produto "<produto>" ao carrinho
      E clico no ícone do carrinho de compras
      Então verifico que o produto "<produto>" está no carrinho
      Quando clico no botão de checkout
      Então verifico que estou na página de checkout your information
      Quando preencho as informações de checkout com nome "Fulano"
      E preencho o sobrenome "Silva"
      E preencho o código postal "12345"
      E clico no botão continuar
      Então visualizo a página checkout overview
      E verifico Payment Information "SauceCard #31337"
      Quando clico no botão finalizar     
      Entao visualizo a pagina checkout_complete
      E visualizo a mensagem de agradecimento "Thank you for your order!"  
              

      Exemplos:
        | usuario                 | senha        | produto                  |
        | standard_user           | secret_sauce | Sauce Labs Backpack      |
        | standard_user           | secret_sauce | Sauce Labs Bike Light    |
        | visual_user             | secret_sauce | Sauce Labs Bolt T-Shirt  |
        | performance_glitch_user | secret_sauce | Sauce Labs Fleece Jacket |  
      