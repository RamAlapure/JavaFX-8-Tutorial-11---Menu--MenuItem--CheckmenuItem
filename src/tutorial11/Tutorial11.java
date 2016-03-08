/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial11;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Ram
 */
public class Tutorial11 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
        primaryStage.setTitle("JavaFX 8 Tutorial 11 - Menus ");
        
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 300, 250, Color.WHITE);
        
        MenuBar menubar = new MenuBar();
        root.setTop(menubar);
        
        //File menu
        Menu fileMenu = new Menu("File");
        MenuItem item1 =new MenuItem("New Project       Ctrl+Shift+N");
        MenuItem item2 =new MenuItem("Open Project       Ctrl+Shift+o");
        MenuItem item3 =new MenuItem("Exit");
        item3.setOnAction(e -> Platform.exit());
        fileMenu.getItems().addAll(item1, item2, new SeparatorMenuItem(), item3);
        
        //View Menu
        Menu viewMenu = new Menu("View");
        CheckMenuItem check1 = new CheckMenuItem("Editor");
        check1.setSelected(true);
        CheckMenuItem check2 = new CheckMenuItem("Line Number");
        check2.setSelected(true);
        viewMenu.getItems().addAll(check1, check2, new SeparatorMenuItem());
        
        Menu toolbar = new Menu("Toolbar");
        toolbar.getItems().addAll(
                new CheckMenuItem("File"),
                new CheckMenuItem("Run"),
                new CheckMenuItem("Debug")
        );
        viewMenu.getItems().add(toolbar);
        //Mode menu
        Menu mode = new Menu("Mode");
        ToggleGroup tGroup = new ToggleGroup();
        RadioMenuItem mode1 = new RadioMenuItem("Desktop");
        mode1.setToggleGroup(tGroup);
        RadioMenuItem mode2 = new RadioMenuItem("Tablet");
        mode2.setToggleGroup(tGroup);
        mode2.setSelected(true);
        
        mode.getItems().addAll(mode1, mode2);
        
        menubar.getMenus().addAll(fileMenu, viewMenu, mode);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
