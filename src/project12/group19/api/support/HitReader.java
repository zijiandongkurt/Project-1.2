package project12.group19.api.support;

import project12.group19.api.domain.Player;

import java.io.IOException;
import java.util.List;

public interface HitReader {
    List<Player.Hit> read(String... pathPatterns) throws IOException;
}
