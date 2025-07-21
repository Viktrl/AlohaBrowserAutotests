import io.appium.java_client.mac.Mac2Driver;
import io.appium.java_client.mac.options.Mac2Options;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlohaBrowserTest {
    private static Mac2Driver driver;

    @BeforeAll
    public static void setUp() {
        try {
            //Объявляем настройки для Mac2Driver
            Mac2Options options = new Mac2Options();
            options.setCapability("appPath", "/Applications/Aloha.app");
            options.setCapability("platformName", "mac");

            //Создаем экземпляр Mac2Driver с указанными настройками
            driver = new Mac2Driver(new URL("http://127.0.0.1:4723/"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testTabClose() {
        try {
            //Открываем новую (вторую) вкладку
            WebElement newTableViaPlusButton = driver.findElement(By.xpath("//XCUIElementTypeButton[@label=\"Новая вкладка\"]"));
            newTableViaPlusButton.click();

            //Вводим URL в адресную строку новой (второй) вкладки
            WebElement enterUrlField = driver.findElement(By.xpath("//XCUIElementTypeTextField[@label=\"Адресная строка и строка поиска\"]"));
            enterUrlField.sendKeys("google.com\n");

            //Проверяем количество вкладок до закрытия
            List<WebElement> tabsBefore = driver.findElements(By.xpath("//XCUIElementTypeTab"));
            assertEquals(2, tabsBefore.size());

            //Закрываем первую вкладку
            WebElement closeFirstTabButton = driver.findElement(By.xpath("(//XCUIElementTypeButton[@label=\"Закрыть\"])[1]"));
            closeFirstTabButton.click();

            //Проверяем количество вкладок после закрытия
            List<WebElement> tabsAfter = driver.findElements(By.xpath("//XCUIElementTypeTab"));
            assertEquals(1, tabsAfter.size());

            //Доп проверка на то, что осталась именно та вкладка, которую не закрывали
            String remainingTab = tabsAfter.get(0).getAttribute("label");
            assertEquals("Google", remainingTab);
        } finally {
            //Закрываем браузер
            driver.quit();
        }
    }
}
