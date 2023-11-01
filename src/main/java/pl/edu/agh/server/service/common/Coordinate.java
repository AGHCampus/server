package pl.edu.agh.server.service.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@RequiredArgsConstructor
@Getter
public class Coordinate implements Serializable {
    private final double longitude;
    private final double latitude;
}
