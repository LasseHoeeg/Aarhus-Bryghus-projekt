package application.controller;

import application.model.Pris;
import application.model.Produkt;
import application.model.ProduktGruppe;
import application.model.Salgssituation;

public class _ControllerTest {
    public static void main(String[] args) {
        Controller controller = Controller.getInstance();

        ProduktGruppe pg1 = controller.createProduktGruppe("Flaske");
        ProduktGruppe pg2 = controller.createProduktGruppe("Fadøl, 40 cl");
        ProduktGruppe pg3 = controller.createProduktGruppe("Spiritus");
        ProduktGruppe pg4 = controller.createProduktGruppe("Fustage");

        Produkt p1 = pg1.createProdukt("Klosterbryg", "Flaskeøl");
        Produkt p2 = pg1.createProdukt("Sweet Geogia Brown", "Flaskeøl");
        Produkt p3 = pg1.createProdukt("Extra Pilsner", "Flaskeøl");

        Produkt p4 = pg2.createProdukt("Jazz Classic", "Fadøl");
        Produkt p5 = pg2.createProdukt("Celebration", "Fadøl");
        Produkt p6 = pg2.createProdukt("Blondie", "Fadøl");

        Produkt p7 = pg3.createProdukt("Whisky", "45%");
        Produkt p8 = pg3.createProdukt("Liquor of Aarhus", "Spiritus");
        Produkt p9 = pg3.createProdukt("Lyng Gin", "50 cl");

        Produkt p10 = pg4.createProdukt("Forårsbryg", "20 liter");
        Produkt p11 = pg4.createProdukt("India Pale Ale", "20 liter");
        Produkt p12 = pg4.createProdukt("Julebryg", "20 liter");

        Salgssituation s1 = Controller.getInstance().createSalgssituation("Fredagsbar", "Studerende");
        Salgssituation s2 = Controller.getInstance().createSalgssituation("Butik", "Arbejde");

        Pris pr1 = s1.createPris(70, 2, p1);
        Pris pr2 = s1.createPris(70, 2, p2);
        Pris pr3 = s1.createPris(70, 2, p3);

        Pris pr4 = s2.createPris(36, p1);
        Pris pr5 = s2.createPris(36, p2);
        Pris pr6 = s2.createPris(36, p3);

        Pris pr7 = s1.createPris(38, 1, p4);
        Pris pr8 = s1.createPris(38, 1, p5);
        Pris pr9 = s1.createPris(38, 1, p6);

        Pris pr10 = s1.createPris(599, p7);
        Pris pr11 = s1.createPris(175, p8);
        Pris pr12 = s1.createPris(350, p9);

        Pris pr13 = s2.createPris(599, p7);
        Pris pr14 = s2.createPris(175, p8);
        Pris pr15 = s2.createPris(350, p9);

        Pris pr16 = s2.createPris(775, p10);
        Pris pr17 = s2.createPris(775, p11);
        Pris pr18 = s2.createPris(775, p12);




    }


}
