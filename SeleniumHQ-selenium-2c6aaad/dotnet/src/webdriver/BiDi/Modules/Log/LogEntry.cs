// <copyright file="LogEntry.cs" company="Selenium Committers">
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

using System;
using System.Collections.Generic;

namespace OpenQA.Selenium.BiDi.Modules.Log;

// https://github.com/dotnet/runtime/issues/72604
//[JsonPolymorphic(TypeDiscriminatorPropertyName = "type")]
//[JsonDerivedType(typeof(GenericLogEntry))] // Fallback when discriminator is not recognized, we have to double check
//[JsonDerivedType(typeof(ConsoleLogEntry), "console")]
//[JsonDerivedType(typeof(JavascriptLogEntry), "javascript")]
public abstract record LogEntry(BiDi BiDi, Level Level, Script.Source Source, string Text, DateTimeOffset Timestamp)
    : EventArgs(BiDi)
{
    public Script.StackTrace? StackTrace { get; set; }
}

public record GenericLogEntry(BiDi BiDi, string Type, Level Level, Script.Source Source, string Text, DateTimeOffset Timestamp)
    : LogEntry(BiDi, Level, Source, Text, Timestamp);

public record ConsoleLogEntry(BiDi BiDi, Level Level, Script.Source Source, string Text, DateTimeOffset Timestamp, string Method, IReadOnlyList<Script.RemoteValue> Args)
    : LogEntry(BiDi, Level, Source, Text, Timestamp);

public record JavascriptLogEntry(BiDi BiDi, Level Level, Script.Source Source, string Text, DateTimeOffset Timestamp)
    : LogEntry(BiDi, Level, Source, Text, Timestamp);

public enum Level
{
    Debug,
    Info,
    Warn,
    Error
}
