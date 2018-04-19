package by.spf.vaadindemo.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.openqa.selenium.By;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestUI {

    @LocalServerPort
    int port;

    @Before
    public void init() {
        Configuration.browser = WebDriverRunner.CHROME;
        Configuration.baseUrl = "http://localhost:" + port;
    }

    @Test
    public void testOpen() {
        open("/sfp");
    }

    @After
    public void teardown() {
        WebDriverRunner.closeWebDriver();
    }

}
