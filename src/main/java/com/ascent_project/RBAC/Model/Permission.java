package com.ascent_project.RBAC.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="permission")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission {
    @Id
    @GeneratedValue
    private long id;

    private String permission_name;
    private String permission_description;
    private String permission_valid_for;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="user_role_id")
@OnDelete(action= OnDeleteAction.CASCADE)
  private UserRole userRole;

}
