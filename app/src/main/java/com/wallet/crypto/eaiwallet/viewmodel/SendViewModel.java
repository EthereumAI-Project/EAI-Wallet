package com.wallet.crypto.eaiwallet.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.wallet.crypto.eaiwallet.entity.Transaction;
import com.wallet.crypto.eaiwallet.entity.Wallet;
import com.wallet.crypto.eaiwallet.router.ConfirmationRouter;

import java.math.BigInteger;

public class SendViewModel extends BaseViewModel {
    private final MutableLiveData<Wallet> defaultWallet = new MutableLiveData<>();
    private final MutableLiveData<Transaction> transaction = new MutableLiveData<>();
    private final ConfirmationRouter confirmationRouter;

    SendViewModel(ConfirmationRouter confirmationRouter) {
        this.confirmationRouter = confirmationRouter;
    }

    public void openConfirmation(Context context, String to, BigInteger amount, String contractAddress, int decimals, String symbol, boolean sendingTokens) {
        confirmationRouter.open(context, to, amount, contractAddress, decimals, symbol, sendingTokens);
    }
}
