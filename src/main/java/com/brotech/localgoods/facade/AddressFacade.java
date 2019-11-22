package com.brotech.localgoods.facade;

import com.brotech.localgoods.dto.AddressDto;
import com.brotech.localgoods.form.AddressForm;
import com.brotech.localgoods.model.Address;

/**
 * Used for general address operations.
 */
public interface AddressFacade {

    /**
     * Convert the addressForm to Address
     *
     * @param addressForm the {@link AddressForm}
     * @return the {@link Address}
     */
    Address convertToAddress(AddressForm addressForm);

    /**
     * Convert the Address to AddressDto
     *
     * @param address the {@link Address}
     * @return the {@link AddressDto}
     */
    AddressDto convertToAddressDto(Address address);
}
