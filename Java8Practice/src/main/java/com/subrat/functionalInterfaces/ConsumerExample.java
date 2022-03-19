package com.subrat.functionalInterfaces;

import com.subrat.data.Student;
import com.subrat.data.StudentDataBase;

import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

public class ConsumerExample {

    static Consumer<Student> c1 = p -> System.out.println(p);
    static Consumer<Student> c2 = p -> System.out.println(p.getName().toUpperCase());
    static Consumer<Student> c3 = p -> System.out.println(p.getActivities());

    public static void printName(){
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(c1);
    }

    public static void printNameAndActivities(){
        System.out.println("printNameAndActivities : ");
        List<Student> personList = StudentDataBase.getAllStudents();
        personList.forEach(c1.andThen(c3));
    }
    public static void printNameAndActivitiesUsingCondition(){
        System.out.println("printNameAndActivitiesUsingCondition : ");
        List<Student> personList = StudentDataBase.getAllStudents();
        personList.forEach(s1 -> {
            if(s1.getGradeLevel() >= 3 && s1.getGpa() > 3.9){
                c2.andThen(c3).accept(s1);
            }
        });
    }

    public static void main(String[] args) {
        Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());

        c1.accept("java8");

        printName();
        printNameAndActivities();
        printNameAndActivitiesUsingCondition();
    }
}
