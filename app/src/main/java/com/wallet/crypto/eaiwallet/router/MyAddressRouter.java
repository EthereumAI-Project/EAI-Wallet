package com.wallet.crypto.eaiwallet.router;

import android.content.Context;
import android.content.Intent;

import com.wallet.crypto.eaiwallet.entity.Wallet;
import com.wallet.crypto.eaiwallet.ui.MyAddressActivity;

import static com.wallet.crypto.eaiwallet.C.Key.WALLET;

public class MyAddressRouter {

    public void open(Context context, Wallet wallet) {
        Intent intent = new Intent(context, MyAddressActivity.class);
        intent.putExtra(WALLET, wallet);
        context.startActivity(intent);
    }
}
