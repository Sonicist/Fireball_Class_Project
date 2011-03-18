import java.util.Scanner;

public class UI {

	/**
	 * @param args
	 */
	static Scanner input = new Scanner(System.in);
	static boolean loggedIn = false;
	static Student currentStudent = null;
	static Database tracks = new Database();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Team Fireball's Degree Planner");
		System.out.println("Press Ctrl+c to end.");
		while (true) {
			login();
			while (loggedIn) {
				System.out.print("Student User ID: ");
				currentStudent = findStudent(Integer.parseInt(input.nextLine()));
				System.out.println("Editing " + currentStudent.name);
			}
		}
	}

	private static void login() {
		String advisorPass; // String password changed to advisorPass
		int advisorID;
		System.out.print("Advisor User ID: ");
		advisorID = Integer.parseInt(input.nextLine());
		System.out.print("Advisor Password: ");
		advisorPass = input.nextLine();
		if (Database.advisorDB[advisorID].equals(advisorPass)) {
			loggedIn = true;
		}
	}

	private static void logout() {
		loggedIn = false;
	}

	private static Student findStudent(int studentID) {
		if (tracks.find(studentID) == null)
		{
			System.out.println("Student ID " + studentID + " not found.");
			System.out.print("Create new student profile with ID " + studentID + " (y/n)? ");
			if (input.nextLine().equals("y"))
			{
				System.out.print("Student Name: ");
				tracks.studentDB.add(new Student(studentID, input.nextLine()));
				System.out.println("Success");
			}
		}
		return tracks.find(studentID);
	}
}
