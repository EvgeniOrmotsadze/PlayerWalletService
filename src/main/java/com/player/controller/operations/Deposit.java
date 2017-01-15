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

@WebServlet("/deposit")
public class Deposit extends HttpServlet{

    private static final long serialVersionUID = 1L;

    public Deposit() {
        super();
    }


    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int playerId = -1; double amount = 0.0;
        try {
            playerId = Integer.parseInt(request.getParameter("player_id"));
            amount = Double.parseDouble(request.getParameter("amount"));
        }catch (Exception e){
            response.getWriter().write("Incorrect Parameters");
        }
        WalletService walletService = new WalletService(playerId, new DatabaseServiceImpl());
        try {
            walletService.deposit(amount);
            response.getWriter().write("Deposit Made Successfully");
        } catch (Exception e) {
            response.getWriter().write(e.getMessage());
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
