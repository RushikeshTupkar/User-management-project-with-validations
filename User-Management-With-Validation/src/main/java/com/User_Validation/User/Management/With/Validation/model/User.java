package com.User_Validation.User.Management.With.Validation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "User_table")
public class User {
    @Id

    private Integer user_id;
    private String user_name;

    private String date_of_birth;
    private String email;
    private String phone_number;
    private Date date ;
    private Timestamp time;


}
