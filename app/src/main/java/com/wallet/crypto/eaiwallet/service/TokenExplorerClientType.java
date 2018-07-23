package com.wallet.crypto.eaiwallet.service;

import com.wallet.crypto.eaiwallet.entity.TokenInfo;

import io.reactivex.Observable;

public interface TokenExplorerClientType {
    Observable<TokenInfo[]> fetch(String walletAddress);
}