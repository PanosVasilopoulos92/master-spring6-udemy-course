package org.viators.eazyschool.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.viators.eazyschool.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
