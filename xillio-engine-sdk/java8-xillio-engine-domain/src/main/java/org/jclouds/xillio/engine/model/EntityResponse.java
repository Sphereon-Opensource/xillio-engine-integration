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
import java.util.ArrayList;
import java.util.List;
import org.jclouds.xillio.engine.model.Entity;

/**
 * EntityResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-12-30T06:23:19.976+01:00")
public class EntityResponse {
  @SerializedName("entity")
  private Entity entity = null;

  @SerializedName("children")
  private List<Entity> children = null;

  public EntityResponse entity(Entity entity) {
    this.entity = entity;
    return this;
  }

   /**
   * Get entity
   * @return entity
  **/
  @ApiModelProperty(value = "")
  public Entity getEntity() {
    return entity;
  }

  public void setEntity(Entity entity) {
    this.entity = entity;
  }

  public EntityResponse children(List<Entity> children) {
    this.children = children;
    return this;
  }

  public EntityResponse addChildrenItem(Entity childrenItem) {
    if (this.children == null) {
      this.children = new ArrayList<Entity>();
    }
    this.children.add(childrenItem);
    return this;
  }

   /**
   * Get children
   * @return children
  **/
  @ApiModelProperty(value = "")
  public List<Entity> getChildren() {
    return children;
  }

  public void setChildren(List<Entity> children) {
    this.children = children;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EntityResponse entityResponse = (EntityResponse) o;
    return Objects.equals(this.entity, entityResponse.entity) &&
        Objects.equals(this.children, entityResponse.children);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entity, children);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EntityResponse {\n");
    
    sb.append("    entity: ").append(toIndentedString(entity)).append("\n");
    sb.append("    children: ").append(toIndentedString(children)).append("\n");
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

