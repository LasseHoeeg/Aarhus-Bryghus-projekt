package gui;

import application.controller.Controller;
import application.model.*;
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

    // texts
    private final Text txtPeriodeForKlip = new Text("Klip");
    private final Text txtPeriodeForKlipProdukt = new Text("Antal klip pr produkt periode:");
    private final Text txtDagsOpgoer = new Text("Dagsopgør");
    private final Text txtKviteringer = new Text("Kviteringer:");
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

        pane.add(lwDagsOpgoer, 3, 3, 1, 2);
        lwDagsOpgoer.setPrefWidth(25);
        lwDagsOpgoer.setPrefHeight(200);

        pane.add(lwLejedeUafleveredeProdukter, 5, 3, 1, 3);
        lwLejedeUafleveredeProdukter.setPrefWidth(100);
        lwLejedeUafleveredeProdukter.setPrefHeight(200);
        lwLejedeUafleveredeProdukter.getItems().setAll(Controller.getInstance().getIkkeAfleveredeUdlejedeProdukter());
        lwLejedeUafleveredeProdukter.setOnMouseExited(e -> eventLeje());

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
        dpDagsOpgoer.setOnMouseExited(e -> eventChangedKlip());

        pane.add(dpdateStart, 0, 1);
        dpdateStart.setPromptText("Start dato");
        dpdateStart.setEditable(false);
        dpDagsOpgoer.setOnMouseExited(e -> eventChangedKlip());


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

// funktioner

    private void eventDagsOpgoer() {
        if (dpDagsOpgoer.getValue()!=null){
            lwDagsOpgoer.getItems().setAll(Controller.getInstance().getDagsKvitteringer(dpDagsOpgoer.getValue()));
            txfSumDagsOpgoer.setText("sum: " + Controller.getInstance().getDagsopgoer(dpDagsOpgoer.getValue()));
        }
    }

//TODO
    private void eventChangedKlip() {
        if (dpdateStart!=null&&dpdateSlut!=null)
            lwAntalKlipPrProduktPeriode.getItems().setAll(Controller.getInstance().getDagsKvitteringer(dpDagsOpgoer.getValue()));
            txfSumKlip.setText("sum: " + Controller.getInstance().getDagsopgoer(dpDagsOpgoer.getValue()));

    }

    private void eventLeje(){

    }
}


