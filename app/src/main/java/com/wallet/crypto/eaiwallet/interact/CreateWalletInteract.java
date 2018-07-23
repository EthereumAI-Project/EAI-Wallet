package com.wallet.crypto.eaiwallet.interact;

import com.wallet.crypto.eaiwallet.entity.Wallet;
import com.wallet.crypto.eaiwallet.interact.rx.operator.Operators;
import com.wallet.crypto.eaiwallet.repository.PasswordStore;
import com.wallet.crypto.eaiwallet.repository.WalletRepositoryType;

import io.reactivex.Single;

import static com.wallet.crypto.eaiwallet.interact.rx.operator.Operators.completableErrorProxy;

public class CreateWalletInteract {

	private final WalletRepositoryType walletRepository;
	private final PasswordStore passwordStore;

	public CreateWalletInteract(WalletRepositoryType walletRepository, PasswordStore passwordStore) {
		this.walletRepository = walletRepository;
		this.passwordStore = passwordStore;
	}

	public Single<Wallet> create() {
	    return passwordStore.generatePassword()
		.flatMap(masterPassword -> walletRepository
			.createWallet(masterPassword)
			.compose(Operators.savePassword(passwordStore, walletRepository, masterPassword))
                       	.flatMap(wallet -> passwordVerification(wallet, masterPassword)));
	}
	
	private Single<Wallet> passwordVerification(Wallet wallet, String masterPassword) {
            return passwordStore
                .getPassword(wallet)
                .flatMap(password -> walletRepository
                        .exportWallet(wallet, password, password)
                        .flatMap(keyStore -> walletRepository.findWallet(wallet.address)))
                .onErrorResumeNext(throwable -> walletRepository
                        .deleteWallet(wallet.address, masterPassword)
                        .lift(completableErrorProxy(throwable))
                        .toSingle(() -> wallet));
	}
}
