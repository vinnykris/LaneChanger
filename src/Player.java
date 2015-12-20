
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;




public class Player extends Entity{
	
	int startX;
	int velX = 0;
	int speed = 3;

	public Player(int x, int y) {
		super(x, y);
		startX = x;
		update();
		
		// TODO Auto-generated constructor stub
	}
	public void update(){
		if (this.x < 500){
			x += velX;
		}
//		if (this.x < 500){
//			
//		} else {
//			x += 0;
//		}
		

	}
	
	public void draw(Graphics2D g2d){
		
		
		g2d.drawImage(getPlayerImg(), x, y, null);

	}
	
	public Image getPlayerImg(){
//		String path = "car.jpg";
//        File file = new File(path);
//        BufferedImage image = null;
//		try {
//			image = ImageIO.read(file);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        JLabel label = new JLabel(new ImageIcon(image));
		
//		ImageIcon ic = new ImageIcon("car.jpg");
		
//		ImageIcon ic = new ImageIcon("C:/LaneChangerPics/car.png");
		ImageIcon ic = new ImageIcon(getClass().getResource("/resources/car.png"));
//		ImageIO.read("/resources/")
		
		
		
		return ic.getImage();
		
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT){
			if (checkCollisions() == false)
				
				velX = -speed;
				
			
		} else if (key == KeyEvent.VK_RIGHT){
			if (checkCollisions() == false)
				velX = speed;
				
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT){
			
			velX = 0;
			
		} else if (key == KeyEvent.VK_RIGHT){
			velX = 0;
		}
	}
	
	public boolean checkCollisions(){
		ArrayList<Obstacle> obstacles = GameFrame.getObstacleList();
		if (this.x > 500 || this.x < -26){
			return true;
		}
		for (int i = 0; i < obstacles.size(); i++){
			Obstacle temp = obstacles.get(i);
			if(getBounds().intersects(temp.getBounds())){
				velX = 0;
				return true;
			}
		}
		return false;
	}
	
	public Rectangle getBounds(){
	
		return new Rectangle(x, y, getPlayerImg().getWidth(null), getPlayerImg().getHeight(null));
	}

}
