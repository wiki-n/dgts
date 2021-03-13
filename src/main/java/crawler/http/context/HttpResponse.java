package crawler.http.context;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class HttpResponse {

  public static final HttpResponse NULL = new HttpResponse(-1,
      Collections.<String, List<String>>emptyMap(), null);

  private final int status;
  private final Map<String, List<String>> headers;
  private final byte[] body;

  public HttpResponse(int status, Map<String, List<String>> headers, byte[] body) {
    this.status = status;
    this.headers = headers;
    this.body = body;
  }

  public int getStatus() {
    return status;
  }

  public Map<String, List<String>> getHeaders() {
    return headers;
  }

  public byte[] getBody() {
    return body;
  }

  public boolean isOk() {
    return status / 100 == 2;
  }

  @Override
  public String toString() {
    return String.format("HttpResponse[status=%s, headers=%s, body=%s]", status, headers,
        Arrays.toString(body));
  }
}
