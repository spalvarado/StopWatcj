/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stopwatcj;

import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author kelvin
 */
public class CounterPane extends StackPane {
    private int value = 0;
    private Text textObj;
    
    public CounterPane() {
        
        textObj = new Text(value+"");
        textObj.setFont( Font.font("Verdana", 40));
        this.getChildren().add(textObj);
    }
    
    public CounterPane( int value ) {
        
        this.value = value;
        textObj = new Text(value+"");
        textObj.setFont( Font.font("Verdana", 40));
        this.getChildren().add(textObj);
    }
    
    public void setValue( int value ) {
        this.value = value;
        textObj.setText(value+"");
    }
    
    public void incrementValue() {
        value +=1;
        textObj.setText(value+"");
    }
}
