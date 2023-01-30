package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import pages.GitPage;

public class TestBase {
    GitPage gitPage = new GitPage();

    @BeforeAll
    public static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";
    }
}
