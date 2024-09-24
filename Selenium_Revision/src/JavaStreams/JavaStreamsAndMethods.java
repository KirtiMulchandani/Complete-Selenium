package JavaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamsAndMethods {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(new String[]{"Kirti", "Aarti", "Gayatri", "Darshil"});

        // here we are converting our list into the stream, so that we apply different methods on it to perform
        // parallel operations
        // so, in the filter() is the intermediary function and it needs terminal methods to produce the output
        // in this case the count() is the terminal method

        Long cnt = names.stream().filter(x->x.endsWith("i")).count(); // will print the count of all the strings ending with the letter "i"
        System.out.println(cnt);

        // the stream can also be defined this way
        //  Let say we want to print the count of the string which are string from "K"

        System.out.println(Stream.of("Kirti", "Aarti", "Gayatri", "Darshil").filter(s->s.startsWith("K")).count());

        // now how is this filter() is evaluating the result is this intermediary method is only working when
        // the condition inside it is true otherwise it's not going to give the results to the terminal method
        // now the condition which is being given inside it, is defined using lambda expression (-> function)
        // so, inside this lambda expression, on the right side of the ->, the condition can be large.  eg.

        System.out.println(Stream.of("Kirti", "Aarti", "Gayatri", "Darshil").filter(s->
        {
            s.startsWith("K");
            return true;
        }).count());

        // This will print all the strings which lengths are lesser than or equal to 5
        names.stream().filter(x->x.length() <= 5).forEach(x->System.out.println(x));

        // let's say, from above results we only want to print the first result only
        names.stream().filter(x->x.length() <= 5).limit(1).forEach(x->System.out.println(x)); // limit()
        // method can be used to define the numbers of the results to be printed


        // but what if we want to modify the strings also present inside this list, this is where, map() comes in
        names.stream().map(x->x.toUpperCase()).forEach(x-> System.out.println(x));

        System.out.println();

        // what if we want to concatenate two streams
        Stream<String> stream = Stream.concat(names.stream(), Stream.of("Kirti", "Aarti", "Gayatri", "Darshil"));

//        stream.forEach(x-> System.out.println(x));

        // Let's say, we want to search whether a particular string is present of not in the list, for that
        // anyMatch() function will be used

        System.out.println(names.stream().anyMatch(x->x.equalsIgnoreCase("kirti")));

        // let's say we want to return the list in a sorted order
//        stream.sorted().forEach(x-> System.out.println(x));


        System.out.println();

        // finding Distinct elements
//        stream.distinct().forEach(x-> System.out.println(x));


        // Collect method to store the end result into a collection (List, Map, Set etc..)
//        List<String> newList = stream.filter(x->x.endsWith("i")).map(x->x.toUpperCase()).collect(Collectors.toList());

//        for(String i : newList) System.out.println(i);



    }
}
