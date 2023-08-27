import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("����")
                .setSurname("�����")
                .setAge(31)
                .setAddress("������")
                .build();
        Person son = mom.newChildBuilder()
                .setName("�������")
                .build();
        System.out.println("� " + mom + " ���� ���, " + son);
        try {
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        try {
            new PersonBuilder().setAge(-1).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        try {
            new PersonBuilder().setAge(120).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}