package com.example.demo;

import com.example.demo.Controller.KursController;
import com.example.demo.Controller.MainController;
import com.example.demo.Model.Kurs;
import com.example.demo.Repo.KursRepository;
import com.example.demo.Repo.StudentRepository;
import com.example.demo.View.MainView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.applet.Main;

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



		for(;;) {
			mainController.showMenu();
			mainController.setChoice();
		}
	}
}
