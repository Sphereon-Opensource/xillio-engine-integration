# xillio-engine-integration
This project contains Xillio Engine SDK generators for various programming languages, as well as a jclouds storage integration module

## Requirements

Building SDK's requires [Maven](https://maven.apache.org/) to be installed.

## Generating Java8 domain classes only

To generate the Java 8 domain classes only, simply execute:

```shell
mvn clean install -P java8-xillio-engine-domain
```

To install proceed to the java8-xillio-engine-domain folder and execute:

```shell
mvn clean install
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users (after deployment)

Add this dependency to your project's POM for the java8 domain classes:

```xml
<dependency>
    <groupId>org.jclouds</groupId>
    <artifactId>java8-xillio-engine-domain</artifactId>
    <version>0.1.0-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>
```

### SDK's and Others

There are currently generators for the following languages

* [java8-okhttp-gson](java8-okhttp-gson) A java8 SDK based on Okhttp and gson
* [csharp-net4](csharp-net4) A Csharp .NET 4.6 implementation
* [javascript](javascript) A  Javascript implementation

To generate these SDK's execute the following command

```shell
mvn clean install -P <sdk-name-here>
```
    

Then get into the corresponding folder for the SDK

## Documentation

Please see one of the SDK project for full documentation. This project only generates the SDK's.

## Author
Copyright 2017, Sphereon B.V. <https://sphereon.com>

License
-------

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

