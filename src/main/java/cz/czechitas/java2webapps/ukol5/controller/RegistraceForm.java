package cz.czechitas.java2webapps.ukol5.controller;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;
import java.util.EnumSet;

public class RegistraceForm {
    @NotBlank
    private String meno;
    @NotBlank
    private String priezvisko;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate datumNarodenia;
    @NotNull
    private Pohlavie pohlavie;
    @NotNull
    private EnumSet<Sport> sporty;
    @NotNull
    private String turnus;
    @Email
    private String email;
    private String telefon;
    private int vek;

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }

    public LocalDate getDatumNarodenia() {
        return datumNarodenia;
    }

    public void setDatumNarodenia(LocalDate datumNarodenia) {
        this.datumNarodenia = datumNarodenia;
    }

    public Pohlavie getPohlavie() {
        return pohlavie;
    }

    public void setPohlavie(Pohlavie pohlavie) {
        this.pohlavie = pohlavie;
    }

    public EnumSet<Sport> getSporty() {
        return sporty;
    }

    public void setSporty(EnumSet<Sport> sporty) {
        this.sporty = sporty;
    }

    public String getTurnus() {
        return turnus;
    }

    public void setTurnus(String turnus) {
        this.turnus = turnus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getVek() {
        Period period = datumNarodenia.until(LocalDate.now());
        return period.getYears();
    }
}
