package gui;

import application.controller.Controller;
import application.model.*;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class Gui extends Application {
    private Controller controller;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Statestik");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------


    // datepicker

    private final DatePicker dpdateStart = new DatePicker();
    private final DatePicker dpdateSlut = new DatePicker();
    private final DatePicker dpDagsOpgoer = new DatePicker();




    // listviews
    private final ListView<Salg> lwAntalKlipPrProduktPeriode = new ListView();
    private final ListView<Salg> lwDagsOpgoer = new ListView();
    private final ListView<Leje> lwLejedeUafleveredeProdukter = new ListView();



    // buttons


    // texts
    private final Text txtPeriodeForKlip = new Text("Klip");
    private final Text txtPeriodeForKlipProdukt = new Text("Antal klip pr produkt periode:");
    private final Text txtDagsOpgoer = new Text("Dagsopgør");
    private final Text txtKviteringer = new Text("Kviteringer:");
    private final Text txtUdeje = new Text("Udlejede Produkter:");
    private final Text txtLeje = new Text("Leje");





    // textfields
    private final TextField txfSumDagsOpgoer = new TextField();
    private final TextField txfSumKlip = new TextField();


    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(50));

        // set horizontal gap between components
        pane.setHgap(10);

        // set vertical gap between components
        pane.setVgap(10);

        // Listviews

        pane.add(lwAntalKlipPrProduktPeriode, 0, 3, 2, 2);
        lwAntalKlipPrProduktPeriode.setPrefWidth(25);
        lwAntalKlipPrProduktPeriode.setPrefHeight(200);
//        ChangeListener<Pris> listenerK = (ov, oldString, newString) -> this.selectionChangedKlip();
//        lwAntalKlipPrProduktPeriode.getSelectionModel().selectedItemProperty().addListener(listenerK);

        pane.add(lwDagsOpgoer, 3, 3, 1, 2);
        lwDagsOpgoer.setPrefWidth(25);
        lwDagsOpgoer.setPrefHeight(200);

        pane.add(lwLejedeUafleveredeProdukter, 5, 3, 1, 3);
        lwLejedeUafleveredeProdukter.setPrefWidth(100);
        lwLejedeUafleveredeProdukter.setPrefHeight(200);
//        ChangeListener<Pris> listenerK = (ov, oldString, newString) -> this.selectionChangedKlip();
//        lwAntalKlipPrProduktPeriode.getSelectionModel().selectedItemProperty().addListener(listenerK);


        // Texts

        pane.add(txtPeriodeForKlip,0,0);
        pane.add(txtPeriodeForKlipProdukt,0,2);
        pane.add(txtDagsOpgoer,3, 0);
        pane.add(txtKviteringer,3, 2);
        pane.add(txtLeje,5, 2);


        // DatePicker

        pane.add(dpdateSlut, 1, 1);
        dpdateSlut.setPromptText("Slut dato");
        dpdateSlut.setEditable(false);


        pane.add(dpdateStart, 0, 1);
        dpdateStart.setPromptText("Start dato");
        dpdateStart.setEditable(false);


        pane.add(dpDagsOpgoer, 3, 1);
        dpDagsOpgoer.setPromptText("Dato Dagsopgør");
        dpDagsOpgoer.setEditable(false);
        dpDagsOpgoer.setOnMouseExited(e -> eventDagsOpgoer());


        // Textfields


        pane.add(txfSumKlip,0,5, 2, 1);
        txfSumKlip.setPromptText("sum:");
        txfSumKlip.setPrefWidth(20);
        txfSumKlip.setEditable(false);

        pane.add(txfSumDagsOpgoer,3,5, 1, 1);
        txfSumDagsOpgoer.setPromptText("sum:");
        txfSumDagsOpgoer.setPrefWidth(20);
        txfSumDagsOpgoer.setEditable(false);






    }

