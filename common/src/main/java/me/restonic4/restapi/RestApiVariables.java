package me.restonic4.restapi;

import me.restonic4.restapi.holder.Generic.RestLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RestApiVariables {
    //MAIN VARIABLES

    public static final String MOD_ID = "restapi";
    public static final String MOD_NAME = "restApi";

    public static final RestLogger API_LOGGER = new RestLogger(MOD_ID);

    //OTHER VARIABLES

    public static final String NOT_IMPLEMENTED_MC = "THIS IS NOT IMPLEMENTED IN THIS MINECRAFT VERSION.";
}
