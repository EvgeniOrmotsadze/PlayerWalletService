package com.player.controller.operations;

import com.player.repository.DatabaseServiceImpl;
import com.player.service.WalletService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by root_pc on 1/14/2017.
 */

@WebServlet("/createWallet")
public class CreateWallet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    public CreateWallet() {
        super();
    }


    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        try {
            int playerId = Integer.parseInt(request.getParameter("player_id"));
            WalletService walletService = new WalletService(playerId, new DatabaseServiceImpl());
            walletService.createWallet();
            response.getWriter().write("Create Successfully");
        } catch (Exception e) {
            response.getWriter().write("Not Created");
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
