## Tangible
- physical presence.
•Has some properties and behaviour.
![[Pasted image 20260921111850.png|403]]
## Intangible objects
- Most objects are tangible – i.e. we can physically touch them.
- There are however also intangible objects.
- For example think of a job, a student loan, a course of study, air, memory in computer.
- its something u cant touch
## Software objects
- Computer systems do not run themselves; programming languages need to be written to provide suitable software.
- Objects in computer programming allow real life problems to be solved by modelling real tangible or intangible objects.
- Objects can interact through their behaviour(s), altering the state of their properties.
## How do we model software objects?
### Objects have:
- Properties, which we model with data variables.
- Behaviour, which we model with functions.
### In OO jargon, these are called:
- Fields (to store the data)
- Methods (to carry out the actions).
## Interesting facts 
- In the early 1970s it was recognised that a large proportion of budgets were spent on software maintenance and little on hardware or new software development.
- Hardware components were sharable and reusable, whereas software procedures were often not so.
- In OO programming, systems can be designed and evolved with self-contained, reusable objects.
## A Class is a template for Objects
- The software model for objects of the same type is programmed in a structure called a class
### A class defines:
- The fields of the object
- The methods of the object.
- It also defines one or more constructors – these are special methods that allow objects to be created.
![[Pasted image 20260921112754.png|299]]
## An Object is an instance of a Class
- When we want to create an object in our program, we invoke the constructor method defined by the class template.
- An instance of the class is created with an initial state. Each time the constructor is invoked we get another new object instance.
- When we use the word 'object' we normally mean an instance of a class.
## Objects and Classes 
- •A class is a data type; it specifies and provides a basis for creating and using objects.
![[Pasted image 20260921113319.png|636]]
## Using existing Classes
- There are over 4500 classes in the Java 17 SE SDK
- The Java platform organises this class library into modules containing packages of related classes.
- Packages may simply be thought of as separate storage locations, allowing us to find classes we need.
- Example packages: java.lang, java.util, java.io, etc.
## Some classes in the Java SDK
### String – models words and sequences of characters
- Fields: array of char, length of string
- Methods: numerous String operations
### System – models the runtime environment.
- Fields: in - keyboard; out - display
- Methods: currentTime, get environment variables, exit, etc
### Integer – models an int value as an object
- Fields: the int value
- Methods: conversion to/from other types
### Scanner – models a text reader
- Fields: a buffer of input characters.
- Methods: read text as number values or strings

## The Java Platform Application Programming Interface (API)
- The Java API specification contains a list of all packages and their contained classes – providing exclusive documentation on:
- How we use classes and their public interface.
- How methods will behave – what they do, their return value, their parameter list.
## Primitive v Reference types
•Consider the two variable declarations:
~~~
int x;
String s;
~~~
- The primitive type declaration will reserve 4 bytes in memory to store a value of that type.
- The reference type declaration will allocate enough memory to store a reference (i.e. memory address).
- Now consider the two variable initialisations:
~~~
x = 5;
s = new String("Hello");
~~~
- The primitive type initialization stores the value 5 inside the memory location that x refers to.
- The reference type initialization stores a reference to the object created by the String class's constructor inside the memory location that s refers to.
## The new operator
### The new operator is a reserved keyword and has the following purpose:
	- Instantiates a class by allocating memory for a new object.
	- Returns a reference to that memory.
	- Invokes the object's constructor.
- "Instantiating a class" means the same thing as "creating an object".
- When you create an object you are creating an "instance" of a class, therefore "instantiating" it.
## Constructing objects
- A class defines 1 or more constructors.
- When a constructor is called, it will initialise the internal state (i.e. fields) of the object instance.
- Values may be provided to the constructor as arguments, otherwise, default values will be used to initialise fields.
## Calling methods
- A class defines a public interface, which is a set of methods, most commonly used to access or modify the internal state of an object.
- Calling (or invoking) a method causes a message to be sent to the receiver object.
- A method is in essence a function, it has a return type, name and a parameter-list.
## Calling methods example 
~~~ 
String name = new String("Luke Attwood");

char c = name.charAt(3);

int len = name.length();

System.out.println("Hello: " + name);
~~~
	- A method is invoked on an object by using the dot (.) notation
