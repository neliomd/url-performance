package performance;

import java.io.Serializable;

public class UrlTestResults implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	public UrlTestResults(String url) {
		this.url = url; 
	}
	
	private String url;
	private String serverAddress;
	private long dnsLookupTime;
	private long connectionTime;
	private long sslHandshakingTime;
	private long roundtripTime;
	private long httpBodyTime;
	private long httpBodySize;
	private String httpResponseStatus;
	private String httpResponseHeaders;
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public long getDnsLookupTime() {
		return dnsLookupTime;
	}
	public void setDnsLookupTime(long dnsLookupTime) {
		this.dnsLookupTime = dnsLookupTime;
	}
	public long getConnectionTime() {
		return connectionTime;
	}
	public void setConnectionTime(long connectionTime) {
		this.connectionTime = connectionTime;
	}
	public long getSslHandshakingTime() {
		return sslHandshakingTime;
	}
	public void setSslHandshakingTime(long sslHandshakingTime) {
		this.sslHandshakingTime = sslHandshakingTime;
	}
	public String getHttpResponseHeaders() {
		return httpResponseHeaders;
	}
	public void setHttpResponseHeaders(String httpResponseHeaders) {
		this.httpResponseHeaders = httpResponseHeaders;
	}
	public long getRoundtripTime() {
		return roundtripTime;
	}
	public void setRoundtripTime(long roundtripTime) {
		this.roundtripTime = roundtripTime;
	}
	public long getHttpBodyTime() {
		return httpBodyTime;
	}
	public void setHttpBodyTime(long httpBodyTime) {
		this.httpBodyTime = httpBodyTime;
	}
	public long getHttpBodySize() {
		return httpBodySize;
	}
	public void setHttpBodySize(long httpBodySize) {
		this.httpBodySize = httpBodySize;
	}
	
	public String getServerAddress() {
		return serverAddress;
	}
	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}
	public String getHttpResponseStatus() {
		return httpResponseStatus;
	}
	public void setHttpResponseStatus(String httpResponseStatus) {
		this.httpResponseStatus = httpResponseStatus;
	}
	@Override
	public String toString() {
		return String.format("%s\n%s\n%s\ndnsLookupTime: %dms\nconnectionTime: %dms\nsslHandshakingTime: %dms\nroundtripTime: %dms\nhttpBodyTime: %dms\nhttpBodySize: %d bytes", 
				url, httpResponseStatus, httpResponseHeaders, dnsLookupTime, connectionTime, sslHandshakingTime, roundtripTime, httpBodyTime, httpBodySize);
	}
	
	
	
}
