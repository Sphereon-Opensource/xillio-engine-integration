# Sphereon.SDK.Xillio.Engine.Api.EntityApi

All URIs are relative to *https://sandbox.xill.io/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**CreateEntity**](EntityApi.md#createentity) | **POST** /entities/{configurationId}/{path} | Create a new Entity
[**DeleteEntity**](EntityApi.md#deleteentity) | **DELETE** /entities/{configurationId}/{path} | Delete an existing Entity
[**GetEntity**](EntityApi.md#getentity) | **GET** /entities/{configurationId}/{path} | Get an Entity
[**ListEntities**](EntityApi.md#listentities) | **GET** /entities | List Available Entities/Repositories
[**UpdateEntity**](EntityApi.md#updateentity) | **PUT** /entities/{configurationId}/{path} | Update an existing Entity


<a name="createentity"></a>
# **CreateEntity**
> EntityResponse CreateEntity (string configurationId, string path, List<string> scope = null, string include = null, string exclude = null, string entity = null, string contents = null)

Create a new Entity

Create a new Entity

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Xillio.Engine.Api;
using Sphereon.SDK.Xillio.Engine.Client;
using Sphereon.SDK.Xillio.Engine.Model;

namespace Example
{
    public class CreateEntityExample
    {
        public void main()
        {
            
            var apiInstance = new EntityApi();
            var configurationId = configurationId_example;  // string | The id of a configured repository.
            var path = path_example;  // string | The XDIP path to the entity.
            var scope = new List<string>(); // List<string> | A comma-separated list of scopes. The available scopes are: children, entity. (default: entity) (optional)  (default to entity)
            var include = include_example;  // string | A comma-separated list of projection rules. Decorators which match these rules will be included. All other decorators will be excluded. By default, all decorators are included. (optional) 
            var exclude = exclude_example;  // string | A comma-separated list of projection rules. Decorators which match these rules will be excluded. (optional) 
            var entity = entity_example;  // string |  (optional) 
            var contents = contents_example;  // string |  (optional) 

            try
            {
                // Create a new Entity
                EntityResponse result = apiInstance.CreateEntity(configurationId, path, scope, include, exclude, entity, contents);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling EntityApi.CreateEntity: " + e.Message );
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
 **scope** | [**List<string>**](string.md)| A comma-separated list of scopes. The available scopes are: children, entity. (default: entity) | [optional] [default to entity]
 **include** | **string**| A comma-separated list of projection rules. Decorators which match these rules will be included. All other decorators will be excluded. By default, all decorators are included. | [optional] 
 **exclude** | **string**| A comma-separated list of projection rules. Decorators which match these rules will be excluded. | [optional] 
 **entity** | **string**|  | [optional] 
 **contents** | **string**|  | [optional] 

### Return type

[**EntityResponse**](EntityResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json;charset=UTF-8

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="deleteentity"></a>
# **DeleteEntity**
> void DeleteEntity (string configurationId, string path)

Delete an existing Entity

Delete an existing Entity

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Xillio.Engine.Api;
using Sphereon.SDK.Xillio.Engine.Client;
using Sphereon.SDK.Xillio.Engine.Model;

namespace Example
{
    public class DeleteEntityExample
    {
        public void main()
        {
            
            var apiInstance = new EntityApi();
            var configurationId = configurationId_example;  // string | The id of a configured repository.
            var path = path_example;  // string | The XDIP path to the entity.

            try
            {
                // Delete an existing Entity
                apiInstance.DeleteEntity(configurationId, path);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling EntityApi.DeleteEntity: " + e.Message );
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

 - **Content-Type**: application/json;charset=UTF-8
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="getentity"></a>
# **GetEntity**
> EntityResponse GetEntity (string configurationId, string path, List<string> scope = null, string include = null, string exclude = null)

Get an Entity

Get an Entity

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Xillio.Engine.Api;
using Sphereon.SDK.Xillio.Engine.Client;
using Sphereon.SDK.Xillio.Engine.Model;

namespace Example
{
    public class GetEntityExample
    {
        public void main()
        {
            
            var apiInstance = new EntityApi();
            var configurationId = configurationId_example;  // string | The id of a configured repository.
            var path = path_example;  // string | The XDIP path to the entity.
            var scope = new List<string>(); // List<string> | A comma-separated list of scopes. The available scopes are: children, entity. (default: entity) (optional)  (default to entity)
            var include = include_example;  // string | A comma-separated list of projection rules. Decorators which match these rules will be included. All other decorators will be excluded. By default, all decorators are included. (optional) 
            var exclude = exclude_example;  // string | A comma-separated list of projection rules. Decorators which match these rules will be excluded. (optional) 

            try
            {
                // Get an Entity
                EntityResponse result = apiInstance.GetEntity(configurationId, path, scope, include, exclude);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling EntityApi.GetEntity: " + e.Message );
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
 **scope** | [**List<string>**](string.md)| A comma-separated list of scopes. The available scopes are: children, entity. (default: entity) | [optional] [default to entity]
 **include** | **string**| A comma-separated list of projection rules. Decorators which match these rules will be included. All other decorators will be excluded. By default, all decorators are included. | [optional] 
 **exclude** | **string**| A comma-separated list of projection rules. Decorators which match these rules will be excluded. | [optional] 

### Return type

[**EntityResponse**](EntityResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json;charset=UTF-8

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="listentities"></a>
# **ListEntities**
> EntityResponse ListEntities (List<string> scope = null, string include = null, string exclude = null)

List Available Entities/Repositories

List Available Entities/Repositories

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Xillio.Engine.Api;
using Sphereon.SDK.Xillio.Engine.Client;
using Sphereon.SDK.Xillio.Engine.Model;

namespace Example
{
    public class ListEntitiesExample
    {
        public void main()
        {
            
            var apiInstance = new EntityApi();
            var scope = new List<string>(); // List<string> | A comma-separated list of scopes. The available scopes are: children, entity. (default: entity) (optional)  (default to entity)
            var include = include_example;  // string | A comma-separated list of projection rules. Decorators which match these rules will be included. All other decorators will be excluded. By default, all decorators are included. (optional) 
            var exclude = exclude_example;  // string | A comma-separated list of projection rules. Decorators which match these rules will be excluded. (optional) 

            try
            {
                // List Available Entities/Repositories
                EntityResponse result = apiInstance.ListEntities(scope, include, exclude);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling EntityApi.ListEntities: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **scope** | [**List<string>**](string.md)| A comma-separated list of scopes. The available scopes are: children, entity. (default: entity) | [optional] [default to entity]
 **include** | **string**| A comma-separated list of projection rules. Decorators which match these rules will be included. All other decorators will be excluded. By default, all decorators are included. | [optional] 
 **exclude** | **string**| A comma-separated list of projection rules. Decorators which match these rules will be excluded. | [optional] 

### Return type

[**EntityResponse**](EntityResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json;charset=UTF-8

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="updateentity"></a>
# **UpdateEntity**
> EntityResponse UpdateEntity (string configurationId, string path, List<string> scope = null, string include = null, string exclude = null, EntityResponse entity = null)

Update an existing Entity

Update an existing Entity

### Example
```csharp
using System;
using System.Diagnostics;
using Sphereon.SDK.Xillio.Engine.Api;
using Sphereon.SDK.Xillio.Engine.Client;
using Sphereon.SDK.Xillio.Engine.Model;

namespace Example
{
    public class UpdateEntityExample
    {
        public void main()
        {
            
            var apiInstance = new EntityApi();
            var configurationId = configurationId_example;  // string | The id of a configured repository.
            var path = path_example;  // string | The XDIP path to the entity.
            var scope = new List<string>(); // List<string> | A comma-separated list of scopes. The available scopes are: children, entity. (default: entity) (optional)  (default to entity)
            var include = include_example;  // string | A comma-separated list of projection rules. Decorators which match these rules will be included. All other decorators will be excluded. By default, all decorators are included. (optional) 
            var exclude = exclude_example;  // string | A comma-separated list of projection rules. Decorators which match these rules will be excluded. (optional) 
            var entity = new EntityResponse(); // EntityResponse |  (optional) 

            try
            {
                // Update an existing Entity
                EntityResponse result = apiInstance.UpdateEntity(configurationId, path, scope, include, exclude, entity);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling EntityApi.UpdateEntity: " + e.Message );
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
 **scope** | [**List<string>**](string.md)| A comma-separated list of scopes. The available scopes are: children, entity. (default: entity) | [optional] [default to entity]
 **include** | **string**| A comma-separated list of projection rules. Decorators which match these rules will be included. All other decorators will be excluded. By default, all decorators are included. | [optional] 
 **exclude** | **string**| A comma-separated list of projection rules. Decorators which match these rules will be excluded. | [optional] 
 **entity** | [**EntityResponse**](EntityResponse.md)|  | [optional] 

### Return type

[**EntityResponse**](EntityResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json;charset=UTF-8
 - **Accept**: application/json;charset=UTF-8

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

