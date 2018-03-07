package com.example.demo.Repo;

import com.example.demo.Model.Kurs;
import com.example.demo.Model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Component
public class StudentDaoFile implements CrudRepository<Student, Integer> {

    String path = "myfile.txt";
    File f;


    @Override
    public <S extends Student> S save(S s) {
        List<Student> list = myFindAll();
        for(int i=0;i<list.size();i++) {
            if(list.get(i).getId() == s.getId()) {
                edit(s);
                return s;
            }
        }
        mySave(s);
        return s;
    }

    @Override
    public <S extends Student> Iterable<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Student findOne(Integer integer) {
        Student student = myFindOne(integer);
        return student;
    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Student> findAll() {
        Iterable<Student> iterable = myFindAll();
        return iterable;
    }

    @Override
    public Iterable<Student> findAll(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Integer integer) {
        myDelete(integer);
    }

    @Override
    public void delete(Student student) {
        myDelete(student.getId());
    }

    @Override
    public void delete(Iterable<? extends Student> iterable) {

    }

    @Override
    public void deleteAll() {

    }


    public List<Student> myFindAll() {
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

    public Student myFindOne(int primaryKey) {
        List<Student> lista = myFindAll();
        return lista.get(primaryKey);
    }

    public void mySave(Student student) {
        List<Student> lista = myFindAll();
        lista.add(student);
        mySave(lista);
    }

    public void myDelete(int id) {
        List<Student> lista = myFindAll();
        lista.remove(id);
        mySave(lista);
    }

    public void mySave(List<Student> e) {
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

    public void edit(Student student) {
        List<Student> lista = myFindAll();
        lista.set(student.getId(), student);
        mySave(lista);
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
