package gui;


public class Gui
    extends Application {


        @Override
        public void start(Stage stage) {
            stage.setTitle("Festival System");
            GridPane pane = new GridPane();
            this.initContent(pane);
            Scene scene = new Scene(pane);
            stage.setScene(scene);
            stage.show();
        }

        // -------------------------------------------------------------------------

        private final ListView lwFest = new ListView();
//    public void init() {
//        Controller.initStorage();
//    }

        private void initContent(GridPane pane) {
            // show or hide grid lines
            pane.setGridLinesVisible(false);

            // set padding of the pane
            pane.setPadding(new Insets(20));
            // set horizontal gap between components
            pane.setHgap(10);
            // set vertical gap between components
            pane.setVgap(10);

            pane.add(lwFest, 0, 0);
        }
    }
}
