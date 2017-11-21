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
    root.xillio-engine.FileDecorator = factory(root.xillio-engine.ApiClient);
  }
}(this, function(ApiClient) {
  'use strict';




  /**
   * The FileDecorator model module.
   * @module com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/FileDecorator
   * @version 0.1.0
   */

  /**
   * Constructs a new <code>FileDecorator</code>.
   * The file decorator contains various pieces of information related to files on a file system.
   * @alias module:com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/FileDecorator
   * @class
   * @param extension {String} The (optionally cleaned) extension of the file.
   * @param rawExtension {String} The extension of the file as found on the filesystem.
   * @param size {Number} The byte-size of the file in kilobytes.
   */
  var exports = function(extension, rawExtension, size) {
    var _this = this;

    _this['extension'] = extension;
    _this['rawExtension'] = rawExtension;
    _this['size'] = size;
  };

  /**
   * Constructs a <code>FileDecorator</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/FileDecorator} obj Optional instance to populate.
   * @return {module:com.sphereon.sdk.xillio.engine.handler/com.sphereon.sdk.xillio.engine.model/FileDecorator} The populated <code>FileDecorator</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('extension')) {
        obj['extension'] = ApiClient.convertToType(data['extension'], 'String');
      }
      if (data.hasOwnProperty('rawExtension')) {
        obj['rawExtension'] = ApiClient.convertToType(data['rawExtension'], 'String');
      }
      if (data.hasOwnProperty('size')) {
        obj['size'] = ApiClient.convertToType(data['size'], 'Number');
      }
    }
    return obj;
  }

  /**
   * The (optionally cleaned) extension of the file.
   * @member {String} extension
   */
  exports.prototype['extension'] = undefined;
  /**
   * The extension of the file as found on the filesystem.
   * @member {String} rawExtension
   */
  exports.prototype['rawExtension'] = undefined;
  /**
   * The byte-size of the file in kilobytes.
   * @member {Number} size
   */
  exports.prototype['size'] = undefined;



  return exports;
}));


