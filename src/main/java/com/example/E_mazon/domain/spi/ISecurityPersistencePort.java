package com.example.E_mazon.domain.spi;

public interface ISecurityPersistencePort {
    void setToken(String jwtToken);
    String getToken();
    void removeToken();
}
