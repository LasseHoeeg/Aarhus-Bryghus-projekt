package gui;

import application.controller.Controller;
import application.model.*;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

public class Gui extends Application {
    private Controller controller;

    @Override
    public void start(Stage stage) {
        stage.setTitle("CRUD Menu");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    // listviews
    private final ListView<Pris> lwSalgsSituationProdukter = new ListView();
    private final ListView<Ordrelinje> lwOrdrelinje = new ListView();

    // buttons
    private final Button btnTilføjOrdrelinje = new Button();
    private final Button btnFjernOrdrelinje = new Button();
    private final Button btnRabat = new Button();
    private final Button btnBetal = new Button();

    // texts
    private final Text txtAarhusBryghus = new Text("Aarhus Bryghus Produkter:");
    private final Text txtIndKurvOrdrelinje = new Text("Indkøbskurv:");

    // textfields
    private final TextField txfAntalProdukter = new TextField();
    private final TextField txfSumOrdrelinje = new TextField();

    // combobox
    private final ComboBox<Salgssituation> cbSalgssituation = new ComboBox();

    // atributter
    private Salg salg;
    private int antal;

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

        pane.add(lwSalgsSituationProdukter, 0, 2, 2, 2);
        lwSalgsSituationProdukter.setPrefWidth(50);
        lwSalgsSituationProdukter.setPrefHeight(150);
        ChangeListener<Pris> listenerSSP = (ov, oldString, newString) -> this.selectionChangedSalgsSituationProdukter();
        lwSalgsSituationProdukter.getSelectionModel().selectedItemProperty().addListener(listenerSSP);

        pane.add(lwOrdrelinje, 2, 2, 2, 1);
        lwOrdrelinje.setPrefWidth(50);
        lwOrdrelinje.setPrefHeight(150);
        ChangeListener<Ordrelinje> listenerOl = (ov, oldString, newString) -> this.selectionChangedOrdrelinje();
        lwOrdrelinje.getSelectionModel().selectedItemProperty().addListener(listenerOl);

        // Texts

        pane.add(txtAarhusBryghus,0,1);
        pane.add(txtIndKurvOrdrelinje,2,1);


        // Buttons

        pane.add(btnTilføjOrdrelinje, 1, 4);
        btnTilføjOrdrelinje.setText("Tilføj");
        btnTilføjOrdrelinje.setPrefWidth(60);
        btnTilføjOrdrelinje.setOnAction(e -> tilføjOrdrelinje());

        pane.add(btnFjernOrdrelinje, 2, 3);
        btnFjernOrdrelinje.setText("Fjern");
        btnFjernOrdrelinje.setPrefWidth(60);
        btnFjernOrdrelinje.setOnAction(e -> fjernOrdrelinje());

        pane.add(btnRabat, 2, 4);
        btnRabat.setText("Rabat");
        btnRabat.setPrefWidth(60);
        btnRabat.setOnAction(e -> rabat());

        pane.add(btnBetal, 3, 4);
        btnBetal.setText("Betal");
        btnBetal.setPrefWidth(60);
        btnBetal.setOnAction(e -> betal());

        // TextFields

        pane.add(txfAntalProdukter,0,4);
        txfAntalProdukter.setPromptText("Antal:");
        txfAntalProdukter.setPrefWidth(100);

        pane.add(txfSumOrdrelinje,3,3);
        txfSumOrdrelinje.setPromptText("sum:");
        txfSumOrdrelinje.setPrefWidth(60);
        txfSumOrdrelinje.setDisable(true);

        // ComboBox
        pane.add(cbSalgssituation,0,0);
        cbSalgssituation.setPromptText("Prislister");
        cbSalgssituation.getItems().setAll(Controller.getInstance().getSalgssituationer());
        ChangeListener listenerSS = (ov, oldString, newString) -> this.selectionChangedSalgssituation();
        lwOrdrelinje.getSelectionModel().selectedItemProperty().addListener(listenerSS);





    }

// ProduktGruppe funktioner

    private void selectionChangedSalgssituation() {
        Salgssituation selected = cbSalgssituation.getSelectionModel().getSelectedItem();
        lwSalgsSituationProdukter.getItems().setAll(selected.getPriser());
        salg = new Salg(selected);
    }

    private void selectionChangedSalgsSituationProdukter() {
        Pris selected = lwSalgsSituationProdukter.getSelectionModel().getSelectedItem();
    }

    private void selectionChangedOrdrelinje() {
        Ordrelinje selected = lwOrdrelinje.getSelectionModel().getSelectedItem();
    }

    private void sumChanged() {
        txfSumOrdrelinje.setText(salg.getSamletBeloeb()+"");
    }


    private void tilføjOrdrelinje() {
        Pris selected = lwSalgsSituationProdukter.getSelectionModel().getSelectedItem();
        if (selected != null && Integer.parseInt(txfAntalProdukter.getText()) > 0) {
            salg.createOrdrelinje(Integer.parseInt(txfAntalProdukter.getText()), selected.getProdukt());
            lwOrdrelinje.getItems().setAll(salg.getOrdrelinjer());
            sumChanged();
        }
    }

    private void fjernOrdrelinje() {
        Ordrelinje selected = lwOrdrelinje.getSelectionModel().getSelectedItem();
        if (selected != null) {
//            salg.removeOrdrelinje(selected);
//            lwOrdrelinje.getItems().setAll(salg.getOrdrelinjer());
//            sumChanged();
        }
    }

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


