package performance;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;
import java.net.UnknownHostException;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class UrlTestHelper {
	
	/**
	 * @param url The url to be tested. Ex: https://www.yahoo.com
	 * @return An object of type UrlTestResults with the test results
	 * @throws Exception if invalid 
	 * @throws UnknownHostException if domain is invalid
	 * @throws IOException if any I/O operation fails
	 */
	public UrlTestResults test(URL url) throws UnknownHostException, IOException {
		UrlTestResults urlTestResults = new UrlTestResults(url.toString());

		//TODO: Perform network tests to fill all urlTestResults attributes: lookupTime, connectionTime...

		return urlTestResults;
	}
}
