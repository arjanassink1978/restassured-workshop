package io.techchamps.workshop.builders;

import generated.dtos.AddressRequest;

public class AddressRequestBuilder {

    private final AddressRequest addressRequest = new AddressRequest();

    public AddressRequestBuilder() {
        addressRequest.setStreet("Some street");
        addressRequest.setHouseNumber("5");
        addressRequest.setZipcode("1111AA");
        addressRequest.setCity("Enschede");
        addressRequest.setCountry("Netherlands");
    }

    public AddressRequestBuilder withStreet(String street) {
        addressRequest.setStreet(street);
        return this;
    }

    public AddressRequestBuilder withHouseNumber(String houseNumber) {
        addressRequest.setHouseNumber(houseNumber);
        return this;
    }

    public AddressRequestBuilder withZipCode(String zipCode) {
        addressRequest.setZipcode(zipCode);
        return this;
    }

    public AddressRequestBuilder withCity(String city) {
        addressRequest.setCity(city);
        return this;
    }

    public AddressRequestBuilder withCountry(String country) {
        addressRequest.setCountry(country);
        return this;
    }

    public AddressRequest build() {
        return addressRequest;
    }
}
