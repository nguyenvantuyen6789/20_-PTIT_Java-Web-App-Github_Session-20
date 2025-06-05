package com.data.repository;

import com.data.entity.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class RoomRepositoryImpl implements RoomRepository {

    private SessionFactory sessionFactory;

    public RoomRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Room> findAll() {
        Session session = null;

        List<Room> rooms = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            Query<Room> query = session.createQuery("FROM Room WHERE status = true ORDER BY roomName");
            rooms = query.getResultList();

            return rooms;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return rooms;
    }

    @Override
    public Room findById(long id) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            Query<Room> query = session.createQuery("FROM Room WHERE id = :id");
            query.setParameter("id", id);
            Room room = query.getSingleResult();

            return room;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean delete(long id) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            Query<Room> query = session.createQuery("FROM Room WHERE id = :id");
            query.setParameter("id", id);
            Room room = query.getSingleResult();

            if (room != null) {
                session.beginTransaction();
                session.delete(room);
                session.getTransaction().commit();
                return true;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }
}
