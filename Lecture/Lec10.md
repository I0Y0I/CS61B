# Lecture 10

## Iterator

```java
for (int x : javaset) {
    System.out.println(x);
}
```

is short for

```java
Iterator<Integer> seer = javaset.iterator();
while (seer.hasNext()) {
    System.out.println(seer.next());
}
```

为实现这种方法，需要：

* 实现`iterator()`方法，返回一个`Iterator<T>`实例；
* 该`Iterator<T>`实例必须实现`hasNext()`和`next()`；
* 该类必须派生`Iterable<T>`类；（仅使用`:`时需要）

完整示例如下：

```java
public class ArraySet<T> implements Iterable<T> {
   /** returns an iterator (a.k.a. seer) into ME */
   public Iterator<T> iterator() {
       return new ArraySetIterator();
   }

   private class ArraySetIterator implements Iterator<T> {
       private int wizPos;

       public ArraySetIterator() {
           wizPos = 0;
       }

       public boolean hasNext() {
           return wizPos < size;
       }

       public T next() {
           T returnItem = items[wizPos];
           wizPos += 1;
           return returnItem;
       }
   }
}
```

## `toString()`方法

`System.out.println()`会调用`Object`的`toSting()`方法，对于类实例默认打印所在地址，如果需要其他形式应override `toString` 方法。

Java中使用`+=`拼接字符串效率很低，应当使用`StringBuilder`类辅助构建：

```java
StringBuilder returnSB = new StringBuilder("{");
returnSB.append(x);
return returnSB.toString();
```

或者使用`String.join()`方法

```java
@Override
public String toString() {
   List<String> listOfItems = new ArrayList<>();
   for (T x : this) {
       listOfItems.add(x.toString());
   }
   return "{" + String.join(", ", listOfItems) + "}";
}
```

## `equals(Object)`方法

Java中的`==`并不调用`equals`方法，而仅是比较地址是否相同，类似python的`is`。

常见模板

```java
@Override
public boolean equals(Object other) {
   // 首先比较是否为同一实例，节省时间
   if (this == other) { return true; }

   // 使用instanceof进行类型转换，如果不是该类型则不进行类型转换
   if (other instanceof ArraySet otherSet) {
       if (this.size != otherSet.size) { return false; }
       for (T x : this) {
           if (!otherSet.contains(x)) {
               return false;
           }
       }
       return true;
   }
    
   return false;
}


```



