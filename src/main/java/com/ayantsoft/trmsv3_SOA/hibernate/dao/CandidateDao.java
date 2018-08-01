package com.ayantsoft.trmsv3_SOA.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.ayantsoft.trmsv3_SOA.hibernate.util.HibernateUtil;
import com.ayantsoft.trmsv3_SOA.util.CandidateUtil;

@Repository
public class CandidateDao implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8035847305275813372L;


	public List<CandidateUtil> findCandidate(String propertyName,String propertyValue){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<CandidateUtil> results = null;
		try{
			String hql = "SELECT c.candidateId as candidateId,c.firstName as candidateName,c.currentLocation as candidateCurrentLocation,"
					+ "c.preferedLocation as candidatePreferredLocation,c.immigrationType as candidateVisa,c.totalAmount as totalAmount,"
					+ "c.enrollmentDate as enrollmentDate,ad.email as candidateEmail,"
					+ "ad.workMobile as candidateWorkMobile,emp.name as recruiterName,superVisor.name as supervisorName "
					+ "FROM Candidate c "
					+ "INNER JOIN c.contactAddress ad "
					+ "INNER JOIN c.employee emp "
					+ "LEFT OUTER JOIN emp.employee superVisor ";
			if(propertyName.equals("id")){
				hql = hql + "WHERE c.candidateId = :canId";
			}
			if(propertyName.equals("name")){
				hql = hql + "WHERE c.firstName = :firstName";
			}
			if(propertyName.equals("email")){
				hql = hql + "WHERE ad.email = :email";
			}
			if(propertyName.equals("phone_no")){
				hql = hql + "WHERE ad.workMobile = :workMobile";
			}

			Query query = session.createQuery(hql);
			if(propertyName.equals("id")){
				query.setParameter("canId",Integer.valueOf(propertyValue));
			}
			if(propertyName.equals("name")){
				query.setParameter("firstName",(String)propertyValue);
			}
			if(propertyName.equals("email")){
				query.setParameter("email",(String)propertyValue);
			}
			if(propertyName.equals("phone_no")){
				query.setParameter("workMobile",(String)propertyValue);
			}
			query.setResultTransformer(Transformers.aliasToBean(CandidateUtil.class));
			results = query.list();

		}catch(HibernateException he){
			he.printStackTrace();
			throw he;
		}finally{
			session.close();
		}
		return results;
	}


}
