package com.example.demo.Controller;

import com.example.demo.Model.Kurs;
import com.example.demo.Model.Student;
import com.example.demo.Repo.KursDaoFile;
import com.example.demo.Repo.KursRepository;
import com.example.demo.Repo.StudentDaoFile;
import com.example.demo.Repo.StudentRepository;
import com.example.demo.View.KursView;
import com.example.demo.View.StudentView;
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
    @Autowired
    private KursDaoFile kursDaoFile;
    @Autowired
    private StudentDaoFile studentDaoFile;

    private int DAOType;
    public final int DBType = 1;
    public final int FileType = 2;

    public KursController() {

    }

    public void addKurs() {
        setList();
        Kurs kurs = kursView.addKurs();
        if (DAOType == DBType) {
            kursRepo.save(kurs);
        } else if (DAOType == FileType) {
            kursDaoFile.save(kurs);
        }
    }

    public void showKursy() {
        setList();
        if (DAOType == DBType) {
            List<Student> studenci = Lists.newArrayList(studentRepo.findAll());
            kursView.viewKursy(lista, studenci);
        } else if (DAOType == FileType) {
            List<Student> studenci = studentDaoFile.findAll();
            kursView.viewKursy(lista, studenci);
        }
    }

    public void showKurs(int i) {
        setList();
        kursView.viewKurs(lista.get(i));
    }

    public void editKurs() {
        setList();
        int id = kursView.editKurs();
        if (DAOType == DBType) {
            Kurs kurs = kursRepo.findOne(id);
            kurs = kursView.editKurs(kurs);
            kursRepo.save(kurs);
        } else if (DAOType == FileType) {
            Kurs kurs = kursDaoFile.findOne(id);
            kurs = kursView.editKurs(kurs);
            kursDaoFile.edit(kurs);
        }
    }

    public void deleteKurs() {
        setList();
        int id = kursView.deleteKurs();
        if (DAOType == DBType) {
            for (Student student : studentRepo.findAll()) {
                if (student.getIdkusru() == id) {
                    student.setIdkusru(0);
                    studentRepo.save(student);
                }
            }
            kursRepo.delete(new Integer(id));
        } else if (DAOType == FileType) {
            for (Student student : studentDaoFile.findAll()) {
                if (student.getIdkusru() == id) {
                    student.setIdkusru(-1);
                    studentDaoFile.edit(student);
                }
            }
            kursDaoFile.delete(id);
        }
    }

    private void setList() {
        kursView = new KursView();
        if (DAOType == DBType) {
            lista = Lists.newArrayList(kursRepo.findAll());
        } else if (DAOType == FileType) {
            lista = kursDaoFile.findAll();
        }
    }

    public void setDAOType(int DAOType) {
        this.DAOType = DAOType;
    }
}
