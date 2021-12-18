package com.example.domain;

public class Address {
    private String city;
    private String state;
    private String zip;

    Address(String city, String state, String zip) {
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public static AddressBuilder builder(final String state) {
        return new AddressBuilder(state);
    }

    public static class AddressBuilder {
        private String city;
        private final String state;
        private String zip;

        AddressBuilder(final String state) {
            this.state = state;
        }

        public AddressBuilder city(String city) {
            this.city = city;
            return this;
        }

        public AddressBuilder zip(String zip) {
            this.zip = zip;
            return this;
        }

        public Address build() {
            return new Address(city, state, zip);
        }

        public String toString() {
            return "Address.AddressBuilder(city=" + this.city + ", state=" + this.state + ", zip=" + this.zip + ")";
        }
    }
}
