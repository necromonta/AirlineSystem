/**
 * Module restapi_module.
 */
module restapi_module {

    requires businesslogic_api_module;
    requires datarecords_module;

    requires java.logging;
    requires java.base;
        
    requires io.javalin;
    //requires jackson.databind;
    
    exports io.github.fontysvenlo.ais.restapi;
}
