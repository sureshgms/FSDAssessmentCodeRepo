package com.simplilearn.assessment.oopswithJava;

import java.io.IOException;
import java.util.Scanner;

public class UserMenu {

	public static void main(String[] args) throws InvalidOptionException {

		Scanner mainSelection = new Scanner(System.in);
		int selectedOption = 0;
		Util utility = new Util();
		
		while (selectedOption != 3) {
			utility.clear();
			System.out.flush();  

			System.out.println("\t\t******************Smart Locker Application******************");
			System.out.println("\t\t*                                      Developer: Suresh K *");
			System.out.println("\t\t*                                      Date:   27-Apr-2022 *");
			System.out.println("\t\t************************************************************");
			System.out.println("\n");
			System.out.println("Select the options from below List...\n");
			System.out.println("1. Print all files in ascending order\n");
			System.out.println("2. File Operations\n");
			System.out.println("3. Close\n");

			try {
				selectedOption = mainSelection.nextInt();

				if (selectedOption < 1 || selectedOption > 3) {
					throw new InvalidOptionException(selectedOption);

				}
			} catch (InvalidOptionException e) {
				System.out.println("Invalid Option Selected...Press Enter to select again");
				mainSelection.nextLine();
				mainSelection.nextLine();

			}
			
			switch (selectedOption) {
			case 1:
				PrintAllFiles printAllFiles = new PrintAllFiles(); 
				System.out.println("Option 1 selected");
				System.out.println("\nEnter Folder name Or Press enter for home Folder: \n");
				Scanner folderName = new Scanner(System.in);
				String folderNameSelected = folderName.nextLine();
				
				if(folderNameSelected == null) {
					
					folderNameSelected = "/01-Java-Assessment/resouces";
				}
			
				printAllFiles.showAllfiles(folderNameSelected);
				System.out.println("\nPress enter to continue...");
				mainSelection.nextLine();
				mainSelection.nextLine();
				break;
				
			case 2:
				System.out.println("\nEnter Folder name Or Press enter for home Folder: \n");
				Scanner folderName1 = new Scanner(System.in);
				String folderNameSelected1 = folderName1.nextLine();
				
				if(folderNameSelected1 == null) {
					
					folderNameSelected1 = "/01-Java-Assessment/resouces";
				}
				FileOperations fileio = new FileOperations(folderNameSelected1);
				fileio.fileOp();
				
			case 3:
				System.out.println("Quitting Application...");
			}

		}
	}
	
	
}
