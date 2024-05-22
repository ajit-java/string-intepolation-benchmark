package org.example.app;

import org.slf4j.helpers.MessageFormatter;

public class StringTest {
    public static void main(String[] args) {
        int i = 0;
        long prev_time = System.currentTimeMillis();
        long time;

        for (i = 0; i < 100000; i++) {
            String s = "Test string start" + i + "end";
        }
        time = System.currentTimeMillis() - prev_time;

        System.out.println("Time taken by (in ms) (+ concat) " + time);

        prev_time = System.currentTimeMillis();
        for (i = 0; i < 100000; i++) {
            String s = String.format("Test string start %d end", i);
        }
        time = System.currentTimeMillis() - prev_time;
        System.out.println("Time taken by (in ms) (String.format) " + time);

        prev_time = System.currentTimeMillis();
        Object[] obj = new Object[1];
        for (i = 0; i < 100000; i++) {
            obj[0] = i;
            MessageFormatter.arrayFormat("Test string start {} end", obj).getMessage();
        }
        time = System.currentTimeMillis() - prev_time;
        System.out.println("Time taken by (in ms) (Slf4j) " + time);

    }
}
