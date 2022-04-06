package application.model;

import application.controller.Controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import storage.Storage;

import java.awt.image.renderable.ContextualRenderedImageFactory;

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
    private Ordrelinje ordrelinje4;
    private Salg salg3;
    private Salg salg4;
    private Salg salg5;
    private Betaling betaling;

    @BeforeEach
    void setUp(){
        pg = Controller.getInstance().createProduktGruppe("Flakseøl");
        p1 = pg.createProdukt("Klosterbryg", "5%");
        p2 = pg.createProdukt("Forårsbryg", "7%");
        ss = Controller.getInstance().createSalgssituation("Fredagsbar", "kl. 16-22");
        prisKlipKlosterbryg = ss.createPris(70, 2, p1);
        prisKlipForårsbryg = ss.createPris(70, 2, p2);
        betaling = Controller.getInstance().createBetaling(Betalingsformer.KLIPPEKORTBETALING);

        salg1 = Controller.getInstance().createSalg(ss);
        ordrelinje1 = salg1.createOrdrelinje(2, p1);
        ordrelinje2 = salg1.createOrdrelinje(1, p2);

        salg2 = Controller.getInstance().createSalg(ss);
        ordrelinje3 = salg2.createOrdrelinje(2, p1);

        salg3 = Controller.getInstance().createSalg(ss);

        salg4 = Controller.getInstance().createSalg(ss);
        ordrelinje4 = salg4.createOrdrelinje(3, p1);
        ordrelinje4.setBetaling(betaling, 2);

        salg5 = Controller.getInstance().createSalg(ss);

    }

        @Test
        void beregnSamletBeloebOgKlip1() {
        //TC1
        assertEquals(210, salg1.getSamletBeloeb(), "Samlet beløb afviger fra 210");
    }
        @Test
        void beregnSamletBeloebOgKlip2() {
        //TC2
        Rabat rabat = salg2.createRabatPct(10);
        assertEquals(126, salg2.getSamletBeloeb());
    }
        @Test
        void beregnSamletBeloebOgKlip3() {
        //TC3
        Rabat rabat3 = salg2.createRabatBeloeb(10);
        assertEquals(130, salg2.getSamletBeloeb());
    }

        @Test
        void beregnSamletBeloebOgKlip4() {
        //TC4
        assertThrows(IllegalArgumentException.class, () -> salg3.beregnSamletBeloebOgKlip());
    }

        @Test
        void beregnSamletBeloebOgKlip5() {
        //TC5
        assertEquals(140, salg2.getSamletBeloeb(), "samlet beløb afviger fra 140");
    }

        @Test
        void beregnSamletBeloebOgKlip6() {
        //TC6
        assertEquals(210, salg1.getSamletBeloeb(), "samlet beløb afviger fra 210");
    }

    @Test
    void beregnSamletBeloebOgKlip7() {
        //TC7
        salg4.beregnSamletBeloebOgKlip();
        assertEquals(70, salg4.getSamletBeloeb(), "samlet beløb afviger fra 210");
        assertEquals(4, salg4.getSamletAntalKlip(), "samlet antal klip afviger fra 4");
    }


    @Test
    void createOrdrelinje1() {
        //TC1
        salg5.createOrdrelinje(2, p1);
        assertEquals(1, salg5.getOrdrelinjer().size(), "Ordrelinjen er ikke blevet tilføjet");


    }

    @Test
    void createRabatPct() {
    }

    @Test
    void createRabatBeloeb() {
    }
}