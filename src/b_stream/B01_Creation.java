package b_stream;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Related to the section 2.2 from the book
 * 402 Java SE 8 for the really impatient
 */
public class B01_Creation {
    public static void main(String[] args) {
        //From split or array
        Stream<String> fromSplit = Stream.of("some,thing,that, can ,be ,split".split(","));

        //From Collection
        Stream<String> fromCollection = Arrays.asList("some", "thing", "that", " can ", "be").stream();

        //Or simply
        Stream<String> fromCollectionSimple = Stream.of("some", "thing", "that", " can ", "be");

        //Concat them
        Stream<String> concat = Stream.concat(fromSplit, fromCollection);

        //Empty it
        fromCollection = Stream.empty();

        //Infinite streams, be sure to limit, or it will be stuck here forever
        Stream<String> infiniteStreamOfEcho = Stream.generate(() -> "Echo");
        List<String> infiniteStreamOfEchoList = infiniteStreamOfEcho.skip(100).limit(100).collect(Collectors.toList());

        //Math::random servers as a supplier, generate random numbers when needed
        Stream<Double> infiniteStreamOfRamdomNumber = Stream.generate(Math::random);
        List<Double> infiniteStreamOfRamdomNumberList = infiniteStreamOfRamdomNumber.skip(100).limit(100).collect(Collectors.toList());

        //BigInteger.ZERO becomes the variable n, and n.add() changes its own val
        Stream<BigInteger> infiniteStreamOfSelfAddingIntegers = Stream.iterate(BigInteger.ZERO, n->n.add(BigInteger.ONE).add(BigInteger.ONE));
        List<BigInteger> infiniteStreamOfSelfAddingIntegersList = infiniteStreamOfSelfAddingIntegers.limit(4000).collect(Collectors.toList());

        //Try return all lines in a file
        Path path = Paths.get("parent_folder","fileName.txt");
        try(Stream<String> lines = Files.lines(path)){
            //Do someting here

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String debugger= "";
    }
}
