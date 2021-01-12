package a_lambda;

public class A03_Lambda_Syntax {
    public static void main(String[] args) {
        diffLambda();
    }

    /**
     * Demo three diff ways to use a lambda
     */
    private static void diffLambda() {
        //Note that Idea can even convert this method to a lambda
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("I'm runnable 1");
            }
        };
        process((runnable1));

        Runnable runnable2 = () -> System.out.println("I'm runnable 2");
        process(runnable2);

        process(() -> System.out.println("I'm runnable 3"));
    }

    private static void process(Runnable runnable) {
        runnable.run();
    }
}
