import processing.core.PApplet;
public class CarAnimation extends PApplet {
	public static void main(String[] args) {
		PApplet.main("CarAnimation");
	}
	int screenWidth = 1000;
	int screenHeight = 1000;
	public void setup() {
		background(5, 5, 255, 100);
		size(screenWidth, screenHeight);
	}
	int y = 0;
	//Mountain coordinates:
	int x1 = 0;
	int x2 = screenHeight / 2 - 100;
	int x3 = 300;
	int x4 = screenHeight / 2 - 100;
	int x5 = (x1 + x3) / 2;
	int x6 = x4 - x3;
	int z1 = -20;
	int z2 = -200;
	public void drawBus(int x, int y) {
		fill(250, 245, 0);
		rect(x, y + 10, 90, 40);
		rect(x - 10, y + 30, 10, 20);
		//window:
		fill(255);
		stroke(0);
		rect(x + 10, y + 15, 10, 10);
		//wheels:
		stroke(255);
		fill(0);
		ellipse(x + 70, y + 55, 15, 15);
		ellipse(x + 10, y + 55, 15, 15);
	}
	public void draw() {
		noStroke();
		background(200, 200, 255);
		//Sun
		fill(255, 230, 0);
		ellipse(800, 100, 50, 50);
		//Mountain
		fill(100, 100, 200);
		triangle(x1, x2, x3, x4, x5, x6);
		x1 += 1; x3 += 1; x5 += 1;
		if (x1 >= screenWidth) {
			x1 = -400;
			x3 = 0;
			x5 = (x1 + x3) / 2;
		}
		//Grass
		fill(100, 230, 100);
		rect(0, screenHeight / 2 - 110, screenWidth, screenHeight / 2);
		//Road:
		fill(0);
		rect(0, height / 2 + 45, width, 50);
		if (y >= 30)
			y = -15;
		//Draw dotted line:
		for (int i = y; i < screenWidth; i += 10) {
			fill(255);
			noStroke();
			rect(i, height / 2 + 60, 10, 5);
			i += 10;
		}
		y += 5;
		//Trees (far away):
		for (int i = z1; i < screenWidth; i += 400) {
			drawTree(i, screenHeight / 2 - 100, 20, 40, true);
		}
		z1 += 3;
		if (z1 > 400)
			z1 = 0;
		//School bus:
		drawBus(width / 2, height / 2);
		//Trees (close up):
		drawTree(z2, screenHeight - 350, 400, 550, false);
		z2 += 20;
		if (z2 > screenWidth + 200)
			z2 = -200;
	}
	public void drawTree(int x, int y, float width, float height, boolean closeup) {
		noStroke();
		fill(125, 85, 85);
		rect(x + width / 3, y, width / 3, height / 4);
		if (closeup)
			fill(30, 95, 40);
		else
			fill(20, 150, 0);
		triangle(x, y, x + width, y, x + width / 2, y - height);
	}
}