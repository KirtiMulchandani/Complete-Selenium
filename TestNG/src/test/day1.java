package test;

import org.testng.annotations.Test;

public class day1 {


    // TestNG doesn't require you to put the main everytime for each of the test case
    // So, question is how does it do that??
    // if we want to create the testcase in TestNG, there is annotation for that

    @Test // by putting @Test annotation we can create a testcase, this annotation considers the
    // each method as testcase if it's been defined followed by it.
    // TestNG has its own Java compiler to execute the methods it doesn't even require you to
    // have main() in the call
    public void firstTest(){
        System.out.println("This is my first testcase");
    }

    // One class can have multiple testcases
    @Test(groups = {"smoke"})
    public void secondTest(){
        System.out.println("Second TestCase");
    }

    // We can have multiple testcases, as per the convention the names of them will have package name
    // at the beginning right, and this is where can include and exclude based on the initial name
    // using regular expression. e.g., the package name is "same"

    @Test
    public void sameTestCase1(){
        System.out.println("I am testcase-1 in same package");
    }

    @Test
    public void sameTestCase2(){
        System.out.println("I am testcase-2 in same package");
    }

    @Test
    public void sameTestCase3(){
        System.out.println("I am testcase-3 in same package");
    }

    @Test
    public void sameTestCase4(){
        System.out.println("I am testcase-4 in same package");
    }

}
