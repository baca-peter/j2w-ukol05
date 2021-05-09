package cz.czechitas.java2webapps.ukol5.controller;

public enum Sport {
    PLAVANI("Plavání"),
    BEH("Běh"),
    CYKLISTIKA("Cyklistika"),
    FOTBAL("Fotbal"),
    BASKETBAL("Basketbal"),
    HOKEJ("Hokej");

    private final String displayValue;

    private Sport(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return  displayValue;
    }
}
