package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.risk_assessment;
import com.internship2025.changemanagementsystem.Modal.users;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class riskAssessmentRepo {

    private  final  JdbcTemplate jdbcTemplate;

    public riskAssessmentRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean saveRisks(risk_assessment assessments) {

        String sql = "insert into  risk_assessment( identified_risk, risk_occurance) values (?,?)";

        return jdbcTemplate.update(sql, assessments.getIdentified_risk(), assessments.getRisk_occurance()) > 0;

    }


    public List<risk_assessment> findAll() {
        String sql = "select * from risk_assessment";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(risk_assessment.class));
    }


}
