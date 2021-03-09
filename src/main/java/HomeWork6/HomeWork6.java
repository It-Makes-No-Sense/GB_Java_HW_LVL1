package HomeWork6;

public class HomeWork6 {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 100,1);
        Cat cat1 = new Cat("Sosiska", 201,0);
        Dog dog = new Dog("Sharik",300,5);
        Dog dog1 = new Dog("Laika",501,10);
        Dog dog2 = new Dog("Martin",100,11);

        //Тест Собак
        System.out.println("DOGS:");
        dog.run();
        dog.swim();
        System.out.println();

        dog1.run();
        dog1.swim();
        System.out.println();

        dog2.run();
        dog2.swim();
        System.out.println();

        //Тест котов
        System.out.println("CATS:");
        cat.run();
        cat.swim();
        System.out.println();

        cat1.run();
        cat1.swim();
    }
}

abstract class Animal {
    abstract void run();
    abstract void swim();
}

class Dog extends Animal{
    public String name;
    public int lenRun;
    public final int maxRun = 500;
    public int lenSwim;
    public final int maxSwim = 10;

    public Dog (String name, int lenRun,int lenSwim){
        this.name = name;
        this.lenRun = lenRun;
        this.lenSwim = lenSwim;
    }

    public void run() {
        if (lenRun <= maxRun && lenRun >= 0) {
            System.out.println(name + " пробежал(а) " + lenRun + " м.");
        } else {
            System.out.println(name +" не может столько пробежать. (от 0 до 500 м)");
        }
    }

    public void swim(){
        if (lenSwim <= maxSwim && lenSwim >= 0) {
            System.out.println(name + " проплыл(а) " + lenRun + " м.");
        } else {
            System.out.println(name + " не может столько проплыть. (от 0 до 10 м)");
        }
    }
}

class Cat extends Animal{
    public String name;
    public int lenRun;
    public final int maxRun = 200;
    public int lenSwim;

    public Cat (String name, int lenRun,int lenSwim){
        this.name = name;
        this.lenRun = lenRun;
        this.lenSwim = lenSwim;
    }

    public void run() {
        if (lenRun <= maxRun && lenRun >= 0) {
            System.out.println(name + " пробежал(а) " + lenRun + " м.");
        } else {
            System.out.println(name + " не может столько пробежать. (от 0 до 200 м)");
        }
    }

    public void swim(){
        System.out.println("Коты/Кошки не умеют плавать.");
    }
}