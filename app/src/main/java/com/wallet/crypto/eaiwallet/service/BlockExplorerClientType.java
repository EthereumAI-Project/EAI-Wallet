package com.wallet.crypto.eaiwallet.service;

import com.wallet.crypto.eaiwallet.entity.Transaction;

import io.reactivex.Observable;

public interface BlockExplorerClientType {
	Observable<Transaction[]> fetchTransactions(String forAddress);
}
