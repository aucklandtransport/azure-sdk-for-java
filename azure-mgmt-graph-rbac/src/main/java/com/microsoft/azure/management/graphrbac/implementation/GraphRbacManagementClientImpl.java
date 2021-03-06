/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.graphrbac.implementation;

import com.microsoft.azure.AzureClient;
import com.microsoft.azure.AzureServiceClient;
import com.microsoft.rest.credentials.ServiceClientCredentials;
import com.microsoft.rest.RestClient;

/**
 * Initializes a new instance of the GraphRbacManagementClientImpl class.
 */
public class GraphRbacManagementClientImpl extends AzureServiceClient {
    /** the {@link AzureClient} used for long running operations. */
    private AzureClient azureClient;

    /**
     * Gets the {@link AzureClient} used for long running operations.
     * @return the azure client;
     */
    public AzureClient getAzureClient() {
        return this.azureClient;
    }

    /** Client API version. */
    private String apiVersion;

    /**
     * Gets Client API version.
     *
     * @return the apiVersion value.
     */
    public String apiVersion() {
        return this.apiVersion;
    }

    /** The tenant ID. */
    private String tenantID;

    /**
     * Gets The tenant ID.
     *
     * @return the tenantID value.
     */
    public String tenantID() {
        return this.tenantID;
    }

    /**
     * Sets The tenant ID.
     *
     * @param tenantID the tenantID value.
     * @return the service client itself
     */
    public GraphRbacManagementClientImpl withTenantID(String tenantID) {
        this.tenantID = tenantID;
        return this;
    }

    /** Gets or sets the preferred language for the response. */
    private String acceptLanguage;

    /**
     * Gets Gets or sets the preferred language for the response.
     *
     * @return the acceptLanguage value.
     */
    public String acceptLanguage() {
        return this.acceptLanguage;
    }

    /**
     * Sets Gets or sets the preferred language for the response.
     *
     * @param acceptLanguage the acceptLanguage value.
     * @return the service client itself
     */
    public GraphRbacManagementClientImpl withAcceptLanguage(String acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
        return this;
    }

    /** Gets or sets the retry timeout in seconds for Long Running Operations. Default value is 30. */
    private int longRunningOperationRetryTimeout;

    /**
     * Gets Gets or sets the retry timeout in seconds for Long Running Operations. Default value is 30.
     *
     * @return the longRunningOperationRetryTimeout value.
     */
    public int longRunningOperationRetryTimeout() {
        return this.longRunningOperationRetryTimeout;
    }

    /**
     * Sets Gets or sets the retry timeout in seconds for Long Running Operations. Default value is 30.
     *
     * @param longRunningOperationRetryTimeout the longRunningOperationRetryTimeout value.
     * @return the service client itself
     */
    public GraphRbacManagementClientImpl withLongRunningOperationRetryTimeout(int longRunningOperationRetryTimeout) {
        this.longRunningOperationRetryTimeout = longRunningOperationRetryTimeout;
        return this;
    }

    /** When set to true a unique x-ms-client-request-id value is generated and included in each request. Default is true. */
    private boolean generateClientRequestId;

    /**
     * Gets When set to true a unique x-ms-client-request-id value is generated and included in each request. Default is true.
     *
     * @return the generateClientRequestId value.
     */
    public boolean generateClientRequestId() {
        return this.generateClientRequestId;
    }

    /**
     * Sets When set to true a unique x-ms-client-request-id value is generated and included in each request. Default is true.
     *
     * @param generateClientRequestId the generateClientRequestId value.
     * @return the service client itself
     */
    public GraphRbacManagementClientImpl withGenerateClientRequestId(boolean generateClientRequestId) {
        this.generateClientRequestId = generateClientRequestId;
        return this;
    }

    /**
     * The ObjectsInner object to access its operations.
     */
    private ObjectsInner objects;

    /**
     * Gets the ObjectsInner object to access its operations.
     * @return the ObjectsInner object.
     */
    public ObjectsInner objects() {
        return this.objects;
    }

    /**
     * The ApplicationsInner object to access its operations.
     */
    private ApplicationsInner applications;

    /**
     * Gets the ApplicationsInner object to access its operations.
     * @return the ApplicationsInner object.
     */
    public ApplicationsInner applications() {
        return this.applications;
    }

    /**
     * The GroupsInner object to access its operations.
     */
    private GroupsInner groups;

    /**
     * Gets the GroupsInner object to access its operations.
     * @return the GroupsInner object.
     */
    public GroupsInner groups() {
        return this.groups;
    }

    /**
     * The ServicePrincipalsInner object to access its operations.
     */
    private ServicePrincipalsInner servicePrincipals;

    /**
     * Gets the ServicePrincipalsInner object to access its operations.
     * @return the ServicePrincipalsInner object.
     */
    public ServicePrincipalsInner servicePrincipals() {
        return this.servicePrincipals;
    }

    /**
     * The UsersInner object to access its operations.
     */
    private UsersInner users;

    /**
     * Gets the UsersInner object to access its operations.
     * @return the UsersInner object.
     */
    public UsersInner users() {
        return this.users;
    }

    /**
     * Initializes an instance of GraphRbacManagementClient client.
     *
     * @param credentials the management credentials for Azure
     */
    public GraphRbacManagementClientImpl(ServiceClientCredentials credentials) {
        this("https://graph.windows.net", credentials);
    }

    /**
     * Initializes an instance of GraphRbacManagementClient client.
     *
     * @param baseUrl the base URL of the host
     * @param credentials the management credentials for Azure
     */
    public GraphRbacManagementClientImpl(String baseUrl, ServiceClientCredentials credentials) {
        super(baseUrl, credentials);
        initialize();
    }

    /**
     * Initializes an instance of GraphRbacManagementClient client.
     *
     * @param restClient the REST client to connect to Azure.
     */
    public GraphRbacManagementClientImpl(RestClient restClient) {
        super(restClient);
        initialize();
    }

    protected void initialize() {
        this.apiVersion = "1.6";
        this.acceptLanguage = "en-US";
        this.longRunningOperationRetryTimeout = 30;
        this.generateClientRequestId = true;
        this.objects = new ObjectsInner(restClient().retrofit(), this);
        this.applications = new ApplicationsInner(restClient().retrofit(), this);
        this.groups = new GroupsInner(restClient().retrofit(), this);
        this.servicePrincipals = new ServicePrincipalsInner(restClient().retrofit(), this);
        this.users = new UsersInner(restClient().retrofit(), this);
        this.azureClient = new AzureClient(this);
    }

    /**
     * Gets the User-Agent header for the client.
     *
     * @return the user agent string.
     */
    @Override
    public String userAgent() {
        return String.format("Azure-SDK-For-Java/%s (%s)",
                getClass().getPackage().getImplementationVersion(),
                "GraphRbacManagementClient, 1.6");
    }
}
