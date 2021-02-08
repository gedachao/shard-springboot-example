package com.heilan.shard.example.service;

import com.heilan.shard.example.domain.Country;

import java.util.List;

/**
 * @Description: CountryService
 * @Author: gedachao
 * @Date: 2021-02-07 16:40
 * @Version 1.0
 */
public interface CountryService {
    int batchInsert(List<Country> countries);
}
