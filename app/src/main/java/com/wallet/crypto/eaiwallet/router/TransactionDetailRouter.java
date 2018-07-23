package com.wallet.crypto.eaiwallet.router;

import android.content.Context;
import android.content.Intent;

import com.wallet.crypto.eaiwallet.entity.Transaction;
import com.wallet.crypto.eaiwallet.ui.TransactionDetailActivity;

import static com.wallet.crypto.eaiwallet.C.Key.TRANSACTION;

public class TransactionDetailRouter {

    public void open(Context context, Transaction transaction) {
        Intent intent = new Intent(context, TransactionDetailActivity.class);
        intent.putExtra(TRANSACTION, transaction);
        context.startActivity(intent);
    }
}
