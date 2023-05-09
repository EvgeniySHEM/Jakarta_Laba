package ru.sanctio.jakarta_laba;

import jakarta.ejb.Local;

import java.util.Set;
@Local
public interface ClientService {
    Set<Address> getAllInformation();
}
