package FinalProject;

public class StudentInformation {
	
	private String studentName;
    private String assignmentName;
    private float assignmentGrade;
    private float overallGrade;

    public StudentInformation(String studentName, String assignmentName, float assignmentGrade, float overallGrade) {
        this.studentName = studentName;
        this.assignmentName = assignmentName;
        this.assignmentGrade = assignmentGrade;
        this.overallGrade = overallGrade;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public float getAssignmentGrade() {
        return assignmentGrade;
    }

    public float getOverallGrade() {
        return overallGrade;
    }

}
