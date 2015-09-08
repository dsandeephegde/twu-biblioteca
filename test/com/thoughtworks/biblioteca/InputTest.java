package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class InputTest {

    @Test
    public void shouldGetStringInput() {
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        Input input = new Input(scanner);
        assertEquals("1", input.getInput());
        System.setIn(System.in);
    }
}