package com.example.demo.View;

import com.example.demo.Model.Kurs;
import com.example.demo.Model.Student;

import java.util.List;
import java.util.Scanner;

public class StudentView {

    public void viewStudent(List<Student> students) {
        for(Student student: students) {
            System.out.println(student.toString());
        }
    }

    public void viewStudent(Student student){
        System.out.println(student.toString());
    }

    public Student addStudent() {
        Scanner sc = new Scanner(System.in);
        String imie, nazwisko;
        System.out.println("Podaj imie");
        imie = sc.nextLine();
        System.out.println("Podaj nazwisko");
        nazwisko = sc.nextLine();
        return new Student(imie, nazwisko,-1);
    }

//    public Student setStudentToKurs() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Podaj id studenta");
//        int ids = sc.nextInt();
//        System.out.println("Podaj id kursu");
//        int idk = sc.nextInt();
//        return new Student(imie, nazwisko);
//    }

    public Student editStudent (Student student){
        Scanner sc = new Scanner(System.in);
        String imie,nazwisko;
        System.out.println("Podaj nowe imie");
        imie = sc.nextLine();
        System.out.println("Podaj nowe nazwisko");
        nazwisko = sc.nextLine();
        student.setImie(imie);
        student.setNazwisko(nazwisko);
        return student;
    }

    public int editStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj id studenta");
        int id = sc.nextInt();
        return id;
    }

    public int getKursId() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj id kursu");
        int id = sc.nextInt();
        return id;
    }

    public int deleteStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj id studenta");
        int id = sc.nextInt();
        return id;
    }

}
