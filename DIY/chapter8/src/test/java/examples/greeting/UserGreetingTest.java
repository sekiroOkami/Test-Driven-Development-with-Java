package examples.greeting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // mark this test as using Mockito
public class UserGreetingTest {

    // drive out SUT
    private static final UserId USER_ID =
            new UserId("1234");
    @Mock
    private UserProfiles profiles;

    @Test
    void formatsGreetingWithName() {
        // confugure @Mock to return the correct stub data for out test
        when(profiles.fetchNicknameFor(any()))
                .thenReturn("Alan");

        var greeting = new UserGreeting(profiles);
        String actual = greeting.formatGreeting(USER_ID);
        assertThat(actual).isEqualTo("Hello and Welcome, Alan");
    }


}
