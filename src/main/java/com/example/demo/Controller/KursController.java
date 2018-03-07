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
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class KursController {
    List<Kurs> lista;
    KursView kursView;

    CrudRepository<Kurs, Integer> kursDao;
    CrudRepository<Student, Integer> studentDao;

    public KursController() {

    }

    public void addKurs() {
        setList();
        Kurs kurs = kursView.addKurs();
        kursDao.save(kurs);
    }

    public void showKursy() {
        setList();
        List<Student> studenci = Lists.newArrayList(studentDao.findAll());
        kursView.viewKursy(lista, studenci);
    }

    public void showKurs(int i) {
        setList();
        kursView.viewKurs(lista.get(i));
    }

    public void editKurs() {
        setList();
        int id = kursView.editKurs();
        Kurs kurs = kursDao.findOne(id);
        kurs = kursView.editKurs(kurs);
        kursDao.save(kurs);
    }

    public void deleteKurs() {
        setList();
        int id = kursView.deleteKurs();
        for (Student student : studentDao.findAll()) {
            if (student.getIdkusru() == id) {
                student.setIdkusru(-1);
                studentDao.save(student);
            }
        }
        kursDao.delete(new Integer(id));
    }

    private void setList() {
        kursView = new KursView();
        lista = Lists.newArrayList(kursDao.findAll());
    }

    public void setDAOType(CrudRepository<Kurs, Integer> kursDao, CrudRepository<Student, Integer> studentDao) {
        this.kursDao = kursDao;
        this.studentDao = studentDao;
    }
}
