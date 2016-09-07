package mansfew.collections.view;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import mansfew.collections.Beatmap;
import mansfew.collections.MainApp;

public class BeatmapOverviewController {

	@FXML
	private TableView<Map.Entry<String,Beatmap>> BeatmapTable;
	
    @FXML
    private TableColumn<Map.Entry<String,Beatmap>, String> beatmapColumn;

    @FXML
    private TableColumn<Map.Entry<String,Beatmap>, String> difficultyColumn;

    @FXML
    private Label artistLabel;

    @FXML
    private Label mapperLabel;

    @FXML
    private Label modeLabel;

    @FXML
    private Label rankedLabel;

    @FXML
    private Label genreLabel;

    @FXML
    private Label sourceLabel;

    @FXML
    private Label tagsLabel;

    @FXML
    private Label mapIDLabel;

    @FXML
    private Label hashLabel;
    
    //reference to main app
    private MainApp mainApp;
    
    public BeatmapOverviewController() {
    }
    

    @FXML
    void initialize() {
       this.beatmapColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, Beatmap>, String>, ObservableValue<String>>() {

           @Override
           public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, Beatmap>, String> p) {
               // this callback returns property for just one cell, you can't use a loop here
               // for first column we use key
               return new SimpleStringProperty(p.getValue().getValue().getSong());
           }
       });
       
       this.difficultyColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, Beatmap>, String>, ObservableValue<String>>() {

           @Override
           public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, Beatmap>, String> p) {
               // this callback returns property for just one cell, you can't use a loop here
               return new SimpleStringProperty(p.getValue().getValue().getDifficulty());
           }
       });
   
    }
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        ObservableList<Map.Entry<String, Beatmap>> items = FXCollections.observableArrayList(mainApp.getBeatmapData().entrySet());
        BeatmapTable.setItems(items);
    }

}

