import java.util.ArrayList;

class CollisionCourse {
	static class Car {
		int x;
		int y;
		int speed;

		Car() {
			this.x = 0;
			this.y = 0;
			this.speed = 0;
		}

		Car(int x, int y, int speed) {
			this.x = x;
			this.y = y;
			this.speed = speed;
		}
	}

	public static void main(String[] args) {
		ArrayList<Car> cars = new ArrayList<>();
		cars.add(new Car(5, 12, 1));
		cars.add(new Car(16, 63, 5));
		cars.add(new Car(-10, 24, 2));
		cars.add(new Car(7, 24, 2));
		cars.add(new Car(-24, 7, 2));

		ArrayList<Integer> times = new ArrayList<>();
		for (Car c : cars) {
			int distance = (int) Math.sqrt(c.x*c.x + c.y*c.y);
			times.add(distance/c.speed);
			System.out.println(distance/c.speed);
		}
	}
}