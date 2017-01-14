package com.player.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by root_pc on 1/14/2017.
 */

@WebServlet("/playerService")
public class PlayerService extends HttpServlet{

        private static final long serialVersionUID = 1L;

        public PlayerService() {
            super();
        }


        protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("home-wallet.jsp");
            dispatcher.forward(request, response);
        }


        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
        }

}
