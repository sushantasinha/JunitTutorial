package com.sample;


import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayTest {



    @Test
    public void test1() {
        int[] expected = {1, 2, 3, 4};
        int[] actual = {1, 2, 3, 4};
        //assertEquals(expected, actual);
        assertArrayEquals(expected, actual);

    }


}
