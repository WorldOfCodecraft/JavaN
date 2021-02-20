package b_stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class B03_Stateful_Trans {
    public static void main(String[] args) {
        List<String> words = List.of("hello", "hello", "hello", "word");
        /**
         * Get the distinct result
         * section 2.5 from "Impatient"
         */
        Stream<String> distinctStr = words.stream().distinct();
        distinctStr.forEach(System.out::println);

        /**
         * Get the sorted
         * section 2.5 from "Impatient"
         */
        Stream<String> sortedStream = words.stream().sorted(Comparator.comparing(String::length));
        sortedStream.collect(Collectors.toList()).forEach(System.out::println);

        /**
         * Get the reversed
         * section 2.5 from "Impatient"
         */
        sortedStream = words.stream().sorted(Comparator.comparing(String::length).reversed());
        sortedStream.collect(Collectors.toList()).forEach(System.out::println);


    }
}
