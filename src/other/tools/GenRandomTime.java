package other.tools;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

public class GenRandomTime {
    public static void main(String[] args) {
        int count = 100;
        int hourFrom = 19;
        int hourTo = 23;
        Random random = new Random();

        int hour = -1;
        int minute = -1;
        int second = -1;
        for (int i = 0; i < count; i++) {
            hour = random.nextInt(hourTo - hourFrom) + 1 + hourFrom;
            minute = random.nextInt(59);
            second = random.nextInt(59);
            System.out.println((hour >= 24? "0" + (hour-24): hour) +
                    ":" +
                    String.format("%02d", minute) +
                    ":" +
                    String.format("%02d", second));
        }

    }
}
