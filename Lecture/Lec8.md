# Lecture 08

## Interface

只定义方法不实现方法，规定`implements`该接口的类必须要实现上述方法。

## Overriding and Overloading

Overriding指子类用当前实现覆盖父类中的相同方法，推荐在Overriding函数前添加`@Overrid`标识；

Overloading指实现相同名称，不同参数的方法。

## Extends and Implements

`extends`用于从类继承方法和变量；`implements`用于从接口继承方法名，仅用于从接口生成类。

## Super

使用`super`调用父类的方法；

在构造函数中通常需要首先调用`super()`构造方法。

## Object

所有class都是Object的子类。