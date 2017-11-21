# ContentApi

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
```java
// Import classes:
//import com.sphereon.sdk.xillio.engine.handler.ApiException;
//import com.sphereon.sdk.xillio.engine.api.ContentApi;


ContentApi apiInstance = new ContentApi();
String configurationId = "configurationId_example"; // String | The id of a configured repository.
String path = "path_example"; // String | The XDIP path to the entity.
try {
    File result = apiInstance.getContent(configurationId, path);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentApi#getContent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **configurationId** | **String**| The id of a configured repository. |
 **path** | **String**| The XDIP path to the entity. |

### Return type

[**File**](File.md)

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
```java
// Import classes:
//import com.sphereon.sdk.xillio.engine.handler.ApiException;
//import com.sphereon.sdk.xillio.engine.api.ContentApi;


ContentApi apiInstance = new ContentApi();
String configurationId = "configurationId_example"; // String | The id of a configured repository.
String path = "path_example"; // String | The XDIP path to the entity.
try {
    apiInstance.updateContent(configurationId, path);
} catch (ApiException e) {
    System.err.println("Exception when calling ContentApi#updateContent");
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

 - **Content-Type**: application/octet-stream
 - **Accept**: Not defined

