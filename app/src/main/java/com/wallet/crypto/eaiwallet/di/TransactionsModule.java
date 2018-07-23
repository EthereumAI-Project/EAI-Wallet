package com.wallet.crypto.eaiwallet.di;

import com.wallet.crypto.eaiwallet.interact.FetchTransactionsInteract;
import com.wallet.crypto.eaiwallet.interact.FindDefaultNetworkInteract;
import com.wallet.crypto.eaiwallet.interact.FindDefaultWalletInteract;
import com.wallet.crypto.eaiwallet.interact.GetDefaultWalletBalance;
import com.wallet.crypto.eaiwallet.repository.EthereumAINetworkRepositoryType;
import com.wallet.crypto.eaiwallet.repository.TransactionRepositoryType;
import com.wallet.crypto.eaiwallet.repository.WalletRepositoryType;
import com.wallet.crypto.eaiwallet.router.ExternalBrowserRouter;
import com.wallet.crypto.eaiwallet.router.ManageWalletsRouter;
import com.wallet.crypto.eaiwallet.router.MyAddressRouter;
import com.wallet.crypto.eaiwallet.router.MyTokensRouter;
import com.wallet.crypto.eaiwallet.router.SendRouter;
import com.wallet.crypto.eaiwallet.router.SettingsRouter;
import com.wallet.crypto.eaiwallet.router.TransactionDetailRouter;
import com.wallet.crypto.eaiwallet.viewmodel.TransactionsViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
class TransactionsModule {
    @Provides
    TransactionsViewModelFactory provideTransactionsViewModelFactory(
            FindDefaultNetworkInteract findDefaultNetworkInteract,
            FindDefaultWalletInteract findDefaultWalletInteract,
            FetchTransactionsInteract fetchTransactionsInteract,
            GetDefaultWalletBalance getDefaultWalletBalance,
            ManageWalletsRouter manageWalletsRouter,
            SettingsRouter settingsRouter,
            SendRouter sendRouter,
            TransactionDetailRouter transactionDetailRouter,
            MyAddressRouter myAddressRouter,
            MyTokensRouter myTokensRouter,
            ExternalBrowserRouter externalBrowserRouter) {
        return new TransactionsViewModelFactory(
                findDefaultNetworkInteract,
                findDefaultWalletInteract,
                fetchTransactionsInteract,
                getDefaultWalletBalance,
                manageWalletsRouter,
                settingsRouter,
                sendRouter,
                transactionDetailRouter,
                myAddressRouter,
                myTokensRouter,
                externalBrowserRouter);
    }

    @Provides
    FindDefaultNetworkInteract provideFindDefaultNetworkInteract(
            EthereumAINetworkRepositoryType ethereumaiNetworkRepositoryType) {
        return new FindDefaultNetworkInteract(ethereumaiNetworkRepositoryType);
    }

    @Provides
    FindDefaultWalletInteract provideFindDefaultWalletInteract(WalletRepositoryType walletRepository) {
        return new FindDefaultWalletInteract(walletRepository);
    }

    @Provides
    FetchTransactionsInteract provideFetchTransactionsInteract(TransactionRepositoryType transactionRepository) {
        return new FetchTransactionsInteract(transactionRepository);
    }

    @Provides
    GetDefaultWalletBalance provideGetDefaultWalletBalance(
            WalletRepositoryType walletRepository, EthereumAINetworkRepositoryType ethereumaiNetworkRepository) {
        return new GetDefaultWalletBalance(walletRepository, ethereumaiNetworkRepository);
    }

    @Provides
    ManageWalletsRouter provideManageWalletsRouter() {
        return new ManageWalletsRouter();
    }

    @Provides
    SettingsRouter provideSettingsRouter() {
        return new SettingsRouter();
    }

    @Provides
    SendRouter provideSendRouter() { return new SendRouter(); }

    @Provides
    TransactionDetailRouter provideTransactionDetailRouter() {
        return new TransactionDetailRouter();
    }

    @Provides
    MyAddressRouter provideMyAddressRouter() {
        return new MyAddressRouter();
    }

    @Provides
    MyTokensRouter provideMyTokensRouter() {
        return new MyTokensRouter();
    }

    @Provides
    ExternalBrowserRouter provideExternalBrowserRouter() {
        return new ExternalBrowserRouter();
    }
}
