package gui;

import application.controller.Controller;
import application.model.Leje;
import application.model.Ordrelinje;
import application.model.Salg;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.time.LocalDate;

public class StatistikPane extends GridPane {

    // datepicker
    private final DatePicker dpDateStart = new DatePicker();
    private final DatePicker dpDateSlut = new DatePicker();
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
        lwLejedeUafleveredeProdukter.setOnMouseClicked(e -> eventLeje());

        // Texts

        this.add(txtPeriodeForKlip,0,0);
        this.add(txtPeriodeForKlipProdukt,0,2);
        this.add(txtDagsOpgoer,3, 0);
        this.add(txtKviteringer,3, 2);
        this.add(txtLeje,5, 2);

        // DatePicker

        this.add(dpDateSlut, 1, 1);
        dpDateSlut.setPromptText("Slut dato");
        dpDateSlut.setEditable(false);
        ChangeListener<LocalDate> listenerDSl = (ov, oldString, newString) -> this.selectionChangedKlip();
        dpDateSlut.valueProperty().addListener(listenerDSl);

        this.add(dpDateStart, 0, 1);
        dpDateStart.setPromptText("Start dato");
        dpDateStart.setEditable(false);
        ChangeListener<LocalDate> listenerDSt = (ov, oldString, newString) -> this.selectionChangedKlip();
        dpDateStart.valueProperty().addListener(listenerDSt);


        this.add(dpDagsOpgoer, 3, 1);
        dpDagsOpgoer.setPromptText("Dato Dagsopgør");
        dpDagsOpgoer.setEditable(false);
        ChangeListener<LocalDate> listenerDO = (ov, oldString, newString) -> this.selectionChangedDagsOpgoer();
        dpDagsOpgoer.valueProperty().addListener(listenerDO);

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

    private void selectionChangedDagsOpgoer() {
        if (dpDagsOpgoer.getValue()!=null){
            lwDagsOpgoer.getItems().setAll(Controller.getInstance().getDagsKvitteringer(dpDagsOpgoer.getValue()));
            txfSumDagsOpgoer.setText("sum: " + Controller.getInstance().getDagsopgoer(dpDagsOpgoer.getValue()));
        }
    }

    //TODO
    private void selectionChangedKlip() {
        if (dpDateStart!=null&&dpDateSlut!=null)
            lwAntalKlipPrProduktPeriode.getItems().setAll(Controller.getInstance().getDagsKvitteringer(dpDagsOpgoer.getValue()));
        txfSumKlip.setText("sum: " + Controller.getInstance().getDagsopgoer(dpDagsOpgoer.getValue()));

    }

    private void eventLeje(){
        lwLejedeUafleveredeProdukter.getItems().setAll(Controller.getInstance().getIkkeAfleveredeUdlejedeProdukter());
    }

}
