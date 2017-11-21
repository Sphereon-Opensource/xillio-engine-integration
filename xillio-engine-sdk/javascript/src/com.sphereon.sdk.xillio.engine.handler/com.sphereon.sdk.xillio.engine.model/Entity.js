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
    define(['com.sphereon.sdk.xillio.engine.handler/ApiClient', 'com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/Decorators'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('./Decorators'));
  } else {
    // Browser globals (root is window)
    if (!root.xillio-engine) {
      root.xillio-engine = {};
    }
    root.xillio-engine.Entity = factory(root.xillio-engine.ApiClient, root.xillio-engine.Decorators);
  }
}(this, function(ApiClient, Decorators) {
  'use strict';




  /**
   * The Entity model module.
   * @module com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/Entity
   * @version 0.1.0
   */

  /**
   * Constructs a new <code>Entity</code>.
   * UDM Entity
   * @alias module:com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/Entity
   * @class
   * @param id {String} An URL that points to the entity.
   */
  var exports = function(id) {
    var _this = this;

    _this['id'] = id;




  };

  /**
   * Constructs a <code>Entity</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/Entity} obj Optional instance to populate.
   * @return {module:com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/Entity} The populated <code>Entity</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('id')) {
        obj['id'] = ApiClient.convertToType(data['id'], 'String');
      }
      if (data.hasOwnProperty('kind')) {
        obj['kind'] = ApiClient.convertToType(data['kind'], 'String');
      }
      if (data.hasOwnProperty('xdip')) {
        obj['xdip'] = ApiClient.convertToType(data['xdip'], 'String');
      }
      if (data.hasOwnProperty('original')) {
        obj['original'] = Decorators.constructFromObject(data['original']);
      }
      if (data.hasOwnProperty('modified')) {
        obj['modified'] = Decorators.constructFromObject(data['modified']);
      }
    }
    return obj;
  }

  /**
   * An URL that points to the entity.
   * @member {String} id
   */
  exports.prototype['id'] = undefined;
  /**
   * A simple content type string that describes the best match for the entity.
   * @member {String} kind
   */
  exports.prototype['kind'] = undefined;
  /**
   * Xdip
   * @member {String} xdip
   */
  exports.prototype['xdip'] = undefined;
  /**
   * @member {module:com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/Decorators} original
   */
  exports.prototype['original'] = undefined;
  /**
   * @member {module:com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/Decorators} modified
   */
  exports.prototype['modified'] = undefined;



  return exports;
}));

