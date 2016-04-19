package com.microsoft.azure.implementation;

import com.microsoft.azure.management.resources.ResourceGroups;
import com.microsoft.azure.management.resources.implementation.ResourceGroupsImpl;
import com.microsoft.azure.management.resources.implementation.api.ResourceManagementClientImpl;
import com.microsoft.azure.management.resources.models.ResourceGroup;
import com.microsoft.azure.management.resources.models.implementation.ResourceGroupImpl;
import com.microsoft.azure.management.storage.ResourceGroupContext;
import com.microsoft.azure.management.storage.StorageAccounts;
import com.microsoft.azure.management.storage.implementation.ResourceGroupContextImpl;
import com.microsoft.azure.management.storage.implementation.StorageAccountsImpl;
import com.microsoft.azure.management.storage.implementation.api.StorageManagementClientImpl;
import com.microsoft.rest.credentials.ServiceClientCredentials;

public class AzureResourceGroupImpl extends ResourceGroupImpl implements Azure.ResourceGroup {
    private ResourceManagementClientImpl client;
    private ResourceGroup resourceGroupCore;
    private ResourceGroups resourceGroupsCore;
    private StorageAccounts storageAccountsCore;

    public AzureResourceGroupImpl(ResourceGroup resourceGroupCore, ResourceManagementClientImpl client) {
        super(resourceGroupCore.inner(), client);
        this.resourceGroupCore = resourceGroupCore;
        this.client = client;
    }

    // StorageAccount collection having a resource resourceGroupCore context.
    //
    public ResourceGroupContext.StorageAccounts storageAccounts() {
        return new ResourceGroupContextImpl(this.resourceGroupCore).storageAccounts(storageAccountsCore());
    }

    private ResourceGroups resourceGroupsCore() {
        if (resourceGroupsCore == null) {
            resourceGroupsCore = new ResourceGroupsImpl(this.client);
        }
        return resourceGroupsCore;
    }

    private StorageAccounts storageAccountsCore() {
        if (storageAccountsCore == null) {
            storageAccountsCore = new StorageAccountsImpl(StorageManagementClient(), resourceGroupsCore());
        }
        return storageAccountsCore;
    }

    private ServiceClientCredentials credentials() {
        return this.client.getCredentials();
    }

    private String subscriptionId() {
        return this.client.getSubscriptionId();
    }

    private StorageManagementClientImpl StorageManagementClient() {
        StorageManagementClientImpl client = new StorageManagementClientImpl(credentials());
        client.setSubscriptionId(subscriptionId());
        return client;
    }
}
