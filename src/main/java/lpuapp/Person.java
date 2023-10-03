package lpuapp;

public class Person {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private static int userNameId = 103;

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    protected Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = String.valueOf(userNameId);
        generateUsername(firstName, lastName);
        userNameId++;
    }

    private void generateUsername(String firstName, String lastName) {
        this.userName = firstName.trim().charAt(0) + lastName.trim() + userNameId;
    }
}