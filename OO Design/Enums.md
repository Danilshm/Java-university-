# Enums 
- A _Java Enum_ is a special Java type used to define collections of constants. More precisely, a Java enum type is a special kind of Java class. An enum can contain constants, methods etc. Java enums were added in Java 5.
```
public enum Level {
    HIGH,
    MEDIUM,
    LOW
}
Level level = Level.HIGH;
if( level == Level.HIGH) {
} else if( level == Level.MEDIUM) {
} else if( level == Level.LOW) {
}
```