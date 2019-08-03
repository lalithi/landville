import java.util.Scanner;

class LandVIlleMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int rows = 0;
		int columns = 0;
		int option = 0;
		int houseRows = 0;
		int houseColumns = 0;
		boolean programmeEnd = false;

		//Task D
		
		//Requesting and validating user inputs to create the land
		System.out.println("Enter row number of the land:");
		rows = sc.nextInt();
		while (rows <= 0 || rows > 10) {
			System.out.println("Row should be greater than 0 and less than or equal to 10");
			System.out.println("Enter row number of the land:");
			rows = sc.nextInt();
		}

		System.out.println("Enter column number of the land:");
		columns = sc.nextInt();
		while (columns < 1 || columns > 10) {
			System.out.println("Column should be greater than 0 and less than or equal to 10");
			System.out.println("Enter column number of the land:");
			columns = sc.nextInt();
		}

		//Creating a land as a landVille object
		LandVille landVille = new LandVille(rows, columns);

		//Task E
		while (!programmeEnd) {

			do {
				System.out.println("Choose from the menu: 1. Build a house, 2. Display land 3. Clear the land 4. Quit");
				option = sc.nextInt();
			} while (option < 0 || option > 4);

			switch (option) {
			
			//Build House
			case 1:
				//Checking whether a house exists in the land
				if (landVille.hasHouse) {
					System.out.println("House already exists!");

				} else {
					//Requesting and validating user inputs to create the house
					System.out.println("Enter row of the house:");
					houseRows = sc.nextInt();

					if (houseRows < 1 || houseRows > rows - 2) {
						System.out.println(
								"Invalid input. Row of house should be greater than 0 and less than or equal to "
										+ (rows - 2) + ". No house is built.");
						break;
					}

					System.out.println("Enter column of the house:");
					houseColumns = sc.nextInt();

					if (houseColumns < 1 || houseColumns > columns - 2) {
						System.out.println(
								"Invalid input. Column of house should be greater than 0 and less than or equal to "
										+ (columns - 2) + ". No house is built.");
						break;
					}

					//Building a house by calling buildHouse method with user given inputs
					landVille.buildHouse(houseRows, houseColumns);
					landVille.displayLand();

				}
				break;

				//Display land
			case 2:
				landVille.displayLand();
				break;

				//Clear the land and then display
			case 3:
				landVille.clearLand();
				landVille.displayLand();
				break;

				//Quit
			case 4:
				programmeEnd = true;
				System.out.println("Program ends.");
				break;

			default:
				System.out.println("Wrong option");
			}
		}
	}

}

public class LandVille {

	int[][] land;
	boolean hasHouse;

	//Task A
	public LandVille(int rows, int columns) {
		//Creating the land
		land = new int[rows][columns];
		hasHouse = false;

		//Setting an empty land
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				land[i][j] = 0;
	}

	//Task B
	public void displayLand() {
		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[i].length; j++)
				System.out.print(land[i][j] + " ");
			System.out.println();
		}
	}

	
	//Task C
	public boolean clearLand() {
		for (int i = 0; i < land.length; i++)
			for (int j = 0; j < land[i].length; j++)
				land[i][j] = 0;

		hasHouse = false;
		return hasHouse;
	}

	//Task F
	public boolean buildHouse(int houseRows, int houseColumns) {
		//Setting the row fences
		for (int i = 0; i < (houseColumns + 2); i++) {
			land[0][i] = 1;
			land[houseRows + 1][i] = 1;
		}

		//Setting the column fences
		for (int i = 1; i < (houseRows + 2); i++) {
			land[i][0] = 1;
			land[i][houseColumns + 1] = 1;
		}

		//Building the house
		for (int i = 1; i < (houseRows + 1); i++)
			for (int j = 1; j < (houseColumns + 1); j++)
				land[i][j] = 8;

		hasHouse = true;
		return hasHouse;
	}
}
