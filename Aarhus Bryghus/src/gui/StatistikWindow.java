package gui;

import application.controller.Controller;
import application.model.Leje;
import application.model.Salg;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StatistikWindow extends Stage {

    private Object o;

    public StatistikWindow(String title, Object o) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.o = o;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

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

    public StatistikWindow(String title) {
        this(title, null);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

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

        // Texts

        pane.add(txtPeriodeForKlip, 0, 0);
        pane.add(txtPeriodeForKlipProdukt, 0, 2);
        pane.add(txtDagsOpgoer, 3, 0);
        pane.add(txtKviteringer, 3, 2);
        pane.add(txtLeje, 5, 2);

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

        // Textfields
        pane.add(txfSumKlip, 0, 5, 2, 1);
        txfSumKlip.setPromptText("sum:");
        txfSumKlip.setPrefWidth(20);
        txfSumKlip.setEditable(false);

        pane.add(txfSumDagsOpgoer, 3, 5, 1, 1);
        txfSumDagsOpgoer.setPromptText("sum:");
        txfSumDagsOpgoer.setPrefWidth(20);
        txfSumDagsOpgoer.setEditable(false);

    }
}
