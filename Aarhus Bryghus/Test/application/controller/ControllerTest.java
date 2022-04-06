package application.controller;

import application.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import setup.StorageInitializer;
import storage.Storage;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    private Salgssituation ss1;
    private Salgssituation ss2;
    private Salg salg1;
    private Salg salg2;
    private Salg salg3;
    private ProduktGruppe pg1;
    private ProduktGruppe pg2;
    private Produkt p1;
    private Produkt p2;
    private Pris pris1;
    private Pris pris2;
    private Betaling b_klip;


    Controller controller = Controller.getInstance();

    @BeforeEach
    void setUp(){

        ss1 = controller.createSalgssituation("Butik", "");
        ss2 = controller.createSalgssituation("Fredagsbar", "");

        salg1 = controller.createSalg(ss1);
        salg2 = controller.createSalg(ss2);
        salg3 = controller.createSalg(ss1);

        pg1 = controller.createProduktGruppe("Flakseøl");
        pg2 = controller.createProduktGruppe("Fadøl");

        p1 = pg1.createProdukt("Klosterbryg", "Flaskeøl");
        p2 = pg2.createProdukt("Forårsbryg", "Fadøl");

        pris1 = ss1.createPris(70, p1);
        pris1 = ss2.createPris(70, p1);
        pris2 = ss1.createPris(70, 2, p2);
        pris2 = ss2.createPris(70, 2, p2);

        b_klip = controller.createBetaling(Betalingsformer.KLIPPEKORTBETALING);

        Storage.getInstance().getSalgssituationer();
    }

    @Test
    void getDagsopgoer1() {
        //TC1
        Ordrelinje ordrelinje1 = salg1.createOrdrelinje(3, p1);
        Ordrelinje ordrelinje2 = salg1.createOrdrelinje(3, p1);
        salg1.beregnSamletBeloebOgKlip();
        assertEquals(490, controller.getDagsopgoer(LocalDate.now()), "Afviger fra beløb");
    }

    @Test
    void getDagsopgoer2() {
        //TC2
        Ordrelinje ordrelinje3 = salg2.createOrdrelinje(1, p1);
        salg2.beregnSamletBeloebOgKlip();
        assertEquals(70, controller.getDagsopgoer(LocalDate.now()), "Afviger fra beløb");
    }

    @Test
    void getAntalBrugteKlip() {
        //TC1

    }

    @Test
    void getPrProduktAntalKlipIPeriode() {
    //TC1

    }
}