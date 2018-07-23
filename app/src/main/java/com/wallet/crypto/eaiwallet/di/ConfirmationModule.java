package com.wallet.crypto.eaiwallet.di;


import com.wallet.crypto.eaiwallet.interact.CreateTransactionInteract;
import com.wallet.crypto.eaiwallet.interact.FetchGasSettingsInteract;
import com.wallet.crypto.eaiwallet.interact.FindDefaultWalletInteract;
import com.wallet.crypto.eaiwallet.repository.PasswordStore;
import com.wallet.crypto.eaiwallet.repository.PreferenceRepositoryType;
import com.wallet.crypto.eaiwallet.repository.TransactionRepositoryType;
import com.wallet.crypto.eaiwallet.repository.WalletRepositoryType;
import com.wallet.crypto.eaiwallet.router.GasSettingsRouter;
import com.wallet.crypto.eaiwallet.viewmodel.ConfirmationViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class ConfirmationModule {
    @Provides
    public ConfirmationViewModelFactory provideConfirmationViewModelFactory(
            FindDefaultWalletInteract findDefaultWalletInteract,
            FetchGasSettingsInteract fetchGasSettingsInteract,
            CreateTransactionInteract createTransactionInteract,
            GasSettingsRouter gasSettingsRouter
    ) {
        return new ConfirmationViewModelFactory(findDefaultWalletInteract, fetchGasSettingsInteract, createTransactionInteract, gasSettingsRouter);
    }

    @Provides
    FindDefaultWalletInteract provideFindDefaultWalletInteract(WalletRepositoryType walletRepository) {
        return new FindDefaultWalletInteract(walletRepository);
    }

    @Provides
    FetchGasSettingsInteract provideFetchGasSettingsInteract(PreferenceRepositoryType preferenceRepositoryType) {
        return new FetchGasSettingsInteract(preferenceRepositoryType);
    }

    @Provides
    CreateTransactionInteract provideCreateTransactionInteract(TransactionRepositoryType transactionRepository, PasswordStore passwordStore) {
        return new CreateTransactionInteract(transactionRepository, passwordStore);
    }

    @Provides
    GasSettingsRouter provideGasSettingsRouter() {
        return new GasSettingsRouter();
    }
}
