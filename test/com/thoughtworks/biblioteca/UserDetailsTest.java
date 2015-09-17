package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class UserDetailsTest {

    @Test
    public void shouldOutputUserDetails() {
        Session session = mock(Session.class);
        View view = mock(View.class);
        User user = mock(User.class);
        UserDetails userDetails = new UserDetails(session, view);
        when(session.getCurrentUser()).thenReturn(user);

        userDetails.performOperation();

        verify(view).output(user.userDetails());
    }
}