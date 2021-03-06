package HomeWork7;

public class HomeWork7 {
    public static void main(String[] args) {
        Cat [] cats = {new Cat("Barsik", 10), new Cat("Tom", 15), new Cat("Rijik", 20)};

        Plate plate = new Plate(0);

        for (Cat c : cats){
            c.info();
        }
        System.out.println();
        plate.info();
        plate.addFood(100);
        plate.info();
        System.out.println("Начинаем кормить котов.");

        for (Cat c : cats){
            c.eat(plate);
            c.info();
            plate.info();
        }
    }
}

class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        food -= n;
        if (food >= n) {
            food -= n;
        }
    }

    public void info(){
        System.out.println("plate: " + food);
    }

    public int getFood(){
        return food;
    }

    public void addFood(int f) {
        food += f;
        System.out.println("В тарелку добавлено: " + f + " еды. Всего еды: " + food);
    }
}
class Cat {
    private String name;
    private int appetite;
    private boolean sit;

    public Cat (String name, int appetite) {
        this.sit = false;
        this.name = name;
        this.appetite = appetite;
    }


    public void info(){
        System.out.println("CAT: " + name + " APPETITE: " + appetite + " SIT: " + sit);
    }

    public void eat (Plate p) {
        if(p.getFood() > appetite);{
            p.decreaseFood(appetite);
            sit = true;
        }
    }
}
