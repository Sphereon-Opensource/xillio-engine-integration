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
    /// The version decorator contains the version number of the entity.
    /// </summary>
    [DataContract]
    public partial class VersionDecorator :  IEquatable<VersionDecorator>
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="VersionDecorator" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected VersionDecorator() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="VersionDecorator" /> class.
        /// </summary>
        /// <param name="Tag">The version number or tag of this entity. (required).</param>
        public VersionDecorator(string Tag = null)
        {
            // to ensure "Tag" is required (not null)
            if (Tag == null)
            {
                throw new InvalidDataException("Tag is a required property for VersionDecorator and cannot be null");
            }
            else
            {
                this.Tag = Tag;
            }
        }
        
        /// <summary>
        /// The version number or tag of this entity.
        /// </summary>
        /// <value>The version number or tag of this entity.</value>
        [DataMember(Name="tag", EmitDefaultValue=false)]
        public string Tag { get; set; }
        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class VersionDecorator {\n");
            sb.Append("  Tag: ").Append(Tag).Append("\n");
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
            return this.Equals(obj as VersionDecorator);
        }

        /// <summary>
        /// Returns true if VersionDecorator instances are equal
        /// </summary>
        /// <param name="other">Instance of VersionDecorator to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(VersionDecorator other)
        {
            // credit: http://stackoverflow.com/a/10454552/677735
            if (other == null)
                return false;

            return 
                (
                    this.Tag == other.Tag ||
                    this.Tag != null &&
                    this.Tag.Equals(other.Tag)
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
                if (this.Tag != null)
                    hash = hash * 59 + this.Tag.GetHashCode();
                return hash;
            }
        }
    }

}