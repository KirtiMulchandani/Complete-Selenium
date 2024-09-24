package test1;

import org.testng.Assert;
import org.testng.annotations.*;

public class class1 {

    @Parameters({"URL", "location"})
    @Test
    public void CarLoanWebLogin(String url, String location){
        System.out.println("CarLoanWebLogin");
        System.out.println("URL is " + url);
        System.out.println("Location " + location);
    }

    @Test(groups = {"smoke"}, timeOut = 1000)
    public void CarLoanMobileLogin(){
        System.out.println("CarLoanMobileLogin");
        Assert.assertTrue(false);
    }


    @Test(dependsOnMethods = {"CarLoanWebLogin"})
    public void CarLoanWebDashboard(){
        System.out.println("CarLoanWebDashboard");
    }

    @Test(groups = {"smoke"})
    public void CarLoanMobileDashboard(){
        System.out.println("CarLoanMobileDashboard");
    }

    @Test(dataProvider = "getData")
    public void dataProviderExample(String username, String password){
        System.out.println("Username: " + username + " Password: " + password);
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("I'll run before Car loan test folder/shell");
    }

    @AfterTest
    public void AfterTest(){
        System.out.println("I'll run after Car loan test folder/shell");
    }

    @DataProvider
    public Object[][] getData(){ // which is going to return multiple usernames and passwords
        Object[][] data = new Object[4][2];
        data[0][0] = "KirtiMulchandani";
        data[0][1] = "122dsaSFDA34";

        data[1][0] = "AartiMulchandani";
        data[1][1] = "1223asd4";

        data[2][0] = "GayatriMulchandani";
        data[2][1] = "122dsada34";

        data[3][0] = "DarshilMulchandani";
        data[3][1] = "1223csdaSDS4";

        return data;
    }

}
