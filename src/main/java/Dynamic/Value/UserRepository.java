package Dynamic.Value;

public abstract class UserRepository {
    public int saveOrUpdateUser(User user) {
        // We make an assumption if user.Id property is -1
        // then user is new and needs to be inserted.
        // Otherwise we update existing user.
        if (user.getId() == -1) {
            return insertUser(user);
        } else {
            return updateUser(user);
        }
    }

    public abstract int insertUser(User user);
    public abstract int updateUser(User user);
}