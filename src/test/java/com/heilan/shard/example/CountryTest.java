package com.heilan.shard.example;

import com.heilan.shard.example.domain.Country;
import com.heilan.shard.example.mapper.CountryMapper;
import com.heilan.shard.example.service.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: CountryTest
 * @Author: gedachao
 * @Date: 2021-02-07 16:42
 * @Version 1.0
 */

@SpringBootTest
@MapperScan(basePackages = "com.heilan.shard.example.mapper")
@Slf4j
public class CountryTest {
    /**
     * t_country 为广播表，即所有的数据源都都一份相同的t_country表；
     * 对 t_country 执行插入或更新操作，所有的数据源内的数据的变动是相同的。
     *
     */

    @Autowired
    private CountryService countryService;

    @Autowired
    private CountryMapper countryMapper;

    @Test
    void insertTest() {
        List<Country> countries = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Country country = new Country(i, "name" + i);
            countries.add(country);
        }
        int count = countryService.batchInsert(countries);
        log.info("插入的记录数量为：{}",count);
    }

    @Test
    void updateTest() {
        Country country = new Country(2, "country变动测试");
        countryMapper.updateByPrimaryKey(country);
    }

}
