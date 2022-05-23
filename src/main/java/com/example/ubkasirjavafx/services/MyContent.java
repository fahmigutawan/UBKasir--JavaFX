package com.example.ubkasirjavafx.services;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.io.InputStream;

import static javafx.scene.input.KeyCode.T;

public class MyContent {
    String nama, id;
    int price;
    ListView listView;
    int total;

    //Other attribute
    Label totalLbl = new Label();
    GridPane gp = new GridPane();

    public MyContent(String nama, String id, int price, ListView listView) {
        this.nama = nama;
        this.id = id;
        this.price = price;
        this.listView = listView;
    }

    public StackPane build(InputStream stream) {
        StackPane pane = new StackPane();
        GridPane result = new GridPane();
        GridPane picAndName = new GridPane();
        Rectangle bg = new Rectangle();

        pane.getChildren().add(0, bg);
        pane.getChildren().add(1, result);

        result.addRow(2);
        result.addColumn(1);

        //Add image to picAndName GridPane
        ImageView iv = new ImageView();
        Image img = new Image(stream);
        iv.setFitWidth(72);
        iv.setFitHeight(72);
        iv.setImage(img);
        picAndName.add(iv, 0, 0);

        //Add name to picAndName GridPane
        Label name = new Label();
        name.setText(nama);
        name.setAlignment(Pos.CENTER);
        name.setMaxWidth(72);
        name.setWrapText(true);
        picAndName.add(name, 0, 1);

        //Make a button
        Button btn = new Button();
        btn.setAlignment(Pos.CENTER);
        btn.setText(String.format("Rp. %d", price));

        //Add both picAndName and Button to main grid
        result.setVgap(8);
        result.add(picAndName, 0, 0);
        result.add(btn, 0, 1);

        /**Btn listener*/
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (total == 0) addPesanan();
                else addTotal();
            }
        });
        return pane;
    }

    private void addTotal() {
        if (total>0) totalLbl.setText(Integer.toString(++total));
    }

    private void removeTotal() {
        if (total>0) totalLbl.setText(Integer.toString(--total));
        System.out.println(total);
        if (total == 0) {
            listView.getItems().remove(gp);
            gp.getChildren().clear();
        }
    }

    private void addPesanan() {
        //Define item layout
        addTotal();
        Label info = new Label();
        Button addBtn = new Button();
        addBtn.setText("+");
        Button removeBtn = new Button();
        removeBtn.setText("-");
        totalLbl.setWrapText(true);
        gp.setHgap(16);

        //Add Button action
        addBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addTotal();
            }
        });

        //Remove Button action
        removeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                removeTotal();
            }
        });


        info.setText(String.format("%s (Rp. %d)", nama, price));
        gp.add(info, 0, 0);

        GridPane control = new GridPane();
        control.setHgap(8);
        control.add(removeBtn, 1,0);
        control.add(totalLbl, 2, 0);
        control.add(addBtn, 3, 0);

        gp.add(control,1,0);

        listView.getItems().add(gp);
        this.total++;
        if(total==1) totalLbl.setText(Integer.toString(total));
    }
}
