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

        //Instansiasi Objek Makanan
        makanan.add(new StackPane(new MyContent("Nasi Goreng","01",12500,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/food/nasi_goreng.png"))));
        makanan.add(new StackPane(new MyContent("Nasi Goreng Spesial","02",16000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/food/nasi_goreng.png"))));
        makanan.add(new StackPane(new MyContent("Nasi Goreng Ikan Asin","03",14000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_food.png"))));
        makanan.add(new StackPane(new MyContent("Nasi Goreng Kambing","04",17000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_food.png"))));
        makanan.add(new StackPane(new MyContent("Indomie Goreng","05",5000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_food.png"))));
        makanan.add(new StackPane(new MyContent("Indomie Kuah","06",5000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_food.png"))));
        makanan.add(new StackPane(new MyContent("Nasi Chili Beef","07",15000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_food.png"))));
        makanan.add(new StackPane(new MyContent("Nasi Chili Chicken","08",15000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_food.png"))));
        makanan.add(new StackPane(new MyContent("Nasi Kulit Sambal Matah","09",17000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_food.png"))));
        makanan.add(new StackPane(new MyContent("Nasi Ayam Geprek","10",14000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_food.png"))));
        makanan.add(new StackPane(new MyContent("Nasi Ayam Penyet","11",14000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_food.png"))));

        //Instansiasi Objek Minuman
        minuman.add(new StackPane(new MyContent("Caffe Latte","01",10000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_drink.png"))));
        minuman.add(new StackPane(new MyContent("Cappuccino","02",10000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_drink.png"))));
        minuman.add(new StackPane(new MyContent("Caramel Latte","03",12000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_drink.png"))));
        minuman.add(new StackPane(new MyContent("Moccachino","04",10000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_drink.png"))));
        minuman.add(new StackPane(new MyContent("Black Coffe","05",7000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_drink.png"))));
        minuman.add(new StackPane(new MyContent("Susu Strawberry","06",10000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_drink.png"))));
        minuman.add(new StackPane(new MyContent("Susu Mint","07",10000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_drink.png"))));
        minuman.add(new StackPane(new MyContent("Susu Almond","08",10000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_drink.png"))));
        minuman.add(new StackPane(new MyContent("Soda Gembira","09",12000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_drink.png"))));
        minuman.add(new StackPane(new MyContent("Teh Tarik","10",8000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_drink.png"))));
        minuman.add(new StackPane(new MyContent("Es Teh Tawar","11",2000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_drink.png"))));
        minuman.add(new StackPane(new MyContent("Teh Tawar","12",2000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_drink.png"))));
        minuman.add(new StackPane(new MyContent("Es Teh Manis","13",2000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_drink.png"))));
        minuman.add(new StackPane(new MyContent("Teh Manis","14",2000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_drink.png"))));
        minuman.add(new StackPane(new MyContent("Air Mineral","15",3000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_drink.png"))));


        //Instansiasi Objek Camilan
        camilan.add(new StackPane(new MyContent("Cireng Pandawa","01",12500,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_snack.png"))));
        camilan.add(new StackPane(new MyContent("Tempe Mendoan","02",12500,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_snack.png"))));
        camilan.add(new StackPane(new MyContent("Kentang Goreng Keju","03",7000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_snack.png"))));
        camilan.add(new StackPane(new MyContent("Roti Bakar Keju Susu","04",10000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_snack.png"))));
        camilan.add(new StackPane(new MyContent("Roti Bakar Keju Cokelat","05",10000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_snack.png"))));
        camilan.add(new StackPane(new MyContent("Roti Bakar Telur","06",8000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_snack.png"))));
        camilan.add(new StackPane(new MyContent("Roti Bakar Kornet Telor","07",12000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_snack.png"))));
        camilan.add(new StackPane(new MyContent("Pisgor Keju Susu","08",12000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_snack.png"))));
        camilan.add(new StackPane(new MyContent("Pisgor Keju Cokelat","09",12000,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_snack.png"))));
        camilan.add(new StackPane(new MyContent("Pisgor Kacang Susu","10",12500,listView, textField).build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_snack.png"))));

    }
}
