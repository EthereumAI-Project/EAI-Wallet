package com.wallet.crypto.eaiwallet.interact;

import com.wallet.crypto.eaiwallet.entity.Wallet;
import com.wallet.crypto.eaiwallet.repository.WalletRepositoryType;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class FetchWalletsInteract {

	private final WalletRepositoryType accountRepository;

	public FetchWalletsInteract(WalletRepositoryType accountRepository) {
		this.accountRepository = accountRepository;
	}

	public Single<Wallet[]> fetch() {
		return accountRepository
				.fetchWallets()
				.observeOn(AndroidSchedulers.mainThread());
	}
}
