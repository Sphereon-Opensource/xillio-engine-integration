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
import org.jclouds.xillio.engine.model.Decorators;

/**
 * UDM Entity
 */
@ApiModel(description = "UDM Entity")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-21T22:36:36.417+01:00")
public class Entity {
  @SerializedName("id")
  private String id = null;

  @SerializedName("kind")
  private String kind = null;

  @SerializedName("xdip")
  private String xdip = null;

  @SerializedName("original")
  private Decorators original = null;

  @SerializedName("modified")
  private Decorators modified = null;

  public Entity id(String id) {
    this.id = id;
    return this;
  }

   /**
   * An URL that points to the entity.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "An URL that points to the entity.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Entity kind(String kind) {
    this.kind = kind;
    return this;
  }

   /**
   * A simple content type string that describes the best match for the entity.
   * @return kind
  **/
  @ApiModelProperty(value = "A simple content type string that describes the best match for the entity.")
  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
  }

  public Entity xdip(String xdip) {
    this.xdip = xdip;
    return this;
  }

   /**
   * Xdip
   * @return xdip
  **/
  @ApiModelProperty(value = "Xdip")
  public String getXdip() {
    return xdip;
  }

  public void setXdip(String xdip) {
    this.xdip = xdip;
  }

  public Entity original(Decorators original) {
    this.original = original;
    return this;
  }

   /**
   * Get original
   * @return original
  **/
  @ApiModelProperty(value = "")
  public Decorators getOriginal() {
    return original;
  }

  public void setOriginal(Decorators original) {
    this.original = original;
  }

  public Entity modified(Decorators modified) {
    this.modified = modified;
    return this;
  }

   /**
   * Get modified
   * @return modified
  **/
  @ApiModelProperty(value = "")
  public Decorators getModified() {
    return modified;
  }

  public void setModified(Decorators modified) {
    this.modified = modified;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Entity entity = (Entity) o;
    return Objects.equals(this.id, entity.id) &&
        Objects.equals(this.kind, entity.kind) &&
        Objects.equals(this.xdip, entity.xdip) &&
        Objects.equals(this.original, entity.original) &&
        Objects.equals(this.modified, entity.modified);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, kind, xdip, original, modified);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Entity {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    xdip: ").append(toIndentedString(xdip)).append("\n");
    sb.append("    original: ").append(toIndentedString(original)).append("\n");
    sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
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
