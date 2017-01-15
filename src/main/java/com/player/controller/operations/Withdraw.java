package com.player.controller.operations;

import com.player.repository.DatabaseServiceImpl;
import com.player.service.WalletService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by root_pc on 1/14/2017.
 */

@WebServlet("/withdraw")
public class Withdraw extends HttpServlet{

    private static final long serialVersionUID = 1L;

    public Withdraw() {
        super();
    }

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        try {
            int playerId = Integer.parseInt(request.getParameter("player_id"));
            double amount = Double.parseDouble(request.getParameter("amount"));
            WalletService walletService = new WalletService(playerId, new DatabaseServiceImpl());
            walletService.withdraw(amount);
            response.getWriter().write("Withdraw Made Successfully");
        } catch (NumberFormatException e) {
            response.getWriter().write("incorrect parameters");
        } catch (IllegalArgumentException e) {
            response.getWriter().write(e.getMessage());
        } catch (SQLException e) {
            response.getWriter().write(e.getMessage());
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
