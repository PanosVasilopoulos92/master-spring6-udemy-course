package org.viators.practice_project13.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.viators.practice_project13.model.Contact;
import org.viators.practice_project13.rowmappers.ContactRowMapper;

import javax.sql.DataSource;
import java.util.List;

/*
    @Repository stereotype annotation is used to add a bean of this class
    type to the Spring context and indicate that given Bean is used to perform
    DB related operations.
* */
@Repository
public class ContactRepository {
    private final JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ContactRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setDataSource(DataSource dataSource){
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public int saveContactMessage(Contact contact) {
        String sql = "INSERT INTO CONTACT_MSG (NAME,MOBILE_NUM,EMAIL,SUBJECT,MESSAGE,STATUS," +
                "CREATED_AT,CREATED_BY) VALUES (?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, contact.getName(), contact.getMobileNum(),
                contact.getEmail(), contact.getSubject(), contact.getMessage(),
                contact.getStatus(), contact.getCreatedAt(), contact.getCreatedBy());
    }

    public List<Contact> findMsgsWithStatus(String status) {
        String sql = "SELECT * FROM CONTACT_MSG WHERE STATUS = :status";
        SqlParameterSource namedParameters = new MapSqlParameterSource("status", status);
        return jdbcTemplate.query(sql, new ContactRowMapper());
    }



}
