package it.unitn.disi.prog2.aliprandi.myproject.main;

import it.unitn.disi.prog2.aliprandi.myproject.Controllers.MainController;
import it.unitn.disi.prog2.aliprandi.myproject.JavaFX.*;
import it.unitn.disi.prog2.aliprandi.myproject.data.*;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.Block;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        MainView v = new MainView();
        Random rand = new Random();

        MainController mc = new MainController(v);
        MainGUI layout = mc.mainGUI;

        Scene scene = new Scene(layout, 900, 900);

        stage.setTitle("Minecraft UniTn");
        stage.setScene(scene);
        stage.show();

        v.map.display();

        v.furnace.display();

    }

    public void init() {

    }
    public static void main(String[] args) {

        launch();


    }
}