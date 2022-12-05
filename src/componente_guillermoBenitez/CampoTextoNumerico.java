/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componente_guillermoBenitez;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author usuario
 */
public class CampoTextoNumerico extends TextField {
    
    final static Label label = new Label();
    
    final TextField sum = new TextField() {
        @Override
        public void replaceText(int start, int end, String text) {
            if (!text.matches("[a-z, A-Z]")) {
                super.replaceText(start, end, text);
            }
            label.setText("Enter a numeric value");
        }
        @Override
        public void replaceSelection(String text) {
            if (!text.matches("[a-z, A-Z]")) {
                super.replaceSelection(text);
            }
        }
    };
}
