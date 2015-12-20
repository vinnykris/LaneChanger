import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GameFrame extends JPanel implements ActionListener{
	
	Timer mainTimer;
	Player player;
	
	int playerH = 48;
	int playerW = 26;
	
	int obstacleCount = 25;
	int level = 1;
	
	
	static ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	Random rand = new Random();
	
	ArrayList <Integer> scores = new ArrayList<Integer>();
	
	public GameFrame(){
		this.setBackground(Color.GRAY);
		setFocusable(true);
		player = new Player(250 - playerW/2, 600 - playerH - playerW);
		addKeyListener(new KeyAdapt(player));
		
		mainTimer = new Timer(10, this);
		mainTimer.start();
		
		startGame();
		
		
	}
	
	
	public void paint (Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		player.draw(g2d);
		
		g2d.drawString("Level: " +level, 10, 20);
		g2d.drawString("DO NOT DRIVE OFF THE ROAD", 10, 10);
		
		
	
		
		for(int i = 0; i < obstacles.size(); i++){
			Obstacle temp = obstacles.get(i);
			temp.draw(g2d);
		}

		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		player.update();
		
		for(int i = 0; i < obstacles.size(); i++){
			Obstacle temp = obstacles.get(i);
			temp.update();
		}
		
		checkEnd();
		
		repaint();
	}
	
	public void addObstacle(Obstacle o){
		obstacles.add(o);
	}
	
	public static ArrayList<Obstacle> getObstacleList(){
		return obstacles;
	}
	
	public void startGame(){
//		
		
//		player.velX = 
		obstacleCount = level *8;
		
		for (int i = 0; i < obstacleCount; i++){
			addObstacle(new Obstacle(rand.nextInt(500 - playerW), -10 + -rand.nextInt(600 - playerH - playerW)));
		}
	}
	
	public void checkEnd(){

		if (player.checkCollisions() == true){
			
			JOptionPane.showMessageDialog(null, "You CRASHED.");
			if(scores.size() == 0){
				scores.add(level);
				obstacles.clear();
				level = 1;
				player.x = 250 - playerW/2;
				startGame();
				
				
			}
			else if (scores.size() == 1){
				
				scores.add(level);
				if(scores.get(0) == scores.get(1)){
					JOptionPane.showMessageDialog(null, "Tie game! Play again to decide winner.");
					tieGame();
				}
				else if(scores.get(0) != scores.get(1)){
					compare(scores.get(0), scores.get(1));
					
				}
				
			}
			

		} 
		
		
		
		if (obstacles.size() == 0){
			level++;
			
			obstacles.clear();
			
			JOptionPane.showMessageDialog(null, "Good. Now onto level " +level);
			
			startGame();
		}
	}


	private void tieGame() {
		// TODO Auto-generated method stub
		
		obstacles.clear();
		player.x = 250 - playerW/2;
		level = 1;
		startGame();
		checkEnd();
		scores.clear();
		
	}


	private void compare(int integer, int integer2) {
		// TODO Auto-generated method stub
		if (integer > integer2){
			JOptionPane.showMessageDialog(null, "Player 1 wins! Player 1: " +integer+ ", Player 2: " +integer2);
			
		}
		if (integer < integer2){
			JOptionPane.showMessageDialog(null, "Player 2 wins! Player 1: " +integer+ ", Player 2: " +integer2);
		}

		scores.clear();
		System.exit(0);
	}


	
	

}
