package com.synechron.wordcounter.interview;

import java.util.List;
import java.util.stream.Collectors;

public class InterviewTest {


    public List<Person> getListOfNames(List<Person> persons){
        persons.add(null);
        return persons.stream()
                .filter(person -> person.age > 40).collect(Collectors.toList());


    }
    public static void main(String[] args) {


    }



    private final class Person{

        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
