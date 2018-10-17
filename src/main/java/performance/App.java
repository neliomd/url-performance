package performance;

import java.net.URL;

public class App 
{
    public static void main( String[] args )
    {
    	try {
            URL url = new URL("https://api-dev-01.emcconnected.com/testapi/US/area");
            UrlTestHelper urlTestHelper = new UrlTestHelper();
            UrlTestResults results = urlTestHelper.test(url);
            System.out.println(results);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}