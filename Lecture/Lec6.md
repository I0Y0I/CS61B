# Lecture 06

 ## Test-Driven Development

解决问题时，首先编写各种情况下的测试，随后编写代码使这些测试通过。

* Identify a new feature.
* Write a unit test for the feature.
* Run the test. It should fail. (RED)
* Write code that passes test. (GREEN)
* Refactor code to make it faster, cleaner, etc. (YELLOW)

## Unit Test

```java
@test
public void test() {
    int input = {};
    int output = method(input);
    assertThat(output).isEqualTo(answer);
}
```

