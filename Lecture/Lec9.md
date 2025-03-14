# Lecture 09

## 可比较类

对于可比较的类，可以implements内置的`Comparable<>`类，类中的比较方法可以implements内置的`Comparator<>`类，例如：

```java
public class Dog implements Comparable<Dog> {
  private String name;
  private int size;
    
  public int compareTo(Dog uddaDog) {
      return this.size - uddaDog.size;
  }

  public static class NameComparator implements Comparator<Dog> {
      public int compare(Dog d1, Dog d2) {
          return d1.name.compareTo(d2.name);
      }
  }
  ...
}
```

使用方法为：

```java
Comparator<Dog> cd = new Dog.NameComparator();
if (cd.compare(d1, d3) > 0) {
    d1.bark();
} else {
    d3.bark();
}
```

这样就可以使用`Comparable`参数的比较函数。

## Java声明哲学

当使用一个Class作为Interface的实现形式时，应当将变量声明为接口，如

```java
List<Intefer> L = new LinkedList<>()
```

在这种情况下，Java只允许使用List公有的方法，方便更换List的实现形式。

## final

使用`final`声明变量，变量一旦被赋值便无法再更改：

```java
final int x = 0;
x = 1; // Will not compile
```

## protected

* `public`声明的变量可以被任何类访问；
* `private`声明的变量仅可以被当前类访问，该类的派生类也无法访问该变量；
* `protected`声明的变量可以被当前类和该类的派生类访问。