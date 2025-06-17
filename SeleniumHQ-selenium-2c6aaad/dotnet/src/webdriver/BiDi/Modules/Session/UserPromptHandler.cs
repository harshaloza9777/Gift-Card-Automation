// <copyright file="UserPromptHandler.cs" company="Selenium Committers">
// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
// </copyright>

namespace OpenQA.Selenium.BiDi.Modules.Session;

public record UserPromptHandler
{
    public UserPromptHandlerType? Alert { get; set; }

    public UserPromptHandlerType? BeforeUnload { get; set; }

    public UserPromptHandlerType? Confirm { get; set; }

    public UserPromptHandlerType? Default { get; set; }

    public UserPromptHandlerType? File { get; set; }

    public UserPromptHandlerType? Prompt { get; set; }
}

public enum UserPromptHandlerType
{
    Accept,
    Dismiss,
    Ignore
}
