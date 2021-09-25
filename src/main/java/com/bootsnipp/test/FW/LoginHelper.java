package com.bootsnipp.test.FW;

import com.bootsnipp.test.Model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelper extends HelperBase{
    WebDriver wd;
    public LoginHelper(WebDriver wd){
        super(wd);
    }
    public void fillLoginForm(User user) {

        //input username and password
        type(By.cssSelector("[name='email']"), user.getEmail());
        type(By.cssSelector("[name='password']"), user.getPassword());


        //remember me checkbox
        rememberMeCheckbox();


        //click login button
        clickSubmitButton();

        //make sure login successful
    }




    public void clickSubmitButton() {
        click(By.cssSelector("[type='submit']"));
    }

    public void rememberMeCheckbox() {
        click(By.cssSelector("[name='remember']"));
    }



    public void logOut() {
        click(By.cssSelector("//a[contains(., 'Profile ')]"));
        click(By.cssSelector("//a[contains(., 'Logout ')]"));

    }
}
