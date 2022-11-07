package com.citynow.residentinformationmanagement.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "role_authority")
public class RoleAuthority {
    @Id
    @Column(name = "id", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_code")
    private Role roleCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "authority_code")
    private Authority authorityCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Role getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(Role roleCode) {
        this.roleCode = roleCode;
    }

    public Authority getAuthorityCode() {
        return authorityCode;
    }

    public void setAuthorityCode(Authority authorityCode) {
        this.authorityCode = authorityCode;
    }

}