package ru.sanctio.jakarta_laba;

import java.time.LocalDate;
import java.util.*;

public class Client implements Comparable {
    private int clientId;
    private String clientName;
    private String type;
    private LocalDate added;
    private Set<Address> addresses;

    public Client(int clientId, String clientName, Type type) {
        setClientId(clientId);
        setClientName(clientName);
        setType(type);
        this.added = LocalDate.now();
        addresses = new HashSet<>();
    }

    public Client(int clientId, String clientName, Type type, int year, int month, int day) {
        setClientId(clientId);
        setClientName(clientName);
        setType(type);
        setAdded(year, month, day);
        addresses = new HashSet<>();
    }

    public int getClientId() {
        return clientId;
    }

    private void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    private void setClientName(String clientName) {
        Objects.requireNonNull(clientName, "The client name value cannot be empty");
        if (clientName.length() > 100)
            throw new IllegalArgumentException("The client name length should not exceed 100 characters");
        if (clientName.matches("^[а-яёА-ЯЁ{\\-\\s,.}]+$")) {
            this.clientName = clientName;
        } else {
            throw new IllegalArgumentException("For the client name field, it is allowed\n" +
                    "to use only the Russian alphabet, as well\n" +
                    "as the characters {- ,.}");
        }
    }

    public String getType() {
        return type;
    }

    private void setType(Type type) {
        Objects.requireNonNull(type, "The type value cannot be empty");
        this.type = type.getClientType();
    }

    public LocalDate getAdded() {
        return added;
    }

    private void setAdded(int year, int month, int day) {
        if (year < LocalDate.EPOCH.getYear() || year > LocalDate.now().getYear())
            throw new IllegalArgumentException("You entered an incorrect year");
        this.added = LocalDate.of(year, month, day);
    }

    public Set<Address> getAddresses() {
        return new HashSet<>(addresses);
    }

    public void addAddress(Address... address) {
        for(Address ex : address) {
            addresses.add(ex);
            ex.setClient(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return clientId == client.clientId && Objects.equals(clientName, client.clientName) && type == client.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, clientName, type);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append(" { clientId = ");
        stringBuilder.append(clientId);
        stringBuilder.append(", clientName = ");
        stringBuilder.append(clientName);
        stringBuilder.append(", type = ");
        stringBuilder.append(type);
        stringBuilder.append(", added = ");
        stringBuilder.append(added);
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    @Override
    public int compareTo(Object o) {
        Client client = (Client) o;
        return this.clientId - client.clientId;
    }
}
