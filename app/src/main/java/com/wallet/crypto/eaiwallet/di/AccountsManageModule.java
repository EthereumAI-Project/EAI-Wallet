package com.wallet.crypto.eaiwallet.di;

import com.wallet.crypto.eaiwallet.interact.CreateWalletInteract;
import com.wallet.crypto.eaiwallet.interact.DeleteWalletInteract;
import com.wallet.crypto.eaiwallet.interact.ExportWalletInteract;
import com.wallet.crypto.eaiwallet.interact.FetchWalletsInteract;
import com.wallet.crypto.eaiwallet.interact.FindDefaultWalletInteract;
import com.wallet.crypto.eaiwallet.interact.SetDefaultWalletInteract;
import com.wallet.crypto.eaiwallet.repository.PasswordStore;
import com.wallet.crypto.eaiwallet.repository.WalletRepositoryType;
import com.wallet.crypto.eaiwallet.router.ImportWalletRouter;
import com.wallet.crypto.eaiwallet.router.TransactionsRouter;
import com.wallet.crypto.eaiwallet.viewmodel.WalletsViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
class AccountsManageModule {

	@Provides
    WalletsViewModelFactory provideAccountsManageViewModelFactory(
			CreateWalletInteract createWalletInteract,
			SetDefaultWalletInteract setDefaultWalletInteract,
			DeleteWalletInteract deleteWalletInteract,
			FetchWalletsInteract fetchWalletsInteract,
			FindDefaultWalletInteract findDefaultWalletInteract,
			ExportWalletInteract exportWalletInteract,
			ImportWalletRouter importWalletRouter,
            TransactionsRouter transactionsRouter) {
		return new WalletsViewModelFactory(createWalletInteract,
                setDefaultWalletInteract,
                deleteWalletInteract,
                fetchWalletsInteract,
                findDefaultWalletInteract,
                exportWalletInteract,
                importWalletRouter,
                transactionsRouter);
	}

	@Provides
    CreateWalletInteract provideCreateAccountInteract(
            WalletRepositoryType accountRepository, PasswordStore passwordStore) {
		return new CreateWalletInteract(accountRepository, passwordStore);
	}

	@Provides
    SetDefaultWalletInteract provideSetDefaultAccountInteract(WalletRepositoryType accountRepository) {
		return new SetDefaultWalletInteract(accountRepository);
	}

	@Provides
    DeleteWalletInteract provideDeleteAccountInteract(
            WalletRepositoryType accountRepository, PasswordStore store) {
		return new DeleteWalletInteract(accountRepository, store);
	}

	@Provides
    FetchWalletsInteract provideFetchAccountsInteract(WalletRepositoryType accountRepository) {
		return new FetchWalletsInteract(accountRepository);
	}

	@Provides
    FindDefaultWalletInteract provideFindDefaultAccountInteract(WalletRepositoryType accountRepository) {
		return new FindDefaultWalletInteract(accountRepository);
	}

	@Provides
    ExportWalletInteract provideExportWalletInteract(
            WalletRepositoryType walletRepository, PasswordStore passwordStore) {
	    return new ExportWalletInteract(walletRepository, passwordStore);
    }

	@Provides
    ImportWalletRouter provideImportAccountRouter() {
		return new ImportWalletRouter();
	}

	@Provides
    TransactionsRouter provideTransactionsRouter() {
	    return new TransactionsRouter();
    }
}
