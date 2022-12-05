/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componente_guillermoBenitez;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 *
 * @author usuario
 */
public class Temporizador extends HBox implements Initializable {
    
    @FXML private Label contadorLabel;
    @FXML private Button startBtn;
    @FXML private Button stopBtn;
    
    
    private ObjectProperty<EventHandler<ActionEvent>> OnAction = 
            new SimpleObjectProperty<>();
    
    public Temporizador() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Temporizador.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        startBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                onActionProperty().get().handle(event);
            }
        });
        
    }
    
    public final ObjectProperty<EventHandler<ActionEvent>> onActionProperty() {
        return OnAction;
    }
    public final void setOnAction(EventHandler<ActionEvent> handler) {
        OnAction.set(handler);
    }
    
    public String getText() {
        return textProperty().get();
    }
    
    public void setText(String value) {
        textProperty().set(value);
    }

    public StringProperty textProperty() {
        return contadorLabel.textProperty();
    }
}
