package student;
/**
 *
 * @author David A-T
 * 
 */
public class Student {
    // Data Members
    private String name;
    private String gender;
    private String email;
    private Course course1, course2, course3;
    
    // Default Constructor
    public Student(){
        this.name = null;
        this.gender = null;
        this.email = null;
        this.course1 = new Course();
        this.course2 = new Course();
        this.course3 = new Course();
    }
    
    // Constructor with name, gender and email
    public Student(String name, String gender, String email){
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.course1 = new Course();
        this.course2 = new Course();
        this.course3 = new Course();
    }
    
    // Constructor with all six data members
    public Student(String name, String gender, String email, Course course1, 
            Course course2, Course course3){
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.course1 = course1;
        this.course2 = course2;
        this.course3 = course3;
    }
    
    // Copy Constructor
    public Student(Student student){
        this.name = student.name;
        this.gender = student.gender;
        this.email = student.email;
        this.course1 = student.course1;
        this.course2 = student.course2;
        this.course3 = student.course3;
    }
    
    /**
     * To check how many courses a student has passed
     * @return the number of courses passed
     */
    public int calcPassedCourseNum(){
        int score = 0;
        
        score += course1.isPassed() ? 1 : 0;
        score += course2.isPassed() ? 1 : 0;
        score += course3.isPassed() ? 1 : 0;
        
        return score;
    }
    
    /**
     * To calculate the total amount of credit garnered
     * @return the total amount of credits
     */
    public double calcTotalCredit(){
        double credit = 0;
        
        credit += course1.isPassed() ? course1.getCredit() : 0;
        credit += course2.isPassed() ? course2.getCredit() : 0;
        credit += course3.isPassed() ? course3.getCredit() : 0;
        
        return credit;
    }
    
    /**
     * To check if the email format is valid
     * @return true or false based on if the email format is valid or not
     */
    public boolean isEmailValid(){
        int count = 0;
        int limit = 4;
        for (int i = 0; i < email.length(); i++){
            count += email.charAt(i) == '.' ? 1 : 0;
            
            if (count == limit)
                return false;
        }
        
        limit = 320;
        if (email.length() > limit){
            return false;
        }
        
        if (email.indexOf("@") == email.lastIndexOf("@") &&
                email.contains("@") && email.contains(".") &&
                email.indexOf("@") < email.lastIndexOf(".") &&
                email.indexOf("@") != 0 &&
                email.indexOf("@") + 1 != email.lastIndexOf(".") &&
                email.lastIndexOf(".") != email.length() - 1){
            if (email.indexOf(".") != email.lastIndexOf(".")){
                if (email.indexOf(".") != 0 &&
                        email.indexOf(".") + 1 != email.indexOf("@"))
                    return true;
            }
            else 
                return true;
                
        }
        
        return false;
    }
    
    /**
     * To check if a student object is identical to another
     * @param student the student to be checked
     * @return true or false based on if the student is identical to another or not
     */
    public boolean equals(Student student) {
        return this.name.contains(student.name) &&
                this.gender.contains(student.gender) &&
                this.email.contains(student.email) && 
                this.course1 == student.course1 &&
                this.course2 == student.course2 &&
                this.course3 == student.course3;
    }
    
    /**
     * To print the object in String form
     * @return the String form of the object
     */
    @Override
    public String toString() {
        String str = "";
        
        str += String.format("%-20s: %s\n", "Name", name);
        str += String.format("%-20s: %s\n", "Gender", gender);
        str += String.format("%-20s: %s\n\n", "Email", email);
        
        str += String.format("%-20s %-30s %-10s %s\n", "Course", "Name", "Credit", "Score");
        str += "---------------------------------------------------------------\n";
        str += String.format("%-20s %-30s: %-10.1f %.1f\n", "Course 1", 
                course1.getCourseName(), course1.getCredit(), course1.calcFinalScore());
        str += String.format("%-20s %-30s: %-10.1f %.1f\n", "Course 2", 
                course2.getCourseName(), course2.getCredit(), course3.calcFinalScore());
        str += String.format("%-20s %-30s: %-10.1f %.1f\n", "Course 3", 
                course3.getCourseName(), course3.getCredit(), course3.calcFinalScore());
        str += String.format("%-20s: %d\n", "Passed Courses", calcPassedCourseNum());
        str += String.format("%-20s: %.1f\n", "Passed Courses", calcTotalCredit());
        
        return str;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Course getCourse1() {
        return course1;
    }

    public void setCourse1(Course course1) {
        this.course1 = course1;
    }

    public Course getCourse2() {
        return course2;
    }

    public void setCourse2(Course course2) {
        this.course2 = course2;
    }

    public Course getCourse3() {
        return course3;
    }

    public void setCourse3(Course course3) {
        this.course3 = course3;
    }
}
