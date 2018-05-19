package com.eugene.wsdemo.service;

import com.eugene.wsdemo.domain.Country;
import com.eugene.wsdemo.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country getCountryByName(String name) {
        return countryRepository.findByName(name);
    }

    @Override
    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public Country updateCountry(Country country) {
        if (countryRepository.existsById(country.getId())) {
            return countryRepository.save(country);
        }
        throw new IllegalArgumentException("Country not exist in DB");
    }
}
