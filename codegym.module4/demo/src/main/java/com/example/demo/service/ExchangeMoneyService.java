package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class ExchangeMoneyService implements IExchangeMoneyService {
    @Override
    public double exchangeMoney(double usd) {
        return usd * 26500;
    }
}
