package oop2.assignment_3;

import com.example.oop2a3zms.Model.Animal;
import com.example.oop2a3zms.Model.Enclosure;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for managing individual enclosure views, displaying animals,
 * and handling CRUD operations (Add/Delete animals) according to the MVC pattern.
 *
 * @author YourName
 */
public class EnclosureViewController {

    @FXML
    private Label enclosureTitleLabel;

    @FXML
    private ListView<Animal> animalListView;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button backButton;

    private Enclosure currentEnclosure;

    /**
     * Sets the enclosure to be displayed and populates the animal list view.
     *
     * @param enclosure The selected Enclosure object
     */
    public void setEnclosure(Enclosure enclosure) {
        this.currentEnclosure = enclosure;
        updateView();
    }

    /**
     * Refreshes the UI components with the latest data from the model.
     */
    private void updateView() {
        if (currentEnclosure != null) {
            enclosureTitleLabel.setText(currentEnclosure.getName());
            animalListView.getItems().setAll(currentEnclosure.getAnimals());
        }
    }

    /**
     * Handles the 'Add' button action to open the animal creation view modal.
     */
    @FXML
    private void handleAddAnimal(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/oop2a3zms/animal-view.fxml"));
            Parent view = fxmlLoader.load();

            // If you have an AnimalViewController, you can pass data or a callback here
            // AnimalViewController animalController = fxmlLoader.getController();

            Scene nextScene = new Scene(view, 400, 300);
            Stage nextStage = new Stage();
            nextStage.setScene(nextScene);
            nextStage.setTitle("Add Animal");
            nextStage.initModality(Modality.WINDOW_MODAL);
            nextStage.initOwner(((Node) event.getSource()).getScene().getWindow());
            nextStage.showAndWait();

            // After closing the modal, update view in case an animal was added
            updateView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the 'Delete' button action to remove the selected animal from the enclosure.
     */
    @FXML
    private void handleRemoveAnimal() {
        Animal selectedAnimal = animalListView.getSelectionModel().getSelectedItem();
        if (selectedAnimal != null && currentEnclosure != null) {
            currentEnclosure.removeAnimal(selectedAnimal);
            updateView();
        }
    }

    /**
     * Handles the 'Back' button action to close the enclosure window and return to the zoo section view.
     */
    @FXML
    private void handleBack(ActionEvent event) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

}
