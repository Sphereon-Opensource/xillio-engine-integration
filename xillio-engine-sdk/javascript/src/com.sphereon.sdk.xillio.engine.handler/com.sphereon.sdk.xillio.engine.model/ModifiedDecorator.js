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
    root.xillio-engine.ModifiedDecorator = factory(root.xillio-engine.ApiClient);
  }
}(this, function(ApiClient) {
  'use strict';




  /**
   * The ModifiedDecorator model module.
   * @module com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/ModifiedDecorator
   * @version 0.1.0
   */

  /**
   * Constructs a new <code>ModifiedDecorator</code>.
   * The modified decorator signifies when an entity was last modified.
   * @alias module:com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/ModifiedDecorator
   * @class
   * @param _date {Date} The last modification date of the entity.
   */
  var exports = function(_date) {
    var _this = this;

    _this['date'] = _date;

  };

  /**
   * Constructs a <code>ModifiedDecorator</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/ModifiedDecorator} obj Optional instance to populate.
   * @return {module:com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/ModifiedDecorator} The populated <code>ModifiedDecorator</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('date')) {
        obj['date'] = ApiClient.convertToType(data['date'], 'Date');
      }
      if (data.hasOwnProperty('by')) {
        obj['by'] = ApiClient.convertToType(data['by'], 'String');
      }
    }
    return obj;
  }

  /**
   * The last modification date of the entity.
   * @member {Date} date
   */
  exports.prototype['date'] = undefined;
  /**
   * The name of the user or entity that last modified this entity.
   * @member {String} by
   */
  exports.prototype['by'] = undefined;



  return exports;
}));

