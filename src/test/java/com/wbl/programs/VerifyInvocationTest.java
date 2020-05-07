package com.wbl.programs;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * This is verify invocation test class.
 */
public class VerifyInvocationTest {

    @Mock
    static List<String> mockedList;

    private static final String THREE_TIMES = "three times";

    @BeforeTest
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * This is verify invocation method.
     */
    @Test
    public static void verifyInvocation() {
        // using mock
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add(THREE_TIMES);
        mockedList.add(THREE_TIMES);
        mockedList.add(THREE_TIMES);

        // following two verifications work exactly the same - times(1) is used
        // by default
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        // exact number of invocations verification
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add(THREE_TIMES);

        // verification using never(). never() is an alias to times(0)
        verify(mockedList, never()).add("never happened");

        // verification using atLeast()/atMost()

        verify(mockedList, atLeastOnce()).add(THREE_TIMES);
        verify(mockedList, atLeast(2)).add(THREE_TIMES);

    }
}
