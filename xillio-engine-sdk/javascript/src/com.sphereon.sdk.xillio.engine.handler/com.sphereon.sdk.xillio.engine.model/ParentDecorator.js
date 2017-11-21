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
    define(['com.sphereon.sdk.xillio.engine.handler/ApiClient'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'));
  } else {
    // Browser globals (root is window)
    if (!root.xillio-engine) {
      root.xillio-engine = {};
    }
    root.xillio-engine.ParentDecorator = factory(root.xillio-engine.ApiClient);
  }
}(this, function(ApiClient) {
  'use strict';




  /**
   * The ParentDecorator model module.
   * @module com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/ParentDecorator
   * @version 0.1.0
   */

  /**
   * Constructs a new <code>ParentDecorator</code>.
   * The parent decorator contains a reference to the entity\&quot;s parent.
   * @alias module:com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/ParentDecorator
   * @class
   * @param id {String} The url that points to the entity\"s parent.
   */
  var exports = function(id) {
    var _this = this;

    _this['id'] = id;
  };

  /**
   * Constructs a <code>ParentDecorator</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/ParentDecorator} obj Optional instance to populate.
   * @return {module:com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/ParentDecorator} The populated <code>ParentDecorator</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('id')) {
        obj['id'] = ApiClient.convertToType(data['id'], 'String');
      }
    }
    return obj;
  }

  /**
   * The url that points to the entity\"s parent.
   * @member {String} id
   */
  exports.prototype['id'] = undefined;



  return exports;
}));

