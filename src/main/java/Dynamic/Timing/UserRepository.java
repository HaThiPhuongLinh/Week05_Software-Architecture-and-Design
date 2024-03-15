package Dynamic.Timing;

import java.util.concurrent.CompletableFuture;

public abstract class UserRepository {
    public CompletableFuture<User> saveUser(String firstName, String lastName, String phoneNumber) {
        User user = new User();
        // We need to wait saveUserTask completeion.
        // If we do not, then saveUserTask may not be completed
        // before we attempt to load user. This may cause
        // undefined behavior or exception.
        CompletableFuture<Integer> saveUserFuture = saveUserAsync(user);
        // User must be saved before we attempt to load.
        return saveUserFuture.thenCompose(savedUserId -> loadUserAsync(savedUserId));
    }

    public abstract CompletableFuture<Integer> saveUserAsync(User user);

    public abstract CompletableFuture<User> loadUserAsync(int id);
}