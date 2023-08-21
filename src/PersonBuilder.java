public class PersonBuilder{
    private String name;
    private String surname;
    private int age;
    private String city;
    public PersonBuilder setName(String name) {
        if(!name.matches("[a-zA-Z�-��-�]+")) {
            throw new IllegalArgumentException("��� ����� �������� ������ �� ���� ���������� �������� ��� ���������");
        }
        this.name = name;
        return this;
    }
    public  PersonBuilder setSurname(String surname) {
        if(!surname.matches("[a-zA-Z�-��-�]+")) {
            throw new IllegalArgumentException("������� ����� �������� ������ �� ���� ���������� �������� ��� ���������");
        }
        this.surname = surname;
        return this;
    }
    public PersonBuilder setAge(int age) {
        if (age<0) {
            throw new IllegalArgumentException("������� �� ����� ���� < 0");
        }
        if (age > 116) {
            throw new IllegalArgumentException("��� �������, ��� �� �� ������ ���� ������ ���������� ������ ���������� (116 ��� � 54 ���)");
        }
        this.age = age;
        return this;
    }
    public PersonBuilder setAddress(String city) {
        if(!surname.matches("[a-zA-Z�-��-�]+")) {
            throw new IllegalArgumentException("����� ����� �������� ������ �� ���� ���������� �������� ��� ���������");
        }
        this.city = city;
        return this;
    }
    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalStateException("�� �� ������� �������/���");
        }
        return new Person(name, surname, age, city);
    }
}
