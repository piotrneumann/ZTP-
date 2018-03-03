package com.example.demo.Repo;

import com.example.demo.Interface.IDaoFile;
import com.example.demo.Model.Kurs;
import com.example.demo.Model.Student;
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
public class KursDaoFile implements IDaoFile <Kurs> {

    String path = "kursfile.txt";
    File f;

    @Override
    public List<Kurs> findAll() {
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

    @Override
    public Kurs findOne(int primaryKey) {
        List<Kurs> lista = findAll();
        return lista.get(primaryKey);
    }

    @Override
    public void save(Kurs kurs) {
        List<Kurs> lista = findAll();
        lista.add(kurs);
        save(lista);
    }

    @Override
    public void delete(int i) {
        List<Kurs> lista = findAll();
        lista.remove(i);
        save(lista);
    }

    @Override
    public void save(List<Kurs> e) {
        openFile();
        if(e.isEmpty()) {
            try (PrintWriter pw = new PrintWriter(f)) {
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        } else {
            try (PrintWriter pw = new PrintWriter(f)) {
                int a=0;
                for(Kurs kurs : e) {
                    pw.println((a++)+kurs.toFile());
                }

            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void edit(Kurs kurs) {
        List<Kurs> lista = findAll();
        lista.set(kurs.getId(), kurs);
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
