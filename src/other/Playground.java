package other;

import a_lambda.A01_Apple;

import java.security.PrivilegedAction;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;

public class Playground {
    public static void main(String[] args) throws Exception {
        Action action = () -> {};
        action.act();

        Runnable runnable = () -> {};
        runnable.run();

        Callable<Integer> c = () -> {
            System.out.println("");
            int nine = 44 + 55;
            return nine;
        };
        c.call();

        Callable<Integer> d = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 42;
            }
        };
        d.call();


        PrivilegedAction<Integer> p1 = () -> 11;
        p1.run();

        PrivilegedAction<Integer> p2 = new PrivilegedAction<Integer>() {
            @Override
            public Integer run() {
                return 11;
            }
        };
        p2.run();

        execute((Runnable) () -> {
            System.out.println("sadgf");
        });

        BiFunction<String, Integer, A01_Apple> bf = (color, weight) -> {
            A01_Apple zWrapUpApple = new A01_Apple(weight, color);
            return zWrapUpApple;
        };
        A01_Apple green = bf.apply("green", 3);

        TriFunction<Integer, Integer, String, RGB> triFunction = RGB::new;
        TriFunction<Integer, Integer, String, RGB> triFunction2 = (r, b, g) -> new RGB(r, b, g);
        TriFunction<Integer, String, Integer, RGB> triFunction3 = RGB::new;
        DblFunction<Integer, Integer, RGB> triFunction4 = (r, b) -> new RGB(r, b);
        DblFunction<Integer, Integer, RGB> triFunction5 = RGB::new;
        RGB apply1 = triFunction.apply(1, 2, "3");
        RGB apply2 = triFunction.apply(1, 2, "3");

        System.out.println("pause");
    }

    public static void execute(Runnable runnable) {
        runnable.run();
    }

    public static void execute(Action action) {
        action.act();
    }

    @FunctionalInterface
    interface Action {
        void act();
    }


}

interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}

interface DblFunction<T, U, R> {
    R apply(T t, U u);
}

class RGB {
    int r;
    int g;
    String b;

    public RGB(int r, int g, String b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public RGB(int r, String b, int g) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public RGB(int r, int g) {
        this.r = r;
        this.g = g;
    }

    public RGB(int r, String b) {
        this.r = r;
        this.b = b;
    }

    public RGB(String b, int r) {
        this.r = r;
        this.b = b;
    }


}
