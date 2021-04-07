package test;

import org.junit.Test;
import org.junit.Assert.*;
import org.junit.*;
import fraction.FractionImpl;



public class FractionImplTest {

    @Test
    public void add() {
        String[][] testaddArray  = {{"2/1", "1/1", "1/1"},
                                    {"1/2", "1/4", "1/4"},
                                    {"79/180", "11/20", "9/-81"},
                                    {"-1/4", "-50/75", "5/12"},
                                    {"69/1", "45/1", "24/1"},
                                    {"-23/25", "-45/125", "-14/25"},
                                    {"1", "0/1", "1"},
                                    {"-5/2", "-3", "1/2"},
                                    {"0", "0", "0"},
                                    {"7/25", "8/25", "-1/25"}


        };
        for (String[] testadd: testaddArray) {
            Assert.assertEquals(new FractionImpl(testadd[0]), new FractionImpl(testadd[1]).add(new FractionImpl(testadd[2])));
        }
        System.out.println("All 10 test passed");
    }

    @Test
    public void subtract() {
        String[][] testaddArray  = {{"2/1", "1/1", "1/1"},
                                    {"1/2", "1/4", "1/4"},
                                    {"79/180", "11/20", "9/-81"},
                                    {"-1/4", "-50/75", "5/12"},
                                    {"69/1", "45/1", "24/1"},
                                    {"-23/25", "-45/125", "-14/25"},
                                    {"1", "0/1", "1"},
                                    {"-5/2", "-3", "1/2"},
                                    {"0", "0", "0"},
                                    {"7/25", "8/25", "-1/25"}


        };
        for (String[] testadd: testaddArray) {
            Assert.assertEquals(new FractionImpl(testadd[0]), new FractionImpl(testadd[1]).add(new FractionImpl(testadd[2])));
        }
        System.out.println("All 10 test passed");
    }
    }

    @Test
    public void multiply() {
    }

    @Test
    public void divide() {
    }

    @Test
    public void abs() {
    }

    @Test
    public void negate() {
    }

    @Test
    public void testHashCode() {
    }

    @Test
    public void testEquals() {
    }

    @Test
    public void testClone() {
    }

    @Test
    public void inverse() {
    }

    @Test
    public void compareTo() {
    }

    @Test
    public void testToString() {
    }

    @Test
    public void main() {
    }
}