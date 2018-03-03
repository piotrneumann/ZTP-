package com.example.demo.Controller;

import com.example.demo.Model.Student;
import com.example.demo.Repo.StudentDaoFile;
import com.example.demo.Repo.StudentRepository;
import com.example.demo.View.StudentView;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentController {

    List<Student> lista;
    StudentView studentView;
    private int DAOType;

    public final int DBType = 1;
    public final int FileType = 2;

    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    StudentDaoFile studentDaoFile;

    public StudentController() {
    }

    public void addStudent() {
        setList();
        Student student = studentView.addStudent();

        if(DAOType == DBType){
            studentRepo.save(student);
        } else if(DAOType == FileType) {
            studentDaoFile.save(student);
        }
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
        if(DAOType == DBType){
            student = studentRepo.findOne(id);
            student = studentView.editStudent(student);
            studentRepo.save(student);
        } else if(DAOType == FileType) {
            student = studentDaoFile.findOne(id);
            student = studentView.editStudent(student);
            studentDaoFile.edit(student);
        }
    }

    public void deleteStudent() {
        setList();
        int id = studentView.deleteStudent();
        if(DAOType == DBType){
            studentRepo.delete(id);
        } else if(DAOType == FileType) {
            studentDaoFile.delete(id);
        }

    }

    private void setList() {
        studentView = new StudentView();
        if (DAOType == DBType) {
            lista = Lists.newArrayList(studentRepo.findAll());
        } else if (DAOType == FileType) {
            lista = studentDaoFile.findAll();
        }
    }

    public void setStudentToKurs() {
        int ids = studentView.editStudent();
        int idk = studentView.getKursId();
        Student student = null;
        if(DAOType == DBType){
            student = studentRepo.findOne(new Integer(ids));
            student.setIdkusru(idk);
            studentRepo.save(student);
        } else if(DAOType == FileType) {
            student = studentDaoFile.findOne(ids);
            student.setIdkusru(idk);
            studentDaoFile.edit(student);
        }

    }

    public void setDAOType(int DAOType) {
        this.DAOType = DAOType;
    }
}
