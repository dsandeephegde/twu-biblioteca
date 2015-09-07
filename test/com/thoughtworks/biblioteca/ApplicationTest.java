package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ApplicationTest {

    @Test
    public void shouldCallStartMethod() {
        Application application = mock(Application.class);
        application.start();
        verify(application).start();
    }
}