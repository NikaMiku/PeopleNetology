import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.OptionalInt;

public class PersonBuilder{
    private String name;
    private String surname;
    private OptionalInt age;
    private String city;
    public PersonBuilder setName(String name) {
        if(!name.matches("[a-zA-Zа-яА-Я]+")) {
            throw new IllegalArgumentException("Имя может состоять только из букв Латинского алфавита или Кириллицы");
        }
        this.name = name;
        return this;
    }
    public  PersonBuilder setSurname(String surname) {
        if(!surname.matches("[a-zA-Zа-яА-Я]+")) {
            throw new IllegalArgumentException("Фамилия может состоять только из букв Латинского алфавита или Кириллицы");
        }
        this.surname = surname;
        return this;
    }
    public PersonBuilder setAge(int age) {
        if (OptionalInt.of(age).isPresent()) {
            if (OptionalInt.of(age).getAsInt()<0) {
                throw new IllegalArgumentException("Возраст не может быть < 0");
            }
        }
        if (OptionalInt.of(age).isPresent()) {
            if (OptionalInt.of(age).getAsInt() > 116) {
                throw new IllegalArgumentException("Мне кажется, что вы не можете быть старше Дзироэмона Кимуры прожившего (116 лет и 54 дня)");
            }
        }
        this.age = OptionalInt.of(age);
        return this;
    }
    public PersonBuilder setAddress(String city) {
        if(!surname.matches("[a-zA-Zа-яА-Я]+")) {
            throw new IllegalArgumentException("Город может состоять только из букв Латинского алфавита или Кириллицы");
        }
        this.city = city;
        return this;
    }
    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalStateException("Вы не указали Фамилию/Имя");
        }
        return new Person(name, surname, age, city);
    }
}
