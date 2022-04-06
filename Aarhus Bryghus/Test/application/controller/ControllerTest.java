package application.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {



    Controller controller = Controller.getInstance();

    @BeforeEach
    void setUp(){
    controller.initStorage(); //Kan man bruge objekterne her, eller skal der oprettes de objekter der skal bruges?

    }

    @Test
    void getDagsopgoer() {
    }

    @Test
    void getAntalBrugteKlip() {
    }

    @Test
    void getPrProduktAntalKlipIPeriode() {
    }
}