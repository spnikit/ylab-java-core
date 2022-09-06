package com.spnikit.homework2;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class ComplexExamples {

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };
        /*  Raw data:

        0 - Harry
        0 - Harry
        1 - Harry
        2 - Harry
        3 - Emily
        4 - Jack
        4 - Jack
        5 - Amelia
        5 - Amelia
        6 - Amelia
        7 - Amelia
        8 - Amelia

        **************************************************

        Duplicate filtered, grouped by name, sorted by name and id:

        Amelia:
        1 - Amelia (5)
        2 - Amelia (6)
        3 - Amelia (7)
        4 - Amelia (8)
        Emily:
        1 - Emily (3)
        Harry:
        1 - Harry (0)
        2 - Harry (1)
        3 - Harry (2)
        Jack:
        1 - Jack (4)
     */

    public static void main(String[] args) {
        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            System.out.println(person.id + " - " + person.name);
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();

        /*
        Task1
            Убрать дубликаты, отсортировать по идентификатору, сгруппировать по имени

            Что должно получиться
                Key: Amelia
                Value:4
                Key: Emily
                Value:1
                Key: Harry
                Value:3
                Key: Jack
                Value:1
         */

        var result = Arrays.stream(RAW_DATA)
                .distinct() // remove duplicates
                .sorted(comparing(Person::getId)) // sort by id
                .collect(groupingBy(Person::getName, counting())); // group by name


        System.out.println(result);

        /*




        Task2

            [3, 4, 2, 7], 10 -> [3, 7] - вывести пару именно в скобках, которые дают сумму - 10
         */

        System.out.println("**********************Task 2**********************");


        int[] array = {3, 4, 2, 7};

        printValuesWhichSumEqualsTo(array, 10);




        /*
        Task3
            Реализовать функцию нечеткого поиска

                    fuzzySearch("car", "ca6$$#_rtwheel"); // true
                    fuzzySearch("cwhl", "cartwheel"); // true
                    fuzzySearch("cwhee", "cartwheel"); // true
                    fuzzySearch("cartwheel", "cartwheel"); // true
                    fuzzySearch("cwheeel", "cartwheel"); // false
                    fuzzySearch("lw", "cartwheel"); // false
         */

        System.out.println("**********************Task 3**********************");

        System.out.println(fuzzySearch("cwheeel", "cartwheel"));

    }

    // method for task2
    private static void printValuesWhichSumEqualsTo(int[] array, int sum) {

        Objects.requireNonNull(array);

        Arrays.stream(array).boxed()
                .flatMap(outer -> Arrays.stream(array)
                        .boxed()
                        .filter(inner -> !inner.equals(outer) && (inner + outer == sum)) // find pair with sum 10, exclude itself
                        .map(inner -> new Integer[]{outer, inner}))// make array from pair
                .findFirst()// get first value if any
                .map(Arrays::deepToString) // for decorative purpose
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("No values that meet condition of sum = " + sum)); //
    }


    // method for task3
    public static boolean fuzzySearch(String valueToSearch, String template) {
        Objects.requireNonNull(valueToSearch);
        Objects.requireNonNull(template);

        if (valueToSearch.equalsIgnoreCase(template)) {
            return true;
        }

        String[] templateArr = template.toLowerCase().split("");
        String[] valueToSearchArr = valueToSearch.toLowerCase().split("");

        int position = 0;
        boolean matchFound = false;

        for (String charInSearch : valueToSearchArr) {
            matchFound = false;
            for (; position < templateArr.length && !matchFound; position++) {

                if (charInSearch.equals(templateArr[position])) {
                    matchFound = true;
                }
            }
        }
        return matchFound;
    }


}

