package com.example.demo.User;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Username")
    private String username;
    @Column(name = "Email")
    private String email;
    @Column(name = "PWD")
    private String pwd;
    @Column(name = "Role_id")
    private Long rid;
    @Column(name = "Service")
    private String serv;
    @Column(name = "`Divison`") // Escaping the reserved keyword div
    private String div;

    public UserModel() {
    }

    public UserModel(Long id, String username, String email, String pwd, Long rid, String serv, String div) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.pwd = pwd;
        this.rid = rid;
        this.serv = serv;
        this.div = div;
    }

    public UserModel(String username, String email, String pwd, Long rid, String serv, String div) {
        this.username = username;
        this.email = email;
        this.pwd = pwd;
        this.rid = rid;
        this.serv = serv;
        this.div = div;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                ", rid=" + rid +
                ", serv='" + serv + '\'' +
                ", div='" + div + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public long getRid() {
        return rid;
    }
    public void setRid(Long rid) {
        this.rid = rid;
    }
    public String getServ() {
        return serv;
    }
    public void setServ(String serv) {
        this.serv = serv;
    }
    public String getDiv() {
        return div;
    }
    public void setDiv(String div) {
        this.div = div;
    }
}
