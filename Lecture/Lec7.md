# Lecture 07

## 泛型数组

不能直接创建泛型数组

```java
new TYPE[cap]
```

会导致`generic array creation`错误，可以使用

```java
(TYPE[]) new Object[cap];
```

创建，会有warning，但可以忽略。