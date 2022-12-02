
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_A_GameObject extends GameObject implements KeyListener {
	int highLighted = 0;

	public Type_A_GameObject(int x, int y) {
		super(x, y);
		setDirection(Direction.DOWN);
		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_A_Down.png"));
		imageList.add(new ImageIcon("images/Type_A_Up.png"));

	}

	public void move(Canvas c, int highlighted) {
		highLighted = highlighted;
		//System.out.println(highLighted);
		Icon icon = getCurrentImage();
		//Icon icon = imageList.get(1);

		 int iconHeight = icon.getIconHeight();
		//int iconWidth = icon.getIconWidth();
		 int canvasHeight = (int)c.getSize().getHeight();
		//int canvasWidth = (int) c.getSize().getWidth();
		// MOVE BALL AND CHECK FOR A COLLISION WITH WALL
		// System.out.println("For C " + getX());
		if (highlighted == 2) {
			//setDirection(Direction.NONE);
			//System.out.println(icon);
			switch (getDirection()) {
			case Direction.UP:
				setY(getY() - getVelocity());
				if (getY() < 0) {
					setY(0);
				}
				break;
			case Direction.DOWN:
				setY(getY() + getVelocity());
				if (getY() + iconHeight > canvasHeight) {
					setY((int) (canvasHeight - iconHeight));
				}
				break;
		  	default:
		  		break;
			}
		} else {
			if (getDirection() == Direction.UP) {
				setDirection(Direction.UP);
				setY(getY() - getVelocity());
				if (getY() < 0) {
					setY(0);

					setDirection(Direction.DOWN);
				}

			} else if (getDirection() == Direction.DOWN){
				setDirection(Direction.DOWN);
				setY(getY() + getVelocity());
				if (getY() + iconHeight > canvasHeight) {
					setY((int) (canvasHeight - iconHeight));
					setDirection(Direction.UP);
					// System.out.println("For C " + getVelocity());
				}
			} else {
				if (currentImage == 0) {
					setDirection(Direction.DOWN);
				} else  if (currentImage == 1){
					setDirection(Direction.UP);
				}
			}
		}
	}

	// SPECIFY THE IMAGE TO DISPLAY
	// USED FOR ANIMATION
	public void setImage() {
		switch (getDirection()) {
		case Direction.NONE:
			break;
		case Direction.DOWN:
			currentImage = 0;
			break;
		case Direction.UP:
			currentImage = 1;
			break;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	    if (e.getKeyCode() != KeyEvent.VK_TAB) {
	        setDirection(Direction.NONE);
	      }
	}

	public void keyPressed(KeyEvent e) {
		if (highLighted == 2) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				//setVelocity(10);
				setDirection(Direction.UP);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				//setVelocity(10);
				setDirection(Direction.DOWN);
			}
		}
	}

}
