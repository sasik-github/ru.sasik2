package ru.sasik.gui.fx;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.RectangleBuilder;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GUIApplication extends Application{
	
	private void init(Stage primaryStage) {
        Group root = new Group();
        Button button = new Button("New Button");
        primaryStage.setScene(new Scene(root));
        TilePane tilePaneRoot = new TilePane(5, 5);
        tilePaneRoot.setHgap(2);
        tilePaneRoot.setVgap(2);
        tilePaneRoot.getChildren().addAll(
            createBox(Cursor.DEFAULT),
            createBox(Cursor.CROSSHAIR),
            createBox(Cursor.TEXT),
            createBox(Cursor.WAIT),
            createBox(Cursor.SW_RESIZE),
            createBox(Cursor.SE_RESIZE),
            createBox(Cursor.NW_RESIZE),
            createBox(Cursor.NE_RESIZE),
            createBox(Cursor.N_RESIZE),
            createBox(Cursor.S_RESIZE),
            createBox(Cursor.W_RESIZE),
            createBox(Cursor.E_RESIZE),
            createBox(Cursor.OPEN_HAND),
            createBox(Cursor.CLOSED_HAND),
            createBox(Cursor.HAND),
            createBox(Cursor.DISAPPEAR),
            createBox(Cursor.MOVE),
            createBox(Cursor.H_RESIZE),
            createBox(Cursor.V_RESIZE),
            createBox(Cursor.NONE)
        );
        root.getChildren().add(tilePaneRoot);
        
    }
 
    private Node createBox(Cursor cursor) {
        Label label = new Label(cursor.toString());
        label.setAlignment(Pos.CENTER);
        label.setPrefSize(85, 85);
        label.setStyle("-fx-border-color: #aaaaaa; -fx-background-color: #dddddd;");
        label.setCursor(cursor);
        return label;
    }
 
    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }

}
