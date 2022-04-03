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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ESpyTest {



    @Test
    public void spyTest() {

        List<String> arrayListSpy = spy(ArrayList.class);
        assertEquals(0, arrayListSpy.size());
        arrayListSpy.add("Dummy");
        assertEquals(1, arrayListSpy.size());
        assertEquals("Dummy", arrayListSpy.get(0));//Other method will work as is, because we did not override it
        verify(arrayListSpy, never()).clear();//CHeck clear() method of arraylist is never called


        List<String> arrayListMock = mock(ArrayList.class);
        assertEquals(0, arrayListMock.size());
        arrayListMock.add("Dummy");//DOES NOT matter of this with MOCK, if it is spy, then it has meaning, rather use when().then() when using mock()
        assertEquals(0, arrayListMock.size());

        List<String> arrayListMock1 = mock(ArrayList.class);
        assertEquals(0, arrayListMock1.size());
        when(arrayListMock1.size()).thenReturn(1);
        assertEquals(1, arrayListMock1.size());
        //assertEquals("Dummy", arrayListMock1.get(0));//As it is mock(), need to override .get() as well to get expected value

    }

}
