package com.bootsnipp.test.FW;

import com.bootsnipp.test.Model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelper extends HelperBase{

    public LoginHelper(WebDriver wd){
        super(wd);
    }
    public void fillLoginForm(User user) {

        type(By.cssSelector("[name='email']"), user.getEmail());
        type(By.cssSelector("[name='password']"), user.getPassword());

    }

    public void rememberMeCheckbox() {
        click(By.cssSelector("[name='remember']"));
    }


    public void clickSubmitButton() {
        click(By.cssSelector("[type='submit']"));
    }





    public void logOut() throws InterruptedException {
        click(By.cssSelector("[class='dropdown dropdown-right active']"));
        Thread.sleep(2000);
        click(By.cssSelector("[href=\"https://bootsnipp.com/logout\"]"));

    }
}
