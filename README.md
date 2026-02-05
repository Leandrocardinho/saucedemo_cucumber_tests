# 🛒 Saucedemo Cucumber Tests

Projeto de automação de testes de interface utilizando **Java**, **Selenium WebDriver**, **Cucumber** e o padrão **Page Object Model (POM)**.  
O alvo dos testes é o site [Saucedemo](https://www.saucedemo.com), que simula um e-commerce para práticas de automação.

---

## 🔧 Tecnologias e práticas utilizadas

- **Java 11+**
- **Selenium WebDriver** para automação de browser
- **Cucumber** para escrita de cenários em Gherkin
- **JUnit 5** para execução e validações
- **Maven** para gerenciamento de dependências e execução
- **Page Object Model (POM)** para organização e reuso de código
- **Assertions (`assertEquals`, `assertTrue`)** para validação de URLs, textos e mensagens
- **Scenario Outline + Examples** para parametrização de testes
- **Validações de fluxo completo** (login, carrinho, checkout, mensagem final)

---

## 📥 Como baixar o projeto

No terminal, execute:

```bash
git clone https://github.com/Leandrocardinho/saucedemo_cucumber_tests.git
cd saucedemo_cucumber_tests


🚀 Como executar os testes via Terminal bash
No terminal, dentro da pasta do projeto, execute:
mvn clean test -Dtest=steps.RunnerTest




Validações de fluxo completo (login, carrinho, checkout, mensagem final)
