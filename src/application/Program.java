package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String productName = sc.nextLine();
			System.out.print("Price: ");
			double productPrice = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Customs fee: ");
				double productCustomsFee = sc.nextDouble();
				list.add(new ImportedProduct(productName, productPrice, productCustomsFee));
			} else if (ch == 'u') {
				System.out.print("Manufacture date (DD/MM/YY): ");
				Date productManufactureDate = sdf.parse(sc.next());
				list.add(new UsedProduct(productName, productPrice, productManufactureDate));
			} else {
				list.add(new Product(productName, productPrice));
			}
		}
		sc.close();
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product prod : list) {
			System.out.println(prod.priceTag());
		}
	}

}
