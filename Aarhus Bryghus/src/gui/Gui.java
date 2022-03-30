package gui;

import application.controller.Controller;
import application.model.Pris;
import application.model.Produkt;
import application.model.ProduktGruppe;
import application.model.Salgssituation;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.Button;
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

    // - Salgssituation

    // listviews
    private final ListView<Salgssituation> lwSalgsSituation = new ListView();

    // buttons
    private final Button btnSalgsSituationCreate = new Button();
    private final Button btnSalgsSituationUpdate = new Button();
    private final Button btnSalgsSituationDelete = new Button();

    // texts

    private final Text txtSalgsSituation = new Text("Salgssituation:");

    // textfields

    private final TextField txfSalgsSituationNavn = new TextField();
    private final TextField txfSalgsSituationBeskrivelse = new TextField();

    // - Produkt Gruppe

    // listviews
    private final ListView<ProduktGruppe> lwProduktGruppe = new ListView();

    // buttons
    private final Button btnProduktGruppeCreate = new Button();
    private final Button btnProduktGruppeUpdate = new Button();
    private final Button btnProduktGruppeDelete = new Button();

    // texts

    private final Text txtProduktGruppe = new Text("Produkt Gruppe:");

    // textfields

    private final TextField txfProduktGruppeNavn = new TextField();

    // - Pris

    // listviews
    private final ListView<Pris> lwPris = new ListView();

    // buttons
    private final Button btnPrisCreate = new Button();
    private final Button btnPrisUpdate = new Button();
    private final Button btnPrisDelete = new Button();

    // texts

    private final Text txtPris = new Text("Priser:");

    // textfields

    private final TextField txfPrisBeløb = new TextField();
    private final TextField txfPrisKlip = new TextField();

    // - Produkt

    // listviews
    private final ListView<Produkt> lwProdukt = new ListView();

    // buttons
    private final Button btnProduktCreate = new Button();
    private final Button btnProduktUpdate = new Button();
    private final Button btnProduktDelete = new Button();

    // texts

    private final Text txtProdukt = new Text("Produkter:");

    // textfields

    private final TextField txfProduktNavn = new TextField();
    private final TextField txfProduktBeskrivelse = new TextField();


    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(50));

        // set horizontal gap between components
        pane.setHgap(10);

        // set vertical gap between components
        pane.setVgap(10);

//Salgssituation

        // Listviews
        pane.add(lwSalgsSituation, 0, 1, 3, 1);
        lwSalgsSituation.setPrefWidth(50);
        lwSalgsSituation.setPrefHeight(150);
        ChangeListener<Salgssituation> listenerSS = (ov, oldString, newString) -> this.selectionChangedSalgssituation();
        lwSalgsSituation.getSelectionModel().selectedItemProperty().addListener(listenerSS);


        // Buttons
        pane.add(btnSalgsSituationCreate, 2, 2);
        btnSalgsSituationCreate.setText("Create");
        btnSalgsSituationCreate.setPrefWidth(60);
        btnSalgsSituationCreate.setOnAction(e -> createSalgssituation());


        pane.add(btnSalgsSituationUpdate, 2, 3);
        btnSalgsSituationUpdate.setText("Update");
        btnSalgsSituationUpdate.setPrefWidth(60);
        btnSalgsSituationUpdate.setOnAction(e -> updateSalgssituation());


        pane.add(btnSalgsSituationDelete, 0, 3);
        btnSalgsSituationDelete.setText("Delete");
        btnSalgsSituationDelete.setPrefWidth(60);
        btnSalgsSituationDelete.setOnAction(e -> deleteSalgssituation());


        // Texts

        pane.add(txtSalgsSituation, 0, 0);

        // Textfields

        pane.add(txfSalgsSituationNavn, 0, 2);
        txfSalgsSituationNavn.setPromptText("Navn:");
        txfSalgsSituationNavn.setPrefWidth(100);

        pane.add(txfSalgsSituationBeskrivelse, 1, 2);
        txfSalgsSituationBeskrivelse.setPromptText("Beskrivelse:");
        txfSalgsSituationBeskrivelse.setPrefWidth(100);

//Pris

        // Listviews
        pane.add(lwPris, 0, 6, 3, 1);
        lwPris.setPrefWidth(50);
        lwPris.setPrefHeight(150);
        ChangeListener<Pris> listenerPri = (ov, oldString, newString) -> this.selectionChangedPris();
        lwPris.getSelectionModel().selectedItemProperty().addListener(listenerPri);


        // Buttons
        pane.add(btnPrisCreate, 2, 7);
        btnPrisCreate.setText("Create");
        btnPrisCreate.setOnAction(e -> createPris());
        btnPrisCreate.setPrefWidth(60);


        pane.add(btnPrisUpdate, 2, 8);
        btnPrisUpdate.setText("Update");
        btnPrisUpdate.setOnAction(e -> updatePris());
        btnPrisUpdate.setPrefWidth(60);

        pane.add(btnPrisDelete, 0, 8);
        btnPrisDelete.setText("Delete");
        btnPrisDelete.setOnAction(e -> deletePris());
        btnPrisDelete.setPrefWidth(60);

        // Texts

        pane.add(txtPris, 0, 5);

        // Textfields

        pane.add(txfPrisBeløb, 0, 7);
        txfPrisBeløb.setPromptText("Beløb:");
        txfPrisBeløb.setPrefWidth(100);

        pane.add(txfPrisKlip, 1, 7);
        txfPrisKlip.setPromptText("Klip:");
        txfPrisKlip.setPrefWidth(100);


