public class Student {

    private int id;
    private String name;
    private int age;
    private String course;
    private String city;

    public Student(int id, String name, int age, String course, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + course + "," + city;
    }
}
