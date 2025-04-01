/**
 * Module restapi_module.
 */
module restapi_module {

    requires datarecords_module;
    requires io.javalin;
    //copilot said to change it from requires com.fasterxml.jackson.databind;
    requires jdk.compiler;
    requires businesslogic_module;
    requires businesslogic_api_module;
    requires com.fasterxml.jackson.databind;

    exports io.github.fontysvenlo.ais.restapi;
}
