import java.util.OptionalInt;
import java.util.Random;

public class Person {

    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String city;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.empty();
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }
    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
        this.city = city;
    }

    public boolean hasAge() {
        return age.isPresent();
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
        return age;
    }
    public String getAddress() {
        return city;
    }

    public void setAddress(String address) {
        city = address;
    }
    public void happyBirthday() {
        if(hasAge()) {
            this.age = OptionalInt.of(this.age.getAsInt() + 1);
        }
    }
    public int RandomChildAge() {
        Random random = new Random();
        return random.nextInt((this.age.getAsInt() - 18) + 1);
    }
    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAddress(this.city)
                .setAge(RandomChildAge());
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
        result = 31 * result + age.getAsInt();
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
