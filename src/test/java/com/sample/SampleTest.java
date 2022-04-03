package com.sample;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class SampleTest {

    @BeforeAll
    public static void masterSetup() {
        System.out.println("In BeforeAll.........................");
    }

    @BeforeEach
    public void setup() {
        System.out.println("In BeforeEach.........................");
    }

    @Test
    private void test(){
        fail("nothing implemented");
    }

    @AfterEach
    public void cleanUp() {
        System.out.println("In AfterEach.........................");
    }

    @AfterAll
    public static void masterCleanUp() {
        System.out.println("In AfterAll.........................");
    }

    @Test
    public void test1() {
        System.out.println("in method test1");
        assertEquals("abc", "abc");
    }

    @Test
    public void test2() {
        System.out.println("in method test2");
        assertEquals(123, 123);
    }

    @Test
    public void test3() {
        System.out.println("in method test3");
        assertEquals(0.0, 0.00);
    }
}
