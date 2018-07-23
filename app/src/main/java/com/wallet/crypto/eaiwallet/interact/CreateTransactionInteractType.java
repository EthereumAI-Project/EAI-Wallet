package com.wallet.crypto.eaiwallet.interact;


import com.wallet.crypto.eaiwallet.entity.Wallet;

import java.math.BigInteger;

import io.reactivex.Single;

public interface CreateTransactionInteractType {

    public Single<String> create(Wallet from, String to, String wei, BigInteger gasPrice, BigInteger gasLimit, String password);
}
