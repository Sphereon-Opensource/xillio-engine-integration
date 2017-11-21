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
    /// UDM Entity
    /// </summary>
    [DataContract]
    public partial class Entity :  IEquatable<Entity>
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Entity" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected Entity() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="Entity" /> class.
        /// </summary>
        /// <param name="Id">An URL that points to the entity. (required).</param>
        /// <param name="Kind">A simple content type string that describes the best match for the entity..</param>
        /// <param name="Xdip">Xdip.</param>
        /// <param name="Original">Original.</param>
        /// <param name="Modified">Modified.</param>
        public Entity(string Id = null, string Kind = null, string Xdip = null, Decorators Original = null, Decorators Modified = null)
        {
            // to ensure "Id" is required (not null)
            if (Id == null)
            {
                throw new InvalidDataException("Id is a required property for Entity and cannot be null");
            }
            else
            {
                this.Id = Id;
            }
            this.Kind = Kind;
            this.Xdip = Xdip;
            this.Original = Original;
            this.Modified = Modified;
        }
        
        /// <summary>
        /// An URL that points to the entity.
        /// </summary>
        /// <value>An URL that points to the entity.</value>
        [DataMember(Name="id", EmitDefaultValue=false)]
        public string Id { get; set; }
        /// <summary>
        /// A simple content type string that describes the best match for the entity.
        /// </summary>
        /// <value>A simple content type string that describes the best match for the entity.</value>
        [DataMember(Name="kind", EmitDefaultValue=false)]
        public string Kind { get; set; }
        /// <summary>
        /// Xdip
        /// </summary>
        /// <value>Xdip</value>
        [DataMember(Name="xdip", EmitDefaultValue=false)]
        public string Xdip { get; set; }
        /// <summary>
        /// Gets or Sets Original
        /// </summary>
        [DataMember(Name="original", EmitDefaultValue=false)]
        public Decorators Original { get; set; }
        /// <summary>
        /// Gets or Sets Modified
        /// </summary>
        [DataMember(Name="modified", EmitDefaultValue=false)]
        public Decorators Modified { get; set; }
        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class Entity {\n");
            sb.Append("  Id: ").Append(Id).Append("\n");
            sb.Append("  Kind: ").Append(Kind).Append("\n");
            sb.Append("  Xdip: ").Append(Xdip).Append("\n");
            sb.Append("  Original: ").Append(Original).Append("\n");
            sb.Append("  Modified: ").Append(Modified).Append("\n");
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
            return this.Equals(obj as Entity);
        }

        /// <summary>
        /// Returns true if Entity instances are equal
        /// </summary>
        /// <param name="other">Instance of Entity to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(Entity other)
        {
            // credit: http://stackoverflow.com/a/10454552/677735
            if (other == null)
                return false;

            return 
                (
                    this.Id == other.Id ||
                    this.Id != null &&
                    this.Id.Equals(other.Id)
                ) && 
                (
                    this.Kind == other.Kind ||
                    this.Kind != null &&
                    this.Kind.Equals(other.Kind)
                ) && 
                (
                    this.Xdip == other.Xdip ||
                    this.Xdip != null &&
                    this.Xdip.Equals(other.Xdip)
                ) && 
                (
                    this.Original == other.Original ||
                    this.Original != null &&
                    this.Original.Equals(other.Original)
                ) && 
                (
                    this.Modified == other.Modified ||
                    this.Modified != null &&
                    this.Modified.Equals(other.Modified)
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
                if (this.Id != null)
                    hash = hash * 59 + this.Id.GetHashCode();
                if (this.Kind != null)
                    hash = hash * 59 + this.Kind.GetHashCode();
                if (this.Xdip != null)
                    hash = hash * 59 + this.Xdip.GetHashCode();
                if (this.Original != null)
                    hash = hash * 59 + this.Original.GetHashCode();
                if (this.Modified != null)
                    hash = hash * 59 + this.Modified.GetHashCode();
                return hash;
            }
        }
    }

}