package Dynamic.Value.fix;

public class UserUiController {
    public void saveUserData(User user) throws Exception{
        UserServiceProxy userService = new UserServiceProxy();
        UserServiceResponse response = userService.saveUser(user);

        // 2. Now check for success result is easy
        if (response.isSuccess()) {
            return;
        }

        // 3. Check for the type of error is easy too
        if (response.getErrorCode() == UserServiceResponseCode.DatabaseError) {
            throw new Exception("Can't save user");
        } else {
            throw new Exception("Failed to save user, unknown reason");
        }
    }
}