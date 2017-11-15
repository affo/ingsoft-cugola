package functional.streams.common;

/**
 * Created by affo on 11/11/17.
 */
public final class Person {
    private static int progressive = 0;

    public final int id;
    public final int age;
    public final String name;
    public final Sex sex;
    public final Nation nationality;

    public Person(int age, String name, Sex sex, Nation nationality) {
        this.id = progressive;
        this.age = age;
        this.name = name;
        this.sex = sex;
        this.nationality = nationality;

        progressive++;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", nationality=" + nationality +
                '}';
    }
}
