import java.util.Objects;

public class Student implements Comparable<Student>{
    String fio;
    int age;
    String group;
    FavoriteSubject favoriteSubject;

    public Student(String fio, int age, String group, FavoriteSubject favoriteSubject) {
        this.fio = fio;
        this.age = age;
        this.group = group;
        this.favoriteSubject = favoriteSubject;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fio='" + fio + '\'' +
                ", age=" + age +
                ", group='" + group + '\'' +
                ", favoriteSubject=" + favoriteSubject +
                '}';
    }

    @Override
    public int compareTo(Student o) {

        return fio.compareTo(o.fio) + age - o.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(fio, student.fio) && Objects.equals(group, student.group) && favoriteSubject == student.favoriteSubject;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio, age, group, favoriteSubject);
    }
}
