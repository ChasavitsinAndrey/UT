package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetSquareTest {


    @DataProvider(name = "getSquareExceptions")
    public static Object[][] getSquareExceptions() {
        return new Object[][]
                {
                        {new Triangle(0.0, 0.0, 0.0)},
                        {new Triangle(-6.0, -4.0, -5.0)},
                        {new Triangle(-6.0, 4.0, 5.0)},
                        {new Triangle(6.0, -4.0, 5.0)},
                        {new Triangle(6.0, 4.0, -5.0)},
                        {new Triangle(0.0, 4.0, 5.0)},
                        {new Triangle(6.0, 0.0, 5.0)},
                        {new Triangle(6.0, 4.0, 0.0)},

                };
    }

    @DataProvider(name = "getSquarePositive")
    public static Object[][] getSquarePositive()
    {
        return new Object[][]{
                        {1.732, new Triangle(2.0, 2.0, 2.0)},
                };
    }


    @Test(expectedExceptions = Exception.class, dataProvider = "getSquareExceptions")
    public void testGetSquareExceptions(Triangle triangle)
    {
        triangle.getSquare();
    }


    @Test(dataProvider = "getSquarePositive")
    public void testGetSquare(double square, Triangle triangle)
    {
        Assert.assertEquals(triangle.getSquare(), square, 0.01);
    }


}
