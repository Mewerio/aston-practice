package classes;

import com.sorting.data;

public class Student implements Identifiable, Comparable<Student> {

    private Integer id;
    private String groupNumber;
    private Double averageScore;
    private Integer studentIdCard;

    private Student(StudentBuilder studentBuilder) {
        this.id = studentBuilder.id;
        this.groupNumber = studentBuilder.groupNumber;
        this.averageScore = studentBuilder.averageScore;
        this.studentIdCard = studentBuilder.studentIdCard;
    }

    public Integer getId(){
        return this.id;
    }

    public String getGroupNumber() {
        return this.groupNumber;
    }

    public Double getAverageScore() {
        return this.averageScore;
    }

    public Integer getStudentIdCard() {
        return this.studentIdCard;
    }

    public static class StudentBuilder {
        private Integer id;
        private String groupNumber;
        private Double averageScore;
        private Integer studentIdCard;

        public StudentBuilder setStudentId(Integer id){
            this.id = id;
            return this;
        }

        public StudentBuilder setGroupNumber(String groupNumber) {
            this.groupNumber = groupNumber;
            return this;
        }

        public StudentBuilder setAverageScore(Double averageScore) {
            this.averageScore = averageScore;
            return this;
        }

        public StudentBuilder setStudentIdCard(Integer studentIdCard) {
            this.studentIdCard = studentIdCard;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    @Override
    public int compareTo(Student o) {
        if(this.groupNumber != null && o.groupNumber != null){
            int compareGroupNumber = this.groupNumber.compareTo(o.groupNumber);
            if (compareGroupNumber != 0) {
                return compareGroupNumber;
            }
        }

        if(this.averageScore != null && o.averageScore != null){
            int compareAverageScore = this.averageScore.compareTo(o.averageScore);
            if (compareAverageScore != 0) {
                return compareAverageScore;
            }
        }

        if(this.studentIdCard != null && o.studentIdCard != null){
            return this.studentIdCard.compareTo(o.studentIdCard);
        }

        return 0;
    }

    @Override
    public String toString() {
        return "Student [" +
                "id='" + id + '\'' +
                "groupNumber='" + groupNumber + '\'' +
                ", averageScore=" + averageScore +
                ", studentIdCard='" + studentIdCard + '\'' +
                ']';
    }
}