// ProduktGruppe funktioner

    private void eventDagsOpgoer() {
        if (dpDagsOpgoer!=null){
            lwDagsOpgoer.getItems().setAll(Controller.getInstance().getDagsKvitteringer(dpDagsOpgoer.getValue()));
            txfSumDagsOpgoer.setText("sum: " + Controller.getInstance().getDagsopgoer(dpDagsOpgoer.getValue()));
        }

//        Salgssituation selected = cbSalgssituation.getSelectionModel().getSelectedItem();
//        lwAntalKlipPrProduktPeriode.getItems().setAll(selected.getPriser());
//        salg = new Salg(selected);
    }
//TODO
    private void selectionChangedKlip() {
        if (dpdateStart!=null&&dpdateSlut!=null)
            lwAntalKlipPrProduktPeriode.getItems().setAll();
    }



    private void tilføjOrdrelinje() {
//        Pris selected = lwSalgsSituationProdukter.getSelectionModel().getSelectedItem();
//        if (selected != null && Integer.parseInt(txfAntalProdukter.getText()) > 0) {
//            salg.createOrdrelinje(Integer.parseInt(txfAntalProdukter.getText()), selected.getProdukt());
//            lwOrdrelinje.getItems().setAll(salg.getOrdrelinjer());
//            sumChanged();
//        }
    }

//    private void fjernOrdrelinje() {
//        Ordrelinje selected = lwOrdrelinje.getSelectionModel().getSelectedItem();
//        if (selected != null) {
////            salg.removeOrdrelinje(selected);
////            lwOrdrelinje.getItems().setAll(salg.getOrdrelinjer());
////            sumChanged();
//        }
//    }

    private void rabat() {
//        sumChanged();
    }

    private void betal() {}

