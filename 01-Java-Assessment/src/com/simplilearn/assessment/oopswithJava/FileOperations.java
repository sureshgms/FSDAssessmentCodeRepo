package com.simplilearn.assessment.oopswithJava;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileOperations {
	int fileOperationsSelected = 0;
	Util utility = new Util();
	String defaultDir;
	String fileName;

	public FileOperations(String defaultDir) {
		super();
		this.defaultDir = defaultDir;
	}

	public void fileOp() {
		Scanner fileOpSelection = new Scanner(System.in);
		int selectedOption = 0;
		while (selectedOption != 4) {

			utility.clear();
			System.out.println("************** Option 2 : File Operations Selected **************");
			System.out.println("Select from below Options...");
			System.out.println("1. Add file to the directory");
			System.out.println("2. Delete file from the directory");
			System.out.println("3. Search for a file in the directory");
			System.out.println("4. Go back to main Menu");
			try {
				selectedOption = fileOpSelection.nextInt();

				if (selectedOption < 1 || selectedOption > 4) {
					throw new InvalidOptionException(selectedOption);

				}
			} catch (InvalidOptionException e) {
				System.out.println("Invalid Option Selected...Press Enter to select again");
				fileOpSelection.nextLine();
				fileOpSelection.nextLine();

			}
			switch (selectedOption) {
			case 1: // Add file to the directory
				addFiles(defaultDir);
				break;

			case 2: // Delete File from directory
				deleteFile(defaultDir);
				break;

			case 3: // Search File
				searchFile(defaultDir);
				break;
			case 4: // Return to main menu
				System.out.println("Going back to main Menu... Press Enter to continue");
				fileOpSelection.nextLine();
				fileOpSelection.nextLine();
				break;
			}

		}
	}

	public void addFiles(String defaultDir) {
		System.out.println("\nEnter File name to be created...");
		Scanner fileNametoCreate = new Scanner(System.in);
		fileName = fileNametoCreate.next();
		fileName = defaultDir + "\\" + fileName;
		System.out.println("Creating file = " + fileName);
		File newFilename = new File(fileName);
		try {
			if (newFilename.createNewFile()) {
				System.out.println("\n File successfully Created");
			} else {
				System.out.println("File Already exists. Provide a different filename");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileNametoCreate.nextLine();
		fileNametoCreate.nextLine();
	}

	public void deleteFile(String defaultDir) {
		System.out.println("Enter File Name to be deleted...");
		Scanner fileNametoDelete = new Scanner(System.in);
		fileName = fileNametoDelete.next();
		fileName = defaultDir + "\\" + fileName;

		File delFile = new File(fileName);
		if (!delFile.exists()) {
			System.out.println("Specified file does not exist. Press Enter to chose the option again");
			fileNametoDelete.nextLine();
			fileNametoDelete.nextLine();

		} else if (delFile.isDirectory()) {
			System.out.println(
					"Specified filename is a Folder. Cannot delete a folder.. Press Enter to chose the option again");
			fileNametoDelete.nextLine();
			fileNametoDelete.nextLine();
			return;
		}

		else {
			System.out.println("Deleting File : " + fileName);
			delFile.delete();
			System.out.println("Successfully Deleted File...Press Enter to continue");
			fileNametoDelete.nextLine();
			fileNametoDelete.nextLine();
			return;
		}
	}

	public void searchFile(String defaultDir) {
		System.out.println("Enter File Name to be Searched...");
		Scanner fileNametoSearch = new Scanner(System.in);
		fileName = fileNametoSearch.next();
		fileName = defaultDir + "\\" + fileName;

		File searchFile = new File(fileName);
		if (searchFile.exists()) {
			System.out.println("\n\n File Found !!!");
			fileNametoSearch.nextLine();
			fileNametoSearch.nextLine();
		} else {
			System.out.println("\n\n File not Found.. Press Enter to Continue");
			fileNametoSearch.nextLine();
			fileNametoSearch.nextLine();
		}
	}

}