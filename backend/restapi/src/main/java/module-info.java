/**
 * Module restapi_module.
 */
module restapi_module {

    requires java.logging;
    requires datarecords_module;
    requires io.javalin;
    requires com.fasterxml.jackson.core;//copilot said to change it from requires com.fasterxml.jackson.databind;
    requires jdk.compiler;
    requires businesslogic_module;
    requires businesslogic_api_module;

    exports io.github.fontysvenlo.ais.restapi;
}
