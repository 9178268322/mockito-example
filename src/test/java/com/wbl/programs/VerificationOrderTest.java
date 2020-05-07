package com.wbl.programs;

import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

/**
 * This is verification order test class.
 */
public class VerificationOrderTest {

    @Mock
    static List<String> singleMock;

    @BeforeTest
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * This is verification order method.
     */
    @Test
    public static void verificationOrder() {

        // using a single mock
        singleMock.add("added first");
        singleMock.add("added second");

        // create an inOrder verifier for a single mock
        InOrder inOrder = inOrder(singleMock);

        // following will make sure that add is first called with "was added
        // first", then with "was added second"
        inOrder.verify(singleMock).add("added first");
        inOrder.verify(singleMock).add("added second");

        // B. Multiple mocks that must be used in a particular order
        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        // using mocks
        firstMock.add("called first");
        secondMock.add("called second");

        // create inOrder object passing any mocks that need to be verified in
        // order
        InOrder inOrder1 = inOrder(firstMock, secondMock);

        // following will make sure that firstMock was called before secondMock
        inOrder1.verify(firstMock).add("called first");
        inOrder1.verify(secondMock).add("called second");
    }
}
