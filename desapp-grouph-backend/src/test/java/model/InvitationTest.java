package model;

import model.plannings.WithFriends;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertTrue;

public class InvitationTest {

    @Test
    public void shouldAccept(){
        User mockedUser = mock(User.class);
        WithFriends mockedPlan = mock(WithFriends.class);
        Invitation invitation = new Invitation(mockedUser, mockedPlan);
        invitation.accept(mockedUser);
        assertTrue(invitation.isAccepted());
        assertEquals(invitation.getOwner(), mockedUser);
        verify(mockedPlan).addUser(mockedUser);
        verify(mockedUser).addPlanning(mockedPlan);
    }

}
