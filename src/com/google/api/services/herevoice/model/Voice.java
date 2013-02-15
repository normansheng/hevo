/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * Warning! This file is generated. Modify at your own risk.
 */

package com.google.api.services.herevoice.model;

import com.google.api.client.json.GenericJson;

/**
 * Model definition for Voice.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the . For a detailed explanation see:
 * <a href="http://code.google.com/p/google-api-java-client/wiki/Json">http://code.google.com/p/google-api-java-client/wiki/Json</a>
 * </p>
 *
 * <p>
 * Upgrade warning: starting with version 1.12 {@code getResponseHeaders()} is removed, instead use
 * {@link com.google.api.client.http.json.JsonHttpRequest#getLastResponseHeaders()}
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Voice extends GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.util.List<Voice> comments;

  static {
    // hack to force ProGuard to consider Voice used, since otherwise it would be stripped out
    // see http://code.google.com/p/google-api-java-client/issues/detail?id=528
    com.google.api.client.util.Data.nullOf(Voice.class);
  }

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime voiceDate;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String voiceID;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String voiceText;

  /**

   * The value returned may be {@code null}.
   */
  public java.util.List<Voice> getComments() {
    return comments;
  }

  /**

   * The value set may be {@code null}.
   */
  public Voice setComments(java.util.List<Voice> comments) {
    this.comments = comments;
    return this;
  }

  /**

   * The value returned may be {@code null}.
   */
  public com.google.api.client.util.DateTime getVoiceDate() {
    return voiceDate;
  }

  /**

   * The value set may be {@code null}.
   */
  public Voice setVoiceDate(com.google.api.client.util.DateTime voiceDate) {
    this.voiceDate = voiceDate;
    return this;
  }

  /**

   * The value returned may be {@code null}.
   */
  public java.lang.String getVoiceID() {
    return voiceID;
  }

  /**

   * The value set may be {@code null}.
   */
  public Voice setVoiceID(java.lang.String voiceID) {
    this.voiceID = voiceID;
    return this;
  }

  /**

   * The value returned may be {@code null}.
   */
  public java.lang.String getVoiceText() {
    return voiceText;
  }

  /**

   * The value set may be {@code null}.
   */
  public Voice setVoiceText(java.lang.String voiceText) {
    this.voiceText = voiceText;
    return this;
  }

}
