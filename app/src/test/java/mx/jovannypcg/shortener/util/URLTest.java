package mx.jovannypcg.shortener.util;

import junit.framework.Assert;

import org.junit.Test;

public class URLTest {
    @Test
    public void isValidShouldNotMatchEmptyString() {
        String invalidURL = "";

        boolean isValid = URL.isValid(invalidURL);
        Assert.assertFalse(isValid);
    }

    @Test
    public void isValidShouldMatchSmallURL() {
        String validURL = "http://www.vogella.com/tutorials/JavaRegularExpressions/article.html";

        boolean isValid = URL.isValid(validURL);
        Assert.assertTrue(isValid);
    }

    @Test
    public void isValidSholdNotMatch() {
        String invalidURL = "htt://example.com/file[/].html";

        boolean isValid = URL.isValid(invalidURL);
        Assert.assertFalse(isValid);
    }

    @Test
    public void isValidShouldMatchLargeURL() {
        String validURL = "https://www.google.com.mx/search?q=regex+valid+url&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjl1IGXn4nUAhWDYyYKHdaQAFsQ_AUICygC&biw=1920&bih=956#imgrc=fcIw5U5ybBJuRM:";

        boolean isValid = URL.isValid(validURL);
        Assert.assertTrue(isValid);
    }
}
