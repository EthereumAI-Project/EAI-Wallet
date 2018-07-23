package com.wallet.crypto.eaiwallet.interact;

import com.wallet.crypto.eaiwallet.entity.NetworkInfo;
import com.wallet.crypto.eaiwallet.repository.EthereumAINetworkRepositoryType;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class FindDefaultNetworkInteract {

    private final EthereumAINetworkRepositoryType ethereumaiNetworkRepository;

    public FindDefaultNetworkInteract(EthereumAINetworkRepositoryType ethereumaiNetworkRepository) {
        this.ethereumaiNetworkRepository = ethereumaiNetworkRepository;
    }

    public Single<NetworkInfo> find() {
        return Single.just(ethereumaiNetworkRepository.getDefaultNetwork())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
