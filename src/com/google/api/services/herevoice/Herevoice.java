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
 * This file was generated.
 *  with google-apis-code-generator 1.2.0 (build: 2013-02-14 15:45:00 UTC)
 *  on 2013-02-16 at 23:48:29 UTC 
 */

package com.google.api.services.herevoice;

import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.common.base.Preconditions;

/**
 * Service definition for Herevoice (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link HerevoiceRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * <p>
 * Upgrade warning: this class now extends {@link AbstractGoogleJsonClient}, whereas in prior
 * version 1.8 it extended {@link com.google.api.client.googleapis.services.GoogleClient}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Herevoice extends AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    Preconditions.checkState(GoogleUtils.VERSION.equals("1.13.2-beta"),
        "You are currently running with version %s of google-api-client. " +
        "You need version 1.13.2-beta of google-api-client to run version " +
        "1.13.2-beta of the  library.", GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://herevoice.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "herevoice/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   * @deprecated (scheduled to be removed in 1.13)
   */
  @Deprecated
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport
   * @param jsonFactory JSON factory
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Herevoice(HttpTransport transport, JsonFactory jsonFactory,
      HttpRequestInitializer httpRequestInitializer) {
    super(transport,
        jsonFactory,
        DEFAULT_ROOT_URL,
        DEFAULT_SERVICE_PATH,
        httpRequestInitializer,
        false);
  }

  /**
   * @param transport HTTP transport
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @param rootUrl root URL of the service
   * @param servicePath service path
   * @param jsonObjectParser JSON object parser
   * @param googleClientRequestInitializer Google request initializer or {@code null} for none
   * @param applicationName application name to be sent in the User-Agent header of requests or
   *        {@code null} for none
   * @param suppressPatternChecks whether discovery pattern checks should be suppressed on required
   *        parameters
   */
  Herevoice(HttpTransport transport,
      HttpRequestInitializer httpRequestInitializer,
      String rootUrl,
      String servicePath,
      JsonObjectParser jsonObjectParser,
      GoogleClientRequestInitializer googleClientRequestInitializer,
      String applicationName,
      boolean suppressPatternChecks) {
    super(transport,
        httpRequestInitializer,
        rootUrl,
        servicePath,
        jsonObjectParser,
        googleClientRequestInitializer,
        applicationName,
        suppressPatternChecks);
  }

  @Override
  protected void initialize(AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "comment".
   *
   * This request holds the parameters needed by the the herevoice server.  After setting any optional
   * parameters, call the {@link Comment#execute()} method to invoke the remote operation.
   *
   * @param postid
   * @param text
   * @param lat
   * @param lng
   * @return the request
   */
  public Comment comment(java.lang.String postid, java.lang.String text, java.lang.String lat, java.lang.String lng) throws java.io.IOException {
    Comment result = new Comment(postid, text, lat, lng);
    initialize(result);
    return result;
  }

  public class Comment extends HerevoiceRequest<Void> {

    private static final String REST_PATH = "comment/{postid}/{text}/{lat}/{lng}";

    /**
     * Create a request for the method "comment".
     *
     * This request holds the parameters needed by the the herevoice server.  After setting any
     * optional parameters, call the {@link Comment#execute()} method to invoke the remote operation.
     * <p> {@link Comment#initialize(AbstractGoogleClientRequest)} must be called to initialize this
     * instance immediately after invoking the constructor. </p>
     *
     * @param postid
     * @param text
     * @param lat
     * @param lng
     * @since 1.13
     */
    protected Comment(java.lang.String postid, java.lang.String text, java.lang.String lat, java.lang.String lng) {
      super(Herevoice.this, "POST", REST_PATH, null, Void.class);
      this.postid = Preconditions.checkNotNull(postid, "Required parameter postid must be specified.");
      this.text = Preconditions.checkNotNull(text, "Required parameter text must be specified.");
      this.lat = Preconditions.checkNotNull(lat, "Required parameter lat must be specified.");
      this.lng = Preconditions.checkNotNull(lng, "Required parameter lng must be specified.");
    }

    @Override
    public Comment setAlt(java.lang.String alt) {
      return (Comment) super.setAlt(alt);
    }

    @Override
    public Comment setFields(java.lang.String fields) {
      return (Comment) super.setFields(fields);
    }

    @Override
    public Comment setKey(java.lang.String key) {
      return (Comment) super.setKey(key);
    }

    @Override
    public Comment setOauthToken(java.lang.String oauthToken) {
      return (Comment) super.setOauthToken(oauthToken);
    }

    @Override
    public Comment setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (Comment) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public Comment setQuotaUser(java.lang.String quotaUser) {
      return (Comment) super.setQuotaUser(quotaUser);
    }

    @Override
    public Comment setUserIp(java.lang.String userIp) {
      return (Comment) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String postid;

    /**

     */
    public java.lang.String getPostid() {
      return postid;
    }

    public Comment setPostid(java.lang.String postid) {
      this.postid = postid;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String text;

    /**

     */
    public java.lang.String getText() {
      return text;
    }

    public Comment setText(java.lang.String text) {
      this.text = text;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String lat;

    /**

     */
    public java.lang.String getLat() {
      return lat;
    }

    public Comment setLat(java.lang.String lat) {
      this.lat = lat;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String lng;

    /**

     */
    public java.lang.String getLng() {
      return lng;
    }

    public Comment setLng(java.lang.String lng) {
      this.lng = lng;
      return this;
    }

  }

  /**
   * Create a request for the method "list".
   *
   * This request holds the parameters needed by the the herevoice server.  After setting any optional
   * parameters, call the {@link List#execute()} method to invoke the remote operation.
   *
   * @param lat
   * @param lng
   * @return the request
   */
  public List list(java.lang.String lat, java.lang.String lng) throws java.io.IOException {
    List result = new List(lat, lng);
    initialize(result);
    return result;
  }

  public class List extends HerevoiceRequest<com.google.api.services.herevoice.model.VoiceCollection> {

    private static final String REST_PATH = "voice/{lat}/{lng}";

    /**
     * Create a request for the method "list".
     *
     * This request holds the parameters needed by the the herevoice server.  After setting any
     * optional parameters, call the {@link List#execute()} method to invoke the remote operation. <p>
     * {@link List#initialize(AbstractGoogleClientRequest)} must be called to initialize this instance
     * immediately after invoking the constructor. </p>
     *
     * @param lat
     * @param lng
     * @since 1.13
     */
    protected List(java.lang.String lat, java.lang.String lng) {
      super(Herevoice.this, "GET", REST_PATH, null, com.google.api.services.herevoice.model.VoiceCollection.class);
      this.lat = Preconditions.checkNotNull(lat, "Required parameter lat must be specified.");
      this.lng = Preconditions.checkNotNull(lng, "Required parameter lng must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public List setAlt(java.lang.String alt) {
      return (List) super.setAlt(alt);
    }

    @Override
    public List setFields(java.lang.String fields) {
      return (List) super.setFields(fields);
    }

    @Override
    public List setKey(java.lang.String key) {
      return (List) super.setKey(key);
    }

    @Override
    public List setOauthToken(java.lang.String oauthToken) {
      return (List) super.setOauthToken(oauthToken);
    }

    @Override
    public List setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (List) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public List setQuotaUser(java.lang.String quotaUser) {
      return (List) super.setQuotaUser(quotaUser);
    }

    @Override
    public List setUserIp(java.lang.String userIp) {
      return (List) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String lat;

    /**

     */
    public java.lang.String getLat() {
      return lat;
    }

    public List setLat(java.lang.String lat) {
      this.lat = lat;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String lng;

    /**

     */
    public java.lang.String getLng() {
      return lng;
    }

    public List setLng(java.lang.String lng) {
      this.lng = lng;
      return this;
    }

  }

  /**
   * Create a request for the method "listComment".
   *
   * This request holds the parameters needed by the the herevoice server.  After setting any optional
   * parameters, call the {@link ListComment#execute()} method to invoke the remote operation.
   *
   * @param postid
   * @return the request
   */
  public ListComment listComment(java.lang.String postid) throws java.io.IOException {
    ListComment result = new ListComment(postid);
    initialize(result);
    return result;
  }

  public class ListComment extends HerevoiceRequest<com.google.api.services.herevoice.model.VoiceCollection> {

    private static final String REST_PATH = "voice/{postid}";

    /**
     * Create a request for the method "listComment".
     *
     * This request holds the parameters needed by the the herevoice server.  After setting any
     * optional parameters, call the {@link ListComment#execute()} method to invoke the remote
     * operation. <p> {@link ListComment#initialize(AbstractGoogleClientRequest)} must be called to
     * initialize this instance immediately after invoking the constructor. </p>
     *
     * @param postid
     * @since 1.13
     */
    protected ListComment(java.lang.String postid) {
      super(Herevoice.this, "GET", REST_PATH, null, com.google.api.services.herevoice.model.VoiceCollection.class);
      this.postid = Preconditions.checkNotNull(postid, "Required parameter postid must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public ListComment setAlt(java.lang.String alt) {
      return (ListComment) super.setAlt(alt);
    }

    @Override
    public ListComment setFields(java.lang.String fields) {
      return (ListComment) super.setFields(fields);
    }

    @Override
    public ListComment setKey(java.lang.String key) {
      return (ListComment) super.setKey(key);
    }

    @Override
    public ListComment setOauthToken(java.lang.String oauthToken) {
      return (ListComment) super.setOauthToken(oauthToken);
    }

    @Override
    public ListComment setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListComment) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListComment setQuotaUser(java.lang.String quotaUser) {
      return (ListComment) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListComment setUserIp(java.lang.String userIp) {
      return (ListComment) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String postid;

    /**

     */
    public java.lang.String getPostid() {
      return postid;
    }

    public ListComment setPostid(java.lang.String postid) {
      this.postid = postid;
      return this;
    }

  }

  /**
   * Create a request for the method "make".
   *
   * This request holds the parameters needed by the the herevoice server.  After setting any optional
   * parameters, call the {@link Make#execute()} method to invoke the remote operation.
   *
   * @param text
   * @param lat
   * @param lng
   * @return the request
   */
  public Make make(java.lang.String text, java.lang.String lat, java.lang.String lng) throws java.io.IOException {
    Make result = new Make(text, lat, lng);
    initialize(result);
    return result;
  }

  public class Make extends HerevoiceRequest<Void> {

    private static final String REST_PATH = "make/{text}/{lat}/{lng}";

    /**
     * Create a request for the method "make".
     *
     * This request holds the parameters needed by the the herevoice server.  After setting any
     * optional parameters, call the {@link Make#execute()} method to invoke the remote operation. <p>
     * {@link Make#initialize(AbstractGoogleClientRequest)} must be called to initialize this instance
     * immediately after invoking the constructor. </p>
     *
     * @param text
     * @param lat
     * @param lng
     * @since 1.13
     */
    protected Make(java.lang.String text, java.lang.String lat, java.lang.String lng) {
      super(Herevoice.this, "POST", REST_PATH, null, Void.class);
      this.text = Preconditions.checkNotNull(text, "Required parameter text must be specified.");
      this.lat = Preconditions.checkNotNull(lat, "Required parameter lat must be specified.");
      this.lng = Preconditions.checkNotNull(lng, "Required parameter lng must be specified.");
    }

    @Override
    public Make setAlt(java.lang.String alt) {
      return (Make) super.setAlt(alt);
    }

    @Override
    public Make setFields(java.lang.String fields) {
      return (Make) super.setFields(fields);
    }

    @Override
    public Make setKey(java.lang.String key) {
      return (Make) super.setKey(key);
    }

    @Override
    public Make setOauthToken(java.lang.String oauthToken) {
      return (Make) super.setOauthToken(oauthToken);
    }

    @Override
    public Make setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (Make) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public Make setQuotaUser(java.lang.String quotaUser) {
      return (Make) super.setQuotaUser(quotaUser);
    }

    @Override
    public Make setUserIp(java.lang.String userIp) {
      return (Make) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String text;

    /**

     */
    public java.lang.String getText() {
      return text;
    }

    public Make setText(java.lang.String text) {
      this.text = text;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String lat;

    /**

     */
    public java.lang.String getLat() {
      return lat;
    }

    public Make setLat(java.lang.String lat) {
      this.lat = lat;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String lng;

    /**

     */
    public java.lang.String getLng() {
      return lng;
    }

    public Make setLng(java.lang.String lng) {
      this.lng = lng;
      return this;
    }

  }

  /**
   * Create a request for the method "make2".
   *
   * This request holds the parameters needed by the the herevoice server.  After setting any optional
   * parameters, call the {@link Make2#execute()} method to invoke the remote operation.
   *
   * @param parentID
   * @param localID
   * @param text
   * @param lat
   * @param lng
   * @return the request
   */
  public Make2 make2(java.lang.String parentID, java.lang.String localID, java.lang.String text, java.lang.String lat, java.lang.String lng) throws java.io.IOException {
    Make2 result = new Make2(parentID, localID, text, lat, lng);
    initialize(result);
    return result;
  }

  public class Make2 extends HerevoiceRequest<com.google.api.services.herevoice.model.Voice> {

    private static final String REST_PATH = "make2/{parentID}/{localID}/{text}/{lat}/{lng}";

    /**
     * Create a request for the method "make2".
     *
     * This request holds the parameters needed by the the herevoice server.  After setting any
     * optional parameters, call the {@link Make2#execute()} method to invoke the remote operation.
     * <p> {@link Make2#initialize(AbstractGoogleClientRequest)} must be called to initialize this
     * instance immediately after invoking the constructor. </p>
     *
     * @param parentID
     * @param localID
     * @param text
     * @param lat
     * @param lng
     * @since 1.13
     */
    protected Make2(java.lang.String parentID, java.lang.String localID, java.lang.String text, java.lang.String lat, java.lang.String lng) {
      super(Herevoice.this, "POST", REST_PATH, null, com.google.api.services.herevoice.model.Voice.class);
      this.parentID = Preconditions.checkNotNull(parentID, "Required parameter parentID must be specified.");
      this.localID = Preconditions.checkNotNull(localID, "Required parameter localID must be specified.");
      this.text = Preconditions.checkNotNull(text, "Required parameter text must be specified.");
      this.lat = Preconditions.checkNotNull(lat, "Required parameter lat must be specified.");
      this.lng = Preconditions.checkNotNull(lng, "Required parameter lng must be specified.");
    }

    @Override
    public Make2 setAlt(java.lang.String alt) {
      return (Make2) super.setAlt(alt);
    }

    @Override
    public Make2 setFields(java.lang.String fields) {
      return (Make2) super.setFields(fields);
    }

    @Override
    public Make2 setKey(java.lang.String key) {
      return (Make2) super.setKey(key);
    }

    @Override
    public Make2 setOauthToken(java.lang.String oauthToken) {
      return (Make2) super.setOauthToken(oauthToken);
    }

    @Override
    public Make2 setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (Make2) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public Make2 setQuotaUser(java.lang.String quotaUser) {
      return (Make2) super.setQuotaUser(quotaUser);
    }

    @Override
    public Make2 setUserIp(java.lang.String userIp) {
      return (Make2) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String parentID;

    /**

     */
    public java.lang.String getParentID() {
      return parentID;
    }

    public Make2 setParentID(java.lang.String parentID) {
      this.parentID = parentID;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String localID;

    /**

     */
    public java.lang.String getLocalID() {
      return localID;
    }

    public Make2 setLocalID(java.lang.String localID) {
      this.localID = localID;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String text;

    /**

     */
    public java.lang.String getText() {
      return text;
    }

    public Make2 setText(java.lang.String text) {
      this.text = text;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String lat;

    /**

     */
    public java.lang.String getLat() {
      return lat;
    }

    public Make2 setLat(java.lang.String lat) {
      this.lat = lat;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String lng;

    /**

     */
    public java.lang.String getLng() {
      return lng;
    }

    public Make2 setLng(java.lang.String lng) {
      this.lng = lng;
      return this;
    }

  }

  /**
   * Builder for {@link Herevoice}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport
     * @param jsonFactory JSON factory
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(HttpTransport transport, JsonFactory jsonFactory,
        HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link Herevoice}. */
    @Override
    public Herevoice build() {
      return new Herevoice(getTransport(),
          getHttpRequestInitializer(),
          getRootUrl(),
          getServicePath(),
          getObjectParser(),
          getGoogleClientRequestInitializer(),
          getApplicationName(),
          getSuppressPatternChecks());
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    /**
     * Set the {@link HerevoiceRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setHerevoiceRequestInitializer(
        HerevoiceRequestInitializer herevoiceRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(herevoiceRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
