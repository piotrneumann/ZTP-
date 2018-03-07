package com.example.demo.Repo;

import com.example.demo.Model.Kurs;
import com.example.demo.Model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Component
public class KursDaoFile implements CrudRepository<Kurs, Integer> {

    String path = "kursfile.txt";
    File f;
    @Override
    public <S extends Kurs> S save(S s) {
        List<Kurs> list = myFindAll();
        for(int i=0;i<list.size();i++) {
            if(list.get(i).getId() == s.getId()) {
                edit(s);
                return s;
            }
        }
        s.setId(0);
        mySave(s);
        return s;
    }

    @Override
    public <S extends Kurs> Iterable<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Kurs findOne(Integer integer) {
        Kurs kurs = myFindOne(integer);
        return kurs;
    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Kurs> findAll() {
        Iterable<Kurs> iterable = myFindAll();
        return iterable;
    }

    @Override
    public Iterable<Kurs> findAll(Iterable<Integer> iterable) {
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
    public void delete(Kurs kurs) {
        myDelete(kurs.getId());
    }

    @Override
    public void delete(Iterable<? extends Kurs> iterable) {

    }

    @Override
    public void deleteAll() {

    }


    public List<Kurs> myFindAll() {
        openFile();
        List<Kurs> list = new ArrayList<>();
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
                Kurs kurs = new Kurs(st[1], st[2]);
                kurs.setId(Integer.parseInt(st[0]));
                list.add(kurs);
            }
        } catch(NoSuchElementException e){
        }
        return list;
    }


    public Kurs myFindOne(int primaryKey) {
        List<Kurs> lista = myFindAll();
        return lista.get(primaryKey);
    }

    public void mySave(Kurs kurs) {
        List<Kurs> lista = myFindAll();
        if(!lista.isEmpty()) {
            int lastIndex = lista.get(lista.size()-1).getId();
            kurs.setId(lastIndex+1);
        }

        lista.add(kurs);
        mySave(lista);
    }

    public void myDelete(int i) {

        List<Kurs> lista = myFindAll();
        for (Kurs kurs  : lista) {
            if(kurs.getId() == i) {
                lista.remove(kurs);
                break;
            }
        }
        mySave(lista);
}

    public void mySave(List<Kurs> e) {
        openFile();
        if(e.isEmpty()) {
            try (PrintWriter pw = new PrintWriter(f)) {
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        } else {
            try (PrintWriter pw = new PrintWriter(f)) {
                for(Kurs kurs : e) {
                    pw.println((kurs.getId())+kurs.toFile());
                }

            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }


    public void edit(Kurs kurs) {
        List<Kurs> lista = myFindAll();
        lista.set(kurs.getId(), kurs);
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
