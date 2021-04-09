package test;


import org.junit.Test;
import org.junit.Assert.*;
import org.junit.*;
import fraction.FractionImpl;



public class FractionImplTest {


    @Test
    public void testMalformedFractions() throws NumberFormatException {
        String [] invalidFractions = {"- 3/ 4", "2/", "/1", "4 4", "-3 4", "4 5/6 7", "1-2", "££", "1.04", "4/(3)"};
        int i = 0;
        while (i<10) {
            try {
                FractionImpl test0 = new FractionImpl(invalidFractions[i]);
                Assert.fail("Test failed, not a malformed fractions");
            } catch (NumberFormatException e) {
                i++;
            }
        }
        System.out.println("All 10 tests passed");
    }


    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        FractionImpl test1= new FractionImpl(1, 0);
    }

    @Test
    public void testValidFractions(){
        Assert.assertEquals(new FractionImpl("1/1"), new FractionImpl(1));
        Assert.assertEquals(new FractionImpl("-3/4"), new FractionImpl(-3, 4));
        Assert.assertEquals(new FractionImpl("2/9"), new FractionImpl(2, 9));
        Assert.assertEquals(new FractionImpl("8/1"), new FractionImpl(8, 1));
        Assert.assertEquals(new FractionImpl("4"), new FractionImpl(4));
        Assert.assertEquals(new FractionImpl("9/-26"), new FractionImpl(9, -26));
        Assert.assertEquals(new FractionImpl("-1"), new FractionImpl(-1));
        Assert.assertEquals(new FractionImpl("0"), new FractionImpl(0));
        Assert.assertEquals(new FractionImpl("42"), new FractionImpl(42));
        Assert.assertEquals(new FractionImpl("1024/2048"), new FractionImpl(1024, 2048));
        System.out.println("All 10 tests passed");
    }

    @Test
    public void testFractionsValidator(){
        Assert.assertEquals(new FractionImpl("1/2"), new FractionImpl(2, 4));
        Assert.assertEquals(new FractionImpl("-5/8"), new FractionImpl(15, -24));
        Assert.assertEquals(new FractionImpl("1/10"), new FractionImpl(10, 100));
        Assert.assertEquals(new FractionImpl("-1/3"), new FractionImpl(-3, 9));
        Assert.assertEquals(new FractionImpl("1/4"), new FractionImpl(5, 20));
        System.out.println("All 5 tests passed");
    }

    @Test
    public void testAdd() {
        String[][] testAddArray  = {{"2/1", "1/1", "1/1"},
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
        for (String[] test: testAddArray) {
            Assert.assertEquals(new FractionImpl(test[0]), new FractionImpl(test[1]).add(new FractionImpl(test[2])));
        }
        System.out.println("All 10 test passed");
    }

    @Test
    public void testSubtract() {
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
    public void testMultiply() {
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
    public void testDivide() {
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
    public void testAbs() {
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
    public void testNegate() {
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
    public void testInverse() {
            String[][] testinvArray = {
                    {"1", "1/1"},
                    {"1/4", "4"},
                    {"5/2", "2/5"},
                    {"-8/3", "3/-8"},
                    {"1/10", "100/10" },
            };
            for (String[] test : testinvArray) {
                Assert.assertEquals(new FractionImpl(test[0]), new FractionImpl(test[1]).inverse());
            }
            System.out.println("All 5 test passed");

    }

    @Test
    public void testCompareTo() {

            Assert.assertEquals(-1, (new FractionImpl("1/2")).compareTo(new FractionImpl(1)));
            Assert.assertEquals(0, (new FractionImpl("10/6")).compareTo(new FractionImpl("5/3")));
            Assert.assertEquals(1, (new FractionImpl(1)).compareTo(new FractionImpl("1/2")));
            System.out.println("All tests passed");
        }

    @Test
    public void testToString() {
        Assert.assertEquals("-1", (new FractionImpl(-1)).toString());
        Assert.assertEquals("0", (new FractionImpl(0)).toString());
        Assert.assertEquals("0", (new FractionImpl(0, 1)).toString());
        Assert.assertEquals("1", (new FractionImpl(1)).toString());
        Assert.assertEquals("-3/2", (new FractionImpl(3, -2)).toString());
        System.out.println("All 5 tests passed");
    }

}