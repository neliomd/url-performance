package performance;

import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"javax.net.ssl.*"})
public class UrlTestHelperTest {

	UrlTestHelper urlTestHelper = new UrlTestHelper();
	
	@Test
	public void testHTTP200() throws Exception {
		URL url = new URL("https://api-dev-01.emcconnected.com/testapi/US/area");
		UrlTestResults results = urlTestHelper.test(url);
		assert(results.getHttpResponseHeaders().startsWith("HTTP/1.1 200") && results.getHttpBodySize()==39);
	}
	
	@Test
	public void testHTTP404() throws Exception {
		URL url = new URL("https://api-dev-01.emcconnected.com/invalid-file");
		UrlTestResults results = urlTestHelper.test(url);
		assert(results.getHttpResponseHeaders().startsWith("HTTP/1.1 404"));
	}

	@Test
	public void testServerAddress() throws Exception {
		URL url = new URL("https://api-qa-01.emcconnected.com/waittests/?wait=1");
		UrlTestResults results = urlTestHelper.test(url);
		assert("50.19.195.96".equals(results.getServerAddress()));
	}
	
	@Test
	public void testHTTPContentType() throws Exception {
		URL url = new URL("https://api-qa-01.emcconnected.com/static/test.txt");
		UrlTestResults results = urlTestHelper.test(url);
		assert(results.getHttpResponseHeaders().contains("text/plain"));
		
	}
	
	@Test
	public void testHTTPContentLength() throws Exception {
		int size = (int)(Math.random()*1000);
		URL url = new URL("https://api-qa-01.emcconnected.com/waittests/?wait=1-"+size+"&responseBodyType=fixed");
		UrlTestResults results = urlTestHelper.test(url);
		assert(results.getHttpBodySize()==size);
		
	}
	
	@Test
	public void testBodyTime() throws Exception {
		int delay = (int)(Math.random()*5) + 1; //1-5 secs
		URL url = new URL("https://api-qa-01.emcconnected.com/waittests/?wait="+delay+"-100&responseBodyType=fixed");
		UrlTestResults results = urlTestHelper.test(url);
		assert(results.getHttpBodyTime()>=delay*1000); //roundtrip is expressed in ms
		
	}
	
	@Test(expected=UnknownHostException.class)
	public void testUnknownHost() throws Exception {
		URL url = new URL("https://invalidUrl.unexisting-host-here.com");
		urlTestHelper.test(url);
	}

	@Test(expected=IOException.class)
	public void testIOException() throws Exception {
		int invalidPort = 8983;
		URL url = new URL("https://api-dev-01.emcconnected.com:"+invalidPort+"/testapi/US/area");
		urlTestHelper.test(url);		
	}
}
