# xillio-engine.AllApi

All URIs are relative to *https://sandbox.xill.io/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createEntity**](AllApi.md#createEntity) | **POST** /entities/{configurationId}/{path} | Create a new Entity
[**deleteEntity**](AllApi.md#deleteEntity) | **DELETE** /entities/{configurationId}/{path} | Delete an existing Entity
[**getContent**](AllApi.md#getContent) | **GET** /contents/{configurationId}/{path} | Download an Entity\&quot;s Binary Content
[**getEntity**](AllApi.md#getEntity) | **GET** /entities/{configurationId}/{path} | Get an Entity
[**listEntities**](AllApi.md#listEntities) | **GET** /entities | List Available Entities/Repositories
[**updateContent**](AllApi.md#updateContent) | **PUT** /contents/{configurationId}/{path} | Replaces an Entity\&quot;s Binary Content
[**updateEntity**](AllApi.md#updateEntity) | **PUT** /entities/{configurationId}/{path} | Update an existing Entity


<a name="createEntity"></a>
# **createEntity**
> EntityResponse createEntity(configurationId, path, opts)

Create a new Entity

Create a new Entity

### Example
```javascript
var xillio-engine = require('xillio-engine-sdk');

var apiInstance = new xillio-engine.AllApi();

var configurationId = "configurationId_example"; // String | The id of a configured repository.

var path = "path_example"; // String | The XDIP path to the entity.

var opts = { 
  'scope': ["entity"], // [String] | A comma-separated list of scopes. The available scopes are: children, entity. (default: entity)
  'include': "include_example", // String | A comma-separated list of projection rules. Decorators which match these rules will be included. All other decorators will be excluded. By default, all decorators are included.
  'exclude': "exclude_example", // String | A comma-separated list of projection rules. Decorators which match these rules will be excluded.
  'entity': "entity_example", // String | 
  'contents': "contents_example" // String | 
};
apiInstance.createEntity(configurationId, path, opts).then(function(data) {
  console.log('API called successfully. Returned data: ' + data);
}, function(error) {
  console.error(error);
});

```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **configurationId** | **String**| The id of a configured repository. | 
 **path** | **String**| The XDIP path to the entity. | 
 **scope** | [**[String]**](String.md)| A comma-separated list of scopes. The available scopes are: children, entity. (default: entity) | [optional] [default to entity]
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
```javascript
var xillio-engine = require('xillio-engine-sdk');

var apiInstance = new xillio-engine.AllApi();

var configurationId = "configurationId_example"; // String | The id of a configured repository.

var path = "path_example"; // String | The XDIP path to the entity.

apiInstance.deleteEntity(configurationId, path).then(function() {
  console.log('API called successfully.');
}, function(error) {
  console.error(error);
});

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

<a name="getContent"></a>
# **getContent**
> File getContent(configurationId, path)

Download an Entity\&quot;s Binary Content

Download an Entity\&quot;s Binary Content

### Example
```javascript
var xillio-engine = require('xillio-engine-sdk');

var apiInstance = new xillio-engine.AllApi();

var configurationId = "configurationId_example"; // String | The id of a configured repository.

var path = "path_example"; // String | The XDIP path to the entity.

apiInstance.getContent(configurationId, path).then(function(data) {
  console.log('API called successfully. Returned data: ' + data);
}, function(error) {
  console.error(error);
});

```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **configurationId** | **String**| The id of a configured repository. | 
 **path** | **String**| The XDIP path to the entity. | 

### Return type

**File**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream

<a name="getEntity"></a>
# **getEntity**
> EntityResponse getEntity(configurationId, path, opts)

Get an Entity

Get an Entity

### Example
```javascript
var xillio-engine = require('xillio-engine-sdk');

var apiInstance = new xillio-engine.AllApi();

var configurationId = "configurationId_example"; // String | The id of a configured repository.

var path = "path_example"; // String | The XDIP path to the entity.

var opts = { 
  'scope': ["entity"], // [String] | A comma-separated list of scopes. The available scopes are: children, entity. (default: entity)
  'include': "include_example", // String | A comma-separated list of projection rules. Decorators which match these rules will be included. All other decorators will be excluded. By default, all decorators are included.
  'exclude': "exclude_example", // String | A comma-separated list of projection rules. Decorators which match these rules will be excluded.
};
apiInstance.getEntity(configurationId, path, opts).then(function(data) {
  console.log('API called successfully. Returned data: ' + data);
}, function(error) {
  console.error(error);
});

```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **configurationId** | **String**| The id of a configured repository. | 
 **path** | **String**| The XDIP path to the entity. | 
 **scope** | [**[String]**](String.md)| A comma-separated list of scopes. The available scopes are: children, entity. (default: entity) | [optional] [default to entity]
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
> EntityResponse listEntities(opts)

List Available Entities/Repositories

List Available Entities/Repositories

### Example
```javascript
var xillio-engine = require('xillio-engine-sdk');

var apiInstance = new xillio-engine.AllApi();

var opts = { 
  'scope': ["entity"], // [String] | A comma-separated list of scopes. The available scopes are: children, entity. (default: entity)
  'include': "include_example", // String | A comma-separated list of projection rules. Decorators which match these rules will be included. All other decorators will be excluded. By default, all decorators are included.
  'exclude': "exclude_example", // String | A comma-separated list of projection rules. Decorators which match these rules will be excluded.
};
apiInstance.listEntities(opts).then(function(data) {
  console.log('API called successfully. Returned data: ' + data);
}, function(error) {
  console.error(error);
});

```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **scope** | [**[String]**](String.md)| A comma-separated list of scopes. The available scopes are: children, entity. (default: entity) | [optional] [default to entity]
 **include** | **String**| A comma-separated list of projection rules. Decorators which match these rules will be included. All other decorators will be excluded. By default, all decorators are included. | [optional] 
 **exclude** | **String**| A comma-separated list of projection rules. Decorators which match these rules will be excluded. | [optional] 

### Return type

[**EntityResponse**](EntityResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json;charset=UTF-8

<a name="updateContent"></a>
# **updateContent**
> updateContent(configurationId, path)

Replaces an Entity\&quot;s Binary Content

Replaces an Entity\&quot;s Binary Content

### Example
```javascript
var xillio-engine = require('xillio-engine-sdk');

var apiInstance = new xillio-engine.AllApi();

var configurationId = "configurationId_example"; // String | The id of a configured repository.

var path = "path_example"; // String | The XDIP path to the entity.

apiInstance.updateContent(configurationId, path).then(function() {
  console.log('API called successfully.');
}, function(error) {
  console.error(error);
});

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

 - **Content-Type**: application/octet-stream
 - **Accept**: Not defined

<a name="updateEntity"></a>
# **updateEntity**
> EntityResponse updateEntity(configurationId, path, opts)

Update an existing Entity

Update an existing Entity

### Example
```javascript
var xillio-engine = require('xillio-engine-sdk');

var apiInstance = new xillio-engine.AllApi();

var configurationId = "configurationId_example"; // String | The id of a configured repository.

var path = "path_example"; // String | The XDIP path to the entity.

var opts = { 
  'scope': ["entity"], // [String] | A comma-separated list of scopes. The available scopes are: children, entity. (default: entity)
  'include': "include_example", // String | A comma-separated list of projection rules. Decorators which match these rules will be included. All other decorators will be excluded. By default, all decorators are included.
  'exclude': "exclude_example", // String | A comma-separated list of projection rules. Decorators which match these rules will be excluded.
  'entity': new xillio-engine.EntityResponse() // EntityResponse | 
};
apiInstance.updateEntity(configurationId, path, opts).then(function(data) {
  console.log('API called successfully. Returned data: ' + data);
}, function(error) {
  console.error(error);
});

```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **configurationId** | **String**| The id of a configured repository. | 
 **path** | **String**| The XDIP path to the entity. | 
 **scope** | [**[String]**](String.md)| A comma-separated list of scopes. The available scopes are: children, entity. (default: entity) | [optional] [default to entity]
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

