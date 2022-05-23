package com.example.ubkasirjavafx.services;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class MyMenu {

    public ArrayList<StackPane> makanan = new ArrayList<StackPane>();
    public ArrayList<StackPane> minuman = new ArrayList<StackPane>();
    public ArrayList<StackPane> camilan = new ArrayList<StackPane>();


    public MyMenu(ListView listView, TextField textField) {

        makanan.add(new StackPane(new MyContent("makanan","01",7500,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_food.png"))));
        makanan.add(new StackPane(new MyContent("makan bang","02",7500,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_food.png"))));

    }
}
