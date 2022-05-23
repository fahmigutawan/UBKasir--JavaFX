package com.example.ubkasirjavafx.controller;

import com.example.ubkasirjavafx.services.MyComponents;
import com.example.ubkasirjavafx.services.Services;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeMenuController implements Initializable {

    @FXML
    private Button btnKembali;
    @FXML
    private TextField textTotal;
    @FXML
    private Button btnCetak;
    @FXML
    private Button btnMakanan;
    @FXML
    private Button btnMinuman;
    @FXML
    private Button btnCamilan;
    @FXML
    private GridPane contentTable;

    @FXML
    private ListView listPesanan;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Define Kembali Button Action
        btnKembali.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                new Services().postDelayed(
                        () -> {
                            try {
                                new Services().transferScene("/com/example/ubkasirjavafx/mainmenu_activity.fxml", btnKembali.getScene().getWindow());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        , 0);
            }
        });

        btnMakanan.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setPreviewMakanan();
            }
        });

        btnMinuman.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setPreviewMinuman();
            }
        });

        btnCamilan.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setPreviewSnack();
            }
        });

        // Call default Preview (Makanan preview)
        contentTable.setHgap(32);
        contentTable.setVgap(16);
        contentTable.setPadding(new Insets(16, 16, 16, 16));
        contentTable.setAlignment(Pos.BASELINE_CENTER);

        setPreviewMakanan();
    }

    void setPreviewMakanan() {
        int random = (int) (Math.random() * 5) + 2;
        contentTable.getChildren().clear();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < random; j++) {
                contentTable.add(
                        new MyComponents()
                                .myContent(
                                        getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_food.png"),
                                        20000,
                                        "Dummy Makanan",
                                        String.format("Dummy-%s-%s", i, j),
                                        listPesanan)
                        , i
                        , j);
            }
        }

    }

    void setPreviewMinuman() {
        int random = (int) (Math.random() * 5) + 2;
        contentTable.getChildren().clear();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < random; j++) {
                contentTable.add(
                        new MyComponents()
                                .myContent(
                                        getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_drink.png"),
                                        20000,
                                        "Dummy Minuman",
                                        String.format("Dummy-%s-%s", i, j),
                                        listPesanan)
                        , i
                        , j);
            }
        }

    }

    void setPreviewSnack() {
        int random = (int) (Math.random() * 5) + 2;
        contentTable.getChildren().clear();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < random; j++) {
                contentTable.add(
                        new MyComponents()
                                .myContent(
                                        getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_snack.png"),
                                        20000,
                                        "Dummy Snack",
                                        String.format("Dummy-%s-%s", i, j),
                                        listPesanan)
                        , i
                        , j);
            }
        }

    }
}
