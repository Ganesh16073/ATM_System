package ATMControler;

import java.util.Scanner;
import com.ATMModel.*;
import com.atmInterface.*;
import com.Database.*;

public class ATMApp {
	
	public static void main(String[] args)  {
		
			Scanner sc=new Scanner(System.in);
			
			System.out.println("------------------- Welcome To XYZ ATM -------------------");
			System.out.println("To Sign in => 'true' or  Register New User => 'false'");
			try
			{
				boolean start=sc.nextBoolean();
				if(start)
				{
						System.out.println();
						long num;
						try
						{
							System.out.println("Enter the Account number");
							num=sc.nextLong();
						}
						catch (Exception e) {
							System.out.println("Something Went Wrong");
							e.printStackTrace();
							System.out.println("Enter the Account number Correctly");
							num=sc.nextLong();
						}
						
						System.out.println();
						int pinn;
						try
						{
							System.out.println("Enter the Pin 4 Digit only");
							pinn=sc.nextInt();
							int count=0;
							int temp=pinn;
							while(temp!=0)
							{
								count++;
								temp/=10;
							}
							if(count!=4)
							{
								count=0;
								System.out.println("enter 4 Digit pin");
								pinn=sc.nextInt();
								temp=pinn;
							}
							
							while(count==4)
							{
								while(temp!=0)
								{
									count++;
									temp/=10;
								}
								if(count!=4)
								{
									count=0;
									System.out.println("enter 4 Digit pin");
									pinn=sc.nextInt();
									temp=pinn;
								}
							}
						}
						catch (Exception e) {
							System.out.println("Something Went Wrong");
							e.printStackTrace();
							System.out.println("Enter the Pin 4 Digit only");
							pinn=sc.nextInt();
							int count=0;
							int temp=pinn;
							while(temp!=0)
							{
								count++;
								temp/=10;
							}
							if(count!=4)
							{
								count=0;
								System.out.println("enter 4 Digit pin");
								pinn=sc.nextInt();
								temp=pinn;
							}
							
							while(count==4)
							{
								while(temp!=0)
								{
									count++;
									temp/=10;
								}
								if(count!=4)
								{
									count=0;
									System.out.println("enter 4 Digit pin");
									pinn=sc.nextInt();
									temp=pinn;
								}
							}
						}
						
						
						LoginUser lu=new LoginUser();
						lu.setAccountNumber(num);
						lu.setPin(pinn);
					
						LoginInterface lif=new LoginRepo();
						boolean login=lif.checkValidUser(lu);
					if(login)
					{
						AccountsData ad=lif.getValidUserData();		
						int choice;
						do {
						 System.out.println("Select A Option");
						 System.out.println("1: Check Account Balence");
						 System.out.println("2: Withdraw Money");
						 System.out.println("3: Deposit Money");
						 System.out.println("4: Show All Details");
						 choice=sc.nextInt();
						 
						 ATMMethods inf=new ATMMethodInf(); // implementing dynamic polymorphism
						 switch(choice)
						 {
						 	case 1:
						 		System.out.println();
						 		System.out.println("Your Current Balence is =>> "+inf.checkBalence(ad));
						 		System.out.println();
						 		System.out.println("------------------ Thank you for visiting ------------------");
						 		break;
						 	
						 	case 2:
						 		System.out.println();
						 		System.out.println("Enter the WithDraw Amount");
						 		double withdrawAmount=sc.nextDouble();
						 		if(withdrawAmount<0)
						 		{
						 			System.out.println();
						 			System.out.println("Special Symbol or Character not allowed");
						 			System.out.println();
						 			System.out.println("------------------ Thank you for visiting ------------------");
						 			break;
						 		}
						 		else
						 		{
						 			if(inf.withDrawMoney(ad, withdrawAmount)==-1)
							 		{
							 			System.out.println();
							 			System.out.println("Account Balence is InSuffiicent to withdraw Amount");
							 			System.out.println();
								 		System.out.println("------------------ Thank you for visiting ------------------");
								 		break;
							 		}
							 		else
							 		{
							 			System.out.println();
							 			System.out.println("Collect The Cash..........");
								 		System.out.println("Updatd Account balence is =>> "+inf.checkBalence(ad));
								 		System.out.println();
								 		System.out.println("------------------ Thank you for visiting ------------------");
							 		}
							 		
						 			
						 		}
						 		
						 		break;
						 		
						 	case 3:
						 		System.out.println();
						 		System.out.println("Enter the Ammount to Add");
						 		double initadd=sc.nextDouble();
						 		if(initadd<0)
						 		{
						 			System.out.println("Negative value CanNot be added");
						 			System.out.println();
						 			System.out.println("--------------- ThankYou Visit Again ---------------");
						 			break;
						 		}
						 		else
						 		{
						 			inf.DeposityMoney(ad, initadd);		
							 		System.out.println();
							 		System.out.println("Amount is Deposited into Your Account SuccessFul......");
							 		System.out.println("Updatd Account balence is =>> "+inf.checkBalence(ad));
							 		
							 		System.out.println();
							 		System.out.println("------------------ Thank you for visiting ------------------");
						 		}
						 		
						 		break;
						 		
						 	case 4:
						 		inf.showDetails(ad);
						 		System.out.println();
						 		System.out.println("------------------ Thank you for visiting ------------------");
						 		break;
						 		
						 	default:
						 			System.out.println("Invalid Choice.................. Try Again");
						 	}
						 System.out.println("Enter -1 to exit");
						}while(choice!=-1);
						 
						
					}
					else
					{
						System.out.println("Pin or account number do not match ..............");
						System.out.println("------------------ Thank you for visiting -------------------");
					}
				
				}
				else if(!start)
				{
//					long newAccountNumber=0; // autoIncrement
					String newName;
					double newBalence;
					int newPin;
					int newConfirmPin;
					long newMobileNumber;
					String newAccountType;
					long newAdharNumber;
					String newPanNumber;
					
					System.out.println("--------------------- Enter the data to Register ---------------------");
					System.out.println();
					System.out.println("Enter the User Name As=>> Per Adhar Card");
					sc.nextLine();
					newName=sc.nextLine();
					
					System.out.println("Enter the first Amount to Deposit");
					newBalence=sc.nextDouble();
					
					System.out.println("Enter the pin (Four Digit)");
					newPin=sc.nextInt();
					
					System.out.println("Enter the Same Pin to Confirm");
					newConfirmPin=sc.nextInt();
					
					int setFinalPin=-1;
					if(newConfirmPin==newPin)
					{
						setFinalPin=newPin;
					}
					else
					{
						System.out.println("Both Pin Do Not Match \nThis Is the Last time to Set Pin If Not Application Will End");
						System.out.println("Enter the pin (Four Digit)");
						newPin=sc.nextInt();
						System.out.println("Enter the Same Pin to Confirm");
						newConfirmPin=sc.nextInt();
						if(newConfirmPin==newPin)
						{
							setFinalPin=newPin;
						}
						else
						{
							System.exit(0);
						}
					}
					
					System.out.println("Enter the Mobile Nummber");
					newMobileNumber=sc.nextLong();
					
					sc.nextLine();
					System.out.println("Enter the Accout Type Manualy");
					System.out.println("=> Saving Account");
					System.out.println("=> Current Account");
					System.out.println("=> Salary Account");
					newAccountType=sc.nextLine();
					System.out.println("Enter the Adhar Number");
					newAdharNumber=sc.nextLong();
					sc.nextLine();
					System.out.println("Enter the Pan Number");
					newPanNumber=sc.nextLine();
					sc.close();
					
					RegisterUser ru=new RegisterUser();
					ru.setName(newName);
					ru.setAccountType(newAccountType);
					ru.setBalence(newBalence);
					ru.setPin(setFinalPin);
					ru.setMobileNumber(newMobileNumber);
					ru.setAccountType(newAccountType);
					ru.setAdharNumber(newAdharNumber);
					ru.setPanNumber(newPanNumber);
					 
					RegisterInterface ri=new RegisterRepo();
					ri.RegisterUserDB(ru);
					
				}
				else
				{
					System.out.println("SomeThing Went Wrong");
				}
		 
			}
			catch (Exception e) {
				System.out.println("Error found --------->");
				e.printStackTrace();
			}
			
			
	
	}

}
