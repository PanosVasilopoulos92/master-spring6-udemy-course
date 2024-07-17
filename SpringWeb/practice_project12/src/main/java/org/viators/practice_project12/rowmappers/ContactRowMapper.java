package org.viators.practice_project12.rowmappers;

import org.springframework.jdbc.core.RowMapper;
import org.viators.practice_project12.model.Contact;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ContactRowMapper implements RowMapper<Contact> {

    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact contact = new Contact();
        contact.setContact_id(rs.getInt("CONTACT_ID"));
        contact.setName(rs.getString("NAME"));
        contact.setMobileNum(rs.getString("MOBILE_NUM"));
        contact.setEmail(rs.getString("EMAIL"));
        contact.setSubject(rs.getString("SUBJECT"));
        contact.setMessage(rs.getString("MESSAGE"));
        contact.setStatus(rs.getString("STATUS"));
        contact.setCreatedAt(rs.getTimestamp("CREATED_AT").toLocalDateTime());
        contact.setCreatedBy(rs.getString("CREATED_BY"));

        if (rs.getTimestamp("UPDATED_AT") != null) {
            contact.setUpdatedAt(rs.getTimestamp("UPDATED_AT").toLocalDateTime());
        }
        if (rs.getString("UPDATED_BY") != null) {
            contact.setUpdatedBy(rs.getString("UPDATED_BY"));
        }

        return contact;
    }
}
