package com.example.demo;

import com.example.demo.Controller.MainController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZtpLab1Application implements CommandLineRunner{


@Autowired
MainController mainController;

	public static void main(String[] args) {
		//SpringApplication.run(ZtpLab1Application.class, args);
		SpringApplication.run(ZtpLab1Application.class, args);

	}

	@Override
	public void run(String... strings) throws Exception {

		//MainController mainController = new MainController();
		mainController.showDAO();
		int choice = mainController.getChoice();
		mainController.setDAOType(choice);
		//StudentDaoJson s = new StudentDaoJson();



		for(;;) {
			mainController.showMenu();
			mainController.setChoice();
		}
	}
}
