package com.mockito.v2;

import com.sample.mockito.TodoBusinessImpl;
import com.sample.mockito.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DTodoBusinessImplAugCaptureTest {

    @Mock
    TodoService todoService;

    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @Test
    public void testThenCaptureAugumentBDD() {

        List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        when(todoService.retrieveTodos("Dummy")).thenReturn(allTodos);
        todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        then(todoService).should().retrieveTodos(stringArgumentCaptor.capture());
        assertEquals("Dummy", stringArgumentCaptor.getValue());

        then(todoService).should().retrieveTodos(stringArgumentCaptor.capture());
        assertEquals("Dummy", stringArgumentCaptor.getValue());

        /*Mockito.verify(todoService).retrieveTodos(stringSrgumentCaptor.capture());
        assertEquals("Dummy", stringSrgumentCaptor.getValue());*/

    }

}
