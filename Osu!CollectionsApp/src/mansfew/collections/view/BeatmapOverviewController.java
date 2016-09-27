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
	private TableView<Beatmap> beatmapTable;
	
    @FXML
    private TableColumn<Beatmap, String> titleColumn;

    @FXML
    private TableColumn<Beatmap, String> mapIDColumn;

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
    
    public BeatmapOverviewController() {}
    

    @FXML
    void initialize() {
    	 titleColumn.setCellValueFactory(cellData -> cellData.getValue().getSong());
         setIDColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
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

