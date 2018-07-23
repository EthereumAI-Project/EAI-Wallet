package com.wallet.crypto.eaiwallet.di;


import com.wallet.crypto.eaiwallet.interact.FindDefaultNetworkInteract;
import com.wallet.crypto.eaiwallet.repository.EthereumAINetworkRepositoryType;
import com.wallet.crypto.eaiwallet.viewmodel.GasSettingsViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class GasSettingsModule {

    @Provides
    public GasSettingsViewModelFactory provideGasSettingsViewModelFactory(FindDefaultNetworkInteract findDefaultNetworkInteract) {
        return new GasSettingsViewModelFactory(findDefaultNetworkInteract);
    }

    @Provides
    FindDefaultNetworkInteract provideFindDefaultNetworkInteract(
            EthereumAINetworkRepositoryType ethereumaiNetworkRepositoryType) {
        return new FindDefaultNetworkInteract(ethereumaiNetworkRepositoryType);
    }
}
