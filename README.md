# Repository for the subject Software development on the Java platform
## Author: Danylo Yablonskyi
## Group: IA-24
<br>

## Instructions for laboratory works
- [Lab 1](#lab-1)
- [Lab 2](#lab-2)
- [Lab 3](#lab-3)
- [Lab 4](#lab-4)
<br>
<br>

## Lab 1

### Source code 
[https://github.com/yablonya/JavaSoftwareCourse/blob/master/Lab1/src/Main.java](https://github.com/yablonya/JavaSoftwareCourse/blob/master/Lab1/src/Main.java)

### How to use
In method `main` set your matrices in variables `matrix1` and `matrix2`
```java
byte[][] matrix1 = {
                    {1, 40, 2},
                    {16, 12, 6},
                    {7, 5, 9}
                   };

byte[][] matrix2 = {
                    {9, 8, 7},
                    {6, 5, 4},
                    {3, 2, 1}
                   };
```
and then run your code
<br>
<br>
<br>

## Lab 2

### Source code 
[https://github.com/yablonya/JavaSoftwareCourse/blob/master/Lab2/src/Main.java](https://github.com/yablonya/JavaSoftwareCourse/blob/master/Lab2/src/Main.java)

### How to use
In method `main`, in `try` block find variable `text` and set the text that you want to procces
```java
String text = "*your text*";
```
and then run your code
<br>
<br>
<br>

## Lab 3

### Source code 
[https://github.com/yablonya/JavaSoftwareCourse/tree/master/Lab3/src](https://github.com/yablonya/JavaSoftwareCourse/tree/master/Lab3/src)

### How to use
Go to the `Main` class, in method `main` find variable `blocks` and set all building blocks that you want to procces
```java
BuildingBlock[] blocks = {
                // First param - name, second - color, third - hardness, fourth - weight, fifth - durability
                new BuildingBlock("Wood", "Brown", 2.5, 1.5, 50),
                new BuildingBlock("Pine", "Brown", 2.5, 2, 50),
                new BuildingBlock("Stone", "Gray", 6.0, 3.0, 200),
                new BuildingBlock("Iron", "Silver", 7.0, 4.5, 300),
                new BuildingBlock("Gold", "Yellow", 5.0, 4.0, 100),
        };
```
Then go down below, find variable `searchBlock` and set a block identical to the one you want to find in the previously specified blocks
```java
BuildingBlock searchBlock = new BuildingBlock("Gold", "Yellow", 5.0, 4.0, 100);
```
and then run your code
<br>
<br>
<br>

## Lab 4

### Source code 
[https://github.com/yablonya/JavaSoftwareCourse/tree/master/Lab4/src](https://github.com/yablonya/JavaSoftwareCourse/tree/master/Lab4/src)

### How to use
Go to the `Main` class, in method `main` find variable `originalText` and set a text that you want to procces
```java
String originalText = "Вже давно відомо, що читабельний зміст буде заважати зосередитись людині..."
```
and then run your code
