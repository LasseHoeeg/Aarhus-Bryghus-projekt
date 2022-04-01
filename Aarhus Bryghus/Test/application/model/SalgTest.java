package application.model;

import application.controller.Controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import storage.Storage;

import static org.junit.jupiter.api.Assertions.*;

class SalgTest {
    private ProduktGruppe pg;
    private Produkt p1;
    private Produkt p2;
    private Salgssituation ss;
    private Pris prisBeløb;
    private Pris prisKlipKlosterbryg;
    private Pris prisKlipForårsbryg;
    private Salg salg1;
    private Ordrelinje ordrelinje1;
    private Ordrelinje ordrelinje2;
    private Salg salg2;
    private Ordrelinje ordrelinje3;
    private Salg salg3;


    @BeforeEach
    void setUp(){
        pg = Controller.getInstance().createProduktGruppe("Flakseøl");
        p1 = pg.createProdukt("Klosterbryg", "5%");
        p2 = pg.createProdukt("Forårsbryg", "7%");
        ss = Controller.getInstance().createSalgssituation("Fredagsbar", "kl. 16-22");
        prisKlipKlosterbryg = ss.createPris(70, 2, p1);
        prisKlipForårsbryg = ss.createPris(70, 2, p2);

        salg1 = Controller.getInstance().createSalg(ss);
        ordrelinje1 = salg1.createOrdrelinje(2, p1);
        ordrelinje2 = salg1.createOrdrelinje(1, p2);

        salg2 = Controller.getInstance().createSalg(ss);
        ordrelinje3 = salg2.createOrdrelinje(2, p1);

        salg3 = Controller.getInstance().createSalg(ss);
    }

    @Test
    void beregnSamletBeloebOgKlip() {
        //TC1
        assertEquals(210, salg1.getSamletBeloeb(), "Samlet beløb afviger fra 210");
        //TC2
        //assertEquals(126, salg2.createRabatPct(10).getRabat(140)); //fixme returnerer 14 kr
        //TC3
        //assertEquals(130, salg2.createRabatBeloeb(10).getRabat(140)); //fixme 10 kr - same
        //TC4
        //assertEquals(IllegalArgumentException, salg3.getSamletBeloeb()); //todo import?
        //TC5
        assertEquals(140, salg2.getSamletBeloeb(), "samlet beløb afviger fra 140");
        //TC6
        assertEquals(210, salg1.getSamletBeloeb(), "samlet beløb afviger fra 210");
    }

    @Test
    void createOrdrelinje() {

    }

    @Test
    void createRabatPct() {
    }

    @Test
    void createRabatBeloeb() {
    }
}