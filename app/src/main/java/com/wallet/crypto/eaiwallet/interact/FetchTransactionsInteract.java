package com.wallet.crypto.eaiwallet.interact;

import com.wallet.crypto.eaiwallet.entity.Transaction;
import com.wallet.crypto.eaiwallet.entity.Wallet;
import com.wallet.crypto.eaiwallet.repository.TransactionRepositoryType;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class FetchTransactionsInteract {

    private final TransactionRepositoryType transactionRepository;

    public FetchTransactionsInteract(TransactionRepositoryType transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Observable<Transaction[]> fetch(Wallet wallet) {
        return transactionRepository
                .fetchTransaction(wallet)
                .observeOn(AndroidSchedulers.mainThread());
    }
}
