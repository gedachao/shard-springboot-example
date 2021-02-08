package com.heilan.shard.example.service;

import com.heilan.shard.example.domain.Student;

import java.util.List;

/**
 * @Description: StudentService
 * @Author: gedachao
 * @Date: 2021-02-07 16:33
 * @Version 1.0
 */
public interface StudentService {
    int batchInsert(List<Student> studentList);

    void transactionInsert();
}
