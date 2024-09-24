package JavaPractice;

public class ExceptionHandling {
    public static void main(String[] args) {
//        method();


        String s1 = "Kirti";
        String s2 = "Kirti";
        String s3 = new String("Kirti");
        String s4 = new String("Kirti");

        System.out.println(s1 == s2); // 1
        System.out.println(s4 == s3);  // 0

    }

//    static void method() throws ArithmeticException{
//        try{
//            System.out.println("Inside Method");
//            throw new ArithmeticException("Demo");
//        }
//        catch (ArithmeticException e){
//            System.out.println(e);
//        }
//
//    }

}
