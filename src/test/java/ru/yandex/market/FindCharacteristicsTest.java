package ru.yandex.market;

import com.codeborne.selenide.Selenide;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

/*
 * Created by A on 22.03.2020 22:36
 */

public class FindCharacteristicsTest {

    @Test
    public void FindCharacteristicsTest() {
        System.setProperty("webdriver.chrome.driver", "T:\\Java\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        // Open Yandex Market
        driver.get("https://market.yandex.ru/");

        // Check whether Yandex Market is opened
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов"));

        // Open 'Электроника' type of goods page
        driver.findElementByLinkText("Электроника").click();

        // Open 'Мобильные телефоны' type of goods page
        driver.findElementByLinkText("Мобильные телефоны").click();

        // Choose Xiaomi checkbox
        WebElement element = driver.findElement(By.id("7893318_7701962"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();

        WebElement checkbox1 = driver.findElement(By.id("7893318_7701962"));
        if (!checkbox1.isSelected()) {
            System.out.println("Toggled off. Toggling on...");
            checkbox1.click();
            //System.out.println("Toggled on.");
        }

        // Find and click on PHONE link
        String phone = "Смартфон " + TestData.PHONE;
        driver.findElementByLinkText(phone).click();

        // Trying different ways to check whether opened page contains 'Характеристики' tab

        //String Characteristics1 = driver.findElementByLinkText("Характеристики").getText();
        //String Characteristics1 = driver.findElementByClassName("n-product-tabs__name"). // >Характеристики</span>) .findElementByLinkText("Характеристики").getText();
        //String Characteristics1 = driver.findElementByClassName("n-product-tabs__name").getTagName();
        //String Characteristics1 = driver.findElementsByName("Характеристики").toString();
        //System.out.println(Characteristics1);

        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles.size());

        //String Characteristics1 =
        //        driver.findElementByClassName("n-product-tabs__name").click(); // .getTagName();
        //driver.findElementByClassName("n-product-tabs__item n-product-tabs__item_name_spec").click(); // .getTagName();
        //System.out.println(Characteristics1);

//        for (String handle : allWindowHandles) {
//            System.out.println("Switching to window - > " + handle);
//            System.out.println("Navigating to google.com");
//            driver.switchTo().window(handle); //Switch to the desired window first and then execute commands using driver
//            //driver.get("http://google.com");
//        }

        //driver.switchTo().window(driver.getWindowHandle());
        //driver.findElementByName("spec");
        //driver.switchTo().frame("spec");
        //WebElement Ch1 = driver.findElement(new By.ByName("Характеристики"));
        //WebElement parentElement = driver.findElement(By.xpath("Характеристики"));
//        int count = driver.getXpathCount("//span[@class='n-product-tabs__name']").intValue();
//        for(int i =1 ; i <= count ; i ++){
//            System.out.println(selenium.getText("//span["+i+"]"));
//        }
//
//      System.out.println(parentElement.toString());

        //body > div.main > div.n-product-sticker.i-bem.n-product-sticker_js_inited > div > div > div > ul > li.n-product-tabs__item.n-product-tabs__item_name_spec > a > span
        //System.out.println(Ch1.toString());
        if (!"Характеристики".equals(driver.findElementsByName("Характеристики").toString())) {
            System.out.println("Вкладка [Характеристики] отсутствует.");
            //fail();
        }

        String Ch1 = driver.findElement(By.xpath("//span[@class='n-product-tabs__name']")).getText();
        System.out.println(Ch1);
        driver.findElementByLinkText("Характеристики").click();

        //driver.quit();

    }

    @Test
    public void FindCharacteristicsDebugTest() {
        // kind of debugging - Trying different ways to check whether opened page contains 'Характеристики' tab
        System.setProperty("webdriver.chrome.driver", "T:\\Java\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://market.yandex.ru/product--smartfon-xiaomi-redmi-note-8-pro-6-64gb/573324027?track=tabs");

        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles.size());

        //body > div.main > div.n-product-sticker.i-bem.n-product-sticker_js_inited > div > div > div > ul > li.n-product-tabs__item.n-product-tabs__item_name_spec > a > span
        //System.out.println(Ch1.toString());
        if (!"Характеристики".equals(driver.findElementsByName("Характеристики").toString())) {
            System.out.println("Вкладка [Характеристики] отсутствует.");
            //fail();
        }

        String Ch1 = driver.findElement(By.xpath("//span[@class='n-product-tabs__name']")).getText();
        System.out.println(Ch1);
        driver.findElementByLinkText("Характеристики").click();

    }

    @Test
    public void FindCharacteristicsSelenideTest() {
        Selenide.open("https://market.yandex.ru/product--smartfon-xiaomi-redmi-note-8-pro-6-64gb/573324027?track=tabs");

    }

}
