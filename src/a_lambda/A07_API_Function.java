package a_lambda;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class A07_API_Function {
    public static void main(String[] args) {
        List<Class> classList = Arrays.asList(List.class, Arrays.class, Method.class);

        //The test method needs a boolean, so we give a boolean to the lambda
        List<String> clazzNameList = filter(classList, (Class clazz) -> clazz.getName());

        clazzNameList.forEach(System.out::println);
    }

    /**
     * Function.apply(T) consumes a T, and returns another type, so it's great to do some convert with T
     *
     * @param from
     * @param function
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> List<R> filter(List<T> from, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (int i = 0; i < from.size(); i++) {
            T t = from.get(i);
            result.add(function.apply(t));
        }
        return result;
    }
}
