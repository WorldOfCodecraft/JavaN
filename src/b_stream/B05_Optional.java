package b_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class B05_Optional {
    public static void main(String[] args) throws Exception {
        List<String> words = Arrays.asList();
        List<String> result = new ArrayList<>();

        Optional<String> max = words.stream().max(String::compareToIgnoreCase);
        /**
         * Produces nothing but it's safe
         */
        max.ifPresent(result::add);
        result.forEach(System.out::println);

        /**
         * If nothing is there, provides an option
         */
        String maxStr = max.orElse("nothing there");
        System.out.println(maxStr);

        /**
         * Throw an exception if nothing
         */
//        max.orElseThrow(Exception::new);

        /**
         * Create an empty optional
         */
        Optional<Object> empty = Optional.empty();

        /**
         * Create a non-empty optional
         */
        Optional<String> stringOptional = Optional.of("I'm not empty");

        /**
         * Will be empty
         */
        Optional<Object> nullOptional = Optional.ofNullable(null);

        /**
         * Will not be empty
         */
        Optional<String> notNullOptional = Optional.ofNullable("I'm not null");

        /**
         * Chain invoking
         * Any link of the chain is empty, the result is empty
         *
         * You cannot do:
         * ChainA.doSthA(true).doSthB(),
         * Because it returns an Optional object
         */
        Optional<ChainB> chainB = ChainA.doSthA(true).flatMap(ChainB::doSthB);
        System.out.println(chainB.isPresent());
    }
}

class ChainA {
    public static Optional<ChainB> doSthA(boolean doIt) {
        return doIt ? Optional.of(new ChainB()) : Optional.empty();
    }
}

class ChainB {
    public static Optional<ChainB> doSthB(ChainB doIt) {
        return doIt.toString().isEmpty() ? Optional.empty() : Optional.of(new ChainB());
    }
}