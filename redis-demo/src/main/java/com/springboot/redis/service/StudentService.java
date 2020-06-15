package com.springboot.redis.service;

import com.springboot.redis.entity.Student;

import java.util.List;

public interface StudentService {

    /**
     * 新增
     * @param student
     * @return
     */
    String save(Student student);

    /**
     * 根据 主键ID 查询
     *
     * @param id
     * @return
     */
    Student findStudentById(Integer id);

    /**
     * 删除
     * @param id
     */
    void delete(Integer id);

    /**
     * 更新
     * @param student
     */
    void updateStudent(Student student);

    /**
     * 集合
     * @return
     */
    List<Student> findStudentList();

}
