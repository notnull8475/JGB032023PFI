package ru.gb;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.mockito.Mockito.verify;

class HelloWorldServletTest {
    //    @Mock
//    private HttpServletRequest request = mock(HttpServletRequest.class);
//    @Mock
//    private HttpServletResponse response = mock(HttpServletResponse.class);
//    @Test
//    public void testHelloWorldServlet() throws Exception {
//        // create mock request and response objects
//
//
//        // create servlet instance
//        HelloWorldServlet servlet = new HelloWorldServlet();
//
//        // call servlet's doGet() method
//        servlet.doGet(request, response);
//
//        // verify response
//        verify(response).setContentType("text/html");
//        verify(response).setStatus(HttpServletResponse.SC_OK);
//        verify(response.getWriter()).write("<h1>Hello World</h1>");
//    }
//
    @Spy
    private HelloWorldServlet servlet;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Test
    public void test() throws Exception {
        servlet.doGet(request, response);
        verify(response).setContentType("text/html");
        verify(response).setStatus(HttpServletResponse.SC_OK);
        verify(response.getWriter()).write("<h1>Hello World</h1>");
    }
}