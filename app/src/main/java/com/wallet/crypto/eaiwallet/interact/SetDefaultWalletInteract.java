package com.wallet.crypto.eaiwallet.interact;

import com.wallet.crypto.eaiwallet.entity.Wallet;
import com.wallet.crypto.eaiwallet.repository.WalletRepositoryType;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class SetDefaultWalletInteract {

	private WalletRepositoryType accountRepository;

	public SetDefaultWalletInteract(WalletRepositoryType walletRepositoryType) {
		this.accountRepository = walletRepositoryType;
	}

	public Completable set(Wallet wallet) {
		return accountRepository
				.setDefaultWallet(wallet)
				.observeOn(AndroidSchedulers.mainThread());
	}
}
