@BeforeAll / @AfterAll
@BeforeEach / @AfterEach

```
 @Test
    public void test1() {
        int[] expected = {1, 2, 3, 4};
        int[] actual = {1, 2, 3, 4};
        //assertEquals(expected, actual); -> will fail, as it is compring obj to obj but as these are diff obj, failing. 
        //To compare values within 2 arrays, need to use assertArrayEquals()
        assertArrayEquals(expected, actual);

    }

```


junit timeout test
```
@Test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    void exceptionTesting() {
        for (int i =0; i < 10000; i++) {
            System.out.println(i);
        }
    }
```

If we want to migrate this test to JUnit 5, we need to replace the @RunWith annotation with the new @ExtendWith:

Junit Parameterized Test:

```
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


```

Test Suite:
I think, siute class should be in parent package or in the same package where the class is present

```
@SelectPackages({"com.sample"})
//@IncludeTags("production")
@Suite
@SuiteDisplayName("A demo Test Suite")
public class JUnit5TestSuiteExample {

}
```

@SelectPackages
@SelectPackages specifies the names of packages to select when running a test suite via @RunWith(JUnitPlatform.class).
```
@Suite
@SelectPackages({"com.howtodoinjava.junit5.examples.packageA",
                     "com.howtodoinjava.junit5.examples.packageB"})
public class JUnit5TestSuiteExample
{
}
```

@SelectClasses
@SelectClasses specifies the classes to select when running a test suite via @RunWith(JUnitPlatform.class).


@IncludePackages and @ExcludePackages
As we learn that @SelectPackages causes all its sub-packages as well to be scanned for test classes.

If you want to exclude any specific package or include any package then you may use @IncludePackages and @ExcludePackages annotations.


@IncludeClassNamePatterns 
@ExcludeClassNamePatterns

@IncludeTags Example
This test suite will run all tests tagged with production inside package com.howtodoinjava.junit5.examples (and its sub-packages).

```
@Suite
@SelectPackages("com.howtodoinjava.junit5.examples")
@IncludeTags("production")
public class JUnit5TestSuiteExample
{
}
```


@ExcludeTags Example
This test suite will exclude all tests tagged with development inside package com.howtodoinjava.junit5.examples (and it’s sub-packages).

[Mockito V1](Mockito_v1.md)



  