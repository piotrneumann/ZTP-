package com.example.demo.Controller;

import com.example.demo.Model.Kurs;
import com.example.demo.Repo.KursDaoFile;
import com.example.demo.Repo.KursRepository;
import com.example.demo.Repo.StudentDaoFile;
import com.example.demo.Repo.StudentRepository;
import com.example.demo.View.KursView;
import com.example.demo.View.MainView;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Component
public class MainController {

    @Autowired
    KursController kursController;
    @Autowired
    StudentController studentController;

    @Autowired
    KursDaoFile kursDaoFile;
    @Autowired
    StudentDaoFile studentDaoFile;
    @Autowired
    KursRepository kursRepository;
    @Autowired
    StudentRepository studentRepository;

    MainView mainView;

    private final int DBDaoType = 1;
    private final int FileDaoType = 2;
    private int daoType;



    public MainController() {
        mainView = new MainView();
    }

    public void showMenu() {
        mainView.showMenu();
    }

    public void showDAO() {
        mainView.DAOChoice();
    }

    public int getChoice() {
        return mainView.getChoice();
    }

    public void setChoice() {
        int choice = mainView.getChoice();
        switch (choice) {
            case 1 : {
                addKurs();
                break;
            }
            case 2: {
                showKurs();
                break;
            }
            case 3: {
                deleteKurs();
                break;
            }
            case 4: {
                editKurs();
                break;
            }
            case 5 : {
                addStudent();
                break;
            }
            case 6: {
                showStudent();
                break;
            }
            case 7: {
                deleteStudent();
                break;
            }
            case 8: {
                editStudent();
                break;
            }
            case 9: {
                setStudentToKurs();
                break;
            }
        }
    }

    private void showKurs() {
        kursController.showKursy();
    }

    private void addKurs() {
        kursController.addKurs();
    }

    private void deleteKurs() {
        kursController.deleteKurs();
    }

    private void editKurs() {
        kursController.editKurs();
    }

    private void showStudent() {
        studentController.showStudent();
    }

    private void addStudent() {
        studentController.addStudent();
    }

    private void deleteStudent() {
        studentController.deleteStudent();
    }

    private void editStudent() {
        studentController.editStudent();
    }

    private void setStudentToKurs() {
        studentController.setStudentToKurs();
    }

    public void setDAOType(int DAOType) {
        if (DAOType == DBDaoType) {
            studentController.setDAOType(kursRepository, studentRepository);
            kursController.setDAOType(kursRepository, studentRepository);
        } else if (DAOType == FileDaoType) {
            studentController.setDAOType(kursDaoFile, studentDaoFile);
            kursController.setDAOType(kursDaoFile, studentDaoFile);
        }

    }
}
