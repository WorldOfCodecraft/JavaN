package a_lambda;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class A10_CalculateRunTimeUtil {
    public <R> R timing(Supplier<R> operation) {
        long start = System.nanoTime();
        R result = operation.get();
        System.out.printf("Time spent: %dms\n", TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start));
        return result;
    }

    public void timing(Runnable runnable) {
        this.timing(() -> {
            runnable.run();
            return null;
        });
    }
}
