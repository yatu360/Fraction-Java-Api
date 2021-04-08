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
        String[][] testsubArray  = {{"0", "1/1", "1/1"},
                                    {"-1/4", "1/4", "1/2"},
                                    {"119/180", "11/20", "9/-81"},
                                    {"-13/12", "-50/75", "5/12"},
                                    {"21/1", "45/1", "24/1"},
                                    {"1/5", "-45/125", "-14/25"},
                                    {"-1", "0/1", "1"},
                                    {"-7/2", "-3", "1/2"},
                                    {"0", "0", "0"},
                                   {"-100", "-50", "50"}


        };
        for (String[] testsub: testsubArray) {
            Assert.assertEquals(new FractionImpl(testsub[0]), new FractionImpl(testsub[1]).subtract(new FractionImpl(testsub[2])));
        }
        System.out.println("All 10 test passed");
    }


    @Test
    public void multiply() {
        String[][] testmulArray  = {
                {"1", "1/1", "1/1"},
                {"-1/8", "1/4", "-1/2"},
                {"0", "0/1", "1"},
                {"3/2", "-3", "-1/2"},
                {"0", "0", "0"},



        };
        for (String[] test: testmulArray) {
            Assert.assertEquals(new FractionImpl(test[0]), new FractionImpl(test[1]).multiply(new FractionImpl(test[2])));
        }
        System.out.println("All 5 test passed");


    }

    @Test
    public void divide() {
        String[][] testmulArray  = {
                {"1", "1/1", "1/1"},
                {"-1/2", "1/4", "-1/2"},
                {"0", "0/1", "1"},
                {"6", "-3", "-1/2"},
                {"2109/5", "111/1", "5/19"},



        };
        for (String[] test: testmulArray) {
            Assert.assertEquals(new FractionImpl(test[0]), new FractionImpl(test[1]).divide(new FractionImpl(test[2])));
        }
        System.out.println("All 5 test passed");


    }


    @Test
    public void abs() {
            String[][] testmulArray = {
                    {"1", "-1/1"},
                    {"1/4", "1/-4"},
                    {"2", "-2/1"},
                    {"1/2", "-1/2"},
                    {"111/1", "-111/1" },


            };
            for (String[] test : testmulArray) {
                Assert.assertEquals(new FractionImpl(test[0]), new FractionImpl(test[1]).abs());
            }
            System.out.println("All 5 test passed");

        }

            @Test
    public void negate() {
                String[][] testmulArray = {
                        {"1", "-1/1"},
                        {"-1/4", "1/4"},
                        {"2", "2/-1"},
                        {"-1/2", "1/2"},
                        {"111/1", "-111/1" },


                };
                for (String[] test : testmulArray) {
                    Assert.assertEquals(new FractionImpl(test[0]), new FractionImpl(test[1]).negate());
                }
                System.out.println("All 5 test passed");

            }

    @Test
    public void testHashCode() {
        Assert.assertEquals((new FractionImpl("-1")).hashCode(), (new FractionImpl("-1/1")).hashCode());
        Assert.assertEquals((new FractionImpl("1")).hashCode(), (new FractionImpl("1/1")).hashCode());
        System.out.println("All tests passed");
    }

    @Test
    public void testEquals() {
        String[][] testEqArray = {
                {"1/1", "1/1"},
                {"1/4", "-1/2"},
                {"0/1", "0"},
                {"-3", "-1/2"},
                { "0", "0"},
                };

        Boolean [] test1 = {true, false, true, false, true};
        int i = 0;
        for (String[] test : testEqArray) {
            Assert.assertEquals(test1[i], new FractionImpl(test[0]).equals(new FractionImpl(test[1])));
            i++;

        }
        System.out.println("All 5 test passed");

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