package com.wbl.programs;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;
import static org.mockito.Mockito.verify;

/**
 * This is list program test class.
 */
public class ListProgramTest {

    @Mock
    static List<String> mockedList;

    @BeforeTest
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * This is test list method.
     */
    @Test
    public static void testList() {
        mockedList.add("one");
        mockedList.clear();
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }
}
