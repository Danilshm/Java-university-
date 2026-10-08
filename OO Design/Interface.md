# Interface 
- Выбирайте **интерфейс**, если вам нужно гарантировать определенное поведение для абсолютно разных, не связанных друг с другом классов, или если вы проектируете гибкую архитектуру «на будущее».

```
public interface Movable {
    // Абстрактный метод (public по умолчанию)
    void move();
}
```

```// Класс Автомобиль реализует Movable
public class Car implements Movable {
    private String model;

    public Car(String model) {
        this.model = model;
    }

    @Override
    public void move() {
        System.out.println("Автомобиль " + model + " едет по дороге, крутя колесами.");
    }
}

// Класс Собака тоже реализует Movable
public class Dog implements Movable {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println("Собака " + name + " бежит по траве и виляет хвостом.");
    }
}
```

```
public class Main {
    public static void main(String[] args) {
        // Мы можем записать разные объекты в переменные типа интерфейса
        Movable myCar = new Car("Tesla Model 3");
        Movable myDog = new Dog("Рекс");

        // Или создать массив «движущихся объектов»
        Movable[] objects = { myCar, myDog };

        // И запустить их в цикле, не задумываясь, кто есть кто
        for (Movable obj : objects) {
            obj.move(); 
        }
    }
}
```