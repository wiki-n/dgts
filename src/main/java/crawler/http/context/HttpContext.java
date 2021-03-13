package crawler.http.context;

import java.io.IOException;

import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.springframework.stereotype.Service;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.providers.netty.NettyAsyncHttpProvider;
import com.ning.http.client.providers.netty.NettyAsyncHttpProviderConfig;

@Service
public class HttpContext {
	private int connectionTimeout = 3;
	private int socketTimeout = 3;
	private int defaultMaxConnectionPerHost = 10;
	private int maxTotalConnection = 100;
	protected AsyncHttpClient asyncHttpClient;
	private HttpUtil httpUtil;

	public HttpContext() {
		try {
			init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void init() throws IOException {
		// set parameter
		HttpConnectionManagerParams hmcp = new HttpConnectionManagerParams();
		hmcp.setSoTimeout(socketTimeout * 1000);
		hmcp.setConnectionTimeout(connectionTimeout * 1000);
		hmcp.setDefaultMaxConnectionsPerHost(defaultMaxConnectionPerHost);
		hmcp.setMaxTotalConnections(maxTotalConnection);
		// create http client pool
		MultiThreadedHttpConnectionManager multiCm = new MultiThreadedHttpConnectionManager();
		multiCm.setParams(hmcp);
		NettyAsyncHttpProviderConfig nettyConfig = new NettyAsyncHttpProviderConfig();
		AsyncHttpClientConfig.Builder builder = new AsyncHttpClientConfig.Builder();
		builder.setMaxRequestRetry(0);
		builder.setAsyncHttpClientProviderConfig(nettyConfig);
		builder.setConnectTimeout(connectionTimeout * 1000);
		builder.setRequestTimeout(connectionTimeout * 1000);
		builder.setReadTimeout(connectionTimeout * 1000);
		builder.setWebSocketTimeout(socketTimeout * 1000);
		builder.setPooledConnectionIdleTimeout(connectionTimeout * 1000);
		asyncHttpClient = new AsyncHttpClient(new NettyAsyncHttpProvider(builder.build()), builder.build());
		httpUtil = new AsyncHttpClientHttpUtil(asyncHttpClient);
	}

	public HttpUtil getHttpUtil() {
		return httpUtil;
	}

	public void setHttpUtil(HttpUtil httpUtil) {
		this.httpUtil = httpUtil;
	}

	public static final String CONTENT_JSON = "application/json";
	public static final String CONTENT_TYPE = "Content-Type";

	public int getConnectionTimeout() {
		return connectionTimeout;
	}

	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	public int getSocketTimeout() {
		return socketTimeout;
	}

	public void setSocketTimeout(int socketTimeout) {
		this.socketTimeout = socketTimeout;
	}

	public int getDefaultMaxConnectionPerHost() {
		return defaultMaxConnectionPerHost;
	}

	public void setDefaultMaxConnectionPerHost(int defaultMaxConnectionPerHost) {
		this.defaultMaxConnectionPerHost = defaultMaxConnectionPerHost;
	}

	public int getMaxTotalConnection() {
		return maxTotalConnection;
	}

	public void setMaxTotalConnection(int maxTotalConnection) {
		this.maxTotalConnection = maxTotalConnection;
	}
}
