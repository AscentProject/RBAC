package com.ascent_project.RBAC.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@Table(name="user_role")
@NoArgsConstructor
@AllArgsConstructor

public class UserRole {
    @Id
    @GeneratedValue
    private long id;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn
//    private IndividualParty user;
    private long user_id;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn
//    private Role role;
    private long role_id;
    private String valid_for;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn
//    private Permission permission;
}
