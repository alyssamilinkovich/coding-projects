package FinalProject;

import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.io.*;

public class GradeBook {
	public static void main(String[] args) throws IOException{
		Scanner scanner = new Scanner(System.in);

		StudentInformation[] student = new StudentInformation[1000];
		boolean userAddition = true;
		final String STOP = "999";
		final int STUDENT_ADD_NUMBER = 1000;
		int studentCount = 0;
		String inputFile = "ExistingStudents.txt";
		String outputFile = "StudentInformation.txt";
		int totalAssignments = 0;
		float totalGrade = 0;

		FileChannel fc = FileChannel.open(Paths.get(outputFile), StandardOpenOption.CREATE, StandardOpenOption.WRITE);

		try {

			while (userAddition) {
				for (int i = studentCount; i < STUDENT_ADD_NUMBER; i++) {
					System.out.println("Please enter your students name or 999 to quit: ");
					String studentName = scanner.nextLine();
					if (studentName.equals(STOP)) {
						userAddition = false;
						break;
					}
					System.out.println("Please enter the assignment name: ");
					String assignmentName = scanner.nextLine();
					System.out.println("Please enter the assignment grade: ");
					float assignmentGrade = scanner.nextFloat();
					totalGrade += assignmentGrade;
					totalAssignments++;
					float overallGrade = totalGrade / totalAssignments;
					scanner.nextLine();

					student[i] = new StudentInformation(studentName, assignmentName, assignmentGrade, overallGrade);
					studentCount++;
				}

				System.out.println("Would you like these sorted by 1.Student Name or  2. Assignment Grade: ");
				int sortChoice = scanner.nextInt();
				scanner.nextLine();

				switch (sortChoice) {
				case 1:
					sortByStudentName(student, studentCount, outputFile, fc, inputFile);
					break;
				case 2:
					sortByAssignmentGrade(student, studentCount, outputFile, fc, inputFile);
					break;
				default:
					System.out.println("This is not a valid entry.");
				}
			}
		} finally {
			scanner.close();
		}
	}

	public static void sortByStudentName(StudentInformation[] student, int studentCount, String outputFile,
			FileChannel fc, String inputFile) {
		try {

			for (int i = 0; i < studentCount - 1; i++) {
				for (int j = 0; j < studentCount - i - 1; j++) {
					if (student[j].getStudentName().compareTo(student[j + 1].getStudentName()) > 0) {
						StudentInformation temp = student[j];
						student[j] = student[j + 1];
						student[j + 1] = temp;
					}
				}
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
			for (int i = 0; i < studentCount; i++) {
				String outputString = "Student Name: " + student[i].getStudentName() + ", Assignment Name: "
						+ student[i].getAssignmentName() + ", Assignment Grade: " + student[i].getAssignmentGrade()
						+ ", Overall Grade: " + student[i].getOverallGrade() + "\n";
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

			System.out.println("Student information has been written to " + outputFile);

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

	public static void sortByAssignmentGrade(StudentInformation[] student, int studentCount, String outputFile,
			FileChannel fc, String inputFile) {
		try {

			for (int i = 0; i < studentCount - 1; i++) {
				for (int j = 0; j < studentCount - i - 1; j++) {
					if (student[j].getAssignmentGrade() > student[j + 1].getAssignmentGrade()) {
						StudentInformation temp = student[j];
						student[j] = student[j + 1];
						student[j + 1] = temp;
					}
				}
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
			for (int i = 0; i < studentCount; i++) {
				String outputString = "Student Name: " + student[i].getStudentName() + ", Assignment Name: "
						+ student[i].getAssignmentName() + ", Assignment Grade: " + student[i].getAssignmentGrade()
						+ ", Overall Grade: " + student[i].getOverallGrade() + "\n";
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

			System.out.println("Student information has been written to " + outputFile);

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
