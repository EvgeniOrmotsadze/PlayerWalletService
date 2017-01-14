package com.player.controller.operations;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by root_pc on 1/14/2017.
 */


public class Withdraw extends HttpServlet{

    private static final long serialVersionUID = 1L;

    public Withdraw() {
        super();
    }


    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
