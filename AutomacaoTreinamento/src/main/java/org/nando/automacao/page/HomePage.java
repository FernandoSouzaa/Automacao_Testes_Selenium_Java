package org.nando.automacao.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.Console;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void editTextCampo(String nome){
        driver.findElement(By.id("elementosForm:nome")).sendKeys(nome);
    }

    public void textArea(String descricao){
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys(descricao);
    }

    public void radioButton(){
        driver.findElement(By.id("elementosForm:sexo:0")).click();
    }

    public void checkBox(){
        int cont = 0;
        for (int i=0; cont <= 7; i++){
            WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
            Select combo = new Select(element);
            //combo.selectByIndex(cont);
            //combo.selectByValue("Superior");
            combo.selectByVisibleText("2o grau incompleto");
            Assert.assertEquals("2o grau incompleto", combo.getFirstSelectedOption().getText());
            cont++;
        }
    }

    public void validandoClickRadioButton(String idCampo){
        Assert.assertTrue(driver.findElement(By.id(idCampo)).isSelected());
    }

    public void validandoTextoCampo(String idCampo, String valueEsperado){
        Assert.assertEquals(valueEsperado, driver.findElement(By.id(idCampo)).getAttribute("value"));
    }

}
