package com.wallet.crypto.eaiwallet.repository;

import android.text.TextUtils;

import com.wallet.crypto.eaiwallet.entity.NetworkInfo;
import com.wallet.crypto.eaiwallet.entity.Ticker;
import com.wallet.crypto.eaiwallet.service.TickerService;

import java.util.HashSet;
import java.util.Set;

import io.reactivex.Single;

import static com.wallet.crypto.eaiwallet.C.ETHEREUMAI_NETWORK_NAME;
import static com.wallet.crypto.eaiwallet.C.ETHEREUM_NETWORK_NAME;
import static com.wallet.crypto.eaiwallet.C.ETH_SYMBOL;
import static com.wallet.crypto.eaiwallet.C.POA_NETWORK_NAME;
import static com.wallet.crypto.eaiwallet.C.POA_SYMBOL;
import static com.wallet.crypto.eaiwallet.C.ROPSTEN_NETWORK_NAME;
import static com.wallet.crypto.eaiwallet.C.CLASSIC_NETWORK_NAME;
import static com.wallet.crypto.eaiwallet.C.ETC_SYMBOL;
import static com.wallet.crypto.eaiwallet.C.EAI_SYMBOL;

public class EthereumAINetworkRepository implements EthereumAINetworkRepositoryType {

	private final NetworkInfo[] NETWORKS = new NetworkInfo[] {
			new NetworkInfo(ETHEREUMAI_NETWORK_NAME, EAI_SYMBOL,
                    "http://10.0.2.2:9545",
                    "https://ropsten.trustwalletapp.com/",
                    "https://ropsten.etherscan.io",8, true),
			new NetworkInfo(ETHEREUM_NETWORK_NAME, ETH_SYMBOL,
                    "https://mainnet.infura.io/llyrtzQ3YhkdESt2Fzrk",
                    "https://api.trustwalletapp.com/",
                    "https://etherscan.io/",1, true),
            new NetworkInfo(CLASSIC_NETWORK_NAME, ETC_SYMBOL,
                    "https://mewapi.epool.io/",
                    "https://classic.trustwalletapp.com",
                    "https://gastracker.io",61, true),
            new NetworkInfo(POA_NETWORK_NAME, POA_SYMBOL,
                    "https://core.poa.network",
                    "https://poa.trustwalletapp.com","poa", 99, false),
			new NetworkInfo(ROPSTEN_NETWORK_NAME, ETH_SYMBOL,
                    "https://ropsten.infura.io/llyrtzQ3YhkdESt2Fzrk",
                    "https://ropsten.trustwalletapp.com/",
                    "https://ropsten.etherscan.io",3, false),
	};

	private final PreferenceRepositoryType preferences;
    private final TickerService tickerService;
    private NetworkInfo defaultNetwork;
    private final Set<OnNetworkChangeListener> onNetworkChangedListeners = new HashSet<>();

    public EthereumAINetworkRepository(PreferenceRepositoryType preferenceRepository, TickerService tickerService) {
		this.preferences = preferenceRepository;
		this.tickerService = tickerService;
		defaultNetwork = getByName(preferences.getDefaultNetwork());
		if (defaultNetwork == null) {
			defaultNetwork = NETWORKS[0];
		}
	}

	private NetworkInfo getByName(String name) {
		if (!TextUtils.isEmpty(name)) {
			for (NetworkInfo NETWORK : NETWORKS) {
				if (name.equals(NETWORK.name)) {
					return NETWORK;
				}
			}
		}
		return null;
	}

	@Override
	public NetworkInfo getDefaultNetwork() {
		return defaultNetwork;
	}

	@Override
	public void setDefaultNetworkInfo(NetworkInfo networkInfo) {
		defaultNetwork = networkInfo;
		preferences.setDefaultNetwork(defaultNetwork.name);

		for (OnNetworkChangeListener listener : onNetworkChangedListeners) {
		    listener.onNetworkChanged(networkInfo);
        }
	}

	@Override
	public NetworkInfo[] getAvailableNetworkList() {
		return NETWORKS;
	}

	@Override
	public void addOnChangeDefaultNetwork(OnNetworkChangeListener onNetworkChanged) {
        onNetworkChangedListeners.add(onNetworkChanged);
	}

    @Override
    public Single<Ticker> getTicker() {
        return Single.fromObservable(tickerService
                .fetchTickerPrice(getDefaultNetwork().symbol));
    }
}
