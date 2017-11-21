/* 
 * Xillio Engine
 *
 * No descripton provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 0.1
 * Contact: dev@sphereon.com
 * Generated by: https://github.com/swagger-api/swagger-codegen.git
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

using System;
using System.Linq;
using System.IO;
using System.Text;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Runtime.Serialization;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;

namespace Sphereon.SDK.Xillio.Engine.Model
{
    /// <summary>
    /// The mimeType decorator contains a reference to the type of media that is contained by the entity. A list of types can be found on http://www.freeformatter.com/mime-types-list.html.
    /// </summary>
    [DataContract]
    public partial class MimeTypeDecorator :  IEquatable<MimeTypeDecorator>
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="MimeTypeDecorator" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected MimeTypeDecorator() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="MimeTypeDecorator" /> class.
        /// </summary>
        /// <param name="Type">The MIME Type of the entity\&quot;s binary contents. (required).</param>
        public MimeTypeDecorator(string Type = null)
        {
            // to ensure "Type" is required (not null)
            if (Type == null)
            {
                throw new InvalidDataException("Type is a required property for MimeTypeDecorator and cannot be null");
            }
            else
            {
                this.Type = Type;
            }
        }
        
        /// <summary>
        /// The MIME Type of the entity\&quot;s binary contents.
        /// </summary>
        /// <value>The MIME Type of the entity\&quot;s binary contents.</value>
        [DataMember(Name="type", EmitDefaultValue=false)]
        public string Type { get; set; }
        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class MimeTypeDecorator {\n");
            sb.Append("  Type: ").Append(Type).Append("\n");
            sb.Append("}\n");
            return sb.ToString();
        }
  
        /// <summary>
        /// Returns the JSON string presentation of the object
        /// </summary>
        /// <returns>JSON string presentation of the object</returns>
        public string ToJson()
        {
            return JsonConvert.SerializeObject(this, Formatting.Indented);
        }

        /// <summary>
        /// Returns true if objects are equal
        /// </summary>
        /// <param name="obj">Object to be compared</param>
        /// <returns>Boolean</returns>
        public override bool Equals(object obj)
        {
            // credit: http://stackoverflow.com/a/10454552/677735
            return this.Equals(obj as MimeTypeDecorator);
        }

        /// <summary>
        /// Returns true if MimeTypeDecorator instances are equal
        /// </summary>
        /// <param name="other">Instance of MimeTypeDecorator to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(MimeTypeDecorator other)
        {
            // credit: http://stackoverflow.com/a/10454552/677735
            if (other == null)
                return false;

            return 
                (
                    this.Type == other.Type ||
                    this.Type != null &&
                    this.Type.Equals(other.Type)
                );
        }

        /// <summary>
        /// Gets the hash code
        /// </summary>
        /// <returns>Hash code</returns>
        public override int GetHashCode()
        {
            // credit: http://stackoverflow.com/a/263416/677735
            unchecked // Overflow is fine, just wrap
            {
                int hash = 41;
                // Suitable nullity checks etc, of course :)
                if (this.Type != null)
                    hash = hash * 59 + this.Type.GetHashCode();
                return hash;
            }
        }
    }

}
