package io.techchamps.workshop.builders;

import generated.dtos.AddressRequest;
import generated.dtos.ProfileRequest;

public class ProfileRequestBuilder {

    private final ProfileRequest profileRequest = new ProfileRequest();

    public ProfileRequestBuilder() {
        profileRequest.addAddressesItem(new AddressRequestBuilder().build());
        profileRequest.addInterestsItem(ProfileRequest.InterestsEnum.FOOD);
        profileRequest.addInterestsItem(ProfileRequest.InterestsEnum.SPORTS);
    }

    public ProfileRequestBuilder withAddress(AddressRequest address) {
        profileRequest.getAddresses().clear();
        profileRequest.addAddressesItem(address);
        return this;
    }

    public ProfileRequestBuilder withInterest(ProfileRequest.InterestsEnum interest) {
        profileRequest.getInterests().clear();
        profileRequest.addInterestsItem(interest);
        return this;
    }

    public ProfileRequest build() {
        return profileRequest;
    }
}
