package com.wallet.crypto.eaiwallet.di;

import com.wallet.crypto.eaiwallet.interact.FindDefaultNetworkInteract;
import com.wallet.crypto.eaiwallet.interact.FindDefaultWalletInteract;
import com.wallet.crypto.eaiwallet.repository.EthereumAINetworkRepositoryType;
import com.wallet.crypto.eaiwallet.repository.WalletRepositoryType;
import com.wallet.crypto.eaiwallet.router.ExternalBrowserRouter;
import com.wallet.crypto.eaiwallet.viewmodel.TransactionDetailViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class TransactionDetailModule {

    @Provides
    TransactionDetailViewModelFactory provideTransactionDetailViewModelFactory(
            FindDefaultNetworkInteract findDefaultNetworkInteract,
            FindDefaultWalletInteract findDefaultWalletInteract,
            ExternalBrowserRouter externalBrowserRouter) {
        return new TransactionDetailViewModelFactory(
                findDefaultNetworkInteract, findDefaultWalletInteract, externalBrowserRouter);
    }

    @Provides
    FindDefaultNetworkInteract provideFindDefaultNetworkInteract(
            EthereumAINetworkRepositoryType ethereumaiNetworkRepository) {
        return new FindDefaultNetworkInteract(ethereumaiNetworkRepository);
    }

    @Provides
    ExternalBrowserRouter externalBrowserRouter() {
        return new ExternalBrowserRouter();
    }

    @Provides
    FindDefaultWalletInteract findDefaultWalletInteract(WalletRepositoryType walletRepository) {
        return new FindDefaultWalletInteract(walletRepository);
    }
}
