package com.kucw.security.service;

import org.springframework.security.access.prepost.PreAuthorize;

public interface MyService {

    @PreAuthorize("hasRole('ADMIN')")
    String getMovie();

    String deleteMovie();
}
