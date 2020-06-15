package com.springboot.redis.mapper;

import com.springboot.redis.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
    /**
     * 新增
     * @param student
     */
    void save(Student student);

    /**
     * 根据主键 ID 查找
     * @param id
     * @return
     */
    Student findStudentById(@Param("id") Integer id);

    /**
     * 删除
     * @param id
     */
    void delete(@Param("id") Integer id);

    /**
     * 更新
     * @param student
     */
    void update(Student student);

    /**
     * 列表
     * @return
     */
    List<Student> list();
}
