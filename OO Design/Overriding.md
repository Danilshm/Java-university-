## Overriding
- Переопределение метода (аннотация `@Override`) в Java это возможность класса-наследника задать свою реализацию метода, уже описанного в родительском классе. При вызове метода у объекта выполняется версия из его собственного класса, а не из родителя. Так реализуется полиморфизм: один метод `voice()` ведет себя по-разному у Dog, Cat и Snake.

```
public class Animal { 
	public void voice() { 
		System.out.println("Голос!"); 
	} 
}
public class Bear extends Animal { 
	@Override 
	public void voice() { 
		System.out.println("Р-р-р!"); 
	} 
} 
public class Cat extends Animal { 
@Override 
	public void voice() { 
		System.out.println("Мяу!"); 
	} 
} 
public class Dog extends Animal { 
	@Override 
	public void voice() { 
		System.out.println("Гав!"); 
	} 
} 
public class Main { 
	public static void main(String[] args) { 
		Animal animal1 = new Dog(); 
		Animal animal2 = new Cat(); 
		Animal animal3 = new Bear(); 
		animal1.voice(); 
		animal2.voice(); 
		animal3.voice();
	} 
}
```
