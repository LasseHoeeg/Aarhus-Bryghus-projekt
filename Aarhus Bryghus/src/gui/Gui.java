package gui;

import application.controller.Controller;
import application.model.Salgssituation;
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
        private final ListView lwSalgsSituationRead = new ListView();

        // buttons
        private final Button btnSalgsSituationCreate = new Button();
        private final Button btnSalgsSituationUpdate = new Button();
        private final Button btnSalgsSituationDelete = new Button();

        // texts

        private final Text txtSalgsSituation = new Text("Salgssituation");

        // textfields

        private final TextField txfSalgsSituationNavn = new TextField();
        private final TextField txfSalgsSituationBeskrivelse = new TextField();




    private void initContent(GridPane pane) {
            // show or hide grid lines
            pane.setGridLinesVisible(false);

            // set padding of the pane
            pane.setPadding(new Insets(50));

            // set horizontal gap between components
            pane.setHgap(10);

            // set vertical gap between components
            pane.setVgap(10);

            //Text

            // Listviews
            pane.add(lwSalgsSituationRead, 0, 1, 3, 1);

            // Buttons
            pane.add(btnSalgsSituationCreate, 2, 2);
            btnSalgsSituationCreate.setText("Create");
//            btnSalgsSituationCreate.setOnAction(e -> SalgsSituationCreate());



        pane.add(btnSalgsSituationUpdate, 1, 3);
            btnSalgsSituationUpdate.setText("Update");

            pane.add(btnSalgsSituationDelete, 2, 3);
            btnSalgsSituationDelete.setText("Delete");

            // Texts

            pane.add(txtSalgsSituation, 0, 0);

            // Textfields

            pane.add(txfSalgsSituationNavn, 0, 2);
            txfSalgsSituationNavn.setPromptText("Navn:");
            pane.add(txfSalgsSituationBeskrivelse, 1, 2);
            txfSalgsSituationBeskrivelse.setPromptText("Beskrivelse:");

    }
//    private void SalgsSituationCreate() {
//        Controller.getInstance().createSalgssituation(txfSalgsSituationNavn.getText(), )
//        if (selected!=null) {
//            txfVinder.setText(selected.getVinder());
//        }
//    }

}

