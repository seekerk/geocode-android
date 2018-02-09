package org.fruct.oss.geopoint;


/**
  * null
 */
public class ternary_value {

    private static final String TYPE_URI = "http://www.semanticweb.org/kulakov/ontologies/2018/0/untitled-ontology-2#ternary_value";

    private String value;

    <T> ternary_value(T value) {
        check_type(value);
        this.value = value.toString();
    }

    public String getValue() {
        return value;
    }

    public static <T> ternary_value getInstance(T value, String accessPointName) {
        return new ternary_value(value);
    }

    public static <T> ternary_value getInstance(T value) {
        return new ternary_value(value);
    }

    public String getID() {
        return value;
    }

    private <T> void check_type(T value) {
        //TODO: check value type
    }
}