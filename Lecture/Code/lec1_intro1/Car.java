package lec1_intro1;

public class Car {
    String model;
    int wheels;

    public Car(String m) {
        this.model = m;
        this.wheels = 4;
    }

    public String getModel() {
        return model;
    }

    public int getWheels() {
        return wheels;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public void drive() {
        if (this.wheels < 4) {
            System.out.println(this.model + " is broken.");
            return;
        }
        System.out.println(this.model + " goes vroom.");
    }

    public static void main(String[] args) {
        Car c;

        c = new Car("BYD");
        c.drive();
        c.setWheels(2);
        c.drive();
    }
}
