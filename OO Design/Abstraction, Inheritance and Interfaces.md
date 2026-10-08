## Abstraction
- The abstract keyword in Java is used to declare a class or a method that cannot be instantiated directly or must be implemented by subclasses, respectively. The purpose of an abstract class is to function as a base for subclasses.
``` 
public abstract class MyAbstractClass {
}
```
## Inheritance 
- Inheritance is a fundamental concept in object-oriented programming where a new class (called a subclass or derived class) acquires properties and behaviors from an existing class (called a superclass or base class). This allows for code reuse and the creation of hierarchical relationships between classes, promoting a more organized and maintainable codebase. The subclass can extend the superclass by adding new attributes and methods or overriding existing ones.
```
public class Vehicle {
    protected String licensePlate = null;

    public void setLicensePlate(String license) {
        this.licensePlate = license;
    }
}
public class Car extends Vehicle { // "extends" works to inherit from superclass
    int numberOfSeats = 0;

    public String getNumberOfSeats() {
        return this.numberOfSeats;
    }
}
```

## Interface
- A _Java_ _interface_ is a bit like a **Java class**, except a Java interface can only contain method signatures and fields. A Java interface is not intended to contain implementations of the methods, only the signature (name, parameters and exceptions) of the method. However, it is possible to provide default implememntations of a method in a Java interface, to make the implementation of the interface easier for classes implementing the interface.
## Interfaces vs Inheritance 
- Inheritance is intended to allow you to share an implementation.
- while an interface specifies that you must implement something, but supply your own logic.
### Interface 
- Can extend one or more interfaces 
- cannot implement anything.
- Specifies behaviour, usually shares no implementation.
### Inheritance 
- Can extend only direct superclass.
- Can implement one or more interfaces 
- Shares implementation.
## super, this, private, protected 
### super
- `super` is a keyword that refers to the super-class object(as opposed to **this**, which refers to 'self)
- It is used to call superclass methods, and to access the superclass constructor.

The most common use of the `super` keyword is to eliminate the confusion between superclasses and subclasses that have methods with the same name.
### private
- A super class `private` fiels cannot be accessed directly by a subclass. Must use the super class methods 
### protected
The `protected` keyword is an access modifier used for attributes, methods and constructors, making them accessible in the same package and subclasses.
### super() constructor 
- The subclass must call the superclass constructor as the first line of its own constructor The inherited fields must be instantiated before the extra fields.
``` 
public class Circle extends Shape {
	private int radius;
	public Circle(int topleftx, int toplefty){
	
		}
}
```
## Overriding methods
- A subclass automatically inherits methods from its superclass
- An overriding method can either:
	- Extend
	- Replace
##  Substitution Principle in Java
- It asserts that objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program. In Java, this principle is often referred to as the Liskov Substitution Principle (LSP).
- **The "L" in SOLID:** It is the third design principle in object-oriented programming.
- **Behavioral Contract:** A subclass must honor the rules, methods, and expectations set by its parent class or interface.
- **No Surprises:** If code works with a parent type, swapping it for a child type should run smoothly without throwing unexpected errors or changing logic
## Converting a superclass to a subclass 



## Upcasting and downcasting
- Upcasting is automatic, whereas downcasting requires a manual cast
	- Upcasting can't fail
	- Downcasting is dangerous
### Downcasting using pattern matching 
- When downcasting you can dynamically check the type using the `instanceof` operator
- Furthermore, pattern matching can conduct the cast for you should  the types match 
```
java
public class Main {
  public static void main(String[] args) {
    Main myObj = new Main();
    System.out.println(myObj instanceof Main); // returns true
  }
}
```
## Dynamic Method Lookup
- При вызове переопределенного метода виртуальная машина динамически находит и вызывает именно ту версию метода, которая определена в подклассе. Данный процесс еще называется dynamic method lookup.[[Polymorphism#Виды полиморфизма в Java|Dynamic]]
