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
- super is a keyword that refers to the super-class object(as opposed to **this**, which refers to 'self)
- It can be used to access the super class constructors and methods. super(), super.toString() super.cost()
### private
- A super class private fiels cannot be accessed directly by a subclass. Must use the super class methods 
### protected


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