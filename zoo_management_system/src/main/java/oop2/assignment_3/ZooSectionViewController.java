package oop2.assignment_3;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import oop2.assignment_3.Model.Enclosure;
import oop2.assignment_3.Model.ImportHelper;
import oop2.assignment_3.Model.ZooComponent;
import oop2.assignment_3.Model.ZooSection;
import oop2.assignment_3.Model.ZooService;

public class ZooSectionViewController {
    private final Deque<ZooSection> sectionHistory = new ArrayDeque<>();
    private ZooSection currentSection;

    @FXML
    private ListView<ZooComponent> zooSectionSectionsListView;

    @FXML
    private Label zooSectionHeaderLabel;

    @FXML
    private Button zooSectionAcceptButton;

    @FXML
    private Button zooSectionBackButton;

    @FXML
    public void initialize() {
        ZooService zooService = ImportHelper.createZooService();
        ZooSection rootSection = zooService.getRootSection();

        if (rootSection != null) {
            displaySection(rootSection);
        }
    }

    @FXML
    void handleAcceptButtonClick() {
        ZooComponent selectedComponent = zooSectionSectionsListView.getSelectionModel().getSelectedItem();
        if (selectedComponent != null) {
            if (selectedComponent instanceof ZooSection) {
                sectionHistory.push(currentSection);
                displaySection((ZooSection) selectedComponent);
            } else if (selectedComponent instanceof Enclosure) {
                openEnclosure((Enclosure) selectedComponent);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Please select a zoo section or enclosure from the list.");
            alert.showAndWait();
        }
    }

    @FXML
    void handleBackButtonClick() {
        if (!sectionHistory.isEmpty()) {
            displaySection(sectionHistory.pop());
        }
    }

    private void displaySection(ZooSection section) {
        currentSection = section;
        zooSectionHeaderLabel.setText(section.getName());
        zooSectionSectionsListView.getItems().setAll(section.getComponents());
        zooSectionBackButton.setDisable(sectionHistory.isEmpty());
    }

    private void openEnclosure(Enclosure enclosure) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/oop2/assignment_3/enclosure-view.fxml"));
            Parent view = loader.load();

            EnclosureViewController controller = loader.getController();
            controller.setEnclosure(enclosure);

            Stage stage = new Stage();
            stage.setTitle(enclosure.getName());
            stage.setScene(new Scene(view));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(zooSectionSectionsListView.getScene().getWindow());
            stage.showAndWait();
        } catch (IOException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Unable to Open Enclosure");
            alert.setHeaderText(null);
            alert.setContentText("The enclosure view could not be opened.");
            alert.showAndWait();
        }

    }
}