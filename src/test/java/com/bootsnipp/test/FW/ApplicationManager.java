package com.bootsnipp.test.FW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    EventFiringWebDriver wd;
    SessionHelper session;
    LoginHelper log;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public static class MyListener extends AbstractWebDriverEventListener {
        Logger logger = LoggerFactory.getLogger(MyListener.class);
        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            logger.info("Start search " + by + "...");
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            logger.info(by + "found.");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            logger.error(throwable.toString());
        }
    }

    public void init() {
        if (browser.equals(BrowserType.CHROME)) {
            wd = new EventFiringWebDriver(new ChromeDriver());
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new EventFiringWebDriver(new FirefoxDriver());
        }

        wd.register(new MyListener());

        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.manage().window().maximize();

        wd.get("https://bootsnipp.com/login");

        session = new SessionHelper(wd);
        log = new LoginHelper(wd);
    }

    public void stop() {
        wd.quit();
    }

    public SessionHelper session() {
        return session;
    }

    public LoginHelper log() {
        return log;
    }
}
