package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> list = new ArrayList<>();
		System.out.print("Enter number of products:");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported?(c/u/i)");
			char c = sc.next().charAt(0);
			if(c != 'c' && c != 'u' && c != 'i' ) {
				System.out.println("This type of product does not exist!");
				System.exit(0);
			}
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			switch (c) {
			case 'i':
				System.out.print("Custom fee: ");
				double fee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, fee));
				break;
			case 'u':
				System.out.println("Manufacture Date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, date));
				break;
			case 'c':
				list.add(new Product(name, price));
				break;
			
				
			}

		}
		System.out.println("PRICE TAGS:\n");
		for (Product product : list) {
			System.out.println(product);

		}

		sc.close();

	}

}
