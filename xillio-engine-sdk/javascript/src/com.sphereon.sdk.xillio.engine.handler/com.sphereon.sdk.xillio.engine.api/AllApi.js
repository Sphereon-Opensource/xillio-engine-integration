/**
 * Xillio Engine
 * No descripton provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 0.1
 * Contact: dev@sphereon.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

(function(root, factory) {
  if (typeof define === 'function' && define.amd) {
    // AMD. Register as an anonymous module.
    define(['com.sphereon.sdk.xillio.engine.handler/ApiClient', 'com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/EntityResponse', 'com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/ErrorResponse'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('../com.sphereon.sdk.xillio.engine.model/EntityResponse'), require('../com.sphereon.sdk.xillio.engine.model/ErrorResponse'));
  } else {
    // Browser globals (root is window)
    if (!root.xillio-engine) {
      root.xillio-engine = {};
    }
    root.xillio-engine.AllApi = factory(root.xillio-engine.ApiClient, root.xillio-engine.EntityResponse, root.xillio-engine.ErrorResponse);
  }
}(this, function(ApiClient, EntityResponse, ErrorResponse) {
  'use strict';

  /**
   * All service.
   * @module com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.api/AllApi
   * @version 0.1.0
   */

  /**
   * Constructs a new AllApi. 
   * @alias module:com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.api/AllApi
   * @class
   * @param {module:com.sphereon.sdk.xillio.engine.handler/ApiClient} apiClient Optional API client implementation to use,
   * default to {@link module:com.sphereon.sdk.xillio.engine.handler/ApiClient#instance} if unspecified.
   */
  var exports = function(apiClient) {
    this.apiClient = apiClient || ApiClient.instance;



    /**
     * Create a new Entity
     * Create a new Entity
     * @param {String} configurationId The id of a configured repository.
     * @param {String} path The XDIP path to the entity.
     * @param {Object} opts Optional parameters
     * @param {Array.<module:com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/String>} opts.scope A comma-separated list of scopes. The available scopes are: children, entity. (default: entity) (default to entity)
     * @param {String} opts.include A comma-separated list of projection rules. Decorators which match these rules will be included. All other decorators will be excluded. By default, all decorators are included.
     * @param {String} opts.exclude A comma-separated list of projection rules. Decorators which match these rules will be excluded.
     * @param {String} opts.entity 
     * @param {String} opts.contents 
     * @return {Promise} a {@link https://www.promisejs.org/|Promise}, with data of type {@link module:com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/EntityResponse}
     */
    this.createEntity = function(configurationId, path, opts) {
      opts = opts || {};
      var postBody = null;

      // verify the required parameter 'configurationId' is set
      if (configurationId == undefined || configurationId == null) {
        throw "Missing the required parameter 'configurationId' when calling createEntity";
      }

      // verify the required parameter 'path' is set
      if (path == undefined || path == null) {
        throw "Missing the required parameter 'path' when calling createEntity";
      }


      var pathParams = {
        'configurationId': configurationId,
        'path': path
      };
      var queryParams = {
        'scope': this.apiClient.buildCollectionParam(opts['scope'], 'csv'),
        'include': opts['include'],
        'exclude': opts['exclude']
      };
      var headerParams = {
      };
      var formParams = {
        'entity': opts['entity'],
        'contents': opts['contents']
      };

      var authNames = [];
      var contentTypes = ['multipart/form-data'];
      var accepts = ['application/json;charset=UTF-8'];
      var returnType = EntityResponse;

      return this.apiClient.callApi(
        '/entities/{configurationId}/{path}', 'POST',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType
      );
    }


    /**
     * Delete an existing Entity
     * Delete an existing Entity
     * @param {String} configurationId The id of a configured repository.
     * @param {String} path The XDIP path to the entity.
     * @return {Promise} a {@link https://www.promisejs.org/|Promise}
     */
    this.deleteEntity = function(configurationId, path) {
      var postBody = null;

      // verify the required parameter 'configurationId' is set
      if (configurationId == undefined || configurationId == null) {
        throw "Missing the required parameter 'configurationId' when calling deleteEntity";
      }

      // verify the required parameter 'path' is set
      if (path == undefined || path == null) {
        throw "Missing the required parameter 'path' when calling deleteEntity";
      }


      var pathParams = {
        'configurationId': configurationId,
        'path': path
      };
      var queryParams = {
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = [];
      var contentTypes = ['application/json;charset=UTF-8'];
      var accepts = [];
      var returnType = null;

      return this.apiClient.callApi(
        '/entities/{configurationId}/{path}', 'DELETE',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType
      );
    }


    /**
     * Download an Entity\&quot;s Binary Content
     * Download an Entity\&quot;s Binary Content
     * @param {String} configurationId The id of a configured repository.
     * @param {String} path The XDIP path to the entity.
     * @return {Promise} a {@link https://www.promisejs.org/|Promise}, with data of type {@link File}
     */
    this.getContent = function(configurationId, path) {
      var postBody = null;

      // verify the required parameter 'configurationId' is set
      if (configurationId == undefined || configurationId == null) {
        throw "Missing the required parameter 'configurationId' when calling getContent";
      }

      // verify the required parameter 'path' is set
      if (path == undefined || path == null) {
        throw "Missing the required parameter 'path' when calling getContent";
      }


      var pathParams = {
        'configurationId': configurationId,
        'path': path
      };
      var queryParams = {
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = [];
      var contentTypes = [];
      var accepts = ['application/octet-stream'];
      var returnType = File;

      return this.apiClient.callApi(
        '/contents/{configurationId}/{path}', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType
      );
    }


    /**
     * Get an Entity
     * Get an Entity
     * @param {String} configurationId The id of a configured repository.
     * @param {String} path The XDIP path to the entity.
     * @param {Object} opts Optional parameters
     * @param {Array.<module:com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/String>} opts.scope A comma-separated list of scopes. The available scopes are: children, entity. (default: entity) (default to entity)
     * @param {String} opts.include A comma-separated list of projection rules. Decorators which match these rules will be included. All other decorators will be excluded. By default, all decorators are included.
     * @param {String} opts.exclude A comma-separated list of projection rules. Decorators which match these rules will be excluded.
     * @return {Promise} a {@link https://www.promisejs.org/|Promise}, with data of type {@link module:com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/EntityResponse}
     */
    this.getEntity = function(configurationId, path, opts) {
      opts = opts || {};
      var postBody = null;

      // verify the required parameter 'configurationId' is set
      if (configurationId == undefined || configurationId == null) {
        throw "Missing the required parameter 'configurationId' when calling getEntity";
      }

      // verify the required parameter 'path' is set
      if (path == undefined || path == null) {
        throw "Missing the required parameter 'path' when calling getEntity";
      }


      var pathParams = {
        'configurationId': configurationId,
        'path': path
      };
      var queryParams = {
        'scope': this.apiClient.buildCollectionParam(opts['scope'], 'csv'),
        'include': opts['include'],
        'exclude': opts['exclude']
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = [];
      var contentTypes = [];
      var accepts = ['application/json;charset=UTF-8'];
      var returnType = EntityResponse;

      return this.apiClient.callApi(
        '/entities/{configurationId}/{path}', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType
      );
    }


    /**
     * List Available Entities/Repositories
     * List Available Entities/Repositories
     * @param {Object} opts Optional parameters
     * @param {Array.<module:com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/String>} opts.scope A comma-separated list of scopes. The available scopes are: children, entity. (default: entity) (default to entity)
     * @param {String} opts.include A comma-separated list of projection rules. Decorators which match these rules will be included. All other decorators will be excluded. By default, all decorators are included.
     * @param {String} opts.exclude A comma-separated list of projection rules. Decorators which match these rules will be excluded.
     * @return {Promise} a {@link https://www.promisejs.org/|Promise}, with data of type {@link module:com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/EntityResponse}
     */
    this.listEntities = function(opts) {
      opts = opts || {};
      var postBody = null;


      var pathParams = {
      };
      var queryParams = {
        'scope': this.apiClient.buildCollectionParam(opts['scope'], 'csv'),
        'include': opts['include'],
        'exclude': opts['exclude']
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = [];
      var contentTypes = [];
      var accepts = ['application/json;charset=UTF-8'];
      var returnType = EntityResponse;

      return this.apiClient.callApi(
        '/entities', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType
      );
    }


    /**
     * Replaces an Entity\&quot;s Binary Content
     * Replaces an Entity\&quot;s Binary Content
     * @param {String} configurationId The id of a configured repository.
     * @param {String} path The XDIP path to the entity.
     * @return {Promise} a {@link https://www.promisejs.org/|Promise}
     */
    this.updateContent = function(configurationId, path) {
      var postBody = null;

      // verify the required parameter 'configurationId' is set
      if (configurationId == undefined || configurationId == null) {
        throw "Missing the required parameter 'configurationId' when calling updateContent";
      }

      // verify the required parameter 'path' is set
      if (path == undefined || path == null) {
        throw "Missing the required parameter 'path' when calling updateContent";
      }


      var pathParams = {
        'configurationId': configurationId,
        'path': path
      };
      var queryParams = {
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = [];
      var contentTypes = ['application/octet-stream'];
      var accepts = [];
      var returnType = null;

      return this.apiClient.callApi(
        '/contents/{configurationId}/{path}', 'PUT',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType
      );
    }


    /**
     * Update an existing Entity
     * Update an existing Entity
     * @param {String} configurationId The id of a configured repository.
     * @param {String} path The XDIP path to the entity.
     * @param {Object} opts Optional parameters
     * @param {Array.<module:com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/String>} opts.scope A comma-separated list of scopes. The available scopes are: children, entity. (default: entity) (default to entity)
     * @param {String} opts.include A comma-separated list of projection rules. Decorators which match these rules will be included. All other decorators will be excluded. By default, all decorators are included.
     * @param {String} opts.exclude A comma-separated list of projection rules. Decorators which match these rules will be excluded.
     * @param {module:com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/EntityResponse} opts.entity 
     * @return {Promise} a {@link https://www.promisejs.org/|Promise}, with data of type {@link module:com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/EntityResponse}
     */
    this.updateEntity = function(configurationId, path, opts) {
      opts = opts || {};
      var postBody = opts['entity'];

      // verify the required parameter 'configurationId' is set
      if (configurationId == undefined || configurationId == null) {
        throw "Missing the required parameter 'configurationId' when calling updateEntity";
      }

      // verify the required parameter 'path' is set
      if (path == undefined || path == null) {
        throw "Missing the required parameter 'path' when calling updateEntity";
      }


      var pathParams = {
        'configurationId': configurationId,
        'path': path
      };
      var queryParams = {
        'scope': this.apiClient.buildCollectionParam(opts['scope'], 'csv'),
        'include': opts['include'],
        'exclude': opts['exclude']
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = [];
      var contentTypes = ['application/json;charset=UTF-8'];
      var accepts = ['application/json;charset=UTF-8'];
      var returnType = EntityResponse;

      return this.apiClient.callApi(
        '/entities/{configurationId}/{path}', 'PUT',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType
      );
    }
  };

  return exports;
}));
