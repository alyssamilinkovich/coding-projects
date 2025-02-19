package FinalProject;

import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.io.*;

public class IMS {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		ProductInformation[] products = new ProductInformation[1000];
		boolean userAddition = true;
		final String STOP = "999";
		final int PRODUCT_ADD_NUMBER = 1000;
		int productCount = 0;
		String inputFile = "ExistingProducts.txt";
		String outputFile = "ProductObjects.txt";

		FileChannel fc = FileChannel.open(Paths.get(outputFile), StandardOpenOption.CREATE, StandardOpenOption.WRITE);

		try {

			while (userAddition) {
				for (int i = productCount; i < PRODUCT_ADD_NUMBER; i++) {
					System.out.println("Please enter your product name or 999 to quit: ");
					String productName = scanner.nextLine();
					if (productName.equals(STOP)) {
						userAddition = false;
						break;
					}
					System.out.println("Please enter your product number: ");
					int productNumber = scanner.nextInt();
					System.out.println("Please enter your product quantity: ");
					int quantity = scanner.nextInt();
					System.out.println("Please enter your products price: ");
					float price = scanner.nextFloat();
					scanner.nextLine();

					products[i] = new ProductInformation(productName, productNumber, quantity, price);
					productCount++;
				}

				System.out.println(
						"Would you like these sorted by 1.Product Name, 2. Product Number, or 3. Product Price: ");
				int sortChoice = scanner.nextInt();
				scanner.nextLine();

				switch (sortChoice) {
				case 1:
					sortByProductName(products, productCount, outputFile, fc, inputFile);
					break;
				case 2:
					sortByProductNumber(products, productCount, outputFile, fc, inputFile);
					break;
				case 3:
					sortByPrice(products, productCount, outputFile, fc, inputFile);
					break;
				default:
					System.out.println("This is not a valid entry.");
				}
			}
		} finally {
			scanner.close();
		}
	}

	public static void sortByProductName(ProductInformation[] products, int productCount, String outputFile,
			FileChannel fc, String inputFile) {
		try {

			for (int i = 0; i < productCount - 1; i++) {
				for (int j = 0; j < productCount - i - 1; j++) {
					if (products[j].getProductName().compareTo(products[j + 1].getProductName()) > 0) {
						ProductInformation temp = products[j];
						products[j] = products[j + 1];
						products[j + 1] = temp;
					}
				}
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
			for (int i = 0; i < productCount; i++) {
				String outputString = "Product Name: " + products[i].getProductName() + ", Product Number: "
						+ products[i].getProductNumber() + ", Quantity: " + products[i].getQuantity() + ", Price: "
						+ products[i].getPrice() + "\n";
				writer.write(outputString);
			}

			try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
				String line;
				while ((line = reader.readLine()) != null) {
					writer.write(line);
					writer.newLine();
				}
			}
			writer.close();

			System.out.println("Sorted product information has been written to " + outputFile);

		} catch (IOException e) {
			System.out.println("Issue: " + e.getMessage());
		} finally {
			try {
				if (fc != null) {
					fc.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void sortByProductNumber(ProductInformation[] products, int productCount, String outputFile,
			FileChannel fc, String inputFile) {
		try {

			for (int i = 0; i < productCount - 1; i++) {
				for (int j = 0; j < productCount - i - 1; j++) {
					if (products[j].getProductNumber() > products[j + 1].getProductNumber()) {
						ProductInformation temp = products[j];
						products[j] = products[j + 1];
						products[j + 1] = temp;
					}
				}
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
			for (int i = 0; i < productCount; i++) {
				String outputString = "Product Name: " + products[i].getProductName() + ", Product Number: "
						+ products[i].getProductNumber() + ", Quantity: " + products[i].getQuantity() + ", Price: "
						+ products[i].getPrice() + "\n";
				writer.write(outputString);
			}

			try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
				String line;
				while ((line = reader.readLine()) != null) {
					writer.write(line);
					writer.newLine();
				}
			}
			writer.close();

			System.out.println("Sorted product information has been written to " + outputFile);

		} catch (IOException e) {
			System.out.println("Issue: " + e.getMessage());
		} finally {
			try {
				if (fc != null) {
					fc.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void sortByPrice(ProductInformation[] products, int productCount, String outputFile, FileChannel fc,
			String inputFile) {
		try {

			for (int i = 0; i < productCount - 1; i++) {
				for (int j = 0; j < productCount - i - 1; j++) {
					if (products[j].getPrice() > products[j + 1].getPrice()) {
						ProductInformation temp = products[j];
						products[j] = products[j + 1];
						products[j + 1] = temp;
					}
				}
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
			for (int i = 0; i < productCount; i++) {
				String outputString = "Product Name: " + products[i].getProductName() + ", Product Number: "
						+ products[i].getProductNumber() + ", Quantity: " + products[i].getQuantity() + ", Price: "
						+ products[i].getPrice() + "\n";
				writer.write(outputString);
			}

			try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
				String line;
				while ((line = reader.readLine()) != null) {
					writer.write(line);
					writer.newLine();
				}
			}
			writer.close();

			System.out.println("Sorted product information has been written to " + outputFile);

		} catch (IOException e) {
			System.out.println("Issue: " + e.getMessage());
		} finally {
			try {
				if (fc != null) {
					fc.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
