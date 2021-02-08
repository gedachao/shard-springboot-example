package com.heilan.shard.example;

import com.heilan.shard.example.domain.Cat;
import com.heilan.shard.example.mapper.CatMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: CatTest
 * @Author: gedachao
 * @Date: 2021-02-08 8:44
 * @Version 1.0
 */
@SpringBootTest
@Slf4j
@MapperScan(basePackages = "com.heilan.shard.example.mapper")
public class CatTest {
    @Autowired
    private CatMapper catMapper;


    /**
     * 表 cat 没有进行分库分表，所以会路由到默认数据源(cent2)中
     */
    @Test
    void insertTest() {
        List<Cat> cats = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Cat cat = new Cat(i, "name" + i, "hobby" + i);
            cats.add(cat);
        }
        for (Cat cat : cats) {
            catMapper.insert(cat);
        }
    }

}
