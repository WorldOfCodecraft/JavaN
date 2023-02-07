# Java New Features

A comprehensive collection of Java code snippets curated for developers seeking practical solutions to common
programming challenges. This repository serves as a trusted resource, offering a vast array of battle-tested code
examples that harness the power and versatility of the Java programming language.

## Tech Stack

**Lambda:** Comparator, predicate, consumer, function, predicate's boxunbox

**Server:** Node, Express

## Documentation

## Lambda
Lambda expressions are a significant addition to the Java programming language, introduced in Java 8. They provide a
concise way to represent anonymous functions or code blocks, allowing you to pass behavior as an argument to methods or
store them in variables. Lambda expressions are particularly useful when working with functional interfaces, which are
interfaces with a single abstract method.

Lambda expressions are commonly used with functional interfaces such as Comparator, Predicate, Consumer, and Function.
Here's an overview of these functional interfaces and how they can be used with lambda expressions:

### Comparator: The Comparator interface provides a way to compare two objects of a particular type. It is commonly used for
sorting and ordering collections. Lambda expressions can be used to define the comparison logic in a concise manner. For
example:

```java
List<String> names=Arrays.asList("Alice","Bob","Charlie");
        Collections.sort(names,(a,b)->a.compareTo(b));
```

### Predicate: The Predicate interface represents a condition that can be evaluated to true or false for a given input. It
is often used for filtering elements in a collection. Lambda expressions can be used to define the condition in a
compact form. For example:

```java

List<Integer> numbers=Arrays.asList(1,2,3,4,5);
        List<Integer> evenNumbers=numbers.stream().filter(n->n%2==0).collect(Collectors.toList());
```

### Consumer: The Consumer interface represents an operation that takes an input but does not return any result. It is
typically used for performing actions on objects or elements. Lambda expressions can be used to define the operation to
be performed. For example:

```java

List<String> names=Arrays.asList("Alice","Bob","Charlie");
        names.forEach(name->System.out.println("Hello, "+name));
```

### Function: The Function interface represents a function that takes an input of one type and produces a result of another
type. It is commonly used for transforming or mapping values. Lambda expressions can be used to define the function's
logic. For example:

```java

List<Integer> numbers=Arrays.asList(1,2,3,4,5);
        List<Integer> squaredNumbers=numbers.stream().map(n->n*n).collect(Collectors.toList());
```

### When it comes to boxing and unboxing with predicates, Java's auto-boxing and auto-unboxing features automatically
convert between primitive types and their corresponding wrapper types (e.g., int to Integer). This behavior also applies
to functional interfaces such as Predicate. For example, if you have a Predicate<Integer>, you can pass it an int value
directly without explicitly converting it to an Integer object.

```java

Predicate<Integer> isPositive=(Integer n)->n>0;
        boolean result=isPositive.test(5); // Auto-boxing: int to Integer
```

Similarly, when the result of a Predicate is used in a context that expects a primitive boolean value, Java performs
auto-unboxing to convert the Boolean wrapper type to the primitive boolean type.

```java

Predicate<Integer> isEven=(Integer n)->n%2==0;
        if(isEven.test(6)){ // Auto-unboxing: Boolean to boolean
// Do something
        }
```
## Stream

Lambda expressions and functional interfaces provide powerful ways to write more concise and expressive code in Java,
making it easier to work with functional programming concepts.

Java's Stream API is a powerful feature introduced in Java 8 that provides a functional programming approach to process collections of data. Streams allow you to perform operations on collections in a declarative and concise manner, enabling you to write more expressive and readable code.

Here are the key characteristics and features of Java Streams:

1. Stream Creation: Streams can be created from various data sources, including collections, arrays, and I/O channels. You can use the stream() or parallelStream() methods provided by collections to obtain a stream.

2. Pipelining: Stream operations can be chained together to form a pipeline. This allows you to perform a series of operations on the elements of a stream in a single expression. Stream operations are divided into two categories: intermediate and terminal operations.

3. Intermediate Operations: Intermediate operations are operations that transform or filter the elements of a stream. Examples include filter(), map(), flatMap(), distinct(), sorted(), and limit(). Intermediate operations are lazy, meaning they are not executed until a terminal operation is invoked on the stream.

4. Terminal Operations: Terminal operations are operations that produce a result or a side effect. They trigger the processing of the elements in the stream. Examples of terminal operations include forEach(), collect(), reduce(), count(), min(), max(), anyMatch(), allMatch(), and noneMatch().

5. Lazy Evaluation: Streams use lazy evaluation, which means that elements are processed on-demand as they are needed. This allows for efficient processing, especially with large datasets or infinite streams.

6. Parallel Processing: Streams can be executed in parallel by invoking the parallelStream() method instead of stream(). This enables concurrent processing of elements, leveraging multiple threads to potentially improve performance on multi-core systems. However, parallel streams require careful consideration and understanding of thread safety and potential synchronization issues.

7. Reduction Operations: Streams provide powerful reduction operations such as reduce(), collect(), and summarizing() that allow you to combine elements of a stream into a single value or container.

8. Stream APIs: The Stream API provides additional features like Optional, Predicate, Comparator, and various helper methods to facilitate stream operations. These APIs work seamlessly with streams, enabling you to perform complex operations on data easily.

Streams offer a more functional and expressive approach to processing collections in Java. They promote code readability, maintainability, and allow for better utilization of modern multi-core processors. By leveraging streams, you can write code that is more concise, declarative, and efficient when dealing with collections and data processing operations.