package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DetectTriangleTest {

    @DataProvider(name = "detectTriangle")
    public static Object[][] detectTriangle() {
        return new Object[][]{

                {8, new Triangle(5.0, 4.0, 3.0)},
                {8, new Triangle(4.0, 5.0, 3.0)},
                {8, new Triangle(3.0, 4.0, 5.0)},

                {1, new Triangle(5.0, 5.0, 5.0)},

                {2, new Triangle(5.0, 5.0, 2.0)},
                {2, new Triangle(5.0, 2.0, 5.0)},
                {2, new Triangle(2.0, 5.0, 5.0)},

                {4, new Triangle(6.0, 4.0, 5.0)},
        };
    }

    @DataProvider(name = "detectTriangleException")
    public static Object[][] detectTriangleException() {
        return new Object[][]{

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

    @Test(dataProvider = "detectTriangle")
    public void testDetectTriangle(int final_state, Triangle triangle)
    {
        Assert.assertEquals(triangle.detectTriangle(), final_state);
    }

    @Test(expectedExceptions = Exception.class, dataProvider = "detectTriangleException")
    public void testDetectTriangleException(Triangle triangle)
    {
        triangle.detectTriangle();
    }

}
