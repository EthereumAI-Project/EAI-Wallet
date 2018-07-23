package com.wallet.crypto.eaiwallet.di;

import com.wallet.crypto.eaiwallet.interact.ImportWalletInteract;
import com.wallet.crypto.eaiwallet.repository.PasswordStore;
import com.wallet.crypto.eaiwallet.repository.WalletRepositoryType;
import com.wallet.crypto.eaiwallet.viewmodel.ImportWalletViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
class ImportModule {
    @Provides
    ImportWalletViewModelFactory provideImportWalletViewModelFactory(
            ImportWalletInteract importWalletInteract) {
        return new ImportWalletViewModelFactory(importWalletInteract);
    }

    @Provides
    ImportWalletInteract provideImportWalletInteract(
            WalletRepositoryType walletRepository, PasswordStore passwordStore) {
        return new ImportWalletInteract(walletRepository, passwordStore);
    }
}
