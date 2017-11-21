# xillio-engine.ContentApi

All URIs are relative to *https://sandbox.xill.io/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getContent**](ContentApi.md#getContent) | **GET** /contents/{configurationId}/{path} | Download an Entity\&quot;s Binary Content
[**updateContent**](ContentApi.md#updateContent) | **PUT** /contents/{configurationId}/{path} | Replaces an Entity\&quot;s Binary Content


<a name="getContent"></a>
# **getContent**
> File getContent(configurationId, path)

Download an Entity\&quot;s Binary Content

Download an Entity\&quot;s Binary Content

### Example
```javascript
var xillio-engine = require('xillio-engine-sdk');

var apiInstance = new xillio-engine.ContentApi();

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

<a name="updateContent"></a>
# **updateContent**
> updateContent(configurationId, path)

Replaces an Entity\&quot;s Binary Content

Replaces an Entity\&quot;s Binary Content

### Example
```javascript
var xillio-engine = require('xillio-engine-sdk');

var apiInstance = new xillio-engine.ContentApi();

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

