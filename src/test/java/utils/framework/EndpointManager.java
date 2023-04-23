package utils.framework;

import models.api.models.resources.bookstore.BookStoreResources;

public class EndpointManager {

    private final String baseUrl;
    private final String accessToken;

    public EndpointManager(String baseUrl, String accessToken){
        this.baseUrl = baseUrl;
        this.accessToken = accessToken;
    }

    public BookStoreResources getBookStoreResources(){
        return new BookStoreResources(baseUrl, accessToken);
    }
}