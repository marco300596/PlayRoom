package logic.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class CheckBookingViewController {

    @FXML
    private VBox vBox;

    @FXML
    private TableView<?> chkTable;

    @FXML
    private TableColumn<?, ?> usCol;

    @FXML
    private TableColumn<?, ?> dtCol;

    @FXML
    private TableColumn<?, ?> hCol;

    @FXML
    private TableColumn<?, ?> numCol;

    @FXML
    private Button upBtn;

    @FXML
    void checkList(MouseEvent event) {
    	//TODO aggiorna la lista delle prenotazioni.
    }

}

