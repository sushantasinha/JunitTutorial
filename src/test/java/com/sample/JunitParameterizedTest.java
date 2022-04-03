package com.sample;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JunitParameterizedTest {

    @DisplayName("Test with @MethodSource")
    @ParameterizedTest(name = "{index}: ({0} + {1}) => {2})")
    @MethodSource("localParameters")
    void test(int first, int second, int sum) {
        assertEquals(sum, first + second);
    }

    static Stream<Arguments> localParameters() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(1, 2, 3),
                Arguments.of(5, 3, 8)
        );
    }

}
