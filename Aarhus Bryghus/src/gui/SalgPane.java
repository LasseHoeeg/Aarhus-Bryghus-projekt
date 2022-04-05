package gui;

import application.controller.Controller;
import application.model.*;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class SalgPane extends GridPane {

    // -------------------------------------------------------------------------

    // listviews
    private final ListView<Pris> lwSalgsSituationProdukter = new ListView();
    private final ListView<Ordrelinje> lwOrdrelinje = new ListView();

    // buttons
    private final Button btnTilføjOrdrelinje = new Button();
    private final Button btnFjernOrdrelinje = new Button();
    private final Button btnRabat = new Button();
    private final Button btnBetal = new Button();
    //TODO
    private final Button btnLeje = new Button();

    // texts
    private final Text txtAarhusBryghus = new Text("Aarhus Bryghus Produkter:");
    private final Text txtIndKurvOrdrelinje = new Text("Indkøbskurv:");

    // textfields
    private final TextField txfAntalProdukter = new TextField();
    private final TextField txfSumOrdrelinje = new TextField();
    //TODO
    private final TextField txfBeloeb = new TextField();


    // combobox
    private final ComboBox<Salgssituation> cbSalgssituation = new ComboBox();
    //TODO
    private final ComboBox<Betaling> cbBetaling = new ComboBox();

    // atributter
    private Salg salg;

    public SalgPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        // ListViews

        this.add(lwSalgsSituationProdukter, 0, 2, 2, 2);
        lwSalgsSituationProdukter.setPrefWidth(50);
        lwSalgsSituationProdukter.setPrefHeight(150);
        ChangeListener<Pris> listenerSSP = (ov, oldString, newString) -> this.selectionChangedSalgsSituationProdukter();
        lwSalgsSituationProdukter.getSelectionModel().selectedItemProperty().addListener(listenerSSP);

        this.add(lwOrdrelinje, 2, 2, 3, 1);
        lwOrdrelinje.setPrefWidth(50);
        lwOrdrelinje.setPrefHeight(150);
        ChangeListener<Ordrelinje> listenerOl = (ov, oldString, newString) -> this.selectionChangedOrdrelinje();
        lwOrdrelinje.getSelectionModel().selectedItemProperty().addListener(listenerOl);

        // Texts

        this.add(txtAarhusBryghus,0,1);
        this.add(txtIndKurvOrdrelinje,2,1);


        // Buttons

        this.add(btnTilføjOrdrelinje, 1, 4);
        btnTilføjOrdrelinje.setText("Tilføj");
        btnTilføjOrdrelinje.setPrefWidth(60);
        btnTilføjOrdrelinje.setOnAction(e -> tilføjOrdrelinje());

        this.add(btnFjernOrdrelinje, 2, 3);
        btnFjernOrdrelinje.setText("Fjern");
        btnFjernOrdrelinje.setPrefWidth(90);
        btnFjernOrdrelinje.setOnAction(e -> fjernOrdrelinje());

        this.add(btnRabat, 3, 3);
        btnRabat.setText("Rabat");
        btnRabat.setPrefWidth(60);
        btnRabat.setOnAction(e -> rabat());

        this.add(btnBetal, 4, 4);
        btnBetal.setText("Betal");
        btnBetal.setPrefWidth(60);
        btnBetal.setOnAction(e -> betal());

        this.add(btnLeje, 4, 1);
        btnLeje.setText("Leje");
        btnLeje.setPrefWidth(60);
        btnLeje.setOnAction(e -> leje());

        // TextFields

        this.add(txfAntalProdukter,0,4);
        txfAntalProdukter.setPromptText("Antal:");
        txfAntalProdukter.setPrefWidth(100);

        this.add(txfBeloeb,3,4);
        txfBeloeb.setPromptText("Klip / Beløb");
        txfBeloeb.setPrefWidth(60);

        this.add(txfSumOrdrelinje,4,3);
        txfSumOrdrelinje.setPromptText("sum:");
        txfSumOrdrelinje.setPrefWidth(60);
        txfSumOrdrelinje.setDisable(true);

        // ComboBoxs

        this.add(cbSalgssituation,0,0);
        cbSalgssituation.setPromptText("Prislister");
        cbSalgssituation.getItems().setAll(Controller.getInstance().getSalgssituationer());
        ChangeListener listenerSS = (ov, oldString, newString) -> this.selectionChangedSalgssituation();
        cbSalgssituation.getSelectionModel().selectedItemProperty().addListener(listenerSS);
        cbSalgssituation.setOnMouseClicked(e -> UpdateSalgssituation());

        this.add(cbBetaling,2,4);
        cbBetaling.setPromptText("Betaling");
        cbBetaling.setPrefWidth(90);
//        cbBetaling.getItems().setAll(Controller.getInstance().get);
        ChangeListener listenerBe = (ov, oldString, newString) -> this.selectionChangedSalgssituation();
        cbBetaling.getSelectionModel().selectedItemProperty().addListener(listenerBe);
        cbBetaling.setOnMouseClicked(e -> selectionChangedBetalling());








    }

    public void UpdateSalgssituation() {
        cbSalgssituation.getItems().setAll(Controller.getInstance().getSalgssituationer());
    }

    private void selectionChangedSalgssituation() {
            Salgssituation selected = cbSalgssituation.getSelectionModel().getSelectedItem();
            lwSalgsSituationProdukter.getItems().setAll(selected.getPriser());
            salg = new Salg(selected);

    }

    private void selectionChangedBetalling() {
        Betaling selected = cbBetaling.getSelectionModel().getSelectedItem();
//        lwSalgsSituationProdukter.getItems().setAll(selected.getPriser());
//        salg = new Salg(selected);

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
        if (selected != null && Integer.parseInt(txfAntalProdukter.getText()) > 0 ) {
            salg.createOrdrelinje(Integer.parseInt(txfAntalProdukter.getText()), selected.getProdukt());
            lwOrdrelinje.getItems().setAll(salg.getOrdrelinjer());
            sumChanged();
        }
    }

    private void fjernOrdrelinje() {
        Ordrelinje selected = lwOrdrelinje.getSelectionModel().getSelectedItem();
        if (selected != null) {
            salg.removeOrdrelinje(selected);
            lwOrdrelinje.getItems().setAll(salg.getOrdrelinjer());
            sumChanged();
        }
    }

    private void rabat() {
//        sumChanged();
    }

    private void betal() {
//        Controller.getInstance().

    }
    private void leje() {
        Controller.getInstance().tivngSalgTilLeje(this.salg);
    }

}

