package com.example.demo.Controller;

import com.example.demo.Model.Kurs;
import com.example.demo.Model.Student;
import com.example.demo.Repo.StudentDaoFile;
import com.example.demo.Repo.StudentRepository;
import com.example.demo.View.StudentView;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentController {

    List<Student> lista;
    StudentView studentView;

    CrudRepository<Kurs, Integer> kursDao;
    CrudRepository<Student, Integer> studentDao;

    public StudentController() {
    }

    public void addStudent() {
        setList();
        Student student = studentView.addStudent();
        studentDao.save(student);
    }

    public void showStudent(int i) {
        studentView.viewStudent(lista.get(i));
    }

    public void showStudent() {
        setList();
        studentView.viewStudent(lista);
    }

    public void editStudent() {
        setList();
        int id = studentView.editStudent();
        Student student = null;
        student = studentDao.findOne(id);
        student = studentView.editStudent(student);
        studentDao.save(student);
    }

    public void deleteStudent() {
        setList();
        int id = studentView.deleteStudent();
        studentDao.delete(id);
    }

    private void setList() {
        studentView = new StudentView();
        lista = Lists.newArrayList(studentDao.findAll());
    }

    public void setStudentToKurs() {
        setList();
        int ids = studentView.editStudent();
        int idk = studentView.getKursId();
        Student student = null;
        student = studentDao.findOne(new Integer(ids));
        student.setIdkusru(idk);
        studentDao.save(student);
    }

    public void setDAOType(CrudRepository<Kurs, Integer> kursDao, CrudRepository<Student, Integer> studentDao) {
        this.kursDao = kursDao;
        this.studentDao = studentDao;
    }
}
