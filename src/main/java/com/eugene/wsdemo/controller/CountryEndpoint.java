package com.eugene.wsdemo.controller;

import com.eugene.wsdemo.domain.*;
import com.eugene.wsdemo.service.CountryService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import static com.eugene.wsdemo.config.WebServiceConfiguration.NAMESPACE_URI;

@Endpoint
public class CountryEndpoint {

    private final CountryService countryService;

    public CountryEndpoint(CountryService countryService) {
        this.countryService = countryService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryByNameRequest")
    @ResponsePayload
    public GetCountryResponse getCountryByName(@RequestPayload GetCountryByNameRequest request) {
        Country found = countryService.getCountryByName(request.getName());
        return new GetCountryResponse(found);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createCountryRequest")
    @ResponsePayload
    public GetCountryResponse createCountry(@RequestPayload CreateCountryRequest request) {
        Country saved = countryService.createCountry(request.getCountry());
        return new GetCountryResponse(saved);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateCountryRequest")
    @ResponsePayload
    public GetCountryResponse updateCountry(@RequestPayload UpdateCountryRequest request) {
        Country updated = countryService.updateCountry(request.getCountry());
        return new GetCountryResponse(updated);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllCountriesRequest")
    @ResponsePayload
    public GetAllCountriesResponse getAllCountries(@RequestPayload GetAllCountriesRequest request) {
        GetAllCountriesResponse response = new GetAllCountriesResponse();
        response.setCountry(countryService.getAllCountries());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteCountryRequest")
    public void deleteCountry(@RequestPayload DeleteCountryRequest request) {
        countryService.deleteCountry(request.getId());
    }
}
