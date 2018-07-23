package com.wallet.crypto.eaiwallet.di;

import android.content.Context;

import com.google.gson.Gson;
import com.wallet.crypto.eaiwallet.App;
import com.wallet.crypto.eaiwallet.repository.PasswordStore;
import com.wallet.crypto.eaiwallet.repository.TrustPasswordStore;
import com.wallet.crypto.eaiwallet.util.LogInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
class ToolsModule {
	@Provides
	Context provideContext(App application) {
		return application.getApplicationContext();
	}

	@Singleton
	@Provides
	Gson provideGson() {
		return new Gson();
	}

	@Singleton
	@Provides
	OkHttpClient okHttpClient() {
		return new OkHttpClient.Builder()
                .addInterceptor(new LogInterceptor())
                .build();
	}

	@Singleton
	@Provides
	PasswordStore passwordStore(Context context) {
		return new TrustPasswordStore(context);
	}
}
