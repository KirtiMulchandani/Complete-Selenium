package test1;

import org.testng.annotations.Test;

public class ChildClass1 extends InheritanceUsageInTestNG{

    @Test
    public void test1(){
        demo();
        UtilityClassUsingTestNG obj = new UtilityClassUsingTestNG(5);
        System.out.println(obj.increment());
        System.out.println(obj.decrement());
        System.out.println(obj.multiplyBy2());
    }
}
