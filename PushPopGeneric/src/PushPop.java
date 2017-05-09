import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;


public class PushPop extends Application {	
	
	//Create text area and field
	TextArea stack = new TextArea();
	TextField txtPush = new TextField();	

	//Create object of generic stack
	Stack<Double> stack1 = new Stack<>();

	//Create BorderPane 
		 protected BorderPane getPane() {
			 
			//create all events for when buttons are pressed 
			  EventHandler<ActionEvent> pushEvent = event -> push();
		        txtPush.setOnAction(pushEvent);
		        
		        EventHandler<ActionEvent> queueEvent = event -> queue();
		        txtPush.setOnAction(queueEvent);
		        
		      EventHandler<ActionEvent> popEvent = event -> pop();
		      
		      EventHandler<ActionEvent> deQueueEvent = event -> deQueue();
		      
		      EventHandler<ActionEvent> clearEvent = event -> clear();
			 
		      //create pane for buttons and attach correct actions to buttons
			    HBox paneForButtons = new HBox(6);
			    
			    Button btPop = new Button("Pop");
			    Button btClear = new Button("Clear");
			    Button btToggle = new Button("Change to Queue");
			    Button btPush = new Button("Push");
			    
			    btPush.setOnAction(pushEvent);
			    			    
			    btPop.setOnAction(popEvent);
			    
			    btClear.setOnAction(clearEvent);
			    
			    btToggle.setOnAction(e -> {
			    		if (btToggle.getText().equals("Change to Queue")) {
			    			btToggle.setText("Change to Push");
			    			btPush.setText("Enter Queue");
			    			btPop.setText("DeQueue");
			    			btPush.setOnAction(queueEvent);
			    			btPop.setOnAction(deQueueEvent);
			    		} else {
			    			btToggle.setText("Change to Queue");
			    			btPush.setText("Push");
			    			btPop.setText("Pop");
			    			btPush.setOnAction(pushEvent);
			    			btPop.setOnAction(popEvent);
			    		}
			    	});
			    	    
			      //put all buttons on pane
			    paneForButtons.getChildren().addAll(btPush, txtPush, btPop, btToggle, btClear);
			    paneForButtons.setAlignment(Pos.CENTER_LEFT );
			    
			    BorderPane pane = new BorderPane();
			    pane.setTop(paneForButtons);
			    
			    //create and add pane for text stack
			    Pane paneForText = new Pane();
			    paneForText.getChildren().add(stack);
			    pane.setCenter(paneForText);
			    			    
			 // Set the font in the label and the text field
			    stack.setFont(new Font("Serif", 14));
			    stack.setWrapText(true);
			    stack.setEditable(false);
			    
			    return pane;
		 }
			@Override // Override the start method in the Application class
			  public void start(Stage primaryStage) {
		 
			    // Create a scene and place it in the stage
			    Scene scene = new Scene(getPane(), 470, 200);
			    primaryStage.setTitle("PushPop"); // Set the stage title
			    primaryStage.setScene(scene); // Place the scene in the stage
			    primaryStage.show(); // Display the stage
			  }
			
	//methods to add to the generic stack as well as pull from stack to display in GUI
			
			public void push(){
			stack1.push(Double.parseDouble(txtPush.getText()));
				stack.setText(stack1.toString());
			}
			
			public void queue(){
				stack1.queue(Double.parseDouble(txtPush.getText()));
				stack.setText(stack1.toString());
			}
			
			
			public void pop(){	
			    stack1.pop();
				stack.setText(stack1.toString());
			}
			
			public void deQueue(){	
			    stack1.deQueue();
				stack.setText(stack1.toString());
			}
			
			public void clear(){
					stack1.clear();
					stack.setText(stack1.toString());
			}

	
	 //  Main not needed
	  public static void main(String[] args) {
	    launch(args);
	  }
}
