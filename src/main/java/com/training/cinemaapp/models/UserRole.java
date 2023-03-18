package com.training.cinemaapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "user_role")
@Data
@IdClass(UserRoleId.class)
@NoArgsConstructor
public class UserRole {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "role_id")
    private Integer roleId;


//    @ManyToOne(optional = false)
//    @MapsId("userId")
//    private UserAccount user;
//
//    @ManyToOne(optional = false)
//    @MapsId("roleId")
//    private Role role;

}
