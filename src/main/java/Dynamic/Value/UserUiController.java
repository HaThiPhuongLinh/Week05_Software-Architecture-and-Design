package Dynamic.Value;

public class UserUiController {
    public void saveUserData(User user) throws Exception {
        UserServiceProxy userService = new UserServiceProxy();
        String response = userService.saveUser(user);
        
        if (!response.toLowerCase().contains("error")) {
            return;
        }

        if (response.toLowerCase().contains("database")) {
            throw new Exception("Can't save user");
        } else {
            throw new Exception("Failed to save user, unknown reason");
        }
    }
}