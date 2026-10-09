# Method chaining
- Method chaining (цепочка вызовов методов) в Java — это подход, при котором несколько методов вызываются последовательно на одном и том же объекте в одной строке кода

### Как это работает
- Чтобы цепочка работала, каждый метод в ней должен возвращать ссылку на текущий объект (return this;) или новый объект, над которым можно выполнить следующий вызов.
- Пример классического класса с Method chaining (например, паттерн Builder):
``` 
public class User {
    private String name;
    private int age;

    public User setName(String name) {
        this.name = name;
        return this; // возвращаем ссылку на этот же объект
    }

    public User setAge(int age) {
        this.age = age;
        return this; // снова возвращаем this
    }
}

// Использование:
User user = new User().setName("Иван").setAge(25);
```

```
String result = new StringBuilder()
    .append("Привет, ")
    .append("мир!")
    .toString();
    
List<String> list = List.of("а", "б", "в");
list.stream()
    .filter(s -> !s.isEmpty())
    .map(String::toUpperCase)
    .forEach(System.out::println);

```


## Плюсы:
- Код становится более компактным и читаемым (в стиле "текучего" интерфейса — fluent interface).
- Меньше промежуточных переменных.
## Минусы:
-  Сложнее отладка (debug): при возникновении NullPointerException в длинной цепочке a().b().c().d() бывает трудно сразу понять, какой именно метод вернул null.
- Нарушение принципов инкапсуляции или рост связанности, если методы изменяют состояние объекта неявным образом.
