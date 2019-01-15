package hibernate;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

@Entity
@Table(name = "podaci")
public class Podaci implements Serializable{
    
    @Id
    @Column(name = "podaci_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ime;
    private int broj_godina;
    private String adresa;
    private int visina_dohotka;

    
    

    public static List<Podaci> List() throws SQLException {
        SessionFactory sessionFactory = datoteka.HibernateUtil.createSessionFactory();
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();
        List<Podaci> ls = s.createCriteria(Podaci.class).list();
        s.getTransaction().commit();
        return ls;
    }
    
    
    public static Podaci GetByID(int id) throws SQLException {
        SessionFactory sessionFactory = datoteka.HibernateUtil.createSessionFactory();
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();
        List<Podaci> podatci = s.createCriteria(Podaci.class).add(Restrictions.eq("id", id)).list();
        Podaci podatak = podatci.get(0);
        s.getTransaction().commit();
        return podatak;
    }

    public void Add() throws SQLException {
        SessionFactory  sessionFactory = datoteka.HibernateUtil.createSessionFactory();
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();
        Podaci p = new Podaci();
        p.ime = getIme();
        p.broj_godina = getBrojGodina();
        p.adresa = getAdresa();
        p.visina_dohotka = getVisinaDohotka();
        s.persist(p);
        s.getTransaction().commit();
    }

    public static List<Podaci> Search(String query) throws SQLException {
        SessionFactory  sessionFactory = datoteka.HibernateUtil.createSessionFactory();
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();
        List<Podaci> ls = s.createCriteria(Podaci.class)
        .add(Restrictions.like("ime", query)).list();
        s.getTransaction().commit();
        return ls;
    }

    public void UpdateAdresa() throws SQLException {
        SessionFactory  sessionFactory = datoteka.HibernateUtil.createSessionFactory();
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();
        Podaci p = GetByID(getId());
        p.adresa = getAdresa();
        s.update(p);
        s.getTransaction().commit();
    }

    public void UpdateVisinaDohotka() throws SQLException {
        SessionFactory  sessionFactory = datoteka.HibernateUtil.createSessionFactory();
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();
        Podaci p = GetByID(getId());
        p.visina_dohotka = getVisinaDohotka();
        s.update(p);
        s.getTransaction().commit();
    }

    public void Delete() throws SQLException {
        SessionFactory  sessionFactory = datoteka.HibernateUtil.createSessionFactory();
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();
        Podaci p = new Podaci();
        p.id = getId();
        p.ime = getIme();
        p.broj_godina = getBrojGodina();
        p.adresa = getAdresa();
        p.visina_dohotka = getVisinaDohotka();
        s.delete(p);
        s.getTransaction().commit();
        
        
    }

    
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    
    public String getIme() {
        return ime;
    }

    
    public void setIme(String ime) {
        this.ime = ime;
    }

    
    public int getBrojGodina() {
        return broj_godina;
    }

    
    public void setBrojGodina(int broj_godina) {
        this.broj_godina = broj_godina;
    }

    
    public String getAdresa() {
        return adresa;
    }

    
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    
    public int getVisinaDohotka() {
        return visina_dohotka;
    }

    
    public void setVisinaDohotka(int visina_dohotka) {
        this.visina_dohotka = visina_dohotka;
    }
    
    public Podaci(String ime, int broj_godina, String adresa, int visina_dohotka) {
        this.ime = ime;
        this.broj_godina = broj_godina;
        this.adresa = adresa;
        this.visina_dohotka = visina_dohotka;
    }

    Podaci() {
        }
    @Override
    public String toString() {
        return "ID je: " + getId() + " " + "Ime: " + getIme() + " " + "Broj godina: " + getBrojGodina()+ " " + "Adresa: " + getAdresa()+ " " + " Visina dohotka: " + getVisinaDohotka();
    }
}