//
//    private void updateProduktGruppe() {
//        ProduktGruppe selected = lwProduktGruppe.getSelectionModel().getSelectedItem();
//        if (selected != null) {
//            //TODO brug update
//            selected.setNavn(txfProduktGruppeNavn.getText());
//            lwProduktGruppe.getItems().setAll(Controller.getInstance().getProduktGrupper());
//        }
//    }
//
//    private void deleteProduktGruppe() {
//        ProduktGruppe selected = lwProduktGruppe.getSelectionModel().getSelectedItem();
//        if (selected != null) {
//            Controller.getInstance().removeProduktGruppe(selected);
//            lwProduktGruppe.getItems().setAll(Controller.getInstance().getProduktGrupper());
//        }
//    }
//
//// Salgssituation funktioner
//
//    private void selectionChangedSalgssituation() {
//        Salgssituation selected = lwSalgsSituation.getSelectionModel().getSelectedItem();
//        txfSalgsSituationNavn.setText(selected.getNavn());
//        txfSalgsSituationBeskrivelse.setText(selected.getBeskrivelse());
//        //TODO (Tjek om given produkt har pris til salgsituation)
//        lwPris.getItems().setAll(selected.getPriser());
//    }
//
//    private void createSalgssituation() {
//        if (txfSalgsSituationNavn.getText() != null && txfSalgsSituationBeskrivelse.getText() != null) {
//            Controller.getInstance().createSalgssituation(txfSalgsSituationNavn.getText(), txfSalgsSituationBeskrivelse.getText());
//            lwSalgsSituation.getItems().setAll(Controller.getInstance().getSalgssituationer());
//        }
//    }
//
//    private void updateSalgssituation() {
//        Salgssituation selected = lwSalgsSituation.getSelectionModel().getSelectedItem();
//        if (selected != null) {
//            //TODO brug update
//            selected.setNavn(txfSalgsSituationNavn.getText());
//            selected.setBeskrivelse(txfSalgsSituationBeskrivelse.getText());
//            lwSalgsSituation.getItems().setAll(Controller.getInstance().getSalgssituationer());
//        }
//    }
//
//    private void deleteSalgssituation() {
//        Salgssituation selected = lwSalgsSituation.getSelectionModel().getSelectedItem();
//        if (selected != null) {
//            Controller.getInstance().removeSalgssituation(selected);
//            lwSalgsSituation.getItems().setAll(Controller.getInstance().getSalgssituationer());
//        }
//    }
//
//// Produkt funktioner
//
//    private void selectionChangedProdukt() {
//        Produkt selected = lwProdukt.getSelectionModel().getSelectedItem();
//        txfProduktNavn.setText(selected.getNavn());
//        txfProduktBeskrivelse.setText(selected.getBeskrivelse());
//        //TODO (Tjek om given produkt har pris til salgsituation)
////        lwProdukt.getItems().setAll(selected.getProdukter());
//    }
//
//    private void createProdukt() {
//        if (txfProduktNavn.getText() != null && txfProduktBeskrivelse.getText() != null) {
//            ProduktGruppe selected = lwProduktGruppe.getSelectionModel().getSelectedItem();
//            selected.createProdukt(txfProduktNavn.getText(),txfProduktBeskrivelse.getText());
//            lwProdukt.getItems().setAll(selected.getProdukter());
//        }
//    }
//
//    private void updateProdukt() {
//        Produkt selected = lwProdukt.getSelectionModel().getSelectedItem();
//        if (selected != null) {
//            //TODO brug update
//            selected.setNavn(txfProduktNavn.getText());
//            selected.setBeskrivelse(txfProduktBeskrivelse.getText());
//            lwProdukt.getItems().setAll(selected.getProduktGruppe().getProdukter());
//        }
//    }
//
//    private void deleteProdukt() {
//        Produkt selected = lwProdukt.getSelectionModel().getSelectedItem();
//        if (selected != null) {
//            selected.getProduktGruppe().removeProdukt(selected);
//            lwProdukt.getItems().setAll(selected.getProduktGruppe().getProdukter());
//        }
//    }
//
//// Pris funktioner
//
//    private void selectionChangedPris() {
//        Pris selected = lwPris.getSelectionModel().getSelectedItem();
//        txfPrisBeløb.setText(selected.getBeloeb()+"");
//        txfPrisKlip.setText(selected.getAntalKlip()+"");
//    }
//
//    private void createPris() {
//        Salgssituation selectedSS = lwSalgsSituation.getSelectionModel().getSelectedItem();
//        Produkt selectedPro = lwProdukt.getSelectionModel().getSelectedItem();
//        if (selectedSS!=null && selectedPro!=null) {
//            if (txfPrisBeløb.getText() != null && txfPrisKlip.getText() != null) {
//                selectedSS.createPris(Double.parseDouble(txfPrisBeløb.getText()), Integer.parseInt(txfPrisKlip.getText()), selectedPro);
//                lwPris.getItems().setAll(selectedSS.getPriser());
//
//            }
//            if (txfPrisBeløb.getText() != null && txfPrisKlip.getText()==null) {
//                Salgssituation selected = lwSalgsSituation.getSelectionModel().getSelectedItem();
//                selectedSS.createPris(Double.parseDouble(txfPrisBeløb.getText()), selectedPro);
//                lwPris.getItems().setAll(selectedSS.getPriser());
//            }
//        }
//    }
//
//    private void updatePris() {
//        Pris selected = lwPris.getSelectionModel().getSelectedItem();
//        if (selected != null) {
//            //TODO brug update
//            selected.setBeloeb(Double.parseDouble(txfPrisBeløb.getText()));
//            if (txfPrisKlip.getText()!=null){
//                selected.setAntalKlip(Integer.parseInt(txfProduktBeskrivelse.getText()));
//            }
//            else {
//                selected.setAntalKlip(0);
//            }
//            lwPris.getItems().setAll(selected.getProdukt().getPriser());
//        }
//    }
//
//    private void deletePris() {
//        Pris selected = lwPris.getSelectionModel().getSelectedItem();
//        if (selected != null) {
//            selected.getSalgssituation().removePris(selected);
//            lwPris.getItems().setAll(selected.getSalgssituation().getPriser());
//        }
//    }
//

}


