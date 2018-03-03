package com.example.demo.Repo;

import com.example.demo.Interface.IDaoFile;
import com.example.demo.Model.Student;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Component
public class StudentDaoFile implements IDaoFile<Student> {

    String path = "myfile.txt";

    File f;


    public StudentDaoFile() {
    }


    @Override
    public List<Student> findAll() {
        openFile();
        List<Student> list = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String dane="";
        try{
            while((dane=scanner.nextLine())!=null){
                String[] st = dane.split(";");
                Student student = new Student(st[1], st[2]);
                student.setId(Integer.parseInt(st[0]));
                student.setIdkusru(Integer.parseInt(st[3]));
                list.add(student);
            }
        } catch(NoSuchElementException e){
        }

        return list;
    }

    @Override
    public Student findOne(int primaryKey) {
        List<Student> lista = findAll();
        return lista.get(primaryKey);
    }

    @Override
    public void save(Student student) {
        List<Student> lista = findAll();
        lista.add(student);
        save(lista);
    }

    @Override
    public void delete(int id) {
        List<Student> lista = findAll();
        lista.remove(id);
        save(lista);
    }

    @Override
    public void save(List<Student> e) {
        openFile();
        if(e.isEmpty()) {
            try (PrintWriter pw = new PrintWriter(f)) {
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        } else {
            try (PrintWriter pw = new PrintWriter(f)) {
                int a=0;
                for(Student student : e) {
                    pw.println((a++)+student.toFile());
                }

            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void edit(Student student) {
        List<Student> lista = findAll();
        lista.set(student.getId(), student);
        save(lista);
    }

    public void openFile() {
        f = new File(path);
        if(!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
