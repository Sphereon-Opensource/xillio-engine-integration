# EntityApi

All URIs are relative to *https://sandbox.xill.io/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createEntity**](EntityApi.md#createEntity) | **POST** /entities/{configurationId}/{path} | Create a new Entity
[**deleteEntity**](EntityApi.md#deleteEntity) | **DELETE** /entities/{configurationId}/{path} | Delete an existing Entity
[**getEntity**](EntityApi.md#getEntity) | **GET** /entities/{configurationId}/{path} | Get an Entity
[**listEntities**](EntityApi.md#listEntities) | **GET** /entities | List Available Entities/Repositories
[**updateEntity**](EntityApi.md#updateEntity) | **PUT** /entities/{configurationId}/{path} | Update an existing Entity


<a name="createEntity"></a>
# **createEntity**
> EntityResponse createEntity(configurationId, path, scope, include, exclude, entity, contents)

Create a new Entity

Create a new Entity

### Example
```java
// Import classes:
//import com.sphereon.sdk.xillio.engine.handler.ApiException;
//import com.sphereon.sdk.xillio.engine.api.EntityApi;


EntityApi apiInstance = new EntityApi();
String configurationId = "configurationId_example"; // String | The id of a configured repository.
String path = "path_example"; // String | The XDIP path to the entity.
List<String> scope = Arrays.asList("entity"); // List<String> | A comma-separated list of scopes. The available scopes are: children, entity. (default: entity)
String include = "include_example"; // String | A comma-separated list of projection rules. Decorators which match these rules will be included. All other decorators will be excluded. By default, all decorators are included.
String exclude = "exclude_example"; // String | A comma-separated list of projection rules. Decorators which match these rules will be excluded.
String entity = "entity_example"; // String | 
String contents = "contents_example"; // String | 
try {
    EntityResponse result = apiInstance.createEntity(configurationId, path, scope, include, exclude, entity, contents);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EntityApi#createEntity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **configurationId** | **String**| The id of a configured repository. |
 **path** | **String**| The XDIP path to the entity. |
 **scope** | [**List&lt;String&gt;**](String.md)| A comma-separated list of scopes. The available scopes are: children, entity. (default: entity) | [optional] [default to entity] [enum: entity, children]
 **include** | **String**| A comma-separated list of projection rules. Decorators which match these rules will be included. All other decorators will be excluded. By default, all decorators are included. | [optional]
 **exclude** | **String**| A comma-separated list of projection rules. Decorators which match these rules will be excluded. | [optional]
 **entity** | **String**|  | [optional]
 **contents** | **String**|  | [optional]

### Return type

[**EntityResponse**](EntityResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json;charset=UTF-8

<a name="deleteEntity"></a>
# **deleteEntity**
> deleteEntity(configurationId, path)

Delete an existing Entity

Delete an existing Entity

### Example
```java
// Import classes:
//import com.sphereon.sdk.xillio.engine.handler.ApiException;
//import com.sphereon.sdk.xillio.engine.api.EntityApi;


EntityApi apiInstance = new EntityApi();
String configurationId = "configurationId_example"; // String | The id of a configured repository.
String path = "path_example"; // String | The XDIP path to the entity.
try {
    apiInstance.deleteEntity(configurationId, path);
} catch (ApiException e) {
    System.err.println("Exception when calling EntityApi#deleteEntity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **configurationId** | **String**| The id of a configured repository. |
 **path** | **String**| The XDIP path to the entity. |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json;charset=UTF-8
 - **Accept**: Not defined

<a name="getEntity"></a>
# **getEntity**
> EntityResponse getEntity(configurationId, path, scope, include, exclude)

Get an Entity

Get an Entity

### Example
```java
// Import classes:
//import com.sphereon.sdk.xillio.engine.handler.ApiException;
//import com.sphereon.sdk.xillio.engine.api.EntityApi;


EntityApi apiInstance = new EntityApi();
String configurationId = "configurationId_example"; // String | The id of a configured repository.
String path = "path_example"; // String | The XDIP path to the entity.
List<String> scope = Arrays.asList("entity"); // List<String> | A comma-separated list of scopes. The available scopes are: children, entity. (default: entity)
String include = "include_example"; // String | A comma-separated list of projection rules. Decorators which match these rules will be included. All other decorators will be excluded. By default, all decorators are included.
String exclude = "exclude_example"; // String | A comma-separated list of projection rules. Decorators which match these rules will be excluded.
try {
    EntityResponse result = apiInstance.getEntity(configurationId, path, scope, include, exclude);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EntityApi#getEntity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **configurationId** | **String**| The id of a configured repository. |
 **path** | **String**| The XDIP path to the entity. |
 **scope** | [**List&lt;String&gt;**](String.md)| A comma-separated list of scopes. The available scopes are: children, entity. (default: entity) | [optional] [default to entity] [enum: entity, children]
 **include** | **String**| A comma-separated list of projection rules. Decorators which match these rules will be included. All other decorators will be excluded. By default, all decorators are included. | [optional]
 **exclude** | **String**| A comma-separated list of projection rules. Decorators which match these rules will be excluded. | [optional]

### Return type

[**EntityResponse**](EntityResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json;charset=UTF-8

<a name="listEntities"></a>
# **listEntities**
> EntityResponse listEntities(scope, include, exclude)

List Available Entities/Repositories

List Available Entities/Repositories

### Example
```java
// Import classes:
//import com.sphereon.sdk.xillio.engine.handler.ApiException;
//import com.sphereon.sdk.xillio.engine.api.EntityApi;


EntityApi apiInstance = new EntityApi();
List<String> scope = Arrays.asList("entity"); // List<String> | A comma-separated list of scopes. The available scopes are: children, entity. (default: entity)
String include = "include_example"; // String | A comma-separated list of projection rules. Decorators which match these rules will be included. All other decorators will be excluded. By default, all decorators are included.
String exclude = "exclude_example"; // String | A comma-separated list of projection rules. Decorators which match these rules will be excluded.
try {
    EntityResponse result = apiInstance.listEntities(scope, include, exclude);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EntityApi#listEntities");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **scope** | [**List&lt;String&gt;**](String.md)| A comma-separated list of scopes. The available scopes are: children, entity. (default: entity) | [optional] [default to entity] [enum: entity, children]
 **include** | **String**| A comma-separated list of projection rules. Decorators which match these rules will be included. All other decorators will be excluded. By default, all decorators are included. | [optional]
 **exclude** | **String**| A comma-separated list of projection rules. Decorators which match these rules will be excluded. | [optional]

### Return type

[**EntityResponse**](EntityResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json;charset=UTF-8

<a name="updateEntity"></a>
# **updateEntity**
> EntityResponse updateEntity(configurationId, path, scope, include, exclude, entity)

Update an existing Entity

Update an existing Entity

### Example
```java
// Import classes:
//import com.sphereon.sdk.xillio.engine.handler.ApiException;
//import com.sphereon.sdk.xillio.engine.api.EntityApi;


EntityApi apiInstance = new EntityApi();
String configurationId = "configurationId_example"; // String | The id of a configured repository.
String path = "path_example"; // String | The XDIP path to the entity.
List<String> scope = Arrays.asList("entity"); // List<String> | A comma-separated list of scopes. The available scopes are: children, entity. (default: entity)
String include = "include_example"; // String | A comma-separated list of projection rules. Decorators which match these rules will be included. All other decorators will be excluded. By default, all decorators are included.
String exclude = "exclude_example"; // String | A comma-separated list of projection rules. Decorators which match these rules will be excluded.
EntityResponse entity = new EntityResponse(); // EntityResponse | 
try {
    EntityResponse result = apiInstance.updateEntity(configurationId, path, scope, include, exclude, entity);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EntityApi#updateEntity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **configurationId** | **String**| The id of a configured repository. |
 **path** | **String**| The XDIP path to the entity. |
 **scope** | [**List&lt;String&gt;**](String.md)| A comma-separated list of scopes. The available scopes are: children, entity. (default: entity) | [optional] [default to entity] [enum: entity, children]
 **include** | **String**| A comma-separated list of projection rules. Decorators which match these rules will be included. All other decorators will be excluded. By default, all decorators are included. | [optional]
 **exclude** | **String**| A comma-separated list of projection rules. Decorators which match these rules will be excluded. | [optional]
 **entity** | [**EntityResponse**](EntityResponse.md)|  | [optional]

### Return type

[**EntityResponse**](EntityResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json;charset=UTF-8
 - **Accept**: application/json;charset=UTF-8

