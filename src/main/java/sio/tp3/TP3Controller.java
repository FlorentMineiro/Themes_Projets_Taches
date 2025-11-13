package sio.tp3;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.util.Callback;
import sio.tp3.Model.Tache;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class TP3Controller implements Initializable {
    private HashMap<String, HashMap<String, ArrayList<Tache>>> mesTaches;
    TreeItem racine;
    Alert alert;
    @FXML
    private ListView lstThemes;
    @FXML
    private ListView lstProjets;
    @FXML
    private TreeView tvTaches;
    @FXML
    private ComboBox cboDeveloppeurs;
    @FXML
    private Button cmdValider;
    @FXML
    private TextField txtNomTache;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mesTaches = new HashMap<>();
        racine = new TreeItem("Mes tâches");
        racine.setExpanded(true);
        tvTaches.setRoot(racine);

        cboDeveloppeurs.getItems().addAll("Enzo","Noa","Lilou","Milo");
        cboDeveloppeurs.getSelectionModel().selectFirst();

        lstThemes.getItems().addAll("Mobile","Web","Réseau");

        for(int i = 1 ; i<=10 ; i++)
        {
            lstProjets.getItems().add("Projet n°" + i);
        }
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur de Saisie");
    }

    @FXML
    public void cmdValiderClicked(Event event)
    {
        if (lstThemes.getSelectionModel().getSelectedItem() == null)
        {
            alert.setTitle("Choix du Thème");
            alert.setHeaderText("Veuillez sélectionner un thème");
            alert.showAndWait();
        } else if (lstProjets.getSelectionModel().getSelectedItem() == null) {
            alert.setTitle("Choix du Projet");
            alert.setHeaderText("Veuillez sélectionner un projet");
            alert.showAndWait();
        } else if (txtNomTache.getText().isEmpty()) {
            alert.setHeaderText("Veuillez saisir une tâche");
            alert.showAndWait();
        }
    }

    @FXML
    public void tvTachesClicked(Event event)
    {

    }
}