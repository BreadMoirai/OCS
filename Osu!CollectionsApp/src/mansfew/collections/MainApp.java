package mansfew.collections;

import java.io.IOException;
import java.util.HashMap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	//http://code.makery.ch/library/javafx-8-tutorial/part2/
	private Stage primaryStage;
	private BorderPane rootLayout;
	  
	/**
	* The data as an observable list of Beatmaps.
	*/
	private HashMap<String, Beatmap> BeatmapData;
	
	/**
	 * Constructor
	 */
	public MainApp() {
	    try {
			BeatmapData = (new OsuParser("src/resources/osu!.db")).getHash();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}
	
	/**
	 * Returns the data as an observable list of Persons. 
	 * @return
	 */
	public HashMap<String, Beatmap> getBeatmapData() {
	    return BeatmapData;
	}
	
	
	
	@Override
	public void start(Stage primaryStage) {
	    this.primaryStage = primaryStage;
	    this.primaryStage.setTitle("CollectionsApp");
	
	    initRootLayout();
	
	    showBeatmapOverview();
	}
	
	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
	    try {
	        // Load root layout from fxml file.
	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
	rootLayout = (BorderPane) loader.load();
	
	// Show the scene containing the root layout.
	        Scene scene = new Scene(rootLayout);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	/**
	 * Shows the person overview inside the root layout.
	 */
	public void showBeatmapOverview() {
	    try {
	        // Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/BeatmapOverview.fxml"));
			AnchorPane BeatmapOverview = (AnchorPane) loader.load();
			
			// Set person overview into the center of root layout.
		        rootLayout.setCenter(BeatmapOverview);
		    } catch (IOException e) {
		        e.printStackTrace();
	    }
	}
	
	/**
	 * Returns the main stage.
	 * @return
	 */
	public Stage getPrimaryStage() {
	    return primaryStage;
	}
	
	public static void main(String[] args) {
	    launch(args);
	}
}