package com.wallet.crypto.eaiwallet.repository;

import com.wallet.crypto.eaiwallet.entity.Wallet;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface PasswordStore {
	Single<String> getPassword(Wallet wallet);
	Completable setPassword(Wallet wallet, String password);
	Single<String> generatePassword();
}
