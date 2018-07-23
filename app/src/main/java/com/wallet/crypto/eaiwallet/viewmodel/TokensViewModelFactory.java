package com.wallet.crypto.eaiwallet.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.wallet.crypto.eaiwallet.interact.FetchTokensInteract;
import com.wallet.crypto.eaiwallet.interact.FindDefaultNetworkInteract;
import com.wallet.crypto.eaiwallet.router.AddTokenRouter;
import com.wallet.crypto.eaiwallet.router.SendTokenRouter;
import com.wallet.crypto.eaiwallet.router.TransactionsRouter;

public class TokensViewModelFactory implements ViewModelProvider.Factory {

    private final FindDefaultNetworkInteract findDefaultNetworkInteract;
    private final FetchTokensInteract fetchTokensInteract;
    private final AddTokenRouter addTokenRouter;
    private final SendTokenRouter sendTokenRouter;
    private final TransactionsRouter transactionsRouter;

    public TokensViewModelFactory(FindDefaultNetworkInteract findDefaultNetworkInteract,
                                  FetchTokensInteract fetchTokensInteract,
                                  AddTokenRouter addTokenRouter,
                                  SendTokenRouter sendTokenRouter,
                                  TransactionsRouter transactionsRouter) {
        this.findDefaultNetworkInteract = findDefaultNetworkInteract;
        this.fetchTokensInteract = fetchTokensInteract;
        this.addTokenRouter = addTokenRouter;
        this.sendTokenRouter = sendTokenRouter;
        this.transactionsRouter = transactionsRouter;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new TokensViewModel(
                findDefaultNetworkInteract,
                fetchTokensInteract,
                addTokenRouter,
                sendTokenRouter,
                transactionsRouter);
    }
}
