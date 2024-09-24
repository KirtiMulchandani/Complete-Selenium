import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickRevisionJava {
    public static void main(String[] args){
        Integer[] arr = {1, 2, 3, 4};

        // normal array can also be converted into arrayList

        List<Integer> convertedFromNormalArr = Arrays.asList(arr);

        String[] name = {"Kirti", "Aarti"};
        List<String> nameList = Arrays.asList(name);

        for (String s : nameList) System.out.println(s);

        for(int i : arr) System.out.println(i);

        ArrayList<String> a = new ArrayList<String>();

        a.add("Kirti Mulchandani");
        a.add("Aarti Mulchandani");
        a.add("Darshil Mulchandani");
        a.add("Gayatri Mulchandani");


        System.out.println(a.get(0));

        for (String s : a) System.out.println(s);

        for(int i = 0; i < a.size(); i++) System.out.println(a.get(i));

        System.out.println(a.contains("Kirti Mulchandani"));

        // calling the method of this class using object since it is a non-static method
        QuickRevisionJava obj = new QuickRevisionJava();
        obj.show();

        // calling the method of another class using object since it is a non-static method
        AnotherClass obj1 = new AnotherClass();
        obj1.show();

        // calling the static method of this class without even creating the object
        staticMethod();

        // calling the static method of different class without even creating the object
        AnotherClass.staticMethod();

    }

    public void show(){
        System.out.println("I am a show method of the same class");
    }

    // we create
    public static void staticMethod(){
        System.out.println("I am a static method of the same class");
    }
}
