package test1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class InheritanceUsageInTestNG {
    public void demo(){
        System.out.println("I am a parent class method");
    }

    //parent class can have @BeforeMethod/@AfterMethod also
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am before method present in the parent class");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after method present in the parent class");
    }

}
