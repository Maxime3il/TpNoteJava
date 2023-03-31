package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.Couleur;
import model.ModelGestionnaire;

public class Controleur {

	private ModelGestionnaire model = new ModelGestionnaire();
	
	@FXML
	private ListView<Couleur> listViewCouleur;
	
    @FXML
    private Button ajouterButton;

    @FXML
    private TextField bleuCouleur;

    @FXML
    private TextField nomCouleur;

    @FXML
    private TextField rougeCouleur;

    @FXML
    private Button sauvegardeButton;

    @FXML
    private Pane scene;

    @FXML
    private BorderPane sceneCouleur;

    @FXML
    private Button supprimerButton;

    @FXML
    private TextField vertCouleur;
    
    @FXML
    private Pane rectangleCouleur;

    @FXML
    public void initialize() {
    	setNumericOnlyFilter(rougeCouleur);
        setNumericOnlyFilter(vertCouleur);
        setNumericOnlyFilter(bleuCouleur);
        
     // ... initialisation du modèle
//        listViewCouleurs.setItems(model.getCouleurs());
//        listViewCouleurs.setCellFactory(param -> new ListCell<Couleur>() {
//            private final VBox vbox = new VBox();
//            private final Label labelNom = new Label();
//            private final Rectangle rectCouleur = new Rectangle(20, 20);
//
//            {
//                vbox.getChildren().addAll(labelNom, rectCouleur);
//            }
//
//            @Override
//            protected void updateItem(Couleur couleur, boolean empty) {
//                super.updateItem(couleur, empty);
//
//                if (empty || couleur == null) {
//                    setText(null);
//                    setGraphic(null);
//                } else {
//                    labelNom.setText(couleur.getNom());
//                    rectCouleur.setFill(Color.rgb(couleur.getRouge(), couleur.getVert(), couleur.getBleu()));
//                    setText(null);
//                    setGraphic(vbox);
//                }
//            }
//        });
    } 
    
    
    /**
     * Ajoute une couleur dans le model de données lorsque l'utilisateur clique sur le boutton ajouter
     * @param event
     */
    @FXML
    void ajouterCouleur(ActionEvent event) {
    	// Récupérer les valeurs saisies pour les composantes RGB
    	int rouge = Integer.parseInt(rougeCouleur.getText());
    	int vert = Integer.parseInt(vertCouleur.getText());
    	int bleu = Integer.parseInt(bleuCouleur.getText());
    	
        if (rouge >= 0 && rouge <= 255 &&
                vert >= 0 && vert <= 255 &&
                bleu >= 0 && bleu <= 255) {

            // Créer une couleur avec les valeurs RGB saisies
            Color couleur = Color.rgb(rouge, vert, bleu);

            // Créer un background avec la couleur
            BackgroundFill fill = new BackgroundFill(couleur, CornerRadii.EMPTY, Insets.EMPTY);
            Background background = new Background(fill);

            // Modifier le background du pane
            rectangleCouleur.setBackground(background);

            // Ajoute la couleur dans la liste
            model.ajouterCouleur(new Couleur(nomCouleur.getText(), rouge, vert, bleu));
        } 
    }
    
    /**
     * Méthode qui permet de vérifier qu'un utilisateur ne rentre uniquement des caractères numériques
     * @param textField
     */
    private void setNumericOnlyFilter(TextField textField) {
        // Définir un filtre de texte pour n'accepter que des caractères numériques
        textField.setTextFormatter(new TextFormatter<>(change ->
                (change.getControlNewText().matches("\\d*")) ? change : null));
    }

    @FXML
    void supprimerCouleur(ActionEvent event) {
        // Récupérer l'indice de la couleur sélectionnée dans la liste
        int selectedIndex = listViewCouleur.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            // Supprimer la couleur de la liste et mettre à jour le modèle de données
            model.supprimerCouleur(selectedIndex);
        }
    }
    
    /**
     * Cette méthode permettra de modifier l'affichage des textField lorsque 
     * l'utilisateur selectionnera une couleur dans la listView
     */
    void selectionCouleur() {
    	// Récupérer la couleur sélectionnée dans la liste
        Couleur selectedCouleur = listViewCouleur.getSelectionModel().getSelectedItem();
        if (selectedCouleur != null) {
        	nomCouleur.setText(selectedCouleur.getNom());
            // Afficher les composantes RGB de la couleur sélectionnée
            rougeCouleur.setText(Integer.toString(selectedCouleur.getRouge()));
            vertCouleur.setText(Integer.toString(selectedCouleur.getVert()));
            bleuCouleur.setText(Integer.toString(selectedCouleur.getBleu()));
        }
    }
    
    @FXML
    void sauvegarder(ActionEvent event) {
//        File file = "";
//        if (file != null) {
//            // Ouvrir un flux de sortie vers le fichier
//            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
//                // Écrire le modèle dans le fichier
//                oos.writeObject(model);
//                oos.flush();
//            } catch (IOException e) {
//            	e.printStackTrace();
//            }
//        }
    }
}

