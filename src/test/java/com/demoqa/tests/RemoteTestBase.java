package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class RemoteTestBase {

    @BeforeAll
    static void beforeAll() {
        String browser = System.getProperty("browser");
        //String browserVersion = System.getProperty("browserVersion");
        //String browserSize = System.getProperty("browserSize");
        //String webDriverHost = System.getProperty("webDriverHost");
        //String baseUrl = System.getProperty("baseUrl");

        //Configuration.baseUrl="https://" + baseUrl;
        //Configuration.pageLoadStrategy="eager";
        //Configuration.browser = browser;
        //Configuration.browserVersion = browserVersion;
        //Configuration.browserSize = browserSize;
        //Configuration.remote = String.format("https://user1:1234@%s/wd/hub", webDriverHost);

        //Configuration.baseUrl = "https://demoqa.com";
        //Configuration.browserSize = "1920x1080";
        //Configuration.pageLoadStrategy = "eager";
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        Configuration.baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browser_version", "100");
        Configuration.remote = System.getProperty("remoteUrl", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        Configuration.timeout = 10000;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}