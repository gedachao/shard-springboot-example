package com.heilan.shard.example.conf;

import com.heilan.commons.exception.BizException;
import org.apache.commons.lang3.StringUtils;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @Description: PreciseTableShard 分表策略, 分片值<=5路由到 table0, 其余的路由到 table1
 * @Author: gedachao
 * @Date: 2021-02-07 9:51
 * @Version 1.0
 */
public class PreciseTableShard implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        if (preciseShardingValue.getValue() == null) {
            throw new BizException("500","分片值不可为空！");
        }
        int tableIndex = getTableIndex(preciseShardingValue.getValue());
        String logicTableName = preciseShardingValue.getLogicTableName();
        String actualTableName = logicTableName+tableIndex;
        for (String tableName : collection) {
            if (StringUtils.equals(tableName, actualTableName)) {
                return tableName;
            }
        }
        throw new BizException("500", "未找到相应的表");
    }


    private int getTableIndex(Long value) {
        if (value <= 5L) {
            return 0;
        } else {
            return 1;
        }
    }
}
