package com.example.demo.View;

import com.example.demo.Controller.KursController;
import com.example.demo.Model.Kurs;
import com.example.demo.Repo.KursRepository;
import com.example.demo.Repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

public class MainView {

    public void DAOChoice() {
        System.out.println("1. Baza danych");
        System.out.println("2. pliki");
    }

    public void showMenu() {
        System.out.println("1. Dodaj kurs");
        System.out.println("2. Wyswietl kurs");
        System.out.println("3. Usun kurs");
        System.out.println("4. Edytuj kurs");
        System.out.println("5. Dodaj studenta");
        System.out.println("6. Wyswietl studenta");
        System.out.println("7. Usun studenta");
        System.out.println("8. Edytuj studenta");
        System.out.println("9. Przypisz studenta do kursu");
    }

    public int getChoice() {
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if ( choice<1 || choice > 9 ) {return 10;}
        else
            return choice;
    }

}
