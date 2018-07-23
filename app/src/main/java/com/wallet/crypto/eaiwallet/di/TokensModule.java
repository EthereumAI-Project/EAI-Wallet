package com.wallet.crypto.eaiwallet.di;

import com.wallet.crypto.eaiwallet.interact.FetchTokensInteract;
import com.wallet.crypto.eaiwallet.interact.FindDefaultNetworkInteract;
import com.wallet.crypto.eaiwallet.repository.EthereumAINetworkRepositoryType;
import com.wallet.crypto.eaiwallet.repository.TokenRepositoryType;
import com.wallet.crypto.eaiwallet.router.AddTokenRouter;
import com.wallet.crypto.eaiwallet.router.SendTokenRouter;
import com.wallet.crypto.eaiwallet.router.TransactionsRouter;
import com.wallet.crypto.eaiwallet.viewmodel.TokensViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
class TokensModule {

    @Provides
    TokensViewModelFactory provideTokensViewModelFactory(
            FindDefaultNetworkInteract findDefaultNetworkInteract,
            FetchTokensInteract fetchTokensInteract,
            AddTokenRouter addTokenRouter,
            SendTokenRouter sendTokenRouter,
            TransactionsRouter transactionsRouter) {
        return new TokensViewModelFactory(
                findDefaultNetworkInteract,
                fetchTokensInteract,
                addTokenRouter,
                sendTokenRouter,
                transactionsRouter);
    }

    @Provides
    FindDefaultNetworkInteract provideFindDefaultNetworkInteract(
            EthereumAINetworkRepositoryType networkRepository) {
        return new FindDefaultNetworkInteract(networkRepository);
    }

    @Provides
    FetchTokensInteract provideFetchTokensInteract(TokenRepositoryType tokenRepository) {
        return new FetchTokensInteract(tokenRepository);
    }

    @Provides
    AddTokenRouter provideAddTokenRouter() {
        return new AddTokenRouter();
    }

    @Provides
    SendTokenRouter provideSendTokenRouter() {
        return new SendTokenRouter();
    }

    @Provides
    TransactionsRouter provideTransactionsRouter() {
        return new TransactionsRouter();
    }
}
