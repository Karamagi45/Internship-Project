package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.risk_assessment;
import com.internship2025.changemanagementsystem.Modal.users;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class usersRepo {

    private final JdbcTemplate  jdbcTemplate;

    public usersRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean save(users user) {

        String sql = "insert into  users(full_name, email, password, confirm_password, role,phone) values (?,?,?,?,?,?)";

       return jdbcTemplate.update(sql, user.getFull_name(), user.getEmail(), user.getPassword(),
                user.getConfirm_password(), user.getRole(),user.getPhone())  > 0;

    }

    public  boolean login(users user){
        String sql = "select count(*) from users  where full_name = ? and email = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, user.getFull_name(),
                user.getEmail());
        return count != null && count > 0;

       // return  jdbcTemplate.update(sql, user.getFull_name(), user.getEmail()) > 0;
    }


    public List<users> findAllUsers() {
        String  sql = "select * from users";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(users.class));
    }

}
