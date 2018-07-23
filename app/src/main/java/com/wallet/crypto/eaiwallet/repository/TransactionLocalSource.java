package com.wallet.crypto.eaiwallet.repository;

import com.wallet.crypto.eaiwallet.entity.Transaction;
import com.wallet.crypto.eaiwallet.entity.Wallet;

import io.reactivex.Single;

public interface TransactionLocalSource {
	Single<Transaction[]> fetchTransaction(Wallet wallet);

	void putTransactions(Wallet wallet, Transaction[] transactions);

    void clear();
}
