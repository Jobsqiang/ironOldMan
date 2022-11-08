package com.qiangjiang.ironOldMan.mapper;

import com.qiangjiang.ironOldMan.model.BpmData;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by jq on 2020-10-14
 */
@Mapper
public interface BpmMapper {
    int insert(BpmData bpmData);
}
