package com.example.ubkasirjavafx.services;

import com.example.ubkasirjavafx.util.CalculatePesanan;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import java.io.InputStream;

public class MyContent {
    String nama, id, recentTotalBayar;
    int price, jumlahItem;

    //Other attribute
    ListView listView;
    TextField totalBayarField;
    Label jumlahItemLbl = new Label();
    GridPane gp = new GridPane();

    public MyContent(String nama, String id, int price, ListView listView, TextField totalBayarField) {
        this.nama = nama;
        this.id = id;
        this.price = price;
        this.listView = listView;
        this.totalBayarField = totalBayarField;
        recentTotalBayar = totalBayarField.getText();
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
                if (jumlahItem == 0) addFirstPesanan();
                else increaseTotal();
            }
        });
        return pane;
    }

    private void increaseTotal() {
        if (jumlahItem > 0) jumlahItemLbl.setText(Integer.toString(++jumlahItem));
        refreshTotalBayar(CalculatePesanan.PLUS);
    }

    private void decreaseTotal() {
        if (jumlahItem > 0) jumlahItemLbl.setText(Integer.toString(--jumlahItem));
        System.out.println(jumlahItem);
        if (jumlahItem == 0) {
            listView.getItems().remove(gp);
            gp.getChildren().clear();
        }
        refreshTotalBayar(CalculatePesanan.MINUS);
    }

    private void addFirstPesanan() {
        //Define item layout
        increaseTotal();
        Label info = new Label();
        Button addBtn = new Button();
        addBtn.setText("+");
        Button removeBtn = new Button();
        removeBtn.setText("-");
        jumlahItemLbl.setWrapText(true);
        gp.setHgap(16);

        //Add Button action
        addBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                increaseTotal();
            }
        });

        //Remove Button action
        removeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                decreaseTotal();
            }
        });


        info.setText(String.format("%s (Rp. %d)", nama, price));
        gp.add(info, 0, 0);

        GridPane control = new GridPane();
        control.setHgap(8);
        control.add(removeBtn, 1, 0);
        control.add(jumlahItemLbl, 2, 0);
        control.add(addBtn, 3, 0);

        gp.add(control, 1, 0);

        listView.getItems().add(gp);
        this.jumlahItem++;
        if (jumlahItem == 1) jumlahItemLbl.setText(Integer.toString(jumlahItem));
    }

    private void refreshTotalBayar(CalculatePesanan calculatePesanan) {
        recentTotalBayar = totalBayarField.getText();
        int tmp = 0;
        if(calculatePesanan.equals(CalculatePesanan.PLUS)) tmp =(Integer.parseInt(recentTotalBayar) + price);
        else tmp = (Integer.parseInt(recentTotalBayar) - price);
        recentTotalBayar = String.format("%d", tmp);
        totalBayarField.setText(recentTotalBayar);
    }
}
