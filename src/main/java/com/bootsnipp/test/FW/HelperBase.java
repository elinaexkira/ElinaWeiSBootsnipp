package com.bootsnipp.test.FW;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class HelperBase {
    WebDriver wd;
     public HelperBase(WebDriver wd){
         this.wd = wd;
     }

    public void click(By by){
        wd.findElement(by).click();
    }

    public void type(By by, String text){
        if (text != null) {
            click(by);
            wd.findElement(by).clear();
            wd.findElement(by).sendKeys(text);
        }
    }

    public String takeScreenshot(){
        File tmp = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshot-"+ System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshot.getAbsolutePath();
    }
}
