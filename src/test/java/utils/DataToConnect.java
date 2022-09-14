package utils;

public enum DataToConnect {
    LOGIN("Dmitryb"),
    PASSWORD("Karambola02032003"),
    HOST("192.168.0.108");

    private final String value;

    DataToConnect(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
