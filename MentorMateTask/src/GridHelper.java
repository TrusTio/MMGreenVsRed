import java.util.Scanner;

public class GridHelper {
	
	/**
	 * Creates a Grid and asks the user for input
	 * @return A grid that starts the game.
	 */
	public static Grid gridGameStarter() {
		Grid grid;
		int widthX, heightY, cellX, cellY, generationN;

		Scanner sc = new Scanner(System.in);
		System.out.println("Grid Width(X): ");
		widthX = sc.nextInt();
		System.out.println("Grid Height(Y): ");
		heightY = sc.nextInt();

		grid = new Grid(widthX, heightY);

		System.out.println("Generation Zero: ");
		grid.enterGenerationZero();

		System.out.println("Cell coordinate X:  ");
		cellX = sc.nextInt();
		System.out.println("Cell coordinate Y:  ");
		cellY = sc.nextInt();
		System.out.println("Generation N:  ");
		generationN = sc.nextInt();

		grid.calculateResult(cellX, cellY, generationN);

		sc.close();
		return grid;
	}

	/**
	 * Decides how to transform the cell.
	 * @param cell A byte representing the cell color.
	 * @param greenNeighbours An int representing the number of green neighbours.
	 * @return A byte representing the resulting cell color.
	 */
	public static byte transformCell(byte cell, int greenNeighbours) {

		if (cell == 0) {
			if (greenNeighbours == 3 || greenNeighbours == 6) {
				return 1;
			} else {
				return 0;
			}
		} else {
			if (greenNeighbours == 2 || greenNeighbours == 3 || greenNeighbours == 6) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	/**
	 *  Counts the amount of green neighbours a cell has.
	 * @param cellX An int representing the X coordinate of the Cell.
	 * @param cellY An int representing the Y coordinate of the Cell.
	 * @param grid A 2 dimensional byte array representing the whole grid.
	 * @return An int representing the amount of green neighbours.
	 */
	public static int countGreenNeighbours(int cellX, int cellY, byte grid[][]) {
		int count = 0;
		// leftTop Cell
		try {
			if (grid[cellX - 1][cellY - 1] == 1)
				count++;
		} catch (Exception e) {

		}
		// left Cell
		try {
			if (grid[cellX - 1][cellY] == 1)
				count++;
		} catch (Exception e) {

		}
		// leftBottom Cell
		try {
			if (grid[cellX - 1][cellY + 1] == 1)
				count++;
		} catch (Exception e) {

		}
		// centerTop Cell
		try {
			if (grid[cellX][cellY - 1] == 1)
				count++;
		} catch (Exception e) {

		}
		// centerBottom Cell
		try {
			if (grid[cellX][cellY + 1] == 1)
				count++;
		} catch (Exception e) {

		}
		// rightTop Cell
		try {
			if (grid[cellX + 1][cellY - 1] == 1)
				count++;
		} catch (Exception e) {

		}
		// right Cell
		try {
			if (grid[cellX + 1][cellY] == 1)
				count++;
		} catch (Exception e) {

		}
		// rightBottom Cell
		try {
			if (grid[cellX + 1][cellY + 1] == 1)
				count++;
		} catch (Exception e) {

		}

		return count;
	}
}
