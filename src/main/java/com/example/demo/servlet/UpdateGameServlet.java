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

@WebServlet(urlPatterns = "/games/update")
public class UpdateGameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idGame = req.getParameter("id");

        try {
            Long id = Long.parseLong(idGame);
            System.out.println(id);
            GameDao dao = new GameDao();
            Optional<Game> game = dao.findById(id);
            System.out.println(game.toString());

            if (game.isPresent()) {
                req.setAttribute("game", game.get());
            } else {
                //TODO : game not found
            }
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
        req.getRequestDispatcher("/WEB-INF/update-game.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("gameId"));
        String name = req.getParameter("gameName");
        String description = req.getParameter("gameDescription");
        Game game = new Game(id, name, description);
        GameDao gameDao = new GameDao();
        gameDao.update(game);

        resp.sendRedirect(req.getContextPath() + "/games");
    }
}
