package com.example.maps;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MyTest {

    @Test
    public void test1()  {
        //  create mock
        MyClass test = mock(MyClass.class);

        // define return value for method getUniqueId()
        when(test.getUniqueId()).thenReturn(43);
        int actual = test.getUniqueId();
        int expected = 43;

        // use mock in test....
        assertEquals(actual,expected);
    }
}
