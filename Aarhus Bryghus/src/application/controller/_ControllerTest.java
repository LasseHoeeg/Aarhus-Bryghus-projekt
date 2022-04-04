package application.controller;

import application.model.*;

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

        System.out.println(pg1.getProdukter());
        System.out.println();
        System.out.println(s1.getPriser());
        System.out.println();
        System.out.println(pr1.getSalgssituation());
        System.out.println();
        System.out.println(pr1.getProdukt());
        System.out.println();
        System.out.println(p1.getPriser());
        System.out.println();
        System.out.println(p1.getProduktGruppe());

        // Controllertest

        Salg salg = Controller.getInstance().createSalg(s1);
        Ordrelinje ordrelinje = salg.createOrdrelinje(5, p1);
        Ordrelinje ordrelinje2 = salg.createOrdrelinje(2, p1);
        Ordrelinje ordrelinje3 = salg.createOrdrelinje(1, p1);



        //System.out.println("Ordrelinjepris i beløb linje 2: "+ordrelinje2.getOrdrelinjePris() +" kr");
        //System.out.println("Ordrelinjepris i Klip linje 2: "+ordrelinje2.getOrdrelinjeKlip()+" klip");
     //   salg.beregnSamletBeloebOgKlip();
        System.out.println("ol? "+salg.getOrdrelinjer());
        System.out.println("Salgspris total beløb: "+salg.getSamletBeloeb());
        System.out.println("Salgspris total antalKlip: "+salg.getSamletAntalKlip());
        System.out.println(salg.getSamletBeloeb());

        Rabat rabat1 = ordrelinje.createRabatProcent(20);
        //Rabat rabat2 = ordrelinje2.createRabatBeloeb(20);
        //System.out.println(ordrelinje2.getOrdrelinjePris());

        Rabat rabat3 = salg.createRabatPct(10);
        Rabat rabat4 = salg.createRabatBeloeb(100);
        System.out.println(salg.getSamletBeloeb());

        //Test af betalingsformer
        //KlippekortBetaling kb1 = new KlippekortBetaling("Klippekort-xx");
        //KlippekortBetaling kb2 = new Betalingsform("Klippekort-yy");
        //KlippekortBetaling kb3 =KlippekortBetaling.getInstance("Klip");

        //Betalingsform kb4 =Betalingsform.getInstance("*Navn på betalingsform*");
        //System.out.println("Test af betalingsform: "+kb4);

        //TODO Static på salg test

        //TODO Tjek om rabat




    }


}
