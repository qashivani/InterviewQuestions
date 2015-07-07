

import java.util.Scanner;

public class taxPersonMain {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		double initialPrice = -1.0;
		String luxury_Status_Input = "";  
		
		do{
		System.out.println("Please input the price of an item");
		initialPrice = parseCost_Input(scan.nextLine());
		}while(initialPrice == -1.0);
		
		do {
			System.out.println("Please input 'yes' if this is a luxury item, which covers everything not needed for basic survival");
			luxury_Status_Input = scan.nextLine();
		}while(!(luxury_Status_Input.matches("yes") || luxury_Status_Input.matches("no")));
		
		Item itemToPrice = new Item();
		itemToPrice.setIsLuxury(parseLuxury_Status(luxury_Status_Input));
		itemToPrice.setCost(initialPrice);
		
		System.out.println("Item cost is: "  itemToPrice.calculateCostAfterTax());
	}
	
	public static double parseCost_Input(String costInput){
		
		if(costInput.matches("\\d\\.\\d") || costInput.matches("\\d\\.\\d\\d") || costInput.matches("\\d")){
			return Double.parseDouble(costInput);
		}
		return -1.0;
	}
	
	public static Boolean parseLuxury_Status(String isLuxuryInput){
		
		if(isLuxuryInput.matches("yes")){
			return true;
		}
		return false;
	}
}
