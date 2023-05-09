package ru.sanctio.jakarta_laba;

import java.util.Objects;

public class Address {
    private String ip;
    private String mac;
    private String model;
    private String address;
    private Client client;

    public Address(String ip, String mac, String model, String address) {
        setIp(ip);
        setMac(mac);
        setModel(model);
        setAddress(address);
    }

    public String getIp() {
        return ip;
    }

    private void setIp(String ip) {
        Objects.requireNonNull(ip, "The ip value cannot be empty");
        if(ip.length() > 25)
            throw new IllegalArgumentException("The ip length should not exceed 25 characters");
        if(ip.matches("^(([01]?\\d?\\d|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d?\\d|2[0-4]\\d|25[0-5])$")) {
            this.ip = ip;
        } else {
            throw new IllegalArgumentException("You entered an incorrect ip address");
        }
    }

    public String getMac() {
        return mac;
    }

    private void setMac(String mac) {
        Objects.requireNonNull(mac, "The mac value cannot be empty");
        if(mac.length() > 20)
            throw new IllegalArgumentException("The mac length should not exceed 20 characters");
        if(mac.matches("^([0-9A-Za-z]{2}[-]){5}([0-9A-Za-z]{2})$")) {
            this.mac = mac;
        } else {
            throw new IllegalArgumentException("You entered an incorrect mac address");
        }
    }

    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        Objects.requireNonNull(model, "The model value cannot be empty");
        if(model.length() > 100)
            throw new IllegalArgumentException("The model length should not exceed 100 characters");
        this.model = model;
    }

    public String getAddress() {
        return address;
    }

    private void setAddress(String address) {
        Objects.requireNonNull(address, "The address value cannot be empty");
        if(address.length() > 200)
            throw new IllegalArgumentException("The address length should not exceed 200 characters");
        this.address = address;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return Objects.equals(ip, address1.ip) && Objects.equals(mac, address1.mac) && Objects.equals(model, address1.model) && Objects.equals(address, address1.address) && Objects.equals(client, address1.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, mac, model, address, client);
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append(" { ip = ");
        stringBuilder.append(ip);
        stringBuilder.append(", mac = ");
        stringBuilder.append(mac);
        stringBuilder.append(", model = ");
        stringBuilder.append(model);
        stringBuilder.append(", address = ");
        stringBuilder.append(address);
        stringBuilder.append(", client = ");
        stringBuilder.append(client);
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
