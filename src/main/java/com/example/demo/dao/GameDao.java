package com.example.demo.dao;

import com.example.demo.connection.EntityManagerConnection;
import com.example.demo.model.Game;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class GameDao implements Dao<Game> {


    private static Long idSequence = 1L;


    EntityManagerFactory emf = EntityManagerConnection.getEntityManager();

    @Override
    public List<Game> getAll() {
        List<Game> gameList = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            TypedQuery<Game> query = em.createQuery("SELECT b FROM Game b", Game.class);
            gameList = query.getResultList();
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return gameList;
    }



    @Override
    public void save(Game game) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(game);
            et.commit();
            System.out.println("game added");
        } catch (Exception e) {
            System.out.println("can't add the game");
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<Game> findById(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        System.out.println("Je suis dans le findById");
        System.out.println(id);
        try {
            et.begin();
            Game game = em.createQuery("SELECT b FROM Game b  WHERE b.id = :idParam", Game.class)
                    .setParameter("idParam", id)
                    .getSingleResult();
            et.commit();
            return Optional.of(game);
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return Optional.empty();
    }


    @Override
    public void update(Game gameParam) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Long id = gameParam.getId();

        try {
            et.begin();
            Game game = em.find(Game.class, id);

            if (Objects.equals(game.getId(), gameParam.getId())) {
                game.setName(gameParam.getName());
                game.setDescription(gameParam.getDescription());
            }
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }

    }



    @Override
    public void delete(Game gameToDelete) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Game game = em.find(Game.class, gameToDelete.getId());
            em.remove(game);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
    }
}
