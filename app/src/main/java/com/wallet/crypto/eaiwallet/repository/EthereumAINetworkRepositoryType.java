package com.wallet.crypto.eaiwallet.repository;

import com.wallet.crypto.eaiwallet.entity.NetworkInfo;
import com.wallet.crypto.eaiwallet.entity.Ticker;

import io.reactivex.Single;

public interface EthereumAINetworkRepositoryType {

	NetworkInfo getDefaultNetwork();

	void setDefaultNetworkInfo(NetworkInfo networkInfo);

	NetworkInfo[] getAvailableNetworkList();

	void addOnChangeDefaultNetwork(OnNetworkChangeListener onNetworkChanged);

	Single<Ticker> getTicker();
}
