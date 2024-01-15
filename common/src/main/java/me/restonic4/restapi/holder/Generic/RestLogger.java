package me.restonic4.restapi.holder.Generic;

import me.restonic4.restapi.RestApiVariables;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RestLogger {
    private final String modId;
    private final Logger logger;

    public RestLogger(String modId) {
        this.modId = modId;
        this.logger = LogManager.getLogger(modId);

        log("Logger created for " + modId + "!");
    }

    public String getObjectMessage(Object object) {
        return (object != null) ? object.toString() : "null";
    }

    public void log(Object message) {
        logger.info(getFullMessage(getObjectMessage(message)));
    }

    public void error(Object message) {
        logger.error(getFullMessage(getObjectMessage(message)));
    }

    public void warn(Object message) {
        logger.warn(getFullMessage(getObjectMessage(message)));
    }

    private String getMixedId() {
        return "[" + RestApiVariables.MOD_ID + " + " + modId + "]";
    }

    private String getFullMessage(String message) {
        return getMixedId() + " -> " + message;
    }
}
