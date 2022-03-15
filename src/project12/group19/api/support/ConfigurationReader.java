package project12.group19.api.support;

import project12.group19.api.game.Configuration;

import java.io.IOException;

public interface ConfigurationReader {
    Configuration read(String path) throws IOException;
}
