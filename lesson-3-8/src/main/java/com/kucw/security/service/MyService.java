package com.kucw.security.service;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

public interface MyService {

    // 權限判定時機點
    // PreAuthorize 在執行前就確認是否有權限
    // PostAuthorize 在執行後才確認是否有權限，沒權限就不回傳值，但是還是會執行到中間的步驟

    @PreAuthorize("hasRole('ADMIN')")
    String getMovie();

    String deleteMovie();
}
