package com.example.ubkasirjavafx.services;

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

public class MyComponents {
    public StackPane myContent(InputStream stream, int price, String nama, String id, ListView listView) {
        StackPane pane = new StackPane();
        GridPane result = new GridPane();
        GridPane picAndName = new GridPane();
        Rectangle bg = new Rectangle();

        pane.getChildren().add(0,bg);
        pane.getChildren().add(1,result);

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

        /**ROBBY*/
        /*
        String id, dan Listview pesanan sudah dimasukkan sebagai parameter. Disini nanti listview akan ditambah berupa id & harga jika diklik pesan.
        String id, nama, harga sudah ada semua sebagai parameter.
         */

        return pane;
    }
}
