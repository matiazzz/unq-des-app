package model;

import model.plannings.WithFriends;
import model.users.Invitation;
import model.users.User;
import org.joda.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class InvitationTest {

    @Test
    public void shouldAccept(){
        User mockedUser = mock(User.class);
        WithFriends mockedPlan = mock(WithFriends.class);
        Invitation invitation = new Invitation(mockedUser, mockedPlan);
        invitation.accept(mockedUser);
        assertTrue(invitation.isAccepted());
        assertEquals(mockedUser, invitation.getOwner());
        assertEquals(LocalDate.now(), invitation.getDate());
        verify(mockedPlan).addUser(mockedUser);
        verify(mockedUser).addPlanning(mockedPlan);
    }

}
