package com.wallet.crypto.eaiwallet.di;

import com.wallet.crypto.eaiwallet.interact.AddTokenInteract;
import com.wallet.crypto.eaiwallet.interact.FindDefaultWalletInteract;
import com.wallet.crypto.eaiwallet.repository.TokenRepositoryType;
import com.wallet.crypto.eaiwallet.repository.WalletRepositoryType;
import com.wallet.crypto.eaiwallet.router.MyTokensRouter;
import com.wallet.crypto.eaiwallet.viewmodel.AddTokenViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class AddTokenModule {

    @Provides
    AddTokenViewModelFactory addTokenViewModelFactory(
            AddTokenInteract addTokenInteract,
            FindDefaultWalletInteract findDefaultWalletInteract,
            MyTokensRouter myTokensRouter) {
        return new AddTokenViewModelFactory(
                addTokenInteract, findDefaultWalletInteract, myTokensRouter);
    }

    @Provides
    AddTokenInteract provideAddTokenInteract(
            TokenRepositoryType tokenRepository,
            WalletRepositoryType walletRepository) {
        return new AddTokenInteract(walletRepository, tokenRepository);
    }

    @Provides
    FindDefaultWalletInteract provideFindDefaultWalletInteract(WalletRepositoryType walletRepository) {
        return new FindDefaultWalletInteract(walletRepository);
    }

    @Provides
    MyTokensRouter provideMyTokensRouter() {
        return new MyTokensRouter();
    }
}
