package com.bootsnipp.test.Tests;

import com.bootsnipp.test.Model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTests extends TestBase{

    
    
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(!app.session().isLoginButtonPresent()){
            app.log().logOut();
        }
    }



    @Test(dataProvider = "validUserFromCSV", dataProviderClass = DataProviders.class)
    public void loginPageTests(User user) throws InterruptedException {

        app.log().fillLoginForm(user);

        app.log().rememberMeCheckbox();

        app.log().clickSubmitButton();

        Assert.assertTrue(app.session().isUserLoggedIn());

        app.session().makeSureLoginSuccessful();

        app.log().logOut();

        app.session().clickOnLoginButton();

    }


}
