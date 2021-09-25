package com.bootsnipp.test.Tests;

import com.bootsnipp.test.Model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    
    @BeforeMethod
    public void ensurePreconditions(){
        if(!app.session().isLoginButtonPresent()){
            app.log().logOut();
        }
    }



    @Test
    public void loginPageTests(){
        //make sure im in a login page
        app.log().fillLoginForm(new User().email("elina@gm.com").password("1Aaaaaaaaa"));

        Assert.assertTrue(app.session().isUserLoggedIn());

        app.session().makeSureLoginSuccessful();

    }


}