//ProduktGruppe

        //Listview
        pane.add(lwProduktGruppe, 3, 1, 3, 1);
        lwProduktGruppe.setPrefWidth(50);
        lwProduktGruppe.setPrefHeight(150);
        ChangeListener<ProduktGruppe> listenerPG = (ov, oldString, newString) -> this.selectionChangedProduktGruppe();
        lwProduktGruppe.getSelectionModel().selectedItemProperty().addListener(listenerPG);

        // Buttons
        pane.add(btnProduktGruppeCreate, 5, 2);
        btnProduktGruppeCreate.setText("Create");
        btnProduktGruppeCreate.setPrefWidth(60);
        btnProduktGruppeCreate.setOnAction(e -> createProduktGruppe());

        pane.add(btnProduktGruppeUpdate, 5, 3);
        btnProduktGruppeUpdate.setText("Update");
        btnProduktGruppeUpdate.setPrefWidth(60);
        btnProduktGruppeUpdate.setOnAction(e -> updateProduktGruppe());

        pane.add(btnProduktGruppeDelete, 3, 3);
        btnProduktGruppeDelete.setText("Delete");
        btnProduktGruppeDelete.setPrefWidth(60);
        btnProduktGruppeDelete.setOnAction(e -> deleteProduktGruppe());


        // Texts

        pane.add(txtProduktGruppe, 3, 0);

        // Textfields

        pane.add(txfProduktGruppeNavn, 3, 2, 2, 1);
        txfProduktGruppeNavn.setPromptText("Navn:");

//Produkt

        //Listview
        pane.add(lwProdukt, 3, 6, 3, 1);
        lwProdukt.setPrefWidth(50);
        lwProdukt.setPrefHeight(150);
        ChangeListener<Produkt> listenerPro = (ov, oldString, newString) -> this.selectionChangedProdukt();
        lwProdukt.getSelectionModel().selectedItemProperty().addListener(listenerPro);


        // Buttons
        pane.add(btnProduktCreate, 5, 7);
        btnProduktCreate.setText("Create");
//            btnSalgsSituationCreate.setOnAction(e -> SalgsSituationCreate());
        btnProduktCreate.setPrefWidth(60);
        btnProduktCreate.setOnAction(e -> createProdukt());



        pane.add(btnProduktUpdate, 5, 8);
        btnProduktUpdate.setText("Update");
        btnProduktUpdate.setPrefWidth(60);
        btnProduktUpdate.setOnAction(e -> updateProdukt());


        pane.add(btnProduktDelete, 3, 8);
        btnProduktDelete.setText("Delete");
        btnProduktDelete.setPrefWidth(60);
        btnProduktDelete.setOnAction(e -> deleteProdukt());


        // Texts

        pane.add(txtProdukt, 3, 5);

        // Textfields

        pane.add(txfProduktNavn, 3, 7);
        txfProduktNavn.setPromptText("Navn:");
        txfProduktNavn.setPrefWidth(100);


        pane.add(txfProduktBeskrivelse, 4, 7);
        txfProduktBeskrivelse.setPromptText("Beskrivelse:");
        txfProduktBeskrivelse.setPrefWidth(100);
    }

// ProduktGruppe funktioner

    private void selectionChangedProduktGruppe() {
        ProduktGruppe selected = lwProduktGruppe.getSelectionModel().getSelectedItem();
        txfProduktGruppeNavn.setText(selected.getNavn());
        lwProdukt.getItems().setAll(selected.getProdukter());

    }

    private void createProduktGruppe() {
        if (txfProduktGruppeNavn.getText() != null) {
            Controller.getInstance().createProduktGruppe(txfProduktGruppeNavn.getText());
            lwProduktGruppe.getItems().setAll(Controller.getInstance().getProduktgrupper());
        }
    }

    private void updateProduktGruppe() {
        ProduktGruppe selected = lwProduktGruppe.getSelectionModel().getSelectedItem();
        if (selected != null) {
            //TODO brug update
            selected.setNavn(txfProduktGruppeNavn.getText());
            lwProduktGruppe.getItems().setAll(Controller.getInstance().getProduktgrupper());
        }
    }

    private void deleteProduktGruppe() {
        ProduktGruppe selected = lwProduktGruppe.getSelectionModel().getSelectedItem();
        if (selected != null) {
            Controller.getInstance().removeProduktgruppe(selected);
            lwProduktGruppe.getItems().setAll(Controller.getInstance().getProduktgrupper());
        }
    }

