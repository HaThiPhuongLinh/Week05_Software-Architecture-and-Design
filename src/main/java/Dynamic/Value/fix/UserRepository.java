package Dynamic.Value.fix;

public abstract class UserRepository {
    public int saveOrUpdateUser(User user) {
        // 3. Use User.isNew()
        if (user.isNew()) {
            return insertUser(user);
        } else {
            return updateUser(user);
        }
    }

    public abstract int insertUser(User user);
    public abstract int updateUser(User user);
}