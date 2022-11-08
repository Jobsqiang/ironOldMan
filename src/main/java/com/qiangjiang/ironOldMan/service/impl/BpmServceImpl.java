package com.qiangjiang.ironOldMan.service.impl;

import com.qiangjiang.ironOldMan.dao.BpmDao;
import com.qiangjiang.ironOldMan.model.BpmData;
import com.qiangjiang.ironOldMan.service.BpmServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jq on 2020-10-14
 */
@Service
public class BpmServceImpl implements BpmServce {

    @Autowired
    private BpmDao bpmDao;

    @Override
    public BpmData add(BpmData bpmData) {
        bpmDao.add(bpmData);
        return null;
    }
}
