package com.wbl.programs;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * This is the linkedlist program test class.
 */
public class LinkedListProgramTest {

    @Mock
    static List<String> mockedList;

    @BeforeTest
    public void init() {
       MockitoAnnotations.initMocks(this);
    }

    /**
     * This is mocked list method.
     */
    @Test
    public static void mockLinkedList() {

        mockedList.add("apple");
        verify(mockedList).add("apple");

        when(mockedList.size()).thenReturn(100);
        Assert.assertEquals(mockedList.size(), 100);
    }
}
