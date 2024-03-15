package Static.Position;

public class UserFactory {
    public String[] createUser(String firstName, String lastName, String phoneNumber) {
        // User is represented as an array where
        // each element position has meaning.
        return new String[] {
            firstName,
            lastName,
            phoneNumber
        };
    }
}
