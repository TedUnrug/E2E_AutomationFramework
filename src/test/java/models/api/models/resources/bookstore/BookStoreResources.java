package models.api.models.resources.bookstore;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.api.models.RequestSpecificationBuilder;
import models.api.routes.resources.BookStoreRoutes;

public class BookStoreResources extends RequestSpecificationBuilder {

    RequestSpecification requestSpecification = getRequestSpecification();

    public BookStoreResources(String baseUrl, String accessToken) {
        super(baseUrl, accessToken);
    }

    public Response getBooks(){
        return requestSpecification.get(BookStoreRoutes.booksInBookStore());
    }
}