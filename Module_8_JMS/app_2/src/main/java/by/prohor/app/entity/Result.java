package by.prohor.app.entity;

/**
 * Created by Artsiom Prokharau 12.08.2021
 */

public enum Result {
    ACCEPT("accepted"), REJECT("rejected");

    private final String result;

    Result(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
