package cz.czechitas.java2webapps.ukol5.controller;

public enum Pohlavie {
    CHLAPEC("Chlapec"),
    DIEVCA("Dievča");

    private final String displayValue;

    private Pohlavie(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return  displayValue;
    }
}
