package com.heilan.shard.example.conf;

import com.google.common.collect.Range;
import com.heilan.commons.exception.BizException;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * @Description: RangeTableShard
 * @Author: gedachao
 * @Date: 2021-02-07 10:08
 * @Version 1.0
 */
public class RangeTableShard implements RangeShardingAlgorithm<Long> {
    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Long> rangeShardingValue) {
        Range<Long> valueRange = rangeShardingValue.getValueRange();
        Long lowerEndpoint = valueRange.lowerEndpoint();
        Long upperEndpoint = valueRange.upperEndpoint();
        String logicTableName = rangeShardingValue.getLogicTableName();
        LinkedHashSet<String> res = new LinkedHashSet<>();
        if (upperEndpoint <= 1000L) {
            res.add(logicTableName + "0");
            return res;
        }
        if (lowerEndpoint <= 1000L && upperEndpoint > 1000L) {
            return collection;
        }

        if (lowerEndpoint > 1000L) {
            res.add(logicTableName + "1");
            return res;
        }
        throw new BizException("500", "范围匹配失败！");

    }

}
