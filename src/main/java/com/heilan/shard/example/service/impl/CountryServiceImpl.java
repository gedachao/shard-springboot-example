package com.heilan.shard.example.service.impl;

import com.heilan.shard.example.domain.Country;
import com.heilan.shard.example.mapper.CountryMapper;
import com.heilan.shard.example.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: CountryServiceImpl
 * @Author: gedachao
 * @Date: 2021-02-07 16:41
 * @Version 1.0
 */
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryMapper countryMapper;

    @Override
    public int batchInsert(List<Country> countries) {
        int count = 0;
        for (Country country : countries) {
            countryMapper.insert(country);
            count++;
        }
        return count;
    }
}
