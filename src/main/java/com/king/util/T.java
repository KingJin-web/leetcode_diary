package com.king.util;

import java.util.TreeSet;

import static com.king.util.MyPrint.*;

/**
 * @author: King
 * @project: leetcode_diary
 * @pcakage: com.king.util.Util
 * @date: 2022年06月08日 01:20
 * @description: ${}
 */
public class T {
    private static class Person implements Comparable<Person> {
        String name;
        int age;


        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Person o) {
            int cmp = age - o.age;
            return cmp != 0 ? cmp : name.compareTo(o.name);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person)) return false;

            Person person = (Person) o;

            if (age != person.age) return false;
            return name != null ? name.equals(person.name) : person.name == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + age;
            return result;
        }
    }

        public static void main(String[] args) {
            TreeSet<Person> set = new TreeSet<>();
            set.add(new Person("Lisa", 24));
            set.add(new Person("Mark", 25));

            print(set);
            set.remove(new Person("Mark", 25));
            print(set);
        }

}