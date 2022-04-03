package com.mockito.v2;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import com.sample.mockito.TodoBusinessImpl;
import com.sample.mockito.TodoService;
import com.stub.TodoServiceStub;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AHamcrestMatchersTest {

    @Test
    public void hamcrestMatchersOptionsTest() {
        List<Integer> list = List.of(100, 40, 55, 99);
        assertThat(list, hasSize(4));
        assertThat(list, hasItem(100));
        //assertThat(list, hasItems(100,40));
        assertThat(list, everyItem(greaterThan(35)));
        assertThat(list, everyItem(lessThan(101)));

        //assertThat( "", isEmptyString());
        //assertThat(null, isEmptyOrNullString());

        Integer[] marks = {1,2,3};
        assertThat(marks, arrayWithSize(3));
        assertThat(marks, arrayContaining(1,2,3));
        assertThat(marks, arrayContainingInAnyOrder(1,3,2));





    }

}
