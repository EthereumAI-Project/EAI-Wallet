package com.wallet.crypto.eaiwallet.interact;


import com.wallet.crypto.eaiwallet.entity.GasSettings;
import com.wallet.crypto.eaiwallet.repository.PreferenceRepositoryType;

public class FetchGasSettingsInteract {
    private final PreferenceRepositoryType repository;

    public FetchGasSettingsInteract(PreferenceRepositoryType repository) {
        this.repository = repository;
    }

    public GasSettings fetch(boolean forTokenTransfer) {
        return repository.getGasSettings(forTokenTransfer);
    }

}
