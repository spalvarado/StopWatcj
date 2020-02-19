/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stopwatcj;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author kelvin
 */
public class StopWatchPane extends BorderPane {
    private CounterPane counterPane = new CounterPane(0);
    private Button btnStart = new Button("Start");
    private Button btnStop = new Button("Stop");
    private Button btnReset = new Button("Reset");
    private MyTimer timer = new MyTimer();
    
    public StopWatchPane() {
        this.setCenter(counterPane);
        HBox controlPane = new HBox();
        controlPane.setAlignment(Pos.CENTER);
        controlPane.setSpacing(20);
        controlPane.getChildren().addAll(btnStart, btnStop, btnReset );
        this.setBottom(controlPane);
        btnStart.setOnAction( new EventHandler<ActionEvent>() {
           @Override
           public void handle( ActionEvent e) {
               timer.start();
           }
        });
        btnStop.setOnAction( new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                timer.stop();
            }
            
        });
        btnReset.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                counterPane.setValue(0);
            }
            
        });
        
    }
    
    public class MyTimer extends AnimationTimer {
        private long previous =0;
        @Override
        public void handle( long nsec ) {
            if (nsec - previous > 1000000000) {
                counterPane.incrementValue();
                previous = nsec;
            }
        }
    }
}
