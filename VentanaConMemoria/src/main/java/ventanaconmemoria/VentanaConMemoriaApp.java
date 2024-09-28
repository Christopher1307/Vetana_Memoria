package ventanaconmemoria;

import javafx.application.Application;
import javafx.beans.property.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import static javafx.scene.paint.Color.rgb;

public class VentanaConMemoriaApp extends Application {



    //model
    private DoubleProperty x = new SimpleDoubleProperty();
    private DoubleProperty y = new SimpleDoubleProperty();
    private DoubleProperty width = new SimpleDoubleProperty();
    private DoubleProperty height = new SimpleDoubleProperty();

    private IntegerProperty red = new SimpleIntegerProperty();
    private IntegerProperty green = new SimpleIntegerProperty();
    private IntegerProperty blue = new SimpleIntegerProperty();


    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("iniciando");

        File profileFolder = new File(System.getProperty("user.home"));
        File configFolder = new File(profileFolder, ".VentanaConMemoria");
        File configFile = new File(configFolder, "config.properties");

        if(configFile.exists()){
            //lo cagarmos
            FileInputStream fis = new FileInputStream(configFile);
            Properties props = new Properties();
            props.load(fis);
            width.set(Double.parseDouble(props.getProperty("size.width")));
            height.set(Double.parseDouble(props.getProperty("size.height")));
            x.set(Double.parseDouble(props.getProperty("size.x")));
            y.set(Double.parseDouble(props.getProperty("size.y")));

            red.set(Integer.parseInt(props.getProperty("background.red", "0")));
            green.set(Integer.parseInt(props.getProperty("background.green", "0")));
            blue.set(Integer.parseInt(props.getProperty("background.blue", "0")));

        } else {
            width.set(320);
            height.set(200);
            x.set(0);
            y.set(0);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //slider del rojo con su label
        Slider redSlider = new Slider();
        redSlider.setMin(0);
        redSlider.setMax(255);
        redSlider.setShowTickLabels(true);
        redSlider.setShowTickMarks(true);
        redSlider.setMajorTickUnit(255);
        redSlider.setMinorTickCount(5);

       Label redLabel = new Label("Rojo:");

       //slider del verde con su label
       Slider greenSlider = new Slider();
        greenSlider.setMin(0);
        greenSlider.setMax(255);
        greenSlider.setShowTickLabels(true);
        greenSlider.setShowTickMarks(true);
        greenSlider.setMajorTickUnit(255);
        greenSlider.setMinorTickCount(5);

        Label greenLabel = new Label("Verde:");

        //slider del azul con su label
        Slider blueSlider = new Slider();
        blueSlider.setMin(0);
        blueSlider.setMax(255);
        blueSlider.setShowTickLabels(true);
        blueSlider.setShowTickMarks(true);
        blueSlider.setMajorTickUnit(255);
        greenSlider.setMinorTickCount(5);

        Label blueLabel= new Label("Azul:");

        //hbox para ordenal los label y slider

        HBox redBox = new HBox(10, redLabel, redSlider);
        HBox greenBox = new HBox(10, greenLabel, greenSlider);
        HBox blueBox = new HBox(10, blueLabel, blueSlider);

        redBox.setAlignment(Pos.CENTER);
        greenBox.setAlignment(Pos.CENTER);
        blueBox.setAlignment(Pos.CENTER);




        VBox root =new VBox();
        root.setFillWidth(false);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(redBox, greenBox, blueBox);

        Scene scene = new Scene(root, width.get() , height.get());



        primaryStage.setX(x.get());
        primaryStage.setY(y.get());
        primaryStage.setTitle("ventana con memoria");
        primaryStage.setScene(scene);
        primaryStage.show();

        //bindings
        x.bind(primaryStage.xProperty());
        y.bind(primaryStage.yProperty());
        width.bind(primaryStage.widthProperty());
        height.bind(primaryStage.heightProperty());

        //rojo
        redSlider.valueProperty().bindBidirectional(red);

        red.addListener((observable, oldValue, newValue) -> {
            Color c = Color.rgb(red.get(),green.get(),blue.get());
            root.setBackground(Background.fill(c));
        });

        //verde
        greenSlider.valueProperty().bindBidirectional(green);

        green.addListener((observable, oldValue, newValue) -> {
            Color a = Color.rgb(red.get(),green.get(),blue.get());
            root.setBackground(Background.fill(a));
        });

        //azul

        blueSlider.valueProperty().bindBidirectional(blue);

        blue.addListener((observable, oldValue, newValue) -> {
            Color b = Color.rgb(red.get(),green.get(),blue.get());
            root.setBackground(Background.fill(b));
        });







    }

    @Override

    public void stop()throws Exception{
        super.stop();
        System.out.println("cerrando");

        File profileFolder = new File(System.getProperty("user.home"));
        File configFolder = new File(profileFolder, ".VentanaConMemoria");
        File configFile = new File(configFolder, "config.properties");

        if(!configFolder.exists()){
            configFolder.mkdir();
        }

//        background.red=206
//        background.blue=60
//        background.green=63
//        size.width=428
//        size.height=278
//        location.x=440
//        location.y=244





//        System.out.println("Profile : "+ profileFolder);
//        System.out.println("Config folder : "+ configFolder);
//        System.out.println("ConfigFile : "+ configFile);

        System.out.println("saving config "+ configFile);


        FileOutputStream fos = new FileOutputStream(configFile);

        Properties props = new Properties();
        props.setProperty("size.width", "" + width.getValue());
        props.setProperty("size.height", "" + height.getValue());
        props.setProperty("size.x", "" + x.getValue());
        props.setProperty("size.y", "" + y.getValue());
        props.store(fos, "Estado de la ventana");



    }


}


