package com.wallet.crypto.eaiwallet.di;

import android.content.Context;

import com.google.gson.Gson;
import com.wallet.crypto.eaiwallet.repository.EthereumAINetworkRepository;
import com.wallet.crypto.eaiwallet.repository.EthereumAINetworkRepositoryType;
import com.wallet.crypto.eaiwallet.repository.PreferenceRepositoryType;
import com.wallet.crypto.eaiwallet.repository.RealmTokenSource;
import com.wallet.crypto.eaiwallet.repository.SharedPreferenceRepository;
import com.wallet.crypto.eaiwallet.repository.TokenLocalSource;
import com.wallet.crypto.eaiwallet.repository.TokenRepository;
import com.wallet.crypto.eaiwallet.repository.TokenRepositoryType;
import com.wallet.crypto.eaiwallet.repository.TransactionInMemorySource;
import com.wallet.crypto.eaiwallet.repository.TransactionLocalSource;
import com.wallet.crypto.eaiwallet.repository.TransactionRepository;
import com.wallet.crypto.eaiwallet.repository.TransactionRepositoryType;
import com.wallet.crypto.eaiwallet.repository.WalletRepository;
import com.wallet.crypto.eaiwallet.repository.WalletRepositoryType;
import com.wallet.crypto.eaiwallet.service.AccountKeystoreService;
import com.wallet.crypto.eaiwallet.service.BlockExplorerClient;
import com.wallet.crypto.eaiwallet.service.BlockExplorerClientType;
import com.wallet.crypto.eaiwallet.service.EthplorerTokenService;
import com.wallet.crypto.eaiwallet.service.GethKeystoreAccountService;
import com.wallet.crypto.eaiwallet.service.TickerService;
import com.wallet.crypto.eaiwallet.service.TokenExplorerClientType;
import com.wallet.crypto.eaiwallet.service.TrustWalletTickerService;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class RepositoriesModule {
	@Singleton
	@Provides
	PreferenceRepositoryType providePreferenceRepository(Context context) {
		return new SharedPreferenceRepository(context);
	}

	@Singleton
	@Provides
	AccountKeystoreService provideAccountKeyStoreService(Context context) {
        File file = new File(context.getFilesDir(), "keystore/keystore");
		return new GethKeystoreAccountService(file);
	}

	@Singleton
    @Provides
    TickerService provideTickerService(OkHttpClient httpClient, Gson gson) {
	    return new TrustWalletTickerService(httpClient, gson);
    }

	@Singleton
	@Provides
	EthereumAINetworkRepositoryType provideEthereumAINetworkRepository(
            PreferenceRepositoryType preferenceRepository,
            TickerService tickerService) {
		return new EthereumAINetworkRepository(preferenceRepository, tickerService);
	}

	@Singleton
	@Provides
    WalletRepositoryType provideWalletRepository(
            OkHttpClient okHttpClient,
			PreferenceRepositoryType preferenceRepositoryType,
			AccountKeystoreService accountKeystoreService,
			EthereumAINetworkRepositoryType networkRepository) {
		return new WalletRepository(
		        okHttpClient, preferenceRepositoryType, accountKeystoreService, networkRepository);
	}

	@Singleton
	@Provides
	TransactionRepositoryType provideTransactionRepository(
			EthereumAINetworkRepositoryType networkRepository,
			AccountKeystoreService accountKeystoreService,
			BlockExplorerClientType blockExplorerClient) {
		TransactionLocalSource inMemoryCache = new TransactionInMemorySource();
		TransactionLocalSource inDiskCache = null;
		return new TransactionRepository(
				networkRepository,
				accountKeystoreService,
				inMemoryCache,
				inDiskCache,
				blockExplorerClient);
	}

	@Singleton
	@Provides
	BlockExplorerClientType provideBlockExplorerClient(
			OkHttpClient httpClient,
			Gson gson,
			EthereumAINetworkRepositoryType ethereumaiNetworkRepository) {
		return new BlockExplorerClient(httpClient, gson, ethereumaiNetworkRepository);
	}

	@Singleton
    @Provides
    TokenRepositoryType provideTokenRepository(
            OkHttpClient okHttpClient,
            EthereumAINetworkRepositoryType ethereumaiNetworkRepository,
            TokenExplorerClientType tokenExplorerClientType,
            TokenLocalSource tokenLocalSource) {
	    return new TokenRepository(
	            okHttpClient,
	            ethereumaiNetworkRepository,
	            tokenExplorerClientType,
                tokenLocalSource);
    }

	@Singleton
    @Provides
    TokenExplorerClientType provideTokenService(OkHttpClient okHttpClient, Gson gson) {
	    return new EthplorerTokenService(okHttpClient, gson);
    }

    @Singleton
    @Provides
    TokenLocalSource provideRealmTokenSource() {
	    return new RealmTokenSource();
    }
}
