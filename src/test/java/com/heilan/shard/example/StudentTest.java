package com.heilan.shard.example;

import com.heilan.shard.example.domain.Student;
import com.heilan.shard.example.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: StudentTest 仅分库测试
 * @Author: gedachao
 * @Date: 2021-02-07 16:27
 * @Version 1.0
 */
@SpringBootTest
@MapperScan(basePackages = "com.heilan.shard.example.mapper")
@Slf4j
public class StudentTest {
    @Autowired
    private StudentService studentService;

    /**
     * 根据student的id对2取模的值选择数据源
     */
    @Test
    void insertTest() {
        List<Student> studentList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Student student = new Student(i, "name" + i, "code" + i);
            studentList.add(student);
        }
        int count = studentService.batchInsert(studentList);
        log.info("插入的记录数量为：{}", count);
    }




}
