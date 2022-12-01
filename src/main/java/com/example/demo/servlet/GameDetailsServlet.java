package com.example.demo.servlet;

import com.example.demo.dao.GameDao;
import com.example.demo.model.Game;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/games/game-details")
public class GameDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Long id = Long.parseLong(req.getParameter("id"));
            GameDao dao = new GameDao();
            Optional<Game> game = dao.get(id);

            if (game.isPresent()) {
                req.setAttribute("game", game.get());
            } else {
                //TODO : game not found
            }
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
        req.getRequestDispatcher("/WEB-INF/game-details.jsp").forward(req, resp);
    }
}
