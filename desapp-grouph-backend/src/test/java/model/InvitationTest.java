package model;

import model.plannings.WithFriends;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class InvitationTest {

    @Test
    public void shouldAccept(){
        User mockedUser = mock(User.class);
        WithFriends mockedPlan = mock(WithFriends.class);
        Invitation invitation = new Invitation(mockedUser, mockedPlan);
        invitation.accept(mockedUser);
        verify(mockedPlan).addUser(mockedUser);
        verify(mockedUser).addPlanning(mockedPlan);
    }

}
