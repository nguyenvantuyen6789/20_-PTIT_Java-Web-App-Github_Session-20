package com.data.repository;

import com.data.entity.Room;
import com.data.entity.Seat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class SeatRepositoryImpl implements SeatRepository {

    private SessionFactory sessionFactory;

    public SeatRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Seat> findAll() {
        Session session = null;

        List<Seat> seats = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            Query<Seat> query = session.createQuery("FROM Seat");
            seats = query.getResultList();

            return seats;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return seats;
    }

}
