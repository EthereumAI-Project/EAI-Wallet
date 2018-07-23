package com.wallet.crypto.eaiwallet.repository;

import com.wallet.crypto.eaiwallet.entity.NetworkInfo;
import com.wallet.crypto.eaiwallet.entity.TokenInfo;
import com.wallet.crypto.eaiwallet.entity.Wallet;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface TokenLocalSource {
    Completable put(NetworkInfo networkInfo, Wallet wallet, TokenInfo tokenInfo);
    Single<TokenInfo[]> fetch(NetworkInfo networkInfo, Wallet wallet);
}
