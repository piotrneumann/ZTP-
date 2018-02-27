package com.example.demo.View;

import com.example.demo.Model.Kurs;
import com.example.demo.Model.Student;

import java.util.List;
import java.util.Scanner;

public class KursView {

    public void viewKursy(List<Kurs> kursy, List<Student> studenci) {
        for(Kurs kurs: kursy) {
            System.out.println(kurs.toString());
            for(Student student: studenci) {
                if(kurs.getId()==student.getIdkusru()) {
                    System.out.println(" " + student.toString());
                }
            }
        }
    }
    public void viewKurs(Kurs kurs){
        System.out.println(kurs.toString());
    }

    public Kurs addKurs() {
        Scanner sc = new Scanner(System.in);
        String nazwa,typ;
        System.out.println("Podaj nazwe");
        nazwa = sc.nextLine();
        System.out.println("Podaj typ");
        typ = sc.nextLine();
        return new Kurs(nazwa, typ);
    }

    public Kurs editKurs (Kurs kurs){
        Scanner sc = new Scanner(System.in);
        String nazwa,typ;
        System.out.println("Podaj nowa nazwe");
        nazwa = sc.nextLine();
        System.out.println("Podaj nowy typ");
        typ = sc.nextLine();
        kurs.setNazwa(nazwa);
        kurs.setTyp(typ);
        return kurs;
    }

    public int deleteKurs() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj id kursu");
        int id = sc.nextInt();
        return id;
    }
    public int editKurs() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj id kursu");
        int id = sc.nextInt();
        return id;
    }

}
