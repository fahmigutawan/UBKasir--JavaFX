package com.example.ubkasirjavafx.services;

import javafx.scene.control.ListView;

public class MyMenu {

    ListView listView;

    public MyMenu(ListView listView) {
        this.listView = listView;
        makanan[0] = new MyContent("makanan","01",7500, this.listView);
    }

    public MyContent[] makanan = new MyContent[10];
    public MyContent[] minuman = new MyContent[10];
    public MyContent[] camilan = new MyContent[10];






}
