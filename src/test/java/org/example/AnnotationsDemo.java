package org.example;

/*
1)login application
2)search
3)logout
4)login
5)advance search
6)logout
 */

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationsDemo {

    @BeforeMethod
    public void loginApp() {
        System.out.println("Login in");
    }

    @Test(priority = 1)
    public void searchInApp() {
        System.out.println("searched............");
    }
    @Test(priority = 2)
    public void advanceSearch() {
        System.out.println("Advance Search completed");
    }

    @AfterMethod
    public void logout() {
        System.out.println("Logout");
    }




}
