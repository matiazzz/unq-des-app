package model;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class UserTest {

    @Test
    public void shouldAddAFriend(){
        User user1 = new User();
        User user2 = new User();
        user1.addFriend(user2);

        Assert.assertTrue(user1.getFriends().contains(user2));
    }

    @Test
    public void shouldAcceptAFriend(){
        User user1 = new User();
        User mockedUser = mock(User.class);
        user1.acceptFriend(mockedUser);
        verify(mockedUser).addFriend(user1);
        Assert.assertTrue(user1.getFriends().contains(mockedUser));
    }

}
