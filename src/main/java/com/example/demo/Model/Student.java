package com.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name = "studenci")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idstudenta")
    private int id;
    @Column(name="imies")
    private String imie;
    @Column(name="nazwiskos")
    private String nazwisko;
    @Column(name = "idkursu")
    private int idkusru;

    public Student() {
    }

    public Student(String imie, String nazwisko, int idkusru) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.idkusru = idkusru;
    }

    public Student(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getIdkusru() {
        return idkusru;
    }

    public void setIdkusru(int idkusru) {
        this.idkusru = idkusru;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", idkusru=" + idkusru +
                '}';
    }
}
