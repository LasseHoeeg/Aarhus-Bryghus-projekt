package gui;

import application.controller.Controller;
import application.model.Leje;
import application.model.Salg;
import javafx.geometry.Insets;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class StatistikPane extends GridPane {

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
    private final Text txtUdeje = new Text("Udlejede Produkter:");
    private final Text txtLeje = new Text("Leje");

    // textfields
    private final TextField txfSumDagsOpgoer = new TextField();
    private final TextField txfSumKlip = new TextField();

    public StatistikPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        this.add(lwAntalKlipPrProduktPeriode, 0, 3, 2, 2);
        lwAntalKlipPrProduktPeriode.setPrefWidth(25);
        lwAntalKlipPrProduktPeriode.setPrefHeight(200);

        this.add(lwDagsOpgoer, 3, 3, 1, 2);
        lwDagsOpgoer.setPrefWidth(25);
        lwDagsOpgoer.setPrefHeight(200);

        this.add(lwLejedeUafleveredeProdukter, 5, 3, 1, 3);
        lwLejedeUafleveredeProdukter.setPrefWidth(100);
        lwLejedeUafleveredeProdukter.setPrefHeight(200);
        lwLejedeUafleveredeProdukter.getItems().setAll(Controller.getInstance().getIkkeAfleveredeUdlejedeProdukter());
        lwLejedeUafleveredeProdukter.setOnMouseExited(e -> eventLeje());

        // Texts

        this.add(txtPeriodeForKlip,0,0);
        this.add(txtPeriodeForKlipProdukt,0,2);
        this.add(txtDagsOpgoer,3, 0);
        this.add(txtKviteringer,3, 2);
        this.add(txtLeje,5, 2);

        // DatePicker

        this.add(dpdateSlut, 1, 1);
        dpdateSlut.setPromptText("Slut dato");
        dpdateSlut.setEditable(false);
        dpDagsOpgoer.setOnMouseExited(e -> eventChangedKlip());

        this.add(dpdateStart, 0, 1);
        dpdateStart.setPromptText("Start dato");
        dpdateStart.setEditable(false);
        dpDagsOpgoer.setOnMouseExited(e -> eventChangedKlip());


        this.add(dpDagsOpgoer, 3, 1);
        dpDagsOpgoer.setPromptText("Dato Dagsopgør");
        dpDagsOpgoer.setEditable(false);
        dpDagsOpgoer.setOnMouseExited(e -> eventDagsOpgoer());


        // Textfields


        this.add(txfSumKlip,0,5, 2, 1);
        txfSumKlip.setPromptText("sum:");
        txfSumKlip.setPrefWidth(20);
        txfSumKlip.setEditable(false);

        this.add(txfSumDagsOpgoer,3,5, 1, 1);
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
