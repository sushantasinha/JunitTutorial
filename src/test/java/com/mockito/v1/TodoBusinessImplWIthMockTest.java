package com.mockito.v1;


import com.sample.mockito.TodoBusinessImpl;
import com.sample.mockito.TodoService;
import com.stub.TodoServiceStub;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TodoBusinessImplWIthMockTest {

    @Test
    public void usingMockitoNiceMock() {
        //mock() on Class or interface
        //As we did not mention what to do (means we did not mention like, List<String> allTodos = Arrays.asList("Learn Spring MVC",
        //                "Learn Spring", "Learn to Dance");), then it will pass empty list. This is called nice mock
        TodoService todoService = mock(TodoService.class);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        List<String> todos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Ranga");
        assertEquals(0, todos.size());
    }


    @Test
    public void usingMockito() {
        //mock() on Class or interface

        //Given
        TodoService todoService = mock(TodoService.class);
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");
        when(todoService.retrieveTodos("dummy")).thenReturn(allTodos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

        //When
        List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("dummy");

        //Then
        assertEquals(2, todos.size());
    }

}
