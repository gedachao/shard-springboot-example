package com.heilan.shard.example.service.impl;

import com.heilan.shard.example.domain.Student;
import com.heilan.shard.example.mapper.StudentMapper;
import com.heilan.shard.example.service.StudentService;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: StudentServiceImpl
 * @Author: gedachao
 * @Date: 2021-02-07 16:33
 * @Version 1.0
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public int batchInsert(List<Student> studentList) {
        int count = 0;
        for (Student student : studentList) {
            studentMapper.insert(student);
            count++;
        }
        return count;
    }

    @Override
    @ShardingTransactionType(TransactionType.XA)
    @Transactional(rollbackFor = Exception.class)
    public void transactionInsert() {
        List<Student> studentList = new ArrayList<>();
        Student student12 = new Student(12, "name12", "code12");
        Student student = new Student(1, "name1", "code1");
        // 插入成功
        studentMapper.insert(student12);
        // 数据库中已经存在 id 为 1 的记录，主键重复，插入失败；测试student12是否会回滚
        studentMapper.insert(student);
    }
}
