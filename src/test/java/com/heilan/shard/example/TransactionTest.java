package com.heilan.shard.example;

import com.heilan.shard.example.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @Description: TransactionTest
 * @Author: gedachao
 * @Date: 2021-02-08 8:52
 * @Version 1.0
 */
@SpringBootTest
@MapperScan(basePackages = "com.heilan.shard.example.mapper")
@Slf4j
public class TransactionTest {
    /**
     * 事务测试，
     */

    @Autowired
    private StudentService studentService;



    /**
     * 根据student的id对2取模的值选择数据源
     */
    @Test
    void insertTest() {
        studentService.transactionInsert();
    }
}
