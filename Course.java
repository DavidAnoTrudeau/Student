package student;
/**
 *
 * @author David A-T
 * 
 */
public class Course {
    // Data Members
    private String courseName;
    private double credit;
    private double examScore;
    private double assignmentScore;
    
    // Default Constructor
    public Course(){
        this.courseName = null;
        this.credit = 0;
        this.examScore = 0;
        this.assignmentScore = 0;
    }
    
    // Constructor with courseName and credit
    public Course(String courseName, double credit){
        this.courseName = courseName;
        this.credit = credit;
        this.examScore = 0;
        this.assignmentScore = 0;
    }
    
    // Constructor with all four data members
    public Course(String courseName, double credit, double examScore, 
            double assignmentScore){
        this.courseName = courseName;
        this.credit = credit;
        this.examScore = examScore;
        this.assignmentScore = assignmentScore;
    }
    
    //Copy Constructor
    public Course(Course course){
        this.courseName = course.courseName;
        this.credit = course.credit;
        this.examScore = course.examScore;
        this.assignmentScore = course.assignmentScore;
    }
    
    /**
     * To calculate the final score (Exam Score = 60% & Assignment Score = 40%)
     * @return the final score based on the exam score and assignment score
     */
    public double calcFinalScore(){
        return ((this.examScore / 100) * 60) + ((this.assignmentScore / 100) * 40);
    }
    
    /**
     * To check if the final score is a passing grade or not
     * @return true or false based on if the final score is a passing grade or not
     */
    public boolean isPassed(){
        if (calcFinalScore() >= 60)
            return true;
        return false;
    }
    
    /**
     * To check if a course object is equals to another
     * @param course
     * @return true or false based on if the objects are identical or not
     */
    public boolean equals(Course course){
        return this.courseName.equals(course.courseName) 
                && this.credit == course.credit 
                && this.examScore == course.examScore 
                && this.assignmentScore == course.assignmentScore;
    }

    /**
     * To turn this object into a String
     * @return the converted object String
     */
    @Override
    public String toString(){
        String str = "";
        
        str += String.format("%-18s: %s\n", "Course Name", courseName);
        str += String.format("%-18s: %.1f\n", "Credit", credit);
        str += String.format("%-18s: %.1f\n", "Exam Score", examScore);
        str += String.format("%-18s: %.1f\n", "Assignment Score", assignmentScore);
        str += String.format("%-18s: %.1f\n", "Final Score", calcFinalScore());
        
        return str;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getExamScore() {
        return examScore;
    }

    public void setExamScore(double examScore) {
        this.examScore = examScore;
    }

    public double getAssignmentScore() {
        return assignmentScore;
    }

    public void setAssignmentScore(double assignmentScore) {
        this.assignmentScore = assignmentScore;
    }
}
