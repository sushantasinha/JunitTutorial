Mock static method: using power mock. Means a method, is calling static method, which we will mock using power mock
****

```
@RunWith(PowerMockRunner.class)
@PrepareForTest({CollaboratorWithStaticMethods.class}) //Class name where the Static method is present. Fully qualified class name i.e. incl package name ()
public class PowerMockCallsTest {
......
}

```

The fullyQualifiedNames element in the @PrepareForTest annotation represents an array of fully qualified names of types we want to mock. 
In this case, we use a package name with a wildcard to tell PowerMockito to prepare all types within 
the com.abc.powermockito.introduction package for mocking.

Power mock does not support junit 5, so, we need junit dependency. 


Please refer JunitTutorials project for details   (also check powermock readme.md once)


static method test: Nothing special, can do using normal junit only (mockito or powermock not needed)  
static method mock: Power Mock (Mockito now allowing to mock, but there is no example i used)  
Previous to version 3.4.0 of Mockito, it wasn't possible to mock static methods directly — only with the help of PowerMockito.  
Now mockito is allowed to mock static method  





static method test: Nothing special, can do using normal junit only (mockito or powermock not needed)  
static method mock: Power Mock (Mockito now allowing to mock, but there is no example i used)  
Previous to version 3.4.0 of Mockito, it wasn't possible to mock static methods directly — only with the help of PowerMockito.  
Now mockito is allowed to mock static method.  



Private method test: Using power mock. Using Whitebox.invokeMethod(...)  
Private method mock: Using power mock. Usig spy() and when().then() reflection.  


final method test: Nothing special, can do using normal junit only (mockito or powermock not needed)  
final method mock: (Mockito: Cannot mock final methods), need to use Power Mock  
 
constructor mocking: Power Mock. Using whenNew()  

Partial mocking possible for static, final and private methods. power mock can be used with @spy  

Mocking for private method, static method and constructor is bad design.  


### TODO: mutation test
### TODO: flapdrool








