package com.example.demo.CourrierD;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "courrierd")
public class CDModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Type")
    private String type;
    @Column(name = "Date")
    private LocalDate date;
    @Column(name = "DateTrait")
    private LocalDate datet;
    @Column(name = "Objet")
    private String objet;
    @Column(name = "Ampiliation")
    private String amp;
    @Column(name = "Destinataire")
    private String dest;
    @Column(name = "Numero")
    private long num;
    @Column(name = "Observation")
    private String obs;
    @Column(name = "PieceJointe")
    private String pj;
    @Column(name = "CreatedAt")
    private LocalDateTime created;
    @Column(name = "UpdatedAt")
    private LocalDateTime updated;

    public CDModel() {
    }

    public CDModel(Long id, String type, LocalDate date, LocalDate datet, String objet, String amp, String dest, long num, String obs, String pj, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.datet = datet;
        this.objet = objet;
        this.amp = amp;
        this.dest = dest;
        this.num = num;
        this.obs = obs;
        this.pj = pj;
        this.created = created;
        this.updated = updated;
    }

    public CDModel(String type, LocalDate date, LocalDate datet, String objet, String amp, String dest, long num, String obs, String pj, LocalDateTime created, LocalDateTime updated) {
        this.type = type;
        this.date = date;
        this.datet = datet;
        this.objet = objet;
        this.amp = amp;
        this.dest = dest;
        this.num = num;
        this.obs = obs;
        this.pj = pj;
        this.created = created;
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "CDModel{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", datet=" + datet +
                ", objet='" + objet + '\'' +
                ", amp='" + amp + '\'' +
                ", dest='" + dest + '\'' +
                ", num=" + num +
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
    public LocalDate getDatet() {
        return datet;
    }
    public void setDatet(LocalDate datet) {
        this.datet = datet;
    }
    public String getObjet() {
        return objet;
    }
    public void setObjet(String objet) {
        this.objet = objet;
    }
    public String getAmp() {
        return amp;
    }
    public void setAmp(String amp) {
        this.amp = amp;
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
