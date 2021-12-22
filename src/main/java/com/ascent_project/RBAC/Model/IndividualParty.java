package com.ascent_project.RBAC.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndividualParty {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String user_code;

}
