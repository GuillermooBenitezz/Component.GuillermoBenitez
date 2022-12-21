/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componente_guillermoBenitez;

import static componente_guillermoBenitez.CampoTextoNumerico.label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

/**
 *
 * @author usuario
 */
public class Temporizador extends HBox implements Initializable {
    @FXML
    private Label secondsLabel;
    private Integer seconds = 10;
    
    //timeline
    private Timeline timeline;
    
    
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
    
    private void doTime(){
        //Duration duration = Duration.ofSeconds(10000);
        Timeline time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
        if(time!= null){//if the time is equal to zero it is finished but if it is not equal to something then it is //doing something
            time.stop();
        }
        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>(){
                        //every one second of the timeline the keyframe will do something (i.e., perform a job and that job //is defined by the event handler)
                        @Override
                        public void handle(ActionEvent event){
                            seconds--;
                            secondsLabel.setText("Contador: " + seconds.toString() + " Segundos");
                            
                             if(seconds <= 0){
                                time.stop();
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setHeaderText("Contador establecido en 0!");
                                alert.show();
                            }
                        }
                    });
        time.getKeyFrames().add(frame);
        time.playFromStart();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        doTime();
    }

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }    

}