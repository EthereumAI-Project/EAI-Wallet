package com.wallet.crypto.eaiwallet.ui.widget;

import android.view.View;

import com.wallet.crypto.eaiwallet.entity.Transaction;

public interface OnTransactionClickListener {
    void onTransactionClick(View view, Transaction transaction);
}
