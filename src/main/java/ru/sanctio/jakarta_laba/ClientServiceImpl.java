package ru.sanctio.jakarta_laba;

import jakarta.ejb.Stateless;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Stateless
public class ClientServiceImpl implements ClientService{
    private static Set<Address> addressList;

    static {
        addressList = new HashSet<>();
        var client1 = new Client(1, "Андрей", Type.TYPE2);
        var address1 = new Address("192.24.26.245", "9f-22-hh-8d-gd-A9", "model1", "dsvdbvh dvhdbhvb dbvhbdh");
        client1.addAddress(address1);
        addressList.add(address1);

        var client2 = new Client(2, "Михаил", Type.TYPE2);
        var address2 = new Address("243.111.123.14", "77-6s-52-7f-ja-4h", "model2", "scbhsadbc skbfchdeb wjdfi");
        var address3 = new Address("122.177.133.19", "GG-63-9d-3j-kc-2y", "model6", "ncjsc nwjq");
        client2.addAddress(address2, address3);
        addressList.add(address2);
        addressList.add(address3);

        var client3 = new Client(3, "Ольга", Type.TYPE1);
        var address4 = new Address("12.240.255.153", "AA-6d-9g-Ja-73-Fs", "model3", "jmkjhmk lmnkhg axzsa");
        client3.addAddress(address4);
        addressList.add(address4);

        var client4 = new Client(4, "Яна", Type.TYPE1);
        var address5 = new Address("234.25.64.244", "hd-83-6f-7s-9a-JJ", "model4", "wkdkij qkwsjiqwj kwjdij");
        var address6 = new Address("255.255.255.255", "n2-73-II-83-jg-8r", "model7", "qskq lfkkre  hqs");
        client4.addAddress(address5, address6);
        addressList.add(address5);
        addressList.add(address6);

        var client5 = new Client(5, "Александр", Type.TYPE1);
        var address7 = new Address("132.211.55.12", "gg-8w-3k-LL-42-1p", "model5", "qoksoqk qpslq grty4");
        client5.addAddress(address7);
        addressList.add(address7);
    }
    @Override
    public List<Address> getAllInformation() {
        return new ArrayList<>(addressList);
    }
}
