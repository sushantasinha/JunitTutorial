package com.sample;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionTest {

    DoStuff doStuff = new DoStuff();

    @Test
    void exceptionTesting() {
        ServiceException thrown = assertThrows(
                ServiceException.class,
                () -> doStuff.getResult(10, 0),
                "Expected doThing() to throw, but it didn't"
        );

        assertTrue(thrown.getMessage().contains("an"));
    }


}
