import java.util.OptionalInt;

public class Person {

    protected final String name;
    protected final String surname;
    protected int age;
    protected String city;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
    }

    public boolean hasAge() {
        if (getAge() != null) {
            return true;
        } else {
            return false;
        }
    }
    public boolean hasAddress() {
        if(city!=null) {
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public OptionalInt getAge() {
        if(OptionalInt.of(age) != null) {
            return OptionalInt.of(age);
        } else {
            return OptionalInt.empty();
        }

    }
    public String getAddress() {
        return city;
    }

    public void setAddress(String address) {
        city = address;
    }
    public void happyBirthday() {
        if(hasAge()) {
            age++;
        }
    }
    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAddress(this.city)
                .setAge(0);
    }
    @Override
    public String toString() {
        return "Person {" +
                "name = " + name + '\'' +
                " surname = " + surname + '\'' +
                " age = " + age + '\'' +
                " city = " + city + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
