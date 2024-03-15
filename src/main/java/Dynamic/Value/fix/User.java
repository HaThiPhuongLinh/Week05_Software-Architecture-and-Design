package Dynamic.Value.fix;

public class User {
    private static final int NEW_USER_ID = -1;
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public User() {
        id = NEW_USER_ID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // 2. Check if user is new
    public boolean isNew() {
        return id == NEW_USER_ID;
    }
}