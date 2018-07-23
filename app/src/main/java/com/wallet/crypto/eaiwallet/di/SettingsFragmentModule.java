package com.wallet.crypto.eaiwallet.di;

import com.wallet.crypto.eaiwallet.interact.FindDefaultWalletInteract;
import com.wallet.crypto.eaiwallet.repository.WalletRepositoryType;
import com.wallet.crypto.eaiwallet.router.ManageWalletsRouter;

import dagger.Module;
import dagger.Provides;

@Module
class SettingsFragmentModule {
    @Provides
    FindDefaultWalletInteract provideFindDefaultWalletInteract(WalletRepositoryType walletRepository) {
        return new FindDefaultWalletInteract(walletRepository);
    }

    @Provides
    ManageWalletsRouter provideManageWalletsRouter() {
        return new ManageWalletsRouter();
    }
}
