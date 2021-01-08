package a_lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class A02_Apple_Comparator {
    public static void main(String[] args) {
        List<A01_Apple> inventory = new ArrayList<>();
        inventory.addAll(genData());
        Collections.shuffle(inventory);

//        inventory.sort(new AppleComparator());

        //Step 3: use lambda
        inventory.sort((A01_Apple a1, A01_Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));

        //Step 3.1: Use type infer
        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));

        //Step 3.2 Use a more understandable comparator
        inventory.sort(Comparator.comparing((A01_Apple a) -> a.getWeight()));

        //Step 4.2 Use method reference
        inventory.sort(Comparator.comparing(A01_Apple::getWeight));

        //More conditions
        //Change to reversed order
        inventory.sort(Comparator.comparing(A01_Apple::getWeight)
                .reversed());

        //After this sorting, sort by another condition
        inventory.sort(Comparator.comparing(A01_Apple::getWeight)
                .reversed()
                .thenComparing(A01_Apple::getCountry));

        boolean breakPoint = false;
    }

    public static List<A01_Apple> genData() {
        List<A01_Apple> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            A01_Apple apple = new A01_Apple();
            apple.setCountry(String.valueOf((char) i));
            apple.setWeight(i);
            apple.setColor(i >= 10 ? "Green" : " Yellow");
            result.add(apple);
        }
        return result;
    }
}

class AppleComparator implements Comparator<A01_Apple> {
    @Override
    public int compare(A01_Apple o1, A01_Apple o2) {
        return o1.getWeight().compareTo(o2.getWeight());
    }
}
