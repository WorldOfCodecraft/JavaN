package a_lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class A04_File_API {
    //This is a common way to read files in Java 7, but how about if you want to read two lines
    public static String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine();
        }
    }

    //Lambdas can only be used in the context of a functional interface,
    // so we create a new interface called BufferReaderProcessor
    //And then we change the processFiles method to the below
    public static String processFile(BufferReaderProcessor processor) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return processor.process(br);
        }
    }

    //After doing this, we can now use lambda to read more lines like so
    public static void main(String[] args) throws IOException {
        //To read one line
        String oneLine = processFile((BufferedReader br) -> br.readLine());
        String twoLine = processFile((BufferedReader br) -> br.readLine() + br.readLine());


    }
}

/**
 * FunctionInterface is symbolic, it demands only one method being in the interface, just like @override
 */
@FunctionalInterface
interface BufferReaderProcessor {
    String process(BufferedReader bufferedReader) throws IOException;
}