package oop2.assignment_3;

import java.io.IOException;

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
import oop2.assignment_3.Model.Animal;
import oop2.assignment_3.Model.Enclosure;

/**
 * Controller for managing individual enclosure views, displaying animals, and
 * handling CRUD operations (Add/Delete animals) according to the MVC pattern.
 *
 * @author Aya
 */
public class EnclosureViewController {

    public Button openButton;
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("animal-view.fxml"));
            Parent view = fxmlLoader.load();

            AnimalViewController animalController = fxmlLoader.getController();
            if (animalController != null && currentEnclosure != null) {
                // Pass the current enclosure so the new animal can be added directly to it
                animalController.prepareForNewAnimal(currentEnclosure);
            }

            Scene nextScene = new Scene(view, 400, 300);
            Stage nextStage = new Stage();
            nextStage.setScene(nextScene);
            nextStage.setTitle("Add Animal");
            nextStage.initModality(Modality.WINDOW_MODAL);
            nextStage.initOwner(((Node) event.getSource()).getScene().getWindow());
            nextStage.showAndWait();

            // Refresh the ListView to display the newly added animal
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
     * Handles the 'Back' button action to close the enclosure window and return
     * to the zoo section view.
     */
    @FXML
    private void handleBack(ActionEvent event) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Handles the 'Open' button action to view or edit the selected animal.
     */
    @FXML
    private void handleOpenAnimal(ActionEvent pEvent) {
        Animal selectedAnimal = animalListView.getSelectionModel().getSelectedItem();

        if (selectedAnimal != null) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("animal-view.fxml"));
                Parent view = fxmlLoader.load();

                AnimalViewController controller = fxmlLoader.getController();
                if (controller != null) {
                    // Pass the selected animal to view/edit its details
                    controller.setAnimal(selectedAnimal);
                }

                Scene nextScene = new Scene(view, 500, 500);
                Stage nextStage = new Stage();
                nextStage.setScene(nextScene);
                nextStage.setTitle(selectedAnimal.getName());
                nextStage.initModality(Modality.WINDOW_MODAL);

                // Fixed: Use pEvent instead of the null Image variable
                nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
                nextStage.showAndWait();

                // Refresh the ListView in case the animal's name/details were updated
                updateView();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}