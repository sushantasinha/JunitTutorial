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


If you are using Junit version < 5, so you have to use @RunWith(SpringRunner.class) or @RunWith(MockitoJUnitRunner.class) etc.
If you are using Junit version = 5, so you have to use @ExtendWith(SpringExtension.class) or @ExtendWith(MockitoExtension.class) etc.

SpringRunner  
MockitoJUnitRunner  
SpringExtension  
MockitoExtension  


### What is the difference between @ExtendWith(SpringExtension.class) and @ExtendWith(MockitoExtension.class)?

#### When involving Spring:
If you want to use Spring test framework features in your tests like for example @MockBean, then you have to use @ExtendWith(SpringExtension.class). It replaces the deprecated JUnit4 @RunWith(SpringJUnit4ClassRunner.class)

#### When NOT involving Spring:
If you just want to involve Mockito and don't have to involve Spring, for example, when you just want to use the @Mock / @InjectMocks annotations, 
then you want to use @ExtendWith(MockitoExtension.class), as it doesn't load in a bunch of unneeded Spring stuff. It replaces the deprecated JUnit4 @RunWith(MockitoJUnitRunner.class).

#### To answer your question:

Yes you can just use @ExtendWith(SpringExtension.class), but if you're not involving Spring test framework features in your tests, then you probably want to just use @ExtendWith(MockitoExtension.class).


Instead of using 
```
 TodoService todoService = mock(TodoService.class);
```

We can use:
```
@ExtendWith(MockitoExtension.class)
public class TodoBusinessImplWIthMockWithAnnotationTest {

    @Mock
    TodoService todoService;

    ......

}
```

Please note, if we use @Mock, then need @ExtendWith(MockitoExtension.class) to be added 


@Mock vs @InjectMock

```
ExtendWith(MockitoExtension.class)
public class CTodoBusinessImplWIthInjectMockWithAnnotationTest {

    @Mock
    TodoService todoService;

    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;

    @Test
    public void usingMockito() {

    }
}
```

@InjectMock will allow mockito to check all the instance variables inside TodoBusinessImpl, and check for those members if 
there is any @Mock available. Like, TodoBusinessImpl has one instance member for TodoService...
And, corresponding mock is available in the test class

```
    @Mock
    TodoService todoService;
```

So, it will create an instance for TodoBusinessImpl and for that instance's TodoService, wil be mocked by (@Mock TodoService todoService;)


```
Please note, if we commented out InjectMocks and use normal object creation here, mock will not work as "wordMap" will NOT be mocked.


public class MyDictionary {
    Map<String, String> wordMap;

    public MyDictionary() {
        wordMap = new HashMap<String, String>();
    }
    public void add(final String word, final String meaning) {
        wordMap.put(word, meaning);
    }
    public String getMeaning(final String word) {
        return wordMap.get(word);
    }
}



@ExtendWith(SpringExtension.class)
public class MyDictionaryTest {

    @Mock
    Map<String, String> wordMap;

    //@InjectMocks
    MyDictionary dic = new MyDictionary();

    @Test
    public void whenUseInjectMocksAnnotation_thenCorrect() {
        Mockito.when(wordMap.get("aWord")).thenReturn("aMeaning");
        assertEquals("aMeaning", dic.getMeaning("aWord"));
    }

}


But do we need InjectMock everywhere when usig mock?
No, if we can pass those mock objects somehow (say using constructor), then inject mock not needed

@ExtendWith(SpringExtension.class)
public class MyDictionaryTest {

    @Mock
    Map<String, String> wordMap;

    //@InjectMocks
    //MyDictionary dic = new MyDictionary(wordMap);

    @Test
    public void whenUseInjectMocksAnnotation_thenCorrect() {
        Mockito.when(wordMap.get("aWord")).thenReturn("aMeaning");
        MyDictionary dic = new MyDictionary(wordMap);//IMP
        assertEquals("aMeaning", dic.getMeaning("aWord"));
    }

}

```


ArgumentCaptor allows us to capture an argument passed to a method in order to inspect it. This is especially useful when we can't access the argument outside of the method we'd like to test.
i.e. when we have a local variable within method and we want to validate it.

ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

can be replaced by:
```
    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;
```


```
public class EmailService {

    private DeliveryPlatform platform;

    public EmailService(DeliveryPlatform platform) {
        this.platform = platform;
    }

    public void send(String to, String subject, String body, boolean html) {
        Format format = Format.TEXT_ONLY;
        if (html) {
            format = Format.HTML;
        }
        Email email = new Email(to, subject, body);
        email.setFormat(format);
        platform.deliver(email);
    }

    ...
}


@Test
public void whenDoesSupportHtml_expectHTMLEmailFormat() {
    String to = "info@baeldung.com";
    String subject = "Using ArgumentCaptor";
    String body = "Hey, let'use ArgumentCaptor";

    emailService.send(to, subject, body, true);

    Mockito.verify(platform).deliver(emailCaptor.capture());
    Email value = emailCaptor.getValue();
    assertEquals(Format.HTML, value.getFormat());
}



```





Instead of Junit runner, we can sue rule:

Junit Runner:
```
ExtendWith(MockitoExtension.class)
public class CTodoBusinessImplWIthInjectMockWithAnnotationTest {

}
```

@Rule
public MocktoRule m = MockitoExtension.rule();

The advantage of Rule is we can use multiple rules (MockitoExtension, Spring runner etc) in a single class; unlike Runner, where we can define only one runner.

@spy
If we want to use the real class (instead of mock whole class), but would like to override certain thing from that class, then use @spy


We cannot mock final classes, static methods, final method. Cannot mock equals(), hashcode()
We can mock interface and classes.

Note: thread-safety or thread-safe code in Java refers to code that can safely be utilized or shared in concurrent or 
multi-threading environment and they will behave as expected.


Is Mockito thread-safe?
For healthy scenarios Mockito plays nicely with threads. For instance, you can run tests in parallel to speed up the build. Also, you can let multiple threads call methods on a shared mock to test in concurrent 
conditions. However, Mockito is only thread-safe in healthy tests, that is tests without multiple threads stubbing/verifying a shared mock. 
Stubbing or verification of a shared mock from different threads is NOT the proper way of testing because it will always lead to intermittent behavior. I

Can I verify toString()?
No. You can stub it
  
  Run junit parallel: You can accomplish this with JUnit's ParallelComputer


***We can mock interface and classes.***






