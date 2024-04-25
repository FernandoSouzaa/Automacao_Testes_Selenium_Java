package org.nando.automacao.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public void validandoClickRadioButton(String idCampo){
        Assert.assertTrue(driver.findElement(By.id(idCampo)).isSelected());
    }

    public void validandoTextoCampo(String idCampo, String valueEsperado){
        Assert.assertEquals(valueEsperado, driver.findElement(By.id(idCampo)).getAttribute("value"));
    }

}
