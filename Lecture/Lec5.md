# Lecture 05

## 双向链表

* 方案一，尾部添加哨兵；Add an additional sentBack sentinel at the end of the list.
* 方案二，将尾部作为头哨兵的前一个元素；（更好，因为不会添加新的特殊case）Make your linked list circular with a single sentinel in the middle.

## 泛型

使用`<LochNess>`进行泛型占位；

当传入类型时，需要使用类型的reference type：

* int: Integer
* double: Double
* char: Character
* boolean: Boolean
* long: Long

