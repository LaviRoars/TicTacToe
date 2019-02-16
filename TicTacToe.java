import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

// for pane
import javafx.scene.layout.BorderPane;	// BorderPane
import javafx.scene.layout.GridPane;	// GridPane
import javafx.scene.layout.FlowPane;
import javafx.geometry.Insets;		// for padding

import javafx.scene.layout.Priority;

// some nodes for the flow pane
import javafx.scene.control.Label;
import javafx.scene.control.Button;


public class TicTacToe extends Application {

	private Label message;
	private MyButton board[][];

	private char whosTurn;	//store 'X' or 'O'
	private int validMoves; //0-16

	//get who's turn to play
	public char getWhosTurn() {
		return whosTurn;
	}

	//update who's turn in message
	public void updateWhosTurn() {
		whosTurn = (whosTurn == 'X') ? 'O' : 'X';
		message.setText("Turn: " + whosTurn);
	}

	//update who won in message
	public void setWin(char c) {
		disableBoard();
		message.setText(c + " won");
	}

	//disable game when one player won
	public void disableBoard() {
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++){
				board[i][j].setDisable(true);
			}
		}
	}

	//check valid moves
	public void incValidMoves() {
		validMoves++;
		if(validMoves==16){
			disableBoard();
			message.setText("Draw Game");
		}
	}

	//check if array index is out of bound
	public boolean isInBound(int x, int y) {
		if(x>=0 && x<=3 && y>=0 && y<=3)
			return true;
		return false;
	}

	//check if last move has won the game
	public MyButton getButtonAt (int x, int y) {
		if(isInBound(x,y))
			return board[x][y];
		return null;
	}

	public void start(Stage primaryStage) {

		this.whosTurn = 'X';
		this.validMoves = 0;


		// --- setting up the Scene --->
		BorderPane pane = new BorderPane();
		FlowPane upperPane = new FlowPane();
		GridPane centerPane = new GridPane();

		this.message = new Label("Turn: " + whosTurn);
		upperPane.getChildren().add(message);
		this.board = new MyButton[4][4];

		//new buttons with loop
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				board[i][j] = new MyButton(i,j,this);
				board[i][j].setMaxWidth(Double.MAX_VALUE);
				board[i][j].setMaxHeight(Double.MAX_VALUE);
				GridPane.setHgrow(board[i][j], Priority.ALWAYS);
				GridPane.setVgrow(board[i][j], Priority.ALWAYS);

			}
		}

		//add components to pane
		for(int i=0; i<4; i++){
					for(int j=0; j<4; j++){
						centerPane.add(board[i][j], i, j);
					}
		}

		pane.setTop(upperPane);
		pane.setCenter(centerPane);

		Scene scene = new Scene(pane, 300, 300);

		primaryStage.setTitle("Tic Tac Toe");
		primaryStage.setScene(scene);
		primaryStage.show();


	}

	public static void main(String args[]) {
		Application.launch(args);
	}
}
