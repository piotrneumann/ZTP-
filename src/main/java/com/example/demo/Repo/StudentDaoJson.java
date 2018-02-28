package com.example.demo.Repo;

import com.example.demo.Interface.IDaoJson;
import com.example.demo.Model.Student;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class StudentDaoJson implements IDaoJson<Student> {

    @Value("path")
    String path;
    //JSONObject obj = new JSONObject(path);

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student findOne(int primaryKey) {
        return null;
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public void delete(Student student) {

    }
}
