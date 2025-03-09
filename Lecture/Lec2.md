# Lecture 02

`static`方法可以通过`类名.`或`实例.`的形式运行，而非`static`方法必须先创建一个实例再通过该实例运行，又被成为`instance`方法。
`static`方法中不可以使用`instance variables`，因为并没有初始化实例。，但可以访问带有`static`的变量和方法。
带有`static`的变量称作类变量，最好不要改变类变量，作为常量使用。

Java中的数组称为Array，通过`[]`和`new`创建，使用`{}`赋初值，如：
```Java
Dog[] dogs = new Dog[2];
int[] array = {4, 7, 10};
```
数组一旦创建，长度便已确定，不能再修改长度，可以通过instance variable `length`查看数组长度。
使用`Arrays.toString(array)`美观打印数组。
使用`for :`遍历数组：
```Java
int[] array = {1, 2, 3};
for (int i : array) {
    System.out.println(i);
}
```

Java中的可变数组称为ArrayList，支持`add`、`remove`、`set`、`get`等方法，创建时需通过`<>`指明数组中元素类型：
```Java
List<String> lst = new ArrayList<>();
```

Java常用数据结构还有`Set`、`Map`，分别包括`TreeSet`、`HashSet`和`TreeMap`和`HashMap`。
```Java
Set<Integer> set = new HashSet<>();
set.add(1);
set.add(1);
set.add(2);
set.remove(2);
System.out.println(set.size());
if (set.contains(1)) {
    System.out.println("1 in set");
}
for (int elem : set) {
    System.out.println(elem);
}
```
```Java
Map<String, String> map = new HashMap<>();
map.put("hello", "hi");
map.put("hello", "goodbye");
System.out.println(map.get("hello"));
System.out.println(map.size());
if (map.containsKey("hello")) {
    System.out.println("\"hello\" in map");
}
for (String key : map.keySet()) {
    System.out.println(key);
}
```

Java使用`throw`抛出异常：
```Java
throw new Exception("There are no elements in the array!");
```