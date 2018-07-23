package com.wallet.crypto.eaiwallet.interact.rx.operator;

import com.wallet.crypto.eaiwallet.entity.Wallet;
import com.wallet.crypto.eaiwallet.repository.PasswordStore;
import com.wallet.crypto.eaiwallet.repository.WalletRepositoryType;

import io.reactivex.CompletableOperator;
import io.reactivex.SingleTransformer;

public class Operators {

    public static SingleTransformer<Wallet, Wallet> savePassword(
            PasswordStore passwordStore, WalletRepositoryType walletRepository, String password) {
        return new SavePasswordOperator(passwordStore, walletRepository, password);
    }

    public static CompletableOperator completableErrorProxy(Throwable throwable) {
        return new CompletableErrorProxyOperator(throwable);
    }
}
