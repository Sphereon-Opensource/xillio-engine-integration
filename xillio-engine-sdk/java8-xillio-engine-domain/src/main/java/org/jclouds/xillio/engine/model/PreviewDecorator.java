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

/**
 * The preview decorator provides a location for previews of an entity. For instance, if the entity is a piece of source code from GitHub, the preview.html field contains an url to the GitHub view of that code.
 */
@ApiModel(description = "The preview decorator provides a location for previews of an entity. For instance, if the entity is a piece of source code from GitHub, the preview.html field contains an url to the GitHub view of that code.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-12-30T06:23:19.976+01:00")
public class PreviewDecorator {
  @SerializedName("html")
  private String html = null;

  public PreviewDecorator html(String html) {
    this.html = html;
    return this;
  }

   /**
   * A web view that can be opened in a browser.
   * @return html
  **/
  @ApiModelProperty(required = true, value = "A web view that can be opened in a browser.")
  public String getHtml() {
    return html;
  }

  public void setHtml(String html) {
    this.html = html;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PreviewDecorator previewDecorator = (PreviewDecorator) o;
    return Objects.equals(this.html, previewDecorator.html);
  }

  @Override
  public int hashCode() {
    return Objects.hash(html);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PreviewDecorator {\n");
    
    sb.append("    html: ").append(toIndentedString(html)).append("\n");
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

