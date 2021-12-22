package com.ascent_project.RBAC.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="role")
@NoArgsConstructor
@AllArgsConstructor
//notused
public class Role {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String valid_for;
    private String role_code;
    private String Status;
}
