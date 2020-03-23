package ru.yandex.market;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

import static org.junit.Assert.fail;

/*
 * Created by A on 22.03.2020 22:36
 */
public class FindCharacteristicsTest {
    @Test
    public void FindCharacteristicsTest() {
        System.setProperty("webdriver.chrome.driver", "T:\\Java\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://market.yandex.ru/");

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов"));

        driver.findElementByLinkText("Электроника").click();
        driver.findElementByLinkText("Мобильные телефоны").click();

        //System.out.println(producer);

        WebElement element = driver.findElement(By.id("7893318_7701962"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();

        WebElement checkbox1 = driver.findElement(By.id("7893318_7701962"));
        if (!checkbox1.isSelected()) {
            System.out.println("Toggled off. Toggling on...");
            checkbox1.click();
            System.out.println("Toggled on.");
        }

        System.out.println("Toggled on.");

        String phone = "Смартфон " + "Redmi Note 8 Pro 6/64GB";
        driver.findElementByLinkText(phone).click();

        //String Characteristics1 = driver.findElementByLinkText("Характеристики").getText();
        //String Characteristics1 = driver.findElementByClassName("n-product-tabs__name"). >Характеристики</span>) .findElementByLinkText("Характеристики").getText();

        //String Characteristics1 = driver.findElementsByName() .findElementByClassName("n-product-tabs__name").getTagName();
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
        WebElement parentElement = driver.findElement(By.xpath("Характеристики"));
        //System.out.println(parentElement.toString());
        //body > div.main > div.n-product-sticker.i-bem.n-product-sticker_js_inited > div > div > div > ul > li.n-product-tabs__item.n-product-tabs__item_name_spec > a > span
        //System.out.println(Ch1.toString());
        if (!"Характеристики".equals(driver.findElementsByName("Характеристики").toString())) {
            System.out.println("Вкладка [Характеристики] отсутствует.");
            fail();
        }
        ;

        driver.findElementByLinkText("Характеристики").click();

        //driver.findElementByLinkText("Характеристики").click();

        //driver.quit();

    }
}
