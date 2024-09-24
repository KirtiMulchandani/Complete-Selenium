package test1;

import org.testng.annotations.*;

public class class2 {
    @Parameters({"URL"})
    @Test
    public void PersonalLoanWebLogin(String url){
        System.out.println("PersonalLoanWebLogin");
        System.out.println("Url is " + url);
    }

    @Test(groups = {"smoke"})
    public void PersonalLoanMobileLogin(){
        System.out.println("PersonalLoanMobileLogin");
    }

    @Test(enabled = false)
    public void PersonalLoanWebDashboard(){
        System.out.println("PersonalLoanWebDashboard");
    }

    @Test(groups = {"smoke"})
    public void PersonalLoanMobileDashboard(){
        System.out.println("PersonalLoanMobileDashboard");
    }

    @BeforeSuite
    public void BeforeSuite(){
        System.out.println("I'll run before the test suite");
    }

    @AfterSuite
    public void AfterSuite(){
        System.out.println("I'll run after test suite");
    }

    @BeforeClass
    public void BeforeClass(){
        System.out.println("I'll run before personal loan class");
    }

    @AfterClass
    public void AfterClass(){
        System.out.println("I'll run after personal loan class");
    }

    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("I'll run after each method of personal loan class");
    }
}
