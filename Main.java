import java.sql.*;
import java.util.Scanner;

public class Main {
	
	//Display method
	static void display(Statement statement) {
		try {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM products");

			while (resultSet.next()) {
				System.out.print(resultSet.getInt("ProductID") + "\t");
				System.out.print(resultSet.getString("Name") + "\t");
				System.out.print(resultSet.getDouble("Price") + "\t");
				System.out.println(resultSet.getDouble("Sales") + "\t");
			}
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		Connection connection = null;
		Statement statement = null;
		
		// Setting up connection to the DB
		String url = "jdbc:mariadb://localhost:3306/project";
		String username = "root";
		String password = "";

		try {

			connection = DriverManager.getConnection(url, username, password);
			statement = connection.createStatement();

			while (true) {
				System.out.println("Choose an option:");
				System.out.println("1) Insert a new product");
				System.out.println("2) Display all the products");
				System.out.println("3) change prices");
				System.out.println("4) Exit");
				System.out.print("Choose an operation:");

				int option = input.nextInt();

				switch (option) {
				// Inserting a new product
				case 1:
					boolean Y = true;
					while (Y) {
						System.out.println("Inserting a new product:");
						System.out.print("ProductID:");
						int productID = input.nextInt();
						System.out.print("product name:");
						String name = input.next();
						System.out.print("Price:");
						double price = input.nextDouble();
						System.out.print("sales:");
						double sales = input.nextDouble();

						String sql = "INSERT INTO products VALUES(" + productID + ",'" + name + "'," + price + "," + sales + ")";
						statement.executeUpdate(sql);

						System.out.println("Insert another record (Y/N)?:");
						String temp = input.next();
						if (!(temp.equals("Y")))
							Y = false;
					}
					break;

				// Displaying all the products
				case 2:
					display(statement);
					break;

				// Change prices
				case 3:

					System.out.print("Enter the sales goal:");
					double salesGoal = input.nextDouble();

					// Displaying the BEFORE prices
					System.out.println("Prices (before) change:");
					display(statement);

					// Changing the price; if Sales >= Goal then increase price by 5% else decrease it by 10%.
					String sql = "UPDATE products SET price = CASE WHEN sales >= " + salesGoal + " THEN price * 1.05 WHEN sales < " + salesGoal + " THEN price * 0.9 END;";
					statement.executeUpdate(sql);

					// Displaying the AFTER prices
					System.out.println("Prices (after) change:");
					display(statement);

					break;

				// Exit
				case 4:
					System.out.println("Thank you, Exiting...");
					statement.close();
					connection.close();
					System.exit(0);
					break;

				// Invalid input
				default:
					System.out.println("Invalid input please try again");
					break;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
