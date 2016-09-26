package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.model.ModelPegawai;

public class ManagePegawai {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	public ManagePegawai(){
		try {
			Configuration config = new Configuration();
			config.configure();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
			sessionFactory = config.buildSessionFactory(serviceRegistry);
		} catch (Throwable e) {
			System.err.println("Failed to create sessionFactory object." + e);
	        throw new ExceptionInInitializerError(e); 
		}
	}
	
	public Integer tambahPegawai(ModelPegawai pegawai){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer res = 0;
		try {
			tx = session.beginTransaction();
			res = (int) session.save(pegawai);
			tx.commit();
		} catch (HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}
	
	public Integer editPegawai(ModelPegawai pegawai){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer res = 0;
		try{
			tx = session.beginTransaction();
			ModelPegawai data = (ModelPegawai) session.get(ModelPegawai.class, pegawai.getIdpegawai());
			data.setNama(pegawai.getNama());
			data.setJenis_kelamin(pegawai.getJenis_kelamin());
			data.setAlamat(pegawai.getAlamat());
			session.update(data);
			tx.commit();
			res = 1;
		} catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}
	
	public Integer hapusData(int idpegawai){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer res = 0;
		try {
			tx = session.beginTransaction();
			ModelPegawai data = (ModelPegawai) session.get(ModelPegawai.class, idpegawai);
			session.delete(data);
			tx.commit();
			res = 1;
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}
	
	public ModelPegawai ambilDataPegawai(int idpegawai){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		ModelPegawai pegawai = new ModelPegawai();
		try{
			tx = session.beginTransaction();
			pegawai = (ModelPegawai) session.get(ModelPegawai.class, idpegawai);
		} catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return pegawai;
	}
	
	public List<ModelPegawai> ambilDaftarPegawai(){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<ModelPegawai> res = new ArrayList<ModelPegawai>();
		
		try{
			tx = session.beginTransaction();
			res = session.createQuery("FROM ModelPegawai").list();
			
		} catch (HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}
}
