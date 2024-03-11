package examples.greeting;

public class UserGreeting {
    private UserProfiles profiles;

    public UserGreeting(UserProfiles userProfiles) {
        this.profiles = userProfiles;
    }

    public String formatGreeting(UserId id) {
        return String.format("Hello and Welcome, %s",profiles.fetchNicknameFor(id));
    }
}
