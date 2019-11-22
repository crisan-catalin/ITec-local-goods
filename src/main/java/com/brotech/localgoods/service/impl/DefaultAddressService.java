package com.brotech.localgoods.service.impl;

import com.brotech.localgoods.model.Address;
import com.brotech.localgoods.repository.AddressRepository;
import com.brotech.localgoods.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultAddressService implements AddressService {

  @Autowired
  private AddressRepository addressRepository;

  @Override
  public Address save(Address address) {
    return addressRepository.save(address);
  }
}
