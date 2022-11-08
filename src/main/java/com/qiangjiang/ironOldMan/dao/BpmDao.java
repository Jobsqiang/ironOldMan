package com.qiangjiang.ironOldMan.dao;

import com.qiangjiang.ironOldMan.mapper.BpmMapper;
import com.qiangjiang.ironOldMan.model.BpmData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by jq on 2020-10-14
 */
@Repository
public class BpmDao {


    @Autowired
    private BpmMapper bpmMapper;

    public void  add(BpmData bpmData){
        bpmMapper.insert(bpmData);
    }

}
