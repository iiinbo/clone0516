package com.kbstar.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class User {
    private String user_id;
    private String user_name;
    private String user_gender;
    private String user_pwd;
    private String user_contact;
    private String user_address;
    private String user_birthday;
    private String admin_check; // 0:고객 / 1:관리자

    public User(String user_id, String user_name, String user_gender, String user_pwd, String user_contact, String user_address, String user_birthday) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_gender = user_gender;
        this.user_pwd = user_pwd;
        this.user_contact = user_contact;
        this.user_address = user_address;
        this.user_birthday = user_birthday;
    }



}