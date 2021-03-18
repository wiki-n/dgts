package crawler.http.context;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.google.common.collect.Multimap;

public interface HttpUtil {

	HttpResponse get(String url, Map<String, String> headers, Map<String, String> queries) throws IOException;

	void get(String url, Map<String, String> headers, Map<String, String> queries,
			HttpOperationListener httpOperationListener);

	HttpResponse post(String url, Map<String, String> headers, String body) throws IOException;

	HttpResponse post(String url, Map<String, String> headers, Map<String, String> params) throws IOException;

	HttpResponse post(String url, Map<String, String> headers, Multimap<String, String> params) throws IOException;

	void post(String url, Map<String, String> headers, Map<String, String> params,
			HttpOperationListener httpOperationListener);

	public HttpResponse post(String url, Map<String, String> headers, String params, int timeOut) throws IOException;

	UploadHandle upload(String url, File file, Map<String, String> headers, UploadListener uploadListener);

	void close();

	interface HttpOperationListener {
		void onThrowable(Throwable throwable);

		void onResponse(HttpResponse httpResponse);
	}

	interface UploadListener {
		void uploaded(long amount, long current, long total);

		void completed(HttpResponse httpResponse);

		void exception(Exception exception);
	}

	interface UploadHandle {
		void cancel();
	}

}
