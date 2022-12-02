import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_C_GameObject extends GameObject implements KeyListener {
	int highLighted = 0;

	public Type_C_GameObject(int x, int y) {
		super(x, y);
		setDirection(Direction.RIGHT);
		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_C_Left.png"));
		imageList.add(new ImageIcon("images/Type_C_Right.png"));

	}

	public void move(Canvas c, int highlighted) {
		highLighted = highlighted;
		//System.out.println(highLighted);
		Icon icon = getCurrentImage();
		//Icon icon = imageList.get(1);

		// int iconHeight = icon.getIconHeight();
		int iconWidth = icon.getIconWidth();
		// int canvasHeight = (int)c.getSize().getHeight();
		int canvasWidth = (int) c.getSize().getWidth();
		// MOVE BALL AND CHECK FOR A COLLISION WITH WALL
		// System.out.println("For C " + getX());
		if (highlighted == 0) {
			//System.out.println(icon);
			switch (getDirection()) {
		      case Direction.LEFT:
		          setX(getX() + getVelocity());
		          if (getX() + iconWidth > canvasWidth) {
		            setX((int)(canvasWidth - iconWidth));
		          }
		          break;
		        case Direction.RIGHT:
		          setX(getX() - getVelocity());
		          if (getX() < 0) {
		            setX(0);
		          }
		          break;
		  	default:
		  		break;
			}
		} else {
			//setDirection(Direction.RIGHT);
			//System.out.println();
			if (getDirection() == Direction.LEFT) {
				setDirection(Direction.LEFT);
				setX(getX() + getVelocity());
				if (getX() + iconWidth > canvasWidth) {
					setX((int) (canvasWidth - iconWidth));
					setDirection(Direction.RIGHT);
					// System.out.println("For C " + getVelocity());
				}

			} else if (getDirection() == Direction.RIGHT){ 
				setDirection(Direction.RIGHT);
				setX(getX() - getVelocity());
				if (getX() < 0) {
					setX(0);

					setDirection(Direction.LEFT);
				}
			} else {
				if (currentImage == 0) {
					setDirection(Direction.LEFT);
				} else  if (currentImage == 1){
					setDirection(Direction.RIGHT);
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
		case Direction.LEFT:
			currentImage = 0;
			break;
		case Direction.RIGHT:
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
		if (highLighted == 0) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				setDirection(Direction.LEFT);
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				setDirection(Direction.RIGHT);
			}
		}
	}

}