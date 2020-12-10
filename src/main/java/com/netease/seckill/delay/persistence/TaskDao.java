package com.netease.seckill.delay.persistence;

import com.alibaba.fastjson.JSON;
import com.netease.seckill.delay.core.DelayTask;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/11/15
 */
public class TaskDao {

    private String tableName;
    private JdbcTemplate jdbcTemplate;

    public TaskDao(String tableName, JdbcTemplate jdbcTemplate) {
        this.tableName = tableName;
        this.jdbcTemplate = jdbcTemplate;
    }

    public long newTask(Class<?> clz, TaskParam taskParam, Date executeTime, DelayTask delayTask) {
        String sql = "insert into " + tableName + " (task_name,task_class,task_params,expected_exec_time,scheduler,exec_timeout_time,status,task_tag)values(?,?,?,?,?,?,?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, clz.getSimpleName());
            ps.setString(2, clz.getName());
            ps.setString(3, delayTask.taskCodec().encode(taskParam));
            ps.setTimestamp(4, new Timestamp(executeTime.getTime()));
            ps.setString(5, "127.0.0.1");
            ps.setTimestamp(6, new Timestamp(new Date().getTime()));
            ps.setInt(7, 0);
            ps.setString(8, taskParam.getTaskTag());
            return ps;
        }, keyHolder);
        return (long) keyHolder.getKey().longValue();
    }
}