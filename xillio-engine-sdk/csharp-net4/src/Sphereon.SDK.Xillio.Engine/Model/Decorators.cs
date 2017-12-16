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
    /// Decorators
    /// </summary>
    [DataContract]
    public partial class Decorators :  IEquatable<Decorators>
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Decorators" /> class.
        /// </summary>
        /// <param name="Container">Container.</param>
        /// <param name="Created">Created.</param>
        /// <param name="Description">Description.</param>
        /// <param name="File">File.</param>
        /// <param name="Filesystem">Filesystem.</param>
        /// <param name="Hash">Hash.</param>
        /// <param name="MimeType">MimeType.</param>
        /// <param name="Modified">Modified.</param>
        /// <param name="Name">Name.</param>
        /// <param name="Parent">Parent.</param>
        /// <param name="Preview">Preview.</param>
        /// <param name="Properties">Properties.</param>
        /// <param name="Version">Version.</param>
        public Decorators(ContainerDecorator Container = null, CreatedDecorator Created = null, DescriptionDecorator Description = null, FileDecorator File = null, FileSystemDecorator Filesystem = null, HashDecorator Hash = null, MimeTypeDecorator MimeType = null, ModifiedDecorator Modified = null, NameDecorator Name = null, ParentDecorator Parent = null, PreviewDecorator Preview = null, PropertiesDecorator Properties = null, VersionDecorator Version = null)
        {
            this.Container = Container;
            this.Created = Created;
            this.Description = Description;
            this.File = File;
            this.Filesystem = Filesystem;
            this.Hash = Hash;
            this.MimeType = MimeType;
            this.Modified = Modified;
            this.Name = Name;
            this.Parent = Parent;
            this.Preview = Preview;
            this.Properties = Properties;
            this.Version = Version;
        }
        
        /// <summary>
        /// Gets or Sets Container
        /// </summary>
        [DataMember(Name="container", EmitDefaultValue=false)]
        public ContainerDecorator Container { get; set; }
        /// <summary>
        /// Gets or Sets Created
        /// </summary>
        [DataMember(Name="created", EmitDefaultValue=false)]
        public CreatedDecorator Created { get; set; }
        /// <summary>
        /// Gets or Sets Description
        /// </summary>
        [DataMember(Name="description", EmitDefaultValue=false)]
        public DescriptionDecorator Description { get; set; }
        /// <summary>
        /// Gets or Sets File
        /// </summary>
        [DataMember(Name="file", EmitDefaultValue=false)]
        public FileDecorator File { get; set; }
        /// <summary>
        /// Gets or Sets Filesystem
        /// </summary>
        [DataMember(Name="filesystem", EmitDefaultValue=false)]
        public FileSystemDecorator Filesystem { get; set; }
        /// <summary>
        /// Gets or Sets Hash
        /// </summary>
        [DataMember(Name="hash", EmitDefaultValue=false)]
        public HashDecorator Hash { get; set; }
        /// <summary>
        /// Gets or Sets MimeType
        /// </summary>
        [DataMember(Name="mimeType", EmitDefaultValue=false)]
        public MimeTypeDecorator MimeType { get; set; }
        /// <summary>
        /// Gets or Sets Modified
        /// </summary>
        [DataMember(Name="modified", EmitDefaultValue=false)]
        public ModifiedDecorator Modified { get; set; }
        /// <summary>
        /// Gets or Sets Name
        /// </summary>
        [DataMember(Name="name", EmitDefaultValue=false)]
        public NameDecorator Name { get; set; }
        /// <summary>
        /// Gets or Sets Parent
        /// </summary>
        [DataMember(Name="parent", EmitDefaultValue=false)]
        public ParentDecorator Parent { get; set; }
        /// <summary>
        /// Gets or Sets Preview
        /// </summary>
        [DataMember(Name="preview", EmitDefaultValue=false)]
        public PreviewDecorator Preview { get; set; }
        /// <summary>
        /// Gets or Sets Properties
        /// </summary>
        [DataMember(Name="properties", EmitDefaultValue=false)]
        public PropertiesDecorator Properties { get; set; }
        /// <summary>
        /// Gets or Sets Version
        /// </summary>
        [DataMember(Name="version", EmitDefaultValue=false)]
        public VersionDecorator Version { get; set; }
        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class Decorators {\n");
            sb.Append("  Container: ").Append(Container).Append("\n");
            sb.Append("  Created: ").Append(Created).Append("\n");
            sb.Append("  Description: ").Append(Description).Append("\n");
            sb.Append("  File: ").Append(File).Append("\n");
            sb.Append("  Filesystem: ").Append(Filesystem).Append("\n");
            sb.Append("  Hash: ").Append(Hash).Append("\n");
            sb.Append("  MimeType: ").Append(MimeType).Append("\n");
            sb.Append("  Modified: ").Append(Modified).Append("\n");
            sb.Append("  Name: ").Append(Name).Append("\n");
            sb.Append("  Parent: ").Append(Parent).Append("\n");
            sb.Append("  Preview: ").Append(Preview).Append("\n");
            sb.Append("  Properties: ").Append(Properties).Append("\n");
            sb.Append("  Version: ").Append(Version).Append("\n");
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
            return this.Equals(obj as Decorators);
        }

        /// <summary>
        /// Returns true if Decorators instances are equal
        /// </summary>
        /// <param name="other">Instance of Decorators to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(Decorators other)
        {
            // credit: http://stackoverflow.com/a/10454552/677735
            if (other == null)
                return false;

            return 
                (
                    this.Container == other.Container ||
                    this.Container != null &&
                    this.Container.Equals(other.Container)
                ) && 
                (
                    this.Created == other.Created ||
                    this.Created != null &&
                    this.Created.Equals(other.Created)
                ) && 
                (
                    this.Description == other.Description ||
                    this.Description != null &&
                    this.Description.Equals(other.Description)
                ) && 
                (
                    this.File == other.File ||
                    this.File != null &&
                    this.File.Equals(other.File)
                ) && 
                (
                    this.Filesystem == other.Filesystem ||
                    this.Filesystem != null &&
                    this.Filesystem.Equals(other.Filesystem)
                ) && 
                (
                    this.Hash == other.Hash ||
                    this.Hash != null &&
                    this.Hash.Equals(other.Hash)
                ) && 
                (
                    this.MimeType == other.MimeType ||
                    this.MimeType != null &&
                    this.MimeType.Equals(other.MimeType)
                ) && 
                (
                    this.Modified == other.Modified ||
                    this.Modified != null &&
                    this.Modified.Equals(other.Modified)
                ) && 
                (
                    this.Name == other.Name ||
                    this.Name != null &&
                    this.Name.Equals(other.Name)
                ) && 
                (
                    this.Parent == other.Parent ||
                    this.Parent != null &&
                    this.Parent.Equals(other.Parent)
                ) && 
                (
                    this.Preview == other.Preview ||
                    this.Preview != null &&
                    this.Preview.Equals(other.Preview)
                ) && 
                (
                    this.Properties == other.Properties ||
                    this.Properties != null &&
                    this.Properties.Equals(other.Properties)
                ) && 
                (
                    this.Version == other.Version ||
                    this.Version != null &&
                    this.Version.Equals(other.Version)
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
                if (this.Container != null)
                    hash = hash * 59 + this.Container.GetHashCode();
                if (this.Created != null)
                    hash = hash * 59 + this.Created.GetHashCode();
                if (this.Description != null)
                    hash = hash * 59 + this.Description.GetHashCode();
                if (this.File != null)
                    hash = hash * 59 + this.File.GetHashCode();
                if (this.Filesystem != null)
                    hash = hash * 59 + this.Filesystem.GetHashCode();
                if (this.Hash != null)
                    hash = hash * 59 + this.Hash.GetHashCode();
                if (this.MimeType != null)
                    hash = hash * 59 + this.MimeType.GetHashCode();
                if (this.Modified != null)
                    hash = hash * 59 + this.Modified.GetHashCode();
                if (this.Name != null)
                    hash = hash * 59 + this.Name.GetHashCode();
                if (this.Parent != null)
                    hash = hash * 59 + this.Parent.GetHashCode();
                if (this.Preview != null)
                    hash = hash * 59 + this.Preview.GetHashCode();
                if (this.Properties != null)
                    hash = hash * 59 + this.Properties.GetHashCode();
                if (this.Version != null)
                    hash = hash * 59 + this.Version.GetHashCode();
                return hash;
            }
        }
    }

}
