package com.eugene.wsdemo.service;

import com.eugene.wsdemo.domain.Country;

import java.util.List;

public interface CountryService {

    List<Country> getAllCountries();

    Country getCountryByName(String name);

    Country createCountry(Country country);

    void deleteCountry(Long id);

    Country updateCountry(Country country);
}
