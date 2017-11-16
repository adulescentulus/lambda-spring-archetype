#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.model;

public class ExampleResponse {

    private final String name;

    public ExampleResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}