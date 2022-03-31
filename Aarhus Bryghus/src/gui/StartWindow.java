package gui;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StartWindow extends Application {

    @Override
    public void init() {
//        Controller.init();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Aarhus Bryghus IT-System");
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -----------------------------------------------------------------------------------------------------------------

    private void initContent(BorderPane pane) {
        TabPane tabPane = new TabPane();
        this.initTapPane(tabPane);
        pane.setCenter(tabPane);
    }
    private void initTapPane(TabPane tabPane) {
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);


        Tab tabSalg = new Tab("Salg");
        tabPane.getTabs().add(tabSalg);

        SalgPane salgPane = new SalgPane();
        tabSalg.setContent(salgPane);


        Tab tabSystemObjek = new Tab("System Objekter");
        tabPane.getTabs().add(tabSystemObjek);

        SystemObjektPane systemObjektPane = new SystemObjektPane();
        tabSystemObjek.setContent(systemObjektPane);


        Tab tabStatistik = new Tab("Statistik");
        tabPane.getTabs().add(tabStatistik);

        StatistikPane statistikPane = new StatistikPane();
        tabStatistik.setContent(statistikPane);

    }
}