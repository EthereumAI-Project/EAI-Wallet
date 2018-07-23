package com.wallet.crypto.eaiwallet.service;

import com.wallet.crypto.eaiwallet.entity.Ticker;

import io.reactivex.Observable;

public interface TickerService {

    Observable<Ticker> fetchTickerPrice(String ticker);
}
