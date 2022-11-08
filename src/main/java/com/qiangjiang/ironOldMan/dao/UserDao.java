package com.qiangjiang.ironOldMan.dao;

import com.qiangjiang.ironOldMan.mapper.HistoryMapper;
import com.qiangjiang.ironOldMan.mapper.UserMapper;
import com.qiangjiang.ironOldMan.model.History;
import com.qiangjiang.ironOldMan.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private HistoryMapper historyMapper;

    public void add(User user){
        userMapper.insert(user);
    }


    public History query(){
        return historyMapper.query();
    }


    @Resource
    private JdbcTemplate jdbcTemplate;

    public History findByName(String username) {
        String querySQL = "SELECT * FROM ITF.GJ_ERP_HISTORY LIMIT 1";
        RowMapper<History> rowMapper = new BeanPropertyRowMapper<>(History.class);
//        History vo = jdbcTemplate.queryForObject(querySQL, new Object[] { username }, rowMapper);
        History vo = jdbcTemplate.queryForObject(querySQL, null, rowMapper);
        return vo;
    }

}
