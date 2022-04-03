package com.mockito.v2;

import com.sample.mockito.TodoBusinessImpl;
import com.sample.mockito.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CTodoBusinessImplWIthInjectMockWithAnnotationTest {

    @Mock
    TodoService todoService;

    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;

    @Test
    public void usingMockito() {

        //Given
        //TodoService todoService = mock(TodoService.class);: No need as added @Mock

        List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        when(todoService.retrieveTodos("dummy")).thenReturn(allTodos);

        //TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);: No need as added @InjectMocks

        //When
        List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("dummy");

        //Then
        assertEquals(2, todos.size());
    }

}
