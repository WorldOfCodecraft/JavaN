package a_lambda;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class A09_CalculateRunTime {
    public static void main(String[] args) {
        A10_CalculateRunTimeUtil runTime = new A10_CalculateRunTimeUtil();
        runTime.timing(() -> method2Invoke("foo", "bar"));
        runTime.timing(() -> System.out.println("Hello"));

        runTime.timing(() -> genLargeNumberOfNumbersWParallel());
        runTime.timing(() -> genLargeNumberOfNumbersWOParallel());

    }

    private static String method2Invoke(String first, String second) {
        //Do nothing
        return first + second;
    }

    //Check the link below for reasons why the parallel here is even slower
    //https://stackoverflow.com/questions/23170832/java-8s-streams-why-parallel-stream-is-slower
    private static void genLargeNumberOfNumbersWParallel(){
        //BigInteger.ZERO becomes the variable n, and n.add() changes its own val
        Stream<BigInteger> infiniteBigIntStream = Stream.iterate(BigInteger.ZERO, n->n.add(BigInteger.ONE).add(BigInteger.ONE)).parallel();
        List<BigInteger> infiniteBigIntList = infiniteBigIntStream.limit(10000000).collect(Collectors.toList());
    }

    private static void genLargeNumberOfNumbersWOParallel(){
        //BigInteger.ZERO becomes the variable n, and n.add() changes its own val
        Stream<BigInteger> infiniteBigIntStream = Stream.iterate(BigInteger.ZERO, n->n.add(BigInteger.ONE).add(BigInteger.ONE));
        List<BigInteger> infiniteBigIntList = infiniteBigIntStream.limit(10000000).collect(Collectors.toList());
    }
}
