import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Obstacle extends Entity{
	

	public int startY;
	public int speed = 3;

	public Obstacle(int x, int y) {
		super(x, y);
		startY = y;
		
	
		// TODO Auto-generated constructor stub
	}
	
	public void update(){
		y += speed;
		checkOffScreen();
	}
	
	public void draw(Graphics2D g2d){
		g2d.drawImage(getObstacleImg(), x, y, null);

	}
	
	public Image getObstacleImg(){
//		String path = "obstacle.jpg";
//        File file = new File(path);
//        BufferedImage image = null;
//		try {
//			image = ImageIO.read(file);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        JLabel label = new JLabel(new ImageIcon(image));
//		
////		ImageIcon ic = new ImageIcon("C:/LaneChangerPics/car.png");
//		
//		return image;
		
//		ImageIcon ic = new ImageIcon("C:/LaneChangerPics/obstacle.png");
//		ImageIcon ic = new ImageIcon("obstacle.jpg");
		
		ImageIcon ic = new ImageIcon(getClass().getResource("/resources/obstacle.png"));
		return ic.getImage();
		
		
	}
	
	public void checkOffScreen(){
		if ( y >= 680){
			GameFrame.getObstacleList().remove(this);
		}
		
	}
	
	
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, getObstacleImg().getWidth(null), getObstacleImg().getHeight(null));
	}

}
