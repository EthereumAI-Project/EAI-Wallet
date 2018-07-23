package com.wallet.crypto.eaiwallet;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.wallet.crypto.eaiwallet.repository.EthereumAINetworkRepository;
import com.wallet.crypto.eaiwallet.repository.EthereumAINetworkRepositoryType;
import com.wallet.crypto.eaiwallet.repository.PreferenceRepositoryType;
import com.wallet.crypto.eaiwallet.repository.SharedPreferenceRepository;

import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class EthereumAINetworkRepositoryTest {

	private EthereumAINetworkRepositoryType networkRepository;

	@Before
	public void setUp() {
		Context context = InstrumentationRegistry.getTargetContext();
		PreferenceRepositoryType preferenceRepositoryType = new SharedPreferenceRepository(context);
		networkRepository = new EthereumAINetworkRepository(preferenceRepositoryType);
	}

}
