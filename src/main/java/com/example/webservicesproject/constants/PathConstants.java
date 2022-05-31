package com.example.webservicesproject.constants;

public interface PathConstants {

    String BASE = "/api";
    String VERSION_0 = "/v0";
    String ID = "/{id}";
    String USERNAME = "/{username}";


    interface Customer {
        String RESOURSE = "/customer";
        String RESOURSE_BASE_V0 = BASE + VERSION_0 + RESOURSE;
    }

    interface Order {
        String RESOURSE = "/order";
        String RESOURSE_BASE_V0 = BASE + VERSION_0 + RESOURSE;
    }

    interface Login {
        String RESOURSE = "/login";
        String RESOURSE_BASE_V0 = BASE + VERSION_0 + RESOURSE;
    }

    interface Product {
        String RESOURSE = "/product";
        String RESOURSE_BASE_V0 = BASE + VERSION_0 + RESOURSE;
    }

    interface Stock {
        String RESOURSE = "/stock";
        String RESOURSE_BASE_V0 = BASE + VERSION_0 + RESOURSE;
    }
}
