package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DescontosStep {

    WebDriver driver = new ChromeDriver();
    @Dado("^que estou no site da qazando$")
    public void acessar_site_qazando() {
        driver.get("https://www.qazando.com.br/curso.html");
    }

    @Quando("^eu preencho meu email$")
    public void eu_preencho_meu_e_mail() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, 10000)");
        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("douglasbuss@hotmail.com");
    }

    @Quando("^clico em ganhar cupom$")
    public void clico_em_ganhar_cupom() {
         driver.findElement(By.id("button")).click();
    }

    @Entao("^eu vejo codigo de desconto$")
    public void eu_vejo_codigo_de_desconto() {
        String texto_cupom = driver.findElement(By.cssSelector("#cupom > h2 > span")).getText();
        System.out.println(texto_cupom);

        driver.quit();
    }


}
