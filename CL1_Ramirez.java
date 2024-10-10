import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CL1_Ramirez{

	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);

		int inp = 0;
		int itemNum = 0;
		double price = 0;
		//Mian loop starts
		while(inp == 0){
			//opeing
			String title = "Welcome to Utep Eats!\n------------Menu-------------\nChoose an option(1-5):";
 			String body = "1. Add a food\n2. View cart\n3. Clear cart\n4. Checkout\n5. Exit\n-----------------------------";

			System.out.println(title);
			System.out.println(body);


			int option = scan.nextInt();
			//opening/business
			switch(option){
				case 1:
					//read and print file
					try{
						File menu = new File("food.txt");
						Scanner fscan = new Scanner(menu);


						while(fscan.hasNextLine()){
						String line = fscan.nextLine();
						System.out.println(line);
						}
						//end reading/menu pick
						scan.nextLine();
						fscan = new Scanner(menu);
						System.out.println("Please type what food you want");
						String food = scan.nextLine();
						while(fscan.hasNext()){
							String item = fscan.next();
							if(food.equals(item)){
							 price =price + fscan.nextDouble();
							 itemNum++;
							System.out.println("------------Cart-------------\nNumber of items: " + itemNum + "\nTotal: " + price +"\n-----------------------------");
						}
						// else if(!food.equals(item)){
						// 	System.out.println("Please enter the correct name");
					}
			
					}catch(FileNotFoundException e){
						System.out.println("File Not Found " + e.getMessage());
					}	
					fscan.close(0);	
					//menu switch end
				break;
				//end menu switch and start view cart switch
				case 2:
					System.out.println("------------Cart-------------\nNumber of items: " + itemNum + "\nTotal: " + price +"\n-----------------------------");
				break;
				//end view cart and start clear cart
				case 3:
					System.out.println("Are you sure you want to clear your cart?\n\tType yes or no");
					scan.nextLine();
					String clear = scan.nextLine();
					if(clear.equals("yes")){
						itemNum = 0;
						price = 0;
					System.out.println("Cart cleared");
					}else{
						System.out.println("Cart not changed. Going back to the menu");
					}
				break;
				//end clear cart and start checkout
				case 4:
					String card;
					double total = price * 0.0725;
					total = total + price;
					//initialize card and add tax
					System.out.println("------------Cart-------------\nNumber of items: " + itemNum + "\nTotal: " + total +"\n-----------------------------");
					System.out.println("Would you like to do pickup or delivery?\n\t1. Pickup\t2. Delivery");
					int end = scan.nextInt();
					//end the end option and start switch
					switch(end){
						case 1:
							System.out.println("Order Information:\nNumber of items: " + itemNum + "\nTotal: " + total);
							System.out.println("Please enter your 16 digit card number.");
							scan.nextLine();
							card = scan.nextLine();
							System.out.println(card);
							System.out.println("Success! Thank you for shopping with UTEP Eats");
							System.out.println("------------Reciept-------------\nNumber of items: " + itemNum + "\nTotal: " + total +"\n------------Reciept-------------");
							System.exit(0);
						break;
					case 2:
						total = total + 5;
						String address;
						System.out.println("A 5 dollar fee has be added");
						System.out.println("New total is: " + total);
						System.out.println("Would you like to add a tip?\n\t1. Yes\t2. No");
						//optional tip ask
						int tip = scan.nextInt();
						if(tip == 1){
							System.out.println("Enter the tip percentage");
							float tipNum = scan.nextFloat();
							tipNum = (tipNum / 100)+1;
							total = total * tipNum;
						}
						System.out.println("Please enter  your adress.");
						scan.nextLine();
						address = scan.nextLine();
						System.out.println(address);
						System.out.println("Order Information:\nNumber of items: " + itemNum + "\nTotal: " + total);
						System.out.println("Please enter your 16 digit card number.");
						card = scan.nextLine();
						System.out.println(card);
						System.out.println("Success! Thank you for shopping with UTEP Eats");
						System.out.println("------------Reciept-------------\nNumber of items: " + itemNum + "\nTotal: " + total +"\n------------Reciept-------------");
						System.exit(0);
					break;
					default:
						System.out.println("Please choose an option");
					break;
				}
				break;
				//end checkout and start exit
				case 5:
					System.out.println("Thank you for using Miner Eats. Goodbye!");
				System.exit(0);
				break;
				default:
					System.out.println("Please choose an option");
					break;
			}//main switch ends

		


		}
		//Main loop ends

		
	}// main static void ends
} //class ends





