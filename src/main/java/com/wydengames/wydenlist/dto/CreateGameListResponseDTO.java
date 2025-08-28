package com.wydengames.wydenlist.dto;

import lombok.Builder;

@Builder
public record CreateGameListResponseDTO(Long id, String name){}
