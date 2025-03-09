# Lecture 01

Java中所有的代码都应该写在类中，主函数写在`public static void main(String[] args)`中。
```Java
// 
public class HelloNumbers {
   public static void main(String[] args) {
      x = 0;
      while (x < 10) {
         System.out.println(x);
         x = x + 1;
      }
   }
}
```

`.java`代码需要先经过`javac`编译为`.class`二进制文件，再通过`java`执行。
Java类结构，请参照：
```Java
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
```

Java中的变量需要先声明再使用，声明时需要注明变量的类型，变量的类型已经生成，便无法改变。
```Java
int i = 0;
```
Java常用类型：
* `boolean`: `true` or `false`；
* `int`: 除数字外，还有`max`和`min`可用；
* `double`
* `String`：使用`""`创建；
* `char`：使用`''`创建。

单行注释可用`#`或`//`，多行注释可用`/*    */`。
