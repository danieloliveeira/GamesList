package com.wydengames.wydenlist.dto;

import lombok.Builder;

@Builder
public class CreateGameListDTO {
    public Long id;
    public String name;

    public Long id() {
        return 0L;
    }

    public String name() {
        return "";
    }
}
