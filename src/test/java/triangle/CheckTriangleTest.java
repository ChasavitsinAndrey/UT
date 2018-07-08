package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckTriangleTest {

    @DataProvider(name = "PositiveTriangle")
    public static Object[][] PositiveTriangle()
    {
        return new Object[][]{
                {new Triangle(3, 3, 3)},
                {new Triangle(3, 4, 5)},
                {new Triangle(2, 2, 3)}
        };
    }

    @DataProvider(name = "NegativeTriangle")
    public static Object[][] NegativeTriangle()
    {
        return new Object[][]{
                {new Triangle(0, 2, 3)},
                {new Triangle(2, 0, 3)},
                {new Triangle(3, 2, 0)},

                {new Triangle(-3, 4, 5)},
                {new Triangle(4, -3, 5)},
                {new Triangle(4, 5, -3)},

                {new Triangle(3, 2, 6)},
                {new Triangle(3, 6, 2)},
                {new Triangle(6, 3, 2)},

                {new Triangle(3, 3, 6)},
                {new Triangle(3, 6, 3)},
                {new Triangle(6, 3, 3)},
        };
    }

    @Test(dataProvider = "PositiveTriangle")
    public void testPositiveTriangle(Triangle triangle) //testCheckTrianglePositive
    {
        Assert.assertTrue(triangle.checkTriangle());
    }


    @Test(dataProvider = "NegativeTriangle") //testCheckTrianglePositive
    public void testNegativeTriangle(Triangle triangle)
    {
        Assert.assertFalse(triangle.checkTriangle());
    }


}