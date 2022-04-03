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

Disadvantages of Stub:
1.Say the object which we want to stub, want to test with multiple value, then we need to sebd multiple values separately
2. If new method we added, need to create new method in Stub as well

Basically in Stub we preparing a dummy obj and passing as method param
In Mock we creating mock and using java reflection


GIVEN-WHEN-THEN -> this is the way to write junit with mock, this is base of BDD


//hamcrest

Help to test readable:

```
assertThat(scores, hasSize(4));
assertThat(scores, hasItems(100, 101));
assertThat(scores, everyItem(greaterThan(90)));
assertThat(scores, everyItem(lessThan(
// String
assertThat("", isEmptyString());
assertThat(null, isEmptyOrNullString());
```




Mockito Annotations
@Mock
@InjectMocks
@RunWith(MockitoJUnitRunner.class)
@Captor


__



