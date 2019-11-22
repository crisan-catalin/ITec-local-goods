package com.brotech.localgoods.service;

import com.brotech.localgoods.model.Address;

/**
 * AddressService for address operations.
 */
public interface AddressService {

  /**
   * Save address via AddressRepository
   *
   * @param address the address
   * @return saved entity
   */
  Address save(Address address);
}
