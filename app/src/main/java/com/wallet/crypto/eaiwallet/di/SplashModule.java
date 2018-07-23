package com.wallet.crypto.eaiwallet.di;

import com.wallet.crypto.eaiwallet.interact.FetchWalletsInteract;
import com.wallet.crypto.eaiwallet.repository.WalletRepositoryType;
import com.wallet.crypto.eaiwallet.viewmodel.SplashViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashModule {

    @Provides
    SplashViewModelFactory provideSplashViewModelFactory(FetchWalletsInteract fetchWalletsInteract) {
        return new SplashViewModelFactory(fetchWalletsInteract);
    }

    @Provides
    FetchWalletsInteract provideFetchWalletInteract(WalletRepositoryType walletRepository) {
        return new FetchWalletsInteract(walletRepository);
    }
}
