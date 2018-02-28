package com.example.demo.Controller;

import com.example.demo.Model.Kurs;
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

    MainView mainView;

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
        studentController.setDAOType(DAOType);
        kursController.setDAOType(DAOType);
    }
}
