package com.tuyu.po;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author walker tu
 * @date 2017/11/1
 * @description：
 */
@Setter
@Getter
@EqualsAndHashCode(exclude = {"roles"})
@Entity
@Table(name = "crm_user")
public class User {
    @Id
    @SequenceGenerator(name = "UserGen", sequenceName = "seq_crm_user")
    @GeneratedValue(generator = "UserGen")
    private Integer id;

    @Column(unique = true)
    private String username;
    private String password;
    private String email;
    private Boolean enabled;
    private Boolean locked;
    @Column(length = 300)
    private String description;

    @ManyToMany
    @JoinTable(name = "crm_user_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles = new HashSet<>();

}
