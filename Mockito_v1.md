If you get ExceptionInInitializerError in the next lecture, Use this dependency instead of mockito-all.


```
<dependency>
  <groupId>org.mockito</groupId>
  <artifactId>mockito-core</artifactId>
  <version>4.0.0</version>
  <scope>test</scope>
</dependency>
```

If you get ExceptionInInitializerError in the next lecture, Use this dependency instead of mockito-all.

```
<dependency>
  <groupId>org.mockito</groupId>
  <artifactId>mockito-core</artifactId>
  <version>4.0.0</version>
  <scope>test</scope>
</dependency>

```


Mock multiple values back
```
@Test
    public void letsMockListSizeWithMultipleReturnValues() {
        List list = mock(List.class);
        Mockito.when(list.size()).thenReturn(10).thenReturn(20);
        assertEquals(10, list.size()); // First Call
        assertEquals(20, list.size()); // Second Call
    }
```

Mockito does not allow a combination of matchers and hard coded value.
when(listMock.subList(anyInt(), 5)).then(...) // not allowed 



