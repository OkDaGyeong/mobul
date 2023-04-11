package com.codehows.mobul.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter
@ToString
public class Users {

    @Id
    @Column(name = "user_id", nullable = false, length = 20)
    private String userId;

    @Column(name = "user_password", nullable = false, length = 20)
    private String userPassword;

    @Column(name = "user_phone", length = 20)
    private String userPhone;

//    @OneToMany(mappedBy = "users")
//    private List<Boards> board_writer;



}
