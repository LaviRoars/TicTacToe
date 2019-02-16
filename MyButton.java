import javafx.scene.control.*;

import javafx.event.*;

public class MyButton extends Button implements EventHandler<ActionEvent> {

	private int x;
	private int y;
	private char c;

	private TicTacToe ttt;

	public MyButton(int x, int y, TicTacToe ttt) {
		this.x = x;
		this.y = y;
		this.c = ' ';
		this.ttt = ttt;
		this.setOnAction(this);
	}

	public void handle(ActionEvent e){
			System.out.println(x + "," + "is clicked - " + ttt.getWhosTurn());
			if( c != ' ')
				return;

			c = ttt.getWhosTurn();
			this.setText(""+c);

			ttt.updateWhosTurn();
			ttt.incValidMoves();

			//checkWin
			int count;

			//check horizontal
			count = 1;
			//to the left
			for(int i=1; i<=2; i++){
				int nx = x + (-1)*i;
				int ny = y + 0 	 *i;
				if(ttt.isInBound(nx,ny) && ttt.getButtonAt(nx,ny).c==c){
					System.out.println("Found match at " + nx + "," + ny);
					count++;
				}
				else
					break;
			}
			//to the right
			for(int i=1; i<=2; i++) {
				int nx = x + 1   *i;
				int ny = y + 0 	 *i;
				if(ttt.isInBound(nx,ny) && ttt.getButtonAt(nx,ny).c==c){
					System.out.println("Found match at " + nx + "," + ny);
					count++;
				}
				else
					break;
			}
			if(count>=3)
				ttt.setWin(c);

			//check vertical
			count = 1;
			//to the upper
			for(int i=1; i<=2; i++) {
				int nx = x + 0   *i;
				int ny = y + (-1)*i;
				if(ttt.isInBound(nx,ny) && ttt.getButtonAt(nx,ny).c==c){
					System.out.println("Found match at " + nx + "," + ny);
					count++;
				}
				else
					break;
			}
			//to the lower
			for(int i=1; i<=2; i++) {
				int nx = x + 0   *i;
				int ny = y + 1   *i;
				if(ttt.isInBound(nx,ny) && ttt.getButtonAt(nx,ny).c==c){
					System.out.println("Found match at " + nx + "," + ny);
					count++;
				}
				else
					break;
			}
			if (count>=3)
				ttt.setWin(c);

			//check diagonal \
			count = 1;
			//to the upper
			for(int i=1; i<=2; i++) {
				int nx = x + (-1)*i;
				int ny = y + (-1)*i;
				if(ttt.isInBound(nx,ny) && ttt.getButtonAt(nx,ny).c==c){
					System.out.println("Found match at " + nx + "," + ny);
					count++;
				}
				else
					break;
			}
			//to the lower
			for(int i=1; i<=2; i++) {
				int nx = x + 1	*i;
				int ny = y + 1	*i;
				if(ttt.isInBound(nx,ny) && ttt.getButtonAt(nx,ny).c==c){
					System.out.println("Found match at " + nx + "," + ny);
					count++;
				}
				else
					break;
			}
			if(count>=3)
				ttt.setWin(c);

			//check diagonal /
			count = 1;
			//to the upper
			for(int i=1; i<=2; i++) {
				int nx = x + 1	 *i;
				int ny = y + (-1)*i;
				if(ttt.isInBound(nx,ny) && ttt.getButtonAt(nx,ny).c==c){
					System.out.println("Found match at " + nx + "," + ny);
					count++;
				}
				else
					break;
			}
			//to the lower
			for(int i=1; i<=2; i++) {
				int nx = x + (-1)*i;
				int ny = y + 1   *i;
				if(ttt.isInBound(nx,ny) && ttt.getButtonAt(nx,ny).c==c){
					System.out.println("Found match at " + nx + "," + ny);
					count++;
				}
				else
					break;
			}
			if(count>=3)
				ttt.setWin(c);
		}
}
