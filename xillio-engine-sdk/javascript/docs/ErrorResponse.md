# xillio-engine.ErrorResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**message** | **String** | A contextual message that describes the cause of this error. | [optional] 
**error** | **String** | A more general error message. | [optional] 
**status** | **Number** | The http status code. | [optional] 
**timestamp** | **String** | The date this exception occurred. | [optional] 
**exception** | **String** | The type of exception that occurred in the backend. | [optional] 
**location** | **String** | The location in the backend where this error occurred. | [optional] 
**path** | **String** | The request URI that caused this error. | [optional] 
**parameters** | **{String: String}** | The parameters that were passed to this request. | [optional] 


