package b_stream;

import a_lambda.A05_API_Predicate;
import a_lambda.A06_API_Consumer;
import a_lambda.A07_API_Function;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class B02_Filter_Map_FlatMap {
    /**
     * Maps effectively replaces codes for Predicate, Consumer, and Function, when they are used to generate a collection
     *
     * @param args
     * @see A05_API_Predicate
     * @see A06_API_Consumer
     * @see A07_API_Function
     */
    public static void main(String[] args) {
        /**
         * Example 1, filter, to replace Predicate
         */
        List<String> stringList = Arrays.asList("abc1", "abc2", "abc3", "abc4", "xyz1", "xyz2");

        //b4
        List<String> stringListThatStartsWithAbc = A05_API_Predicate.filter(stringList, (String str) -> str.startsWith("abc"));
        stringListThatStartsWithAbc.forEach(System.out::println);

        //after
        Stream<String> stringStream = stringList.stream();
        stringListThatStartsWithAbc = stringStream.filter(w -> w.startsWith("abc")).collect(Collectors.toList());
        stringListThatStartsWithAbc.forEach(System.out::println);


        /**
         * Example 2, map to get class names, to replace Function
         */
        List<Class> classList = Arrays.asList(List.class, Arrays.class, Method.class);

        //b4
        List<String> clazzNameList = A07_API_Function.filter(classList, (Class clazz) -> clazz.getName());
        clazzNameList.forEach(System.out::println);

        //after
        clazzNameList = classList.stream().map(c -> c.getName()).collect(Collectors.toList());
        clazzNameList.forEach(System.out::println);

        /**
         * Example 2.1, map to get the first char, to replace Function
         */
        List<Character> firstCharList = stringList.stream().map(w -> w.charAt(0)).collect(Collectors.toList());
        firstCharList.forEach(System.out::println);

        /**
         * Example 3, get every element from a list of lists of streams
         */
        List<Character> characters = stringList.stream().flatMap(s -> characterStream(s)).collect(Collectors.toList());
        characters.forEach(System.out::println);

    }

    public static Stream<Character> characterStream(String s) {
        List<Character> result = new ArrayList<>();
        for (char c :
                s.toCharArray()) {
            result.add(c);
        }
        return result.stream();
    }
}
