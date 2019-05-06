package com.qiangjiang.ironOldMan.mapper;

import com.qiangjiang.ironOldMan.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int insert(User user);
}
