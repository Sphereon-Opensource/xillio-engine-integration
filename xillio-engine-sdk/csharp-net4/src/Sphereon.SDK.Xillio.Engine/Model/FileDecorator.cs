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
    /// The file decorator contains various pieces of information related to files on a file system.
    /// </summary>
    [DataContract]
    public partial class FileDecorator :  IEquatable<FileDecorator>
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="FileDecorator" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected FileDecorator() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="FileDecorator" /> class.
        /// </summary>
        /// <param name="Extension">The (optionally cleaned) extension of the file. (required).</param>
        /// <param name="RawExtension">The extension of the file as found on the filesystem. (required).</param>
        /// <param name="Size">The byte-size of the file in kilobytes. (required).</param>
        public FileDecorator(string Extension = null, string RawExtension = null, decimal? Size = null)
        {
            // to ensure "Extension" is required (not null)
            if (Extension == null)
            {
                throw new InvalidDataException("Extension is a required property for FileDecorator and cannot be null");
            }
            else
            {
                this.Extension = Extension;
            }
            // to ensure "RawExtension" is required (not null)
            if (RawExtension == null)
            {
                throw new InvalidDataException("RawExtension is a required property for FileDecorator and cannot be null");
            }
            else
            {
                this.RawExtension = RawExtension;
            }
            // to ensure "Size" is required (not null)
            if (Size == null)
            {
                throw new InvalidDataException("Size is a required property for FileDecorator and cannot be null");
            }
            else
            {
                this.Size = Size;
            }
        }
        
        /// <summary>
        /// The (optionally cleaned) extension of the file.
        /// </summary>
        /// <value>The (optionally cleaned) extension of the file.</value>
        [DataMember(Name="extension", EmitDefaultValue=false)]
        public string Extension { get; set; }
        /// <summary>
        /// The extension of the file as found on the filesystem.
        /// </summary>
        /// <value>The extension of the file as found on the filesystem.</value>
        [DataMember(Name="rawExtension", EmitDefaultValue=false)]
        public string RawExtension { get; set; }
        /// <summary>
        /// The byte-size of the file in kilobytes.
        /// </summary>
        /// <value>The byte-size of the file in kilobytes.</value>
        [DataMember(Name="size", EmitDefaultValue=false)]
        public decimal? Size { get; set; }
        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class FileDecorator {\n");
            sb.Append("  Extension: ").Append(Extension).Append("\n");
            sb.Append("  RawExtension: ").Append(RawExtension).Append("\n");
            sb.Append("  Size: ").Append(Size).Append("\n");
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
            return this.Equals(obj as FileDecorator);
        }

        /// <summary>
        /// Returns true if FileDecorator instances are equal
        /// </summary>
        /// <param name="other">Instance of FileDecorator to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(FileDecorator other)
        {
            // credit: http://stackoverflow.com/a/10454552/677735
            if (other == null)
                return false;

            return 
                (
                    this.Extension == other.Extension ||
                    this.Extension != null &&
                    this.Extension.Equals(other.Extension)
                ) && 
                (
                    this.RawExtension == other.RawExtension ||
                    this.RawExtension != null &&
                    this.RawExtension.Equals(other.RawExtension)
                ) && 
                (
                    this.Size == other.Size ||
                    this.Size != null &&
                    this.Size.Equals(other.Size)
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
                if (this.Extension != null)
                    hash = hash * 59 + this.Extension.GetHashCode();
                if (this.RawExtension != null)
                    hash = hash * 59 + this.RawExtension.GetHashCode();
                if (this.Size != null)
                    hash = hash * 59 + this.Size.GetHashCode();
                return hash;
            }
        }
    }

}
