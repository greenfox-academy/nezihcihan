package greenfoxorg;

public class Student extends Person {

    String previousOrganization;
    int skippedDays;

    public Student(String name, int age, String gender,String previousOrganization) {
        super(name,age,gender);
        this.previousOrganization = previousOrganization;
        this.skippedDays = 0;
    }
    public Student() {
        this.previousOrganization = "The school of Life";
        this.skippedDays = 0;
    }
    public void getGoal() {
        System.out.println("My goal is: Be a junior software developer.");
    }

    public void introduce() {
        System.out.println("Hi, I'm " + name + " ,a " + age +  " year old " +  gender
                + " from " +  previousOrganization  + " who skipped "  + skippedDays +
                " days from the course already.");
    }
    public void skipDays(int numberOfDays) {  this.skippedDays += numberOfDays;
    }
}
