package com.springboot.redis.service.impl;

import com.springboot.redis.entity.Student;
import com.springboot.redis.mapper.StudentMapper;
import com.springboot.redis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public String save(Student student) {
        studentMapper.save(student);
        return student.getId();
    }

    @Override
    public Student findStudentById(Integer id) {
        Student student = studentMapper.findStudentById(id);
        return student;
    }

    @Override
    public void delete(Integer id) {
        studentMapper.delete(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.update(student);
    }

    @Override
    public List<Student> findStudentList() {
        List<Student> students = studentMapper.list();
        return students;
    }
}
