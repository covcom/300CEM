package com.example.jianhuayang.mytests;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jianhuayang on 10/11/2016.
 */
public class DeadlineTest {
    @Test
    public void calculate() throws Exception {
        Deadline deadline = new Deadline("12/12/16");
        assertEquals(deadline.calculate(), 1);
    }

}
