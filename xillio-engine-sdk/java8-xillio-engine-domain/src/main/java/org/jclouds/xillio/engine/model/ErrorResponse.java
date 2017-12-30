/*
 * Xillio Engine
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 0.1
 * Contact: dev@sphereon.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package org.jclouds.xillio.engine.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The preview decorator provides a location for previews of an entity. For instance, if the entity is a piece of source code from GitHub, the preview.html field contains an url to the GitHub view of that code.
 */
@ApiModel(description = "The preview decorator provides a location for previews of an entity. For instance, if the entity is a piece of source code from GitHub, the preview.html field contains an url to the GitHub view of that code.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-12-30T06:23:19.976+01:00")
public class ErrorResponse {
  @SerializedName("message")
  private String message = null;

  @SerializedName("error")
  private String error = null;

  @SerializedName("status")
  private BigDecimal status = null;

  @SerializedName("timestamp")
  private String timestamp = null;

  @SerializedName("exception")
  private String exception = null;

  @SerializedName("location")
  private String location = null;

  @SerializedName("path")
  private String path = null;

  @SerializedName("parameters")
  private Map<String, String> parameters = null;

  public ErrorResponse message(String message) {
    this.message = message;
    return this;
  }

   /**
   * A contextual message that describes the cause of this error.
   * @return message
  **/
  @ApiModelProperty(value = "A contextual message that describes the cause of this error.")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ErrorResponse error(String error) {
    this.error = error;
    return this;
  }

   /**
   * A more general error message.
   * @return error
  **/
  @ApiModelProperty(value = "A more general error message.")
  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public ErrorResponse status(BigDecimal status) {
    this.status = status;
    return this;
  }

   /**
   * The http status code.
   * @return status
  **/
  @ApiModelProperty(value = "The http status code.")
  public BigDecimal getStatus() {
    return status;
  }

  public void setStatus(BigDecimal status) {
    this.status = status;
  }

  public ErrorResponse timestamp(String timestamp) {
    this.timestamp = timestamp;
    return this;
  }

   /**
   * The date this exception occurred.
   * @return timestamp
  **/
  @ApiModelProperty(value = "The date this exception occurred.")
  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public ErrorResponse exception(String exception) {
    this.exception = exception;
    return this;
  }

   /**
   * The type of exception that occurred in the backend.
   * @return exception
  **/
  @ApiModelProperty(value = "The type of exception that occurred in the backend.")
  public String getException() {
    return exception;
  }

  public void setException(String exception) {
    this.exception = exception;
  }

  public ErrorResponse location(String location) {
    this.location = location;
    return this;
  }

   /**
   * The location in the backend where this error occurred.
   * @return location
  **/
  @ApiModelProperty(value = "The location in the backend where this error occurred.")
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public ErrorResponse path(String path) {
    this.path = path;
    return this;
  }

   /**
   * The request URI that caused this error.
   * @return path
  **/
  @ApiModelProperty(value = "The request URI that caused this error.")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public ErrorResponse parameters(Map<String, String> parameters) {
    this.parameters = parameters;
    return this;
  }

  public ErrorResponse putParametersItem(String key, String parametersItem) {
    if (this.parameters == null) {
      this.parameters = new HashMap<String, String>();
    }
    this.parameters.put(key, parametersItem);
    return this;
  }

   /**
   * The parameters that were passed to this request.
   * @return parameters
  **/
  @ApiModelProperty(value = "The parameters that were passed to this request.")
  public Map<String, String> getParameters() {
    return parameters;
  }

  public void setParameters(Map<String, String> parameters) {
    this.parameters = parameters;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorResponse errorResponse = (ErrorResponse) o;
    return Objects.equals(this.message, errorResponse.message) &&
        Objects.equals(this.error, errorResponse.error) &&
        Objects.equals(this.status, errorResponse.status) &&
        Objects.equals(this.timestamp, errorResponse.timestamp) &&
        Objects.equals(this.exception, errorResponse.exception) &&
        Objects.equals(this.location, errorResponse.location) &&
        Objects.equals(this.path, errorResponse.path) &&
        Objects.equals(this.parameters, errorResponse.parameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, error, status, timestamp, exception, location, path, parameters);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponse {\n");
    
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    exception: ").append(toIndentedString(exception)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
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

