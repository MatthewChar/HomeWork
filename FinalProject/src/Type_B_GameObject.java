import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_B_GameObject extends GameObject implements KeyListener {
	int highLighted = 0;

	public Type_B_GameObject(int x, int y) {
		super(x, y);
		setDirection(Direction.LEFT);

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_D_Up.png"));
		imageList.add(new ImageIcon("images/Type_B_Down.png"));
		imageList.add(new ImageIcon("images/Type_B_Left.png"));
		imageList.add(new ImageIcon("images/Type_B_Right.png"));

	}

	public void move(Canvas c, int highlighted) {
		Icon icon = getCurrentImage();
		highLighted = highlighted;

		int iconHeight = icon.getIconHeight();
		int iconWidth = icon.getIconWidth();
		int canvasHeight = (int) c.getSize().getHeight();
		int canvasWidth = (int) c.getSize().getWidth();
		// int canvasHeightHalf = canvasHeight / 2;
		// int canvasWidthHalf = canvasWidth / 2;

		// System.out.println("THis is X " + getX());
		// System.out.println("THis is Y " + getY());
		// System.out.println("THis is X with width" + (getX() + canvasWidth));
		// System.out.println("THis is Y height" + (getY() + canvasHeight));
		// System.out.println("This is Canvas height " + canvasHeight / 2);
		// System.out.println("This is Canvas width " + canvasWidth / 2);
		// System.out.println(highlighted);
		// System.out.println(getDirection());
		if (highLighted == 3) {
			//System.out.println("this is image in highlighted" + currentImage);
			// MOVE BLUE GAME OBJECT
			switch (getDirection()) {
			case Direction.UP:
				//System.out.println("this is getDirection" + getDirection());
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
			case Direction.LEFT:
				setX(getX() + getVelocity());
				if (getX() + iconWidth > canvasWidth) {
					setX((int) (canvasWidth - iconWidth));
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
//			System.out.println("this is image in else " + currentImage);
//			System.out.println("THis is Y " + getY());
			// System.out.println(getDirection());
			if (getDirection() == Direction.UP) {
				// System.out.println("this is getDirection" + getDirection());
				setDirection(Direction.UP);
				setY(getY() - getVelocity());
				if (getY() < 0) {
					setY(0);
					setDirection(Direction.DOWN);
				} else if (getY() == 400) {
					int countU = (int) (Math.random() * 2 + 1);
					if (countU == 1) {
						setDirection(Direction.LEFT);
					} else {
						setDirection(Direction.RIGHT);
					}
				}

			} else if (getDirection() == Direction.DOWN) {
				setDirection(Direction.DOWN);
				setY(getY() + getVelocity());
				if (getY() + iconHeight > canvasHeight) {
					setY((int) (canvasHeight - iconHeight));
					// setY(0);
					setDirection(Direction.UP);
					// System.out.println("For C " + getVelocity());
				} else if (getY() == 400) {
					int countD = (int) (Math.random() * 2 + 1);
					if (countD == 1) {
						setDirection(Direction.LEFT);
					} else {
						setDirection(Direction.RIGHT);
					}
				}
			} else if (getDirection() == Direction.LEFT) {
				setDirection(Direction.LEFT);
				setX(getX() + getVelocity());
				if (getX() + iconWidth > canvasWidth) {
					setX((int) (canvasWidth - iconWidth));
					// setX(0);
					setDirection(Direction.RIGHT);
					// System.out.println("For C " + getVelocity());
				} else if (getX() == 300) {
					int countL = (int) (Math.random() * 2 + 1);
					if (countL == 1) {
						setDirection(Direction.UP);
					} else {
						setDirection(Direction.DOWN);
					}
				}

			} else if (getDirection() == Direction.RIGHT) {
				setDirection(Direction.RIGHT);
				setX(getX() - getVelocity());
				if (getX() < 0) {
					setX(0);
					setDirection(Direction.LEFT);
				}
			} else if (getX() == 300) {
				int countR = (int) (Math.random() * 2 + 1);
				if (countR == 1) {
					setDirection(Direction.UP);
				} else {
					setDirection(Direction.DOWN);
				}
			} else {
				//System.out.println("this is image in else 2 " + currentImage);
				// System.out.println("this is currentimage" + currentImage);
				if (currentImage == 0) {
					setDirection(Direction.UP);
				} else if (currentImage == 1) {
					setDirection(Direction.DOWN);
				} else if (currentImage == 2) {
					setDirection(Direction.LEFT);
				} else if (currentImage == 3) {
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
		case Direction.UP:
			// System.out.println("this is getDirection" + getDirection());
			currentImage = 0;
			break;
		case Direction.DOWN:
			currentImage = 1;
			break;
		case Direction.LEFT:
			currentImage = 2;
			break;
		case Direction.RIGHT:
			currentImage = 3;
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
		if (highLighted == 3) {
			// System.out.println("in keypress " + getDirection());
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				setDirection(Direction.UP);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				setDirection(Direction.DOWN);
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				setDirection(Direction.LEFT);
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				setDirection(Direction.RIGHT);
			}
		}
	}

}
