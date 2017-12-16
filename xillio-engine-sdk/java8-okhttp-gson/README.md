# xillio-engine-sdk-java8-okhttp-gson

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>com.sphereon.sdk</groupId>
    <artifactId>xillio-engine-sdk-java8-okhttp-gson</artifactId>
    <version>0.1.0-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.sphereon.sdk:xillio-engine-sdk-java8-okhttp-gson:0.1.0-SNAPSHOT"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/xillio-engine-sdk-java8-okhttp-gson-0.1.0-SNAPSHOT.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import com.sphereon.sdk.xillio.engine.handler.*;
import com.sphereon.sdk.xillio.engine.handler.auth.*;
import com.sphereon.sdk.xillio.engine.model.*;
import com.sphereon.sdk.xillio.engine.api.AllApi;

import java.io.File;
import java.util.*;

public class AllApiExample {

    public static void main(String[] args) {
        
        AllApi apiInstance = new AllApi();
        String configurationId = "configurationId_example"; // String | The id of a configured repository.
        String path = "path_example"; // String | The XDIP path to the entity.
        List<String> scope = Arrays.asList("entity"); // List<String> | A comma-separated list of scopes. The available scopes are: children, entity. (default: entity)
        String include = "include_example"; // String | A comma-separated list of projection rules. Decorators which match these rules will be included. All other decorators will be excluded. By default, all decorators are included.
        String exclude = "exclude_example"; // String | A comma-separated list of projection rules. Decorators which match these rules will be excluded.
        String entity = "entity_example"; // String | 
        File contents = new File("/path/to/file.txt"); // File | 
        try {
            EntityResponse result = apiInstance.createEntity(configurationId, path, scope, include, exclude, entity, contents);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AllApi#createEntity");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://sandbox.xill.io/v2*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AllApi* | [**createEntity**](docs/AllApi.md#createEntity) | **POST** /entities/{configurationId}/{path} | Create a new Entity
*AllApi* | [**deleteEntity**](docs/AllApi.md#deleteEntity) | **DELETE** /entities/{configurationId}/{path} | Delete an existing Entity
*AllApi* | [**getContent**](docs/AllApi.md#getContent) | **GET** /contents/{configurationId}/{path} | Download an Entity&#39;s Binary Content
*AllApi* | [**getEntity**](docs/AllApi.md#getEntity) | **GET** /entities/{configurationId}/{path} | Get an Entity
*AllApi* | [**listEntities**](docs/AllApi.md#listEntities) | **GET** /entities | List Available Entities/Repositories
*AllApi* | [**updateContent**](docs/AllApi.md#updateContent) | **PUT** /contents/{configurationId}/{path} | Replaces an Entity&#39;s Binary Content
*AllApi* | [**updateEntity**](docs/AllApi.md#updateEntity) | **PUT** /entities/{configurationId}/{path} | Update an existing Entity
*ContentApi* | [**getContent**](docs/ContentApi.md#getContent) | **GET** /contents/{configurationId}/{path} | Download an Entity&#39;s Binary Content
*ContentApi* | [**updateContent**](docs/ContentApi.md#updateContent) | **PUT** /contents/{configurationId}/{path} | Replaces an Entity&#39;s Binary Content
*EntityApi* | [**createEntity**](docs/EntityApi.md#createEntity) | **POST** /entities/{configurationId}/{path} | Create a new Entity
*EntityApi* | [**deleteEntity**](docs/EntityApi.md#deleteEntity) | **DELETE** /entities/{configurationId}/{path} | Delete an existing Entity
*EntityApi* | [**getEntity**](docs/EntityApi.md#getEntity) | **GET** /entities/{configurationId}/{path} | Get an Entity
*EntityApi* | [**listEntities**](docs/EntityApi.md#listEntities) | **GET** /entities | List Available Entities/Repositories
*EntityApi* | [**updateEntity**](docs/EntityApi.md#updateEntity) | **PUT** /entities/{configurationId}/{path} | Update an existing Entity


## Documentation for Models

 - [ContainerDecorator](docs/ContainerDecorator.md)
 - [CreatedDecorator](docs/CreatedDecorator.md)
 - [Decorators](docs/Decorators.md)
 - [DescriptionDecorator](docs/DescriptionDecorator.md)
 - [Entity](docs/Entity.md)
 - [EntityResponse](docs/EntityResponse.md)
 - [ErrorResponse](docs/ErrorResponse.md)
 - [FileDecorator](docs/FileDecorator.md)
 - [FileSystemDecorator](docs/FileSystemDecorator.md)
 - [HashDecorator](docs/HashDecorator.md)
 - [MimeTypeDecorator](docs/MimeTypeDecorator.md)
 - [ModifiedDecorator](docs/ModifiedDecorator.md)
 - [NameDecorator](docs/NameDecorator.md)
 - [ParentDecorator](docs/ParentDecorator.md)
 - [PreviewDecorator](docs/PreviewDecorator.md)
 - [PropertiesDecorator](docs/PropertiesDecorator.md)
 - [VersionDecorator](docs/VersionDecorator.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### oauth2schema

- **Type**: OAuth
- **Flow**: application
- **Authorization URL**: 
- **Scopes**: 
  - global: accessEverything


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

dev@sphereon.com

