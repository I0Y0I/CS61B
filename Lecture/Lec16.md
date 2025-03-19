# Lecture 16

## Java内置数据结构

* List：包括LinkedList、ArrayList；
* Set：包括HashSet、TreeSet；
* Map：HashMap、TreeMap；

这些数据结构都是Collection的派生类。

## BST

二分搜索数，每个节点都有两个子树，左子树中的每一个元素都比当前树小，右子树中的每一个元素都比当前树大。

### Find

```Java
static BST find(BST T, Key sk) {
   if (T == null)
      return null;
   if (sk.equals(T.key))
      return T;
   else if (sk ≺ T.key)
      return find(T.left, sk);
   else
      return find(T.right, sk);
}
```

### Insert

```Java
static BST insert(BST T, Key ik) {
  if (T == null)
    return new BST(ik);
  if (ik ≺ T.key)
    T.left = insert(T.left, ik);
  else if (ik ≻ T.key)
    T.right = insert(T.right, ik);
  return T;
}
```

