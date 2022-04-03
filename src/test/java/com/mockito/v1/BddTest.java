package com.mockito.v1;

import com.sample.mockito.TodoBusinessImpl;
import com.sample.mockito.TodoService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

public class BddTest {

    @Test
    public void testVerifyBDD() {

        TodoService todoService = mock(TodoService.class);
        List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        when(todoService.retrieveTodos("Dummy")).thenReturn(allTodos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        verify(todoService).retrieveTodos("Dummy");//Verify todoService.retrieveTodos("Dummy") is called 1 time... this is exactly same for "verify(todoService, Mockito.times(1)).retrieveTodos("Dummy");"
        verify(todoService, Mockito.times(1)).retrieveTodos("Dummy");
        verify(todoService, Mockito.never()).retrieveTodos("Dummy1");
    }

    //Another way also we can write as. then() instead of verify()

    @Test
    public void testThenBDD() {

        TodoService todoService = mock(TodoService.class);
        List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        when(todoService.retrieveTodos("Dummy")).thenReturn(allTodos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        then(todoService).should().retrieveTodos("Dummy");//Verify todoService.retrieveTodos("Dummy") is called 1 time... this is exactly same for "then(todoService).should(Mockito.times(1)).retrieveTodos("Dummy");"
        then(todoService).should(Mockito.times(1)).retrieveTodos("Dummy");
        then(todoService).should(Mockito.never()).retrieveTodos("Dummy1");
    }


    @Test
    public void testThenCaptureAugumentBDD() {

        ArgumentCaptor<String> stringSrgumentCaptor = ArgumentCaptor.forClass(String.class);

        TodoService todoService = mock(TodoService.class);
        List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        when(todoService.retrieveTodos("Dummy")).thenReturn(allTodos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        then(todoService).should().retrieveTodos(stringSrgumentCaptor.capture());
        assertEquals("Dummy", stringSrgumentCaptor.getValue());

        then(todoService).should().retrieveTodos(stringSrgumentCaptor.capture());
        assertEquals("Dummy", stringSrgumentCaptor.getValue());

        /*Mockito.verify(todoService).retrieveTodos(stringSrgumentCaptor.capture());
        assertEquals("Dummy", stringSrgumentCaptor.getValue());*/

    }


    /*
    This method tests there are 2 calls of todoService.retrieveTodos()
    One with "Dummy" as param
    Another is "abc" as param
     */

    @Test
    public void testThenCaptureAugumentBDDMultipleCall() {

        ArgumentCaptor<String> stringSrgumentCaptor = ArgumentCaptor.forClass(String.class);

        TodoService todoService = mock(TodoService.class);
        List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        when(todoService.retrieveTodos("Dummy")).thenReturn(allTodos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");



        // Now uncomment todoService.retrieveTodos("abc"); in TodoBusinessImpl
        // And comment lines:
        // then(todoService).should().retrieveTodos(stringSrgumentCaptor.capture());
        // assertEquals("Dummy", stringSrgumentCaptor.getValu
        // then(todoService).should().retrieveTodos(stringSrgumentCaptor.capture());
        // assertEquals("Dummy", stringSrgumentCaptor.getValue());

        then(todoService).should(Mockito.times(2)).retrieveTodos(stringSrgumentCaptor.capture());
        assertTrue(stringSrgumentCaptor.getAllValues().contains("abc"));
        assertTrue(stringSrgumentCaptor.getAllValues().contains("Dummy"));


    }


}