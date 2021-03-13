package crawler.http.context;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.commons.httpclient.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.collect.Multimap;
import com.google.common.net.HttpHeaders;
import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClient.BoundRequestBuilder;
import com.ning.http.client.RequestBuilder;
import com.ning.http.client.Response;

public class AsyncHttpClientHttpUtil implements HttpUtil {
	private static final Logger logger = LoggerFactory.getLogger(AsyncHttpClientHttpUtil.class);

	private final AsyncHttpClient asyncHttpClient;

	private static final int TIMES_TO_RETRY = 3;

	public AsyncHttpClientHttpUtil(AsyncHttpClient asyncHttpClient) {
		this.asyncHttpClient = asyncHttpClient;
	}

	@Override
	public HttpResponse get(String url, Map<String, String> headers, Map<String, String> queries) throws IOException {
		RequestBuilder requestBuilder = buildGetRequest(url, headers, queries);

		try {
			int retry = 0;
			Response response = null;
			while (retry < TIMES_TO_RETRY) {
				retry++;
				response = asyncHttpClient.executeRequest(requestBuilder.build()).get(180, TimeUnit.SECONDS);

				if (response.getStatusCode() == 302) {
					response = asyncHttpClient.prepareGet(response.getHeader(HttpHeaders.LOCATION)).execute().get();
				}

				// Server error
				if (response.getStatusCode() >= HttpStatus.SC_INTERNAL_SERVER_ERROR) {
					logger.warn("Get: {} return STATUS: {}, retry: {}", url, response.getStatusCode(), retry);
					continue;
				} else
					break;
			}

			if (response == null)
				return HttpResponse.NULL;

			return new HttpResponse(response.getStatusCode(), response.getHeaders(), response.getResponseBodyAsBytes());
		} catch (InterruptedException e) {
			logger.warn("Get ERROR", e);
			Thread.currentThread().interrupt();
			return HttpResponse.NULL;
		} catch (ExecutionException e) {
			logger.warn("Get ERROR", e);
			return HttpResponse.NULL;
		} catch (Exception e) {
			logger.warn("Get ERROR", e);
			return HttpResponse.NULL;
		}
	}

	@Override
	public void get(String url, Map<String, String> headers, Map<String, String> queries,
			final HttpOperationListener httpOperationListener) {
		RequestBuilder requestBuilder = buildGetRequest(url, headers, queries);

		try {
			asyncHttpClient.executeRequest(requestBuilder.build(), new AsyncCompletionHandler<Void>() {
				@Override
				public void onThrowable(Throwable t) {
					httpOperationListener.onThrowable(t);
				}

				@Override
				public Void onCompleted(Response response) throws Exception {
					httpOperationListener.onResponse(new HttpResponse(response.getStatusCode(), response.getHeaders(),
							response.getResponseBodyAsBytes()));
					return null;
				}
			});
		} catch (Exception e) {
			httpOperationListener.onThrowable(e);
		}
	}

	private RequestBuilder buildGetRequest(String url, Map<String, String> headers, Map<String, String> queries) {
		RequestBuilder requestBuilder = new RequestBuilder();
		requestBuilder.setUrl(url);

		if (headers != null)
			for (Entry<String, String> header : headers.entrySet())
				requestBuilder.setHeader(header.getKey(), header.getValue());

		if (queries != null)
			for (Entry<String, String> query : queries.entrySet())
				requestBuilder.addQueryParam(query.getKey(), query.getValue());

		return requestBuilder;
	}

	@Override
	public HttpResponse post(String url, Map<String, String> headers, Map<String, String> params) throws IOException {
		RequestBuilder requestBuilder = buildPostRequest(url, headers, params);
		try {
			int retry = 0;
			Response response = null;
			while (retry < TIMES_TO_RETRY) {
				retry++;
				response = asyncHttpClient.executeRequest(requestBuilder.build()).get(180, TimeUnit.SECONDS);

				// Server error
				if (response.getStatusCode() >= HttpStatus.SC_INTERNAL_SERVER_ERROR) {
					logger.warn("Post: {} return STATUS: {}, retry: {}", url, response.getStatusCode(), retry);
					continue;
				} else
					break;
			}
			if (response == null)
				return HttpResponse.NULL;

			return new HttpResponse(response.getStatusCode(), response.getHeaders(), response.getResponseBodyAsBytes());
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return null;
		} catch (ExecutionException e) {
			return null;
		} catch (Exception e) {
			logger.warn("Get ERROR", e);
			return HttpResponse.NULL;
		}
	}

	@Override
	public HttpResponse post(String url, Map<String, String> headers, String body) throws IOException {
		// RequestBuilder requestBuilder = buildPostRequest(url, headers, params);
		BoundRequestBuilder requestBuilder = buildPostRequestWithJsonBody(url, headers, body);
		try {
			int retry = 0;
			Response response = null;
			while (retry < TIMES_TO_RETRY) {
				retry++;
				response = asyncHttpClient.executeRequest(requestBuilder.build()).get(180, TimeUnit.SECONDS);

				// Server error
				if (response.getStatusCode() >= HttpStatus.SC_INTERNAL_SERVER_ERROR) {
					logger.warn("Post: {} return STATUS: {}, retry: {}", url, response.getStatusCode(), retry);
					continue;
				} else
					break;
			}

			if (response == null)
				return HttpResponse.NULL;

			return new HttpResponse(response.getStatusCode(), response.getHeaders(), response.getResponseBodyAsBytes());
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return null;
		} catch (ExecutionException e) {
			return null;
		} catch (Exception e) {
			logger.warn("Get ERROR", e);
			return HttpResponse.NULL;
		}
	}

	@Override
	public HttpResponse post(String url, Map<String, String> headers, Multimap<String, String> params)
			throws IOException {
		RequestBuilder requestBuilder = buildPostRequest(url, headers, params);

		try {
			int retry = 0;
			Response response = null;
			while (retry < TIMES_TO_RETRY) {
				retry++;
				response = asyncHttpClient.executeRequest(requestBuilder.build()).get(180, TimeUnit.SECONDS);

				// Server error
				if (response.getStatusCode() >= HttpStatus.SC_INTERNAL_SERVER_ERROR) {
					logger.warn("Post: {} return STATUS: {}, retry: {}", url, response.getStatusCode(), retry);
					continue;
				} else
					break;
			}

			if (response == null)
				return HttpResponse.NULL;

			return new HttpResponse(response.getStatusCode(), response.getHeaders(), response.getResponseBodyAsBytes());
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return null;
		} catch (ExecutionException e) {
			return null;
		} catch (Exception e) {
			logger.warn("Get ERROR", e);
			return HttpResponse.NULL;
		}

	}

	@Override
	public HttpResponse post(String url, Map<String, String> headers, String params, int timeOut) throws IOException {
		RequestBuilder requestBuilder = buildPostRequest(url, headers, params);
		try {
			if (timeOut <= 0)
				timeOut = 30;

			int retry = 0;
			Response response = null;
			while (retry < TIMES_TO_RETRY) {
				retry++;
				response = asyncHttpClient.executeRequest(requestBuilder.build()).get(timeOut, TimeUnit.SECONDS);

				// Server error
				if (response.getStatusCode() >= HttpStatus.SC_INTERNAL_SERVER_ERROR) {
					logger.warn("Post: {} return STATUS: {}, retry: {}", url, response.getStatusCode(), retry);
					continue;
				} else
					break;
			}

			if (response == null)
				return HttpResponse.NULL;

			return new HttpResponse(response.getStatusCode(), response.getHeaders(), response.getResponseBodyAsBytes());
		} catch (InterruptedException e) {
			logger.warn("post InterruptedException", e);
			Thread.currentThread().interrupt();
			return null;
		} catch (ExecutionException e) {
			logger.warn("post ExecutionException", e);
			return null;
		} catch (Exception e) {
			logger.warn("post ERROR", e);
			return HttpResponse.NULL;
		}
	}

	private RequestBuilder buildPostRequest(String url, Map<String, String> headers, String body) {
		RequestBuilder requestBuilder = new RequestBuilder();
		requestBuilder.setUrl(url);
		requestBuilder.setMethod("POST");
		requestBuilder.setBody(body);

		for (Entry<String, String> header : headers.entrySet()) {
			requestBuilder.addHeader(header.getKey(), header.getValue());
		}

		return requestBuilder;
	}

	private RequestBuilder buildPostRequest(String url, Map<String, String> headers, Multimap<String, String> params) {
		RequestBuilder requestBuilder = new RequestBuilder();
		requestBuilder.setUrl(url);
		requestBuilder.setMethod("POST");

		for (Entry<String, Collection<String>> param : params.asMap().entrySet()) {
			for (String item : param.getValue())
				requestBuilder.addFormParam(param.getKey(), item);
		}

		for (Entry<String, String> header : headers.entrySet()) {
			requestBuilder.addHeader(header.getKey(), header.getValue());
		}
		return requestBuilder;
	}

	@Override
	public void post(String url, Map<String, String> headers, Map<String, String> params,
			final HttpOperationListener httpOperationListener) {
		RequestBuilder requestBuilder = buildPostRequest(url, headers, params);
		try {
			asyncHttpClient.executeRequest(requestBuilder.build(), new AsyncCompletionHandler<Void>() {
				@Override
				public void onThrowable(Throwable t) {
					httpOperationListener.onThrowable(t);
				}

				@Override
				public Void onCompleted(Response response) throws Exception {
					httpOperationListener.onResponse(new HttpResponse(response.getStatusCode(), response.getHeaders(),
							response.getResponseBodyAsBytes()));
					return null;
				}
			});
		} catch (Exception e) {
			httpOperationListener.onThrowable(e);
		}
	}

	private BoundRequestBuilder buildPostRequestWithJsonBody(String url, Map<String, String> headers, String jsonBody) {
		BoundRequestBuilder builder = asyncHttpClient.preparePost(url);
		builder.setBody(jsonBody);
		builder.setBodyEncoding("UTF-8");
		for (Entry<String, String> header : headers.entrySet()) {
			builder.addHeader(header.getKey(), header.getValue());
		}
		return builder;
	}

	private RequestBuilder buildPostRequest(String url, Map<String, String> headers, Map<String, String> params) {
		RequestBuilder requestBuilder = new RequestBuilder();
		requestBuilder.setUrl(url);
		requestBuilder.setMethod("POST");

		for (Entry<String, String> param : params.entrySet()) {
			requestBuilder.addFormParam(param.getKey(), param.getValue());
		}

		for (Entry<String, String> header : headers.entrySet()) {
			requestBuilder.addHeader(header.getKey(), header.getValue());
		}
		return requestBuilder;
	}

	@Override
	public UploadHandle upload(String urlStr, File file, Map<String, String> headers,
			final UploadListener uploadListener) {
		Preconditions.checkNotNull(uploadListener, "uploadListener null");

		final AtomicBoolean canceled = new AtomicBoolean();
		UploadHandle uploadHandle = new UploadHandle() {
			@Override
			public void cancel() {
				canceled.set(true);
			}
		};
		final String end = "\r\n";
		final String twoHyphens = "--";
		final String boundary = "*****++++++************++++++++++++";
		DataOutputStream ds = null;
		FileInputStream fStream = null;

		try {
			URL url = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);

			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);

			for (Entry<String, String> header : headers.entrySet()) {
				conn.addRequestProperty(header.getKey(), header.getValue());
			}

			ds = new DataOutputStream(conn.getOutputStream());
			ds.writeBytes(twoHyphens + boundary + end);
			ds.writeBytes("Content-Disposition: form-data; name=\"file\";filename=\"" + file.getName() + "\"" + end);
			ds.writeBytes(end);

			fStream = new FileInputStream(file);
			int bufferSize = 1024;
			byte[] buffer = new byte[bufferSize];
			int length = -1;

			while ((length = fStream.read(buffer)) != -1 && !canceled.get()) {
				ds.write(buffer, 0, length);
			}

			ds.writeBytes(end);
			ds.writeBytes(twoHyphens + boundary + twoHyphens + end);

			int responseCode = conn.getResponseCode();
			InputStream is = conn.getInputStream();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			DataOutputStream outds = new DataOutputStream(out);
			byte[] data = new byte[bufferSize];
			int leng = -1;
			while ((leng = is.read(data)) != -1) {
				outds.write(data, 0, leng);
			}

			uploadListener.completed(
					new HttpResponse(responseCode, Collections.<String, List<String>>emptyMap(), out.toByteArray()));
		} catch (Exception e) {
			uploadListener.exception(e);
			// e.printStackTrace();
		} finally {
			try {
				if (fStream != null)
					fStream.close();

				if (ds != null) {
					ds.flush();
					ds.close();
				}
			} catch (IOException e) {
				logger.error("[upload] - IOException: ", e);
			}
		}

		return uploadHandle;
	}
}
