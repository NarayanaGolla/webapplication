package com.web.application.designpattern;

public class InterceptingFilterDemo {
    public static void main(String[] args) {
        FilterManager filterManager = new FilterManager(new Target());
        filterManager.setFilter(new AuthenticationFilter());

        Client client = new Client();
        client.setFilterManager(filterManager);

        client.sendRequest("HOME");
    }
}
