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
@EqualsAndHashCode(exclude = {"roles", "resources"})
@Entity
@Table(name = "crm_resource")
public class Resource {
    @Id
    @SequenceGenerator(name = "resourceGen", sequenceName = "seq_crm_resource")
    @GeneratedValue(generator = "resourceGen")
    private Integer id;
    @Column(unique = true, length = 100)
    private String name;
    @Column(length = 100)
    private String title;
    @Column(length = 300)
    private String href;
    @Column(length = 50)
    private String target;
    @Column(length = 100)
    private String constant;
    private Boolean shown;
    private Boolean enabled;
    private Boolean type;

    @ManyToOne
    @JoinColumn(name = "parent")
    private Resource parent;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "parent", fetch = FetchType.LAZY)
    private Set<Resource> resources = new HashSet<>();

    @ManyToMany(mappedBy = "resources")
    private Set<Role> roles = new HashSet<>();

}
