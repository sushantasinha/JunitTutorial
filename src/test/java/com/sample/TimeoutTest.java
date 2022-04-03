package com.sample;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimeoutTest {

    DoStuff doStuff = new DoStuff();

    @Test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    void exceptionTesting() {
        for (int i =0; i < 10000; i++) {
            System.out.println(i);
        }
    }


}
