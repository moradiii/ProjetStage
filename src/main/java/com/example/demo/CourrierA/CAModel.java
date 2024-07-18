package com.example.demo.CourrierA;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "courriera")
public class CAModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Type")
    private String type;
    @Column(name = "Date")
    private LocalDate date;
    @Column(name = "DateBO")
    private LocalDate datebo;
    @Column(name = "Objet")
    private String objet;
    @Column(name = "Affectation")
    private String affet;
    @Column(name = "Destinataire")
    private String dest;
    @Column(name = "Numero")
    private long num;
    @Column(name = "NumeroBO")
    private Long numbo;
    @Column(name = "Origin")
    private String origin;
    @Column(name = "Observation")
    private String obs;
    @Column(name = "PieceJointe")
    private String pj;
    @Column(name = "CreatedAt")
    private LocalDateTime created;
    @Column(name = "UpdatedAt")
    private LocalDateTime updated;

    public CAModel() {
    }

    public CAModel(Long id, String type, LocalDate date, LocalDate datebo, String objet, String affet, String dest, long num, Long numbo, String origin, String obs, String pj, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.datebo = datebo;
        this.objet = objet;
        this.affet = affet;
        this.dest = dest;
        this.num = num;
        this.numbo = numbo;
        this.origin = origin;
        this.obs = obs;
        this.pj = pj;
        this.created = created;
        this.updated = updated;
    }

    public CAModel(String type, LocalDate date, LocalDate datebo, String objet, String affet, String dest, long num, Long numbo, String origin, String obs, String pj, LocalDateTime created, LocalDateTime updated) {
        this.type = type;
        this.date = date;
        this.datebo = datebo;
        this.objet = objet;
        this.affet = affet;
        this.dest = dest;
        this.num = num;
        this.numbo = numbo;
        this.origin = origin;
        this.obs = obs;
        this.pj = pj;
        this.created = created;
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "CAModel{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", datebo=" + datebo +
                ", objet='" + objet + '\'' +
                ", affet='" + affet + '\'' +
                ", dest='" + dest + '\'' +
                ", num=" + num +
                ", numbo=" + numbo +
                ", origin='" + origin + '\'' +
                ", obs='" + obs + '\'' +
                ", pj='" + pj + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalDate getDatebo() {
        return datebo;
    }
    public void setDatebo(LocalDate datebo) {
        this.datebo = datebo;
    }
    public String getObjet() {
        return objet;
    }
    public void setObjet(String objet) {
        this.objet = objet;
    }
    public String getAffet() {
        return affet;
    }
    public void setAffet(String affet) {
        this.affet = affet;
    }
    public String getDest() {
        return dest;
    }
    public void setDest(String dest) {
        this.dest = dest;
    }
    public long getNum() {
        return num;
    }
    public void setNum(long num) {
        this.num = num;
    }
    public Long getNumbo() {
        return numbo;
    }
    public void setNumbo(Long numbo) {
        this.numbo = numbo;
    }
    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getObs() {
        return obs;
    }
    public void setObs(String obs) {
        this.obs = obs;
    }
    public String getPj() {
        return pj;
    }
    public void setPj(String pj) {
        this.pj = pj;
    }
    public LocalDateTime getCreated() {
        return created;
    }
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
    public LocalDateTime getUpdated() {
        return updated;
    }
    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}
