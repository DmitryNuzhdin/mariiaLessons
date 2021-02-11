package springFirstTry.a.dto;

import javafx.util.Pair;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

public class MarketVolumesDTO implements Serializable {
    long typeId;
    LocalDateTime timestamp;
    Map<Double, Pair<Long, Long>> volumes;
}
