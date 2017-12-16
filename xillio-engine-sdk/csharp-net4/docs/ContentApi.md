# Sphereon.SDK.Xillio.Engine.Api.ContentApi

All URIs are relative to *https://sandbox.xill.io/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**GetContent**](ContentApi.md#getcontent) | **GET** /contents/{configurationId}/{path} | Download an Entity\&quot;s Binary Content
[**UpdateContent**](ContentApi.md#updatecontent) | **PUT** /contents/{configurationId}/{path} | Replaces an Entity\&quot;s Binary Content


<a name="getcontent"></a>
# **GetContent**
> System.IO.Stream GetContent (string configurationId, string path)

Download an Entity\"s Binary Content

Download an Entity\"s Binary Content

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Xillio.Engine.Api;
using Sphereon.SDK.Xillio.Engine.Client;
using Sphereon.SDK.Xillio.Engine.Model;

namespace Example
{
    public class GetContentExample
    {
        public void main()
        {
            
            var apiInstance = new ContentApi();
            var configurationId = configurationId_example;  // string | The id of a configured repository.
            var path = path_example;  // string | The XDIP path to the entity.

            try
            {
                // Download an Entity\"s Binary Content
                System.IO.Stream result = apiInstance.GetContent(configurationId, path);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling ContentApi.GetContent: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **configurationId** | **string**| The id of a configured repository. | 
 **path** | **string**| The XDIP path to the entity. | 

### Return type

**System.IO.Stream**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="updatecontent"></a>
# **UpdateContent**
> void UpdateContent (string configurationId, string path)

Replaces an Entity\"s Binary Content

Replaces an Entity\"s Binary Content

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Xillio.Engine.Api;
using Sphereon.SDK.Xillio.Engine.Client;
using Sphereon.SDK.Xillio.Engine.Model;

namespace Example
{
    public class UpdateContentExample
    {
        public void main()
        {
            
            var apiInstance = new ContentApi();
            var configurationId = configurationId_example;  // string | The id of a configured repository.
            var path = path_example;  // string | The XDIP path to the entity.

            try
            {
                // Replaces an Entity\"s Binary Content
                apiInstance.UpdateContent(configurationId, path);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling ContentApi.UpdateContent: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **configurationId** | **string**| The id of a configured repository. | 
 **path** | **string**| The XDIP path to the entity. | 

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/octet-stream
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

