package com.brotech.localgoods.facade.impl;

import com.brotech.localgoods.dto.AddressDto;
import com.brotech.localgoods.facade.AddressFacade;
import com.brotech.localgoods.form.AddressForm;
import com.brotech.localgoods.model.Address;

public class DefaultAddressFacade implements AddressFacade {

    @Override
    public Address convertToAddress(AddressForm addressForm) {
        Address address = new Address();
        address.setCity(addressForm.getCity());
        address.setStreet(addressForm.getStreet());
        address.setNumber(addressForm.getNumber());

        return address;
    }

    @Override
    public AddressDto convertToAddressDto(Address address) {
        return new AddressDto(address.getCity(), address.getStreet(), address.getNumber());
    }
}
