package com.wallet.crypto.eaiwallet.interact;

import com.wallet.crypto.eaiwallet.entity.Wallet;
import com.wallet.crypto.eaiwallet.repository.EthereumAINetworkRepositoryType;
import com.wallet.crypto.eaiwallet.repository.WalletRepositoryType;
import com.wallet.crypto.eaiwallet.util.BalanceUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.wallet.crypto.eaiwallet.C.USD_SYMBOL;
import static com.wallet.crypto.eaiwallet.util.BalanceUtils.weiToEth;

public class GetDefaultWalletBalance {

    private final WalletRepositoryType walletRepository;
    private final EthereumAINetworkRepositoryType ethereumaiNetworkRepository;

    public GetDefaultWalletBalance(
            WalletRepositoryType walletRepository,
            EthereumAINetworkRepositoryType ethereumaiNetworkRepository) {
        this.walletRepository = walletRepository;
        this.ethereumaiNetworkRepository = ethereumaiNetworkRepository;
    }

    public Single<Map<String, String>> get(Wallet wallet) {
        return walletRepository.balanceInWei(wallet)
                .flatMap(ethBallance -> {
                    Map<String, String> balances = new HashMap<>();
                    balances.put(ethereumaiNetworkRepository.getDefaultNetwork().symbol, weiToEth(ethBallance, 5));
                    return Single.just(balances);
                })
                .flatMap(balances -> ethereumaiNetworkRepository
                        .getTicker()
                        .observeOn(Schedulers.io())
                        .flatMap(ticker -> {
                            String ethBallance = balances.get(ethereumaiNetworkRepository.getDefaultNetwork().symbol);
                            balances.put(USD_SYMBOL, BalanceUtils.ethToUsd(ticker.price, ethBallance));
                            return Single.just(balances);
                        })
                        .onErrorResumeNext(throwable -> Single.just(balances)))
                .observeOn(AndroidSchedulers.mainThread());
    }


}