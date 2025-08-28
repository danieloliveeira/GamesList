package com.wydengames.wydenlist.services;

public interface GameApplicationFlux <T, R> {
    R process(T request);
}
