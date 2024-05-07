package com.ilp03.utility;

import java.util.Scanner;

import com.ilp03.dao.EpicDAO;
import com.ilp03.dao.ProjectDAO;
import com.ilp03.dao.SprintDAO;
import com.ilp03.dao.UserStoryDAO;
import com.ilp03.service.SprintToolService;

public class SprintToolUtility {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		char goToMenu;
		do {
			System.out.println("---------------Melinda's Sprint Planning Tool---------------\n");
			System.out.println("1. New Project \n2. Add Epic \n3. Add User Story \n4. View Projects "
					+ "\n5. View User Stories \n6. Add Sprint\n7. Add User Story to Sprint\n"
					+ "8. View User Stories in a particular Sprint ");

			System.out.println("\nEnter menu choice: ");
			int menuChoice = scanner.nextInt();
			switch (menuChoice) {
			case 1:
				ProjectDAO.addProject();
				break;
			case 2:
				EpicDAO.addEpic();
				break;
			case 3:
				UserStoryDAO.addUserStory();
				break;
			case 4:
				SprintToolService.displayProjects();
				break;
			case 5:
				SprintToolService.displayUserStories();
				break;
			case 6:
				SprintDAO.addSprint();
				break;
			case 7:
				SprintToolService.addStoryToSprint();
				break;
			case 8:
				SprintToolService.viewUserStoriesInSprint();
				break;
			}
			System.out.println("\nGo back to menu? (y/n)");
			goToMenu = scanner.next().charAt(0);
		} while (goToMenu == 'y');

	}

}
