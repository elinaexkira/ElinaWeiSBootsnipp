package com.bootsnipp.test.FW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class SessionHelper extends HelperBase{
    WebDriver wd;
    public SessionHelper(WebDriver wd){
        super(wd);
    }
    public boolean isLoginButtonPresent() {
        return isElementPresent(By.cssSelector("[type='submit']"));
    }

    public boolean isUserLoggedIn(){
        return isElementPresent(By.cssSelector("[class$='dropdown-right active']"));
    }
    public void makeSureLoginSuccessful() {
        if (isElementPresent(By.cssSelector("[class$='dropdown-right active']"))){
            System.out.println("Login Successful");
        }else{
            System.out.println("Error");
        }
    }

    public boolean isElementPresent(By by){
        try{
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }
}
