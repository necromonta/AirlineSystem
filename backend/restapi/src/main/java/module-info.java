/**
 * Module restapi_module.
 */
module restapi_module {

    requires businesslogic_api_module;
    requires datarecords_module;

    requires java.logging;

    requires io.javalin;
    requires com.fasterxml.jackson.databind;
    requires jdk.compiler;

    exports io.github.fontysvenlo.ais.restapi;
}
