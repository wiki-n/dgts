package crawler.dgts.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import crawler.dgts.utils.AppConstant;
import lombok.Builder;

/**
 * DCMResponse
 */
@Validated
@Builder
public class DCMResponse {
	@JsonProperty("code")
	private int code;

	@JsonProperty("message")
	private String message = null;

	@JsonProperty("value")
	private String value = null;

	public DCMResponse(int code) {
		this.code = code;
		this.message = AppConstant.ERROR_CODE.getMessage(code);
	}

	public DCMResponse(int code, String message, String value) {
		this.code = code;
		this.value = value;
		this.message = message;
	}

	public DCMResponse(int code, String value) {
		this.code = code;
		this.value = value;
		this.message = AppConstant.ERROR_CODE.getMessage(code);
	}

	/**
	 * Get code
	 * 
	 * @return code
	 **/

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public DCMResponse message(String message) {
		this.message = message;
		return this;
	}

	/**
	 * Get message
	 * 
	 * @return message
	 **/

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		DCMResponse dcMResponse = (DCMResponse) o;
		return Objects.equals(this.code, dcMResponse.code) && Objects.equals(this.message, dcMResponse.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, message);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class DCMResponse {\n");

		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    message: ").append(toIndentedString(message)).append("\n");
		sb.append("    value: ").append(toIndentedString(value)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
