package Static.Position;

public class UserFactoryFixed {
    public User createUser(String firstName, String lastName, String phoneNumber) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhoneNumber(phoneNumber);
        return user;
    }
}
