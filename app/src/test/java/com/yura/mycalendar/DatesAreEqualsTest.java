package com.yura.mycalendar;

import models.Date;
import org.junit.Assert;
import org.junit.Test;

public class DatesAreEqualsTest {
    @Test
    public void areEquals_test1(){
        Date d1 = new Date(2000,10,5);
        Date d2 = new Date(2000, 10, 6);
        Assert.assertFalse(Date.areEquals(d1,d2));
    }
    @Test
    public void areEquals_test2(){
        Date d1 = new Date(2010,3,4);
        Date d2 = new Date(2010, 3, 4);
        Assert.assertTrue(Date.areEquals(d1,d2));
    }
}