// Salgssituation funktioner

    private void selectionChangedSalgssituation() {
        Salgssituation selected = lwSalgsSituation.getSelectionModel().getSelectedItem();
        txfSalgsSituationNavn.setText(selected.getNavn());
        txfSalgsSituationBeskrivelse.setText(selected.getDeltagerInfo());
        //TODO (Tjek om given produkt har pris til salgsituation)
        lwPris.getItems().setAll(selected.getPriser());
    }

    private void createSalgssituation() {
        if (txfSalgsSituationNavn.getText() != null && txfSalgsSituationBeskrivelse.getText() != null) {
            Controller.getInstance().createSalgssituation(txfSalgsSituationNavn.getText(), txfSalgsSituationBeskrivelse.getText());
            lwSalgsSituation.getItems().setAll(Controller.getInstance().getSalgssituationer());
        }
    }

    private void updateSalgssituation() {
        Salgssituation selected = lwSalgsSituation.getSelectionModel().getSelectedItem();
        if (selected != null) {
            //TODO brug update
            selected.setNavn(txfSalgsSituationNavn.getText());
            selected.setDeltagerInfo(txfSalgsSituationBeskrivelse.getText());
            lwSalgsSituation.getItems().setAll(Controller.getInstance().getSalgssituationer());
        }
    }

    private void deleteSalgssituation() {
        Salgssituation selected = lwSalgsSituation.getSelectionModel().getSelectedItem();
        if (selected != null) {
            Controller.getInstance().removeSalgssituation(selected);
            lwSalgsSituation.getItems().setAll(Controller.getInstance().getSalgssituationer());
        }
    }

// Produkt funktioner

    private void selectionChangedProdukt() {
        Produkt selected = lwProdukt.getSelectionModel().getSelectedItem();
        txfProduktNavn.setText(selected.getNavn());
        txfProduktBeskrivelse.setText(selected.getBeskrivelse());
        //TODO (Tjek om given produkt har pris til salgsituation)
//        lwProdukt.getItems().setAll(selected.getProdukter());
    }

    private void createProdukt() {
        if (txfProduktNavn.getText() != null && txfProduktBeskrivelse.getText() != null) {
            ProduktGruppe selected = lwProduktGruppe.getSelectionModel().getSelectedItem();
            selected.createProdukt(txfProduktNavn.getText(),txfProduktBeskrivelse.getText(),selected);
            lwProdukt.getItems().setAll(selected.getProdukter());
        }
    }

    private void updateProdukt() {
        Produkt selected = lwProdukt.getSelectionModel().getSelectedItem();
        if (selected != null) {
            //TODO brug update
            selected.setNavn(txfProduktNavn.getText());
            selected.setBeskrivelse(txfProduktBeskrivelse.getText());
            lwProdukt.getItems().setAll(selected.getProduktGruppe().getProdukter());
        }
    }

    private void deleteProdukt() {
        Produkt selected = lwProdukt.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.getProduktGruppe().removeProdukt(selected);
            lwProdukt.getItems().setAll(selected.getProduktGruppe().getProdukter());
        }
    }

// Pris funktioner

    private void selectionChangedPris() {
        Pris selected = lwPris.getSelectionModel().getSelectedItem();
        txfPrisBeløb.setText(selected.getBeloeb()+"");
        txfPrisKlip.setText(selected.getAntalKlip()+"");
    }

    private void createPris() {
        Salgssituation selectedSS = lwSalgsSituation.getSelectionModel().getSelectedItem();
        Produkt selectedPro = lwProdukt.getSelectionModel().getSelectedItem();
        if (selectedSS!=null && selectedPro!=null) {
            if (txfPrisBeløb.getText() != null && txfPrisKlip.getText() != null) {
                selectedSS.createPris(Double.parseDouble(txfPrisBeløb.getText()), Integer.parseInt(txfPrisKlip.getText()), selectedPro,selectedSS);
                lwPris.getItems().setAll(selectedSS.getPriser());

            }
            if (txfPrisBeløb.getText() != null && txfPrisKlip.getText()==null) {
                Salgssituation selected = lwSalgsSituation.getSelectionModel().getSelectedItem();
                selectedSS.createPris(Double.parseDouble(txfPrisBeløb.getText()), selectedPro,selectedSS);
                lwPris.getItems().setAll(selectedSS.getPriser());
            }
        }
    }

    private void updatePris() {
        Pris selected = lwPris.getSelectionModel().getSelectedItem();
        if (selected != null) {
            //TODO brug update
            selected.setBeloeb(Double.parseDouble(txfPrisBeløb.getText()));
            if (txfPrisKlip.getText()!=null){
                selected.setAntalKlip(Integer.parseInt(txfProduktBeskrivelse.getText()));
            }
            else {
                selected.setAntalKlip(0);
            }
            lwPris.getItems().setAll(selected.getProdukt().getPriser());
        }
    }

    private void deletePris() {
        Pris selected = lwPris.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.getSalgssituation().removePris(selected);
            lwPris.getItems().setAll(selected.getSalgssituation().getPriser());
        }
    }


}


