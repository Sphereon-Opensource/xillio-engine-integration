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
using System.IO;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Reflection;
using RestSharp;
using NUnit.Framework;

using Sphereon.SDK.Xillio.Engine.Client;
using Sphereon.SDK.Xillio.Engine.Api;
using Sphereon.SDK.Xillio.Engine.Model;

namespace Sphereon.SDK.Xillio.Engine.Test
{
    /// <summary>
    ///  Class for testing EntityApi
    /// </summary>
    /// <remarks>
    /// This file is automatically generated by Swagger Codegen.
    /// Please update the test case below to test the API endpoint.
    /// </remarks>
    [TestFixture]
    public class EntityApiTests
    {
        private EntityApi instance;

        /// <summary>
        /// Setup before each unit test
        /// </summary>
        [SetUp]
        public void Init()
        {
            instance = new EntityApi();
        }

        /// <summary>
        /// Clean up after each unit test
        /// </summary>
        [TearDown]
        public void Cleanup()
        {

        }

        /// <summary>
        /// Test an instance of EntityApi
        /// </summary>
        [Test]
        public void InstanceTest()
        {
            // TODO uncomment below to test 'IsInstanceOfType' EntityApi
            //Assert.IsInstanceOfType(typeof(EntityApi), instance, "instance is a EntityApi");
        }

        
        /// <summary>
        /// Test CreateEntity
        /// </summary>
        [Test]
        public void CreateEntityTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string configurationId = null;
            //string path = null;
            //List<string> scope = null;
            //string include = null;
            //string exclude = null;
            //string entity = null;
            //string contents = null;
            //var response = instance.CreateEntity(configurationId, path, scope, include, exclude, entity, contents);
            //Assert.IsInstanceOf<EntityResponse> (response, "response is EntityResponse");
        }
        
        /// <summary>
        /// Test DeleteEntity
        /// </summary>
        [Test]
        public void DeleteEntityTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string configurationId = null;
            //string path = null;
            //instance.DeleteEntity(configurationId, path);
            
        }
        
        /// <summary>
        /// Test GetEntity
        /// </summary>
        [Test]
        public void GetEntityTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string configurationId = null;
            //string path = null;
            //List<string> scope = null;
            //string include = null;
            //string exclude = null;
            //var response = instance.GetEntity(configurationId, path, scope, include, exclude);
            //Assert.IsInstanceOf<EntityResponse> (response, "response is EntityResponse");
        }
        
        /// <summary>
        /// Test ListEntities
        /// </summary>
        [Test]
        public void ListEntitiesTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //List<string> scope = null;
            //string include = null;
            //string exclude = null;
            //var response = instance.ListEntities(scope, include, exclude);
            //Assert.IsInstanceOf<EntityResponse> (response, "response is EntityResponse");
        }
        
        /// <summary>
        /// Test UpdateEntity
        /// </summary>
        [Test]
        public void UpdateEntityTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string configurationId = null;
            //string path = null;
            //List<string> scope = null;
            //string include = null;
            //string exclude = null;
            //EntityResponse entity = null;
            //var response = instance.UpdateEntity(configurationId, path, scope, include, exclude, entity);
            //Assert.IsInstanceOf<EntityResponse> (response, "response is EntityResponse");
        }
        
    }

}