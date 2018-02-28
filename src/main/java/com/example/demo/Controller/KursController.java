package com.example.demo.Controller;

import com.example.demo.Model.Kurs;
import com.example.demo.Model.Student;
import com.example.demo.Repo.KursRepository;
import com.example.demo.Repo.StudentRepository;
import com.example.demo.View.KursView;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class KursController {
    List<Kurs> lista;
    KursView kursView;

    @Autowired
    private KursRepository kursRepo;
    @Autowired
    private StudentRepository studentRepo;
    private int DAOType;

    public KursController() {

//        kursView = new KursView();
//        lista = Lists.newArrayList(kursRepo.findAll());
}

    public void addKurs() {
        setList();
        Kurs kurs = kursView.addKurs();
        kursRepo.save(kurs);
    }

    public void showKursy() {
        setList();
        List<Student> studenci = Lists.newArrayList(studentRepo.findAll());
        kursView.viewKursy(lista, studenci);
    }

    public void showKurs(int i) {
        setList();
        kursView.viewKurs(lista.get(i));
    }

    public void editKurs() {
        setList();
        int id = kursView.editKurs();
        Kurs kurs = kursRepo.findOne(id);
        kurs = kursView.editKurs(kurs);
        kursRepo.save(kurs);
    }

    public void deleteKurs() {
        setList();
        int id = kursView.deleteKurs();
        for (Student student : studentRepo.findAll()) {
            if (student.getIdkusru() == id) {
                student.setIdkusru(0);
                studentRepo.save(student);
            }
        }
        kursRepo.delete(new Integer(id));
    }

    public void setList() {
        kursView = new KursView();
        lista = Lists.newArrayList(kursRepo.findAll());
    }

    public void setDAOType(int DAOType) {
        this.DAOType = DAOType;
    }
}
