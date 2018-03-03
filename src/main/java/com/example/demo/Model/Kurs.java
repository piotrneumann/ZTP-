package com.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name = "kursy")
public class Kurs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idkursu")
    private int id;
    @Column(name = "nazwak")
    private String nazwa;
    @Column(name = "typk")
    private String typ;

    public Kurs() {
    }

    public Kurs(String nazwa, String typ) {
        this.nazwa = nazwa;
        this.typ = typ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String toFile() {
        return ";"+nazwa+";"+typ;
    }

    @Override
    public String toString() {
        return "Kurs{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", typ='" + typ + '\'' +
                '}';
    }

}
