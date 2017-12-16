
# ErrorResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**message** | **String** | A contextual message that describes the cause of this error. |  [optional]
**error** | **String** | A more general error message. |  [optional]
**status** | [**BigDecimal**](BigDecimal.md) | The http status code. |  [optional]
**timestamp** | **String** | The date this exception occurred. |  [optional]
**exception** | **String** | The type of exception that occurred in the backend. |  [optional]
**location** | **String** | The location in the backend where this error occurred. |  [optional]
**path** | **String** | The request URI that caused this error. |  [optional]
**parameters** | **Map&lt;String, String&gt;** | The parameters that were passed to this request. |  [optional]



