package models.api.routes.resources;

import models.api.routes.Routes;

public class BookStoreRoutes extends Routes {

    public static final String BOOKSTORE = "/BookStore";
    public static final String BOOKS = "/Books";

    public static String booksInBookStore(){
        return BOOKSTORE + VERSION + BOOKS;
    }
}
