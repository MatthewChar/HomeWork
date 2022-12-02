public class MyMain {

	public static void main(String[] args) {

		// TASK 1: CREATE A CANVAS FOR ANIMATION
		Canvas canvas = new Canvas();
		canvas.requestFocus();
		
		//TASK 2:  ADD A USER GAME OBJECT
		Type_D_GameObject objectD = new Type_D_GameObject(200, 200);
		
		Type_C_GameObject objectC = new Type_C_GameObject(100, 100);
		
		Type_A_GameObject objectA = new Type_A_GameObject(150, 300);
		
		Type_B_GameObject objectB = new Type_B_GameObject(200, 200);
		
		
		objectA.setVelocity(10);
		objectC.setVelocity(10);
		objectD.setVelocity(10);
		objectB.setVelocity(10);
		canvas.addKeyListener(objectB);
		canvas.addGameObject(objectB);
		canvas.addKeyListener(objectA);
		canvas.addGameObject(objectA);
		canvas.addKeyListener(objectC);
		canvas.addGameObject(objectC);
		canvas.addKeyListener(objectD);
		canvas.addGameObject(objectD);

	}

}

