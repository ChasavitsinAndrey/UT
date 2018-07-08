package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetMessageTest {


    @DataProvider(name = "msg")
    public static Object[][] msg() {
        return new Object[][]{

                {"a+b<=c", new Triangle(3, 3, 6)},
                {"a+b<=c", new Triangle(3, 2, 6)},

                {"b+c<=a", new Triangle(6, 3, 3)},
                {"b+c<=a", new Triangle(6, 2, 3)},

                {"a+c<=b", new Triangle(3, 6, 3)},
                {"a+c<=b", new Triangle(3, 6, 2)},

                {"a<=0", new Triangle(-3,4, 5)},
                {"a<=0", new Triangle(0,4, 5)},

                {"b<=0", new Triangle(3, -4,5)},
                {"b<=0", new Triangle(3, 0,5)},

                {"c<=0", new Triangle(3, 4, -5)},
                {"c<=0", new Triangle(3, 4, 0)},

                {"a<=0 b<=0", new Triangle(0, 0, 5)},
                {"a<=0 b<=0", new Triangle(-1, -1, 5)},
                {"a<=0 b<=0", new Triangle(0, -1, 5)},
                {"a<=0 b<=0", new Triangle(-1, 0, 5)},

                {"b<=0 c<=0", new Triangle(5, 0, 0)},
                {"b<=0 c<=0", new Triangle(5, -1, -1)},
                {"b<=0 c<=0", new Triangle(5, 0, -1)},
                {"b<=0 c<=0", new Triangle(5, -1, 0)},

                {"a<=0 c<=0", new Triangle(0, 5, 0)},
                {"a<=0 c<=0", new Triangle(-1, 5, -1)},
                {"a<=0 c<=0", new Triangle(-1, 5, 0)},
                {"a<=0 c<=0", new Triangle(0, 5, -1)},

                {"a<=0 b<=0 c<=0", new Triangle(0, 0, 0)},
                {"a<=0 b<=0 c<=0", new Triangle(-1, -1, -1)},

                {"a<=0 b<=0 c<=0", new Triangle(0, -1, -1)},
                {"a<=0 b<=0 c<=0", new Triangle(-1, 0, -1)},
                {"a<=0 b<=0 c<=0", new Triangle(-1, -1, 0)},

                {"a<=0 b<=0 c<=0", new Triangle(-1, 0, 0)},
                {"a<=0 b<=0 c<=0", new Triangle(0, -1, 0)},
                {"a<=0 b<=0 c<=0", new Triangle(0, 0, -1)},
        };
    }


    @Test
    public void testDefaultMessage()
    {
        Triangle triangle = new Triangle(3.0, 4.0, 6.0);
        triangle.checkTriangle();
        Assert.assertEquals(triangle.getMessage(), "");
    }


    @Test(dataProvider = "msg")
    public void testMessage(String message, Triangle triangle)
    {
        triangle.checkTriangle();
        Assert.assertEquals(triangle.getMessage(), message);
    }
}