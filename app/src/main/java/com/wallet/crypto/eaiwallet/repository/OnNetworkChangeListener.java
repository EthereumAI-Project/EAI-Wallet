package com.wallet.crypto.eaiwallet.repository;

import com.wallet.crypto.eaiwallet.entity.NetworkInfo;

public interface OnNetworkChangeListener {
	void onNetworkChanged(NetworkInfo networkInfo);
}
