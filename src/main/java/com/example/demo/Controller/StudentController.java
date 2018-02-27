package com.example.demo.Controller;

import com.example.demo.Model.Kurs;
import com.example.demo.Model.Student;
import com.example.demo.Repo.KursRepository;
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
public class StudentController {

    List<Student> lista;
    StudentView studentView;

    @Autowired
    private StudentRepository studentRepo;

    public StudentController() {

        //studentView = new StudentView();
        //lista = Lists.newArrayList(studentRepo.findAll());
    }

    public void addStudent() {
        setList();
        System.out.println("SIEMA");
        Student student = studentView.addStudent();
        studentRepo.save(student);
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
        Student student = studentRepo.findOne(id);
        student = studentView.editStudent(student);
        studentRepo.save(student);
    }

    public void deleteStudent() {
        setList();
        int id = studentView.deleteStudent();
        studentRepo.delete(id);
    }

    private void setList() {
        studentView = new StudentView();
        lista = Lists.newArrayList(studentRepo.findAll());
    }

    public void setStudentToKurs() {
        int ids = studentView.editStudent();
        int idk = studentView.getKursId();
        Student student = studentRepo.findOne(new Integer(ids));
        student.setIdkusru(idk);
        studentRepo.save(student);
    }
}
