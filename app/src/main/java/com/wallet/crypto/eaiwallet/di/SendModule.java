package com.wallet.crypto.eaiwallet.di;

import com.wallet.crypto.eaiwallet.router.ConfirmationRouter;
import com.wallet.crypto.eaiwallet.viewmodel.SendViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
class SendModule {
    @Provides
    SendViewModelFactory provideSendViewModelFactory(ConfirmationRouter confirmationRouter) {
        return new SendViewModelFactory(confirmationRouter);
    }

    @Provides
    ConfirmationRouter provideConfirmationRouter() {
        return new ConfirmationRouter();
    }
}
