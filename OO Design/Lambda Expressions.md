# # Lambda Expressions
- Лямбда-выражения в языке Java представляют набор инструкций, которые можно выделить в отдельную переменную и затем многократно вызвать в различных местах программы.
- Для создания лямбда-выражения применяется лямбда-оператор (стрелка ->). Этот оператор разделяет лямбда-выражение на две части
	- `(параметры) -> действия`
```
public class Program {
    public static void main(String[] args) {
        Operationable op;
        
        op = (x,y)->x+y;
        
        int result = op.execute(10, 20);
        
        System.out.println(result); //30

    }
}
interface Operationable{

    int execute(int x, int y);
}
```

```
public class Program {

    public static void main(String[] args) {

        Printable printer = message -> System.out.println(message);

        printer.print(``"Hello World"``);

        printer.print(``"Hello Work"``);

    }  

}

interface Printable{

    void print(String message);

}
```

```
// Старый вариант (анонимный класс)
Runnable task1 = new Runnable() {
    @Override
    public void run() {
        System.out.println("Привет");
    }
};

// Новый вариант (лямбда-выражение)
Runnable task2 = () -> System.out.println("Привет");
task2.run();

```