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
@EqualsAndHashCode(exclude = {"users", "resources"})
@Entity
@Table(name = "crm_role")
public class Role {
    @Id
    @SequenceGenerator(name = "roleGen", sequenceName = "seq_crm_role")
    @GeneratedValue(generator = "roleGen")
    private Integer id;
    @Column(unique = true, length = 100)
    private String name;
    @Column(length = 200)
    private String constant;
    private Boolean enabled;
    @Column(length = 300)
    private String description;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "crm_role_resource", joinColumns = {@JoinColumn(name = "role_id")}, inverseJoinColumns = {@JoinColumn(name = "resource_id")})
    private Set<Resource> resources = new HashSet<>();

}
