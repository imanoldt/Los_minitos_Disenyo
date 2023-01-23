package dao;

import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import domain.Reto;
import domain.Sesion;
import domain.User;

public class DAO implements IDAO {
	
	private PersistenceManagerFactory pmf;
	private static DAO instance;
	
	private DAO() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	public static DAO getInstance() {
		if(instance == null) {
			instance = new DAO();
		}
		return instance;
	}

	@Override
	public void storeUser(User u) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println("   * Storing a user: " + u.getEmail());
			pm.makePersistent(u);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error storing a user: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}

	@Override
	public User getUser(String mail, String pass) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		User u = null;

		try {
			System.out.println("   * Querying a User: " + mail);

			tx.begin();
			Query<?> query = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE email == '" + mail + "' and password == '" + pass + "'");
			query.setUnique(true);
			u = (User) query.execute();
			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
			return null;
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return u;
	}
	
	@Override
	public User getUser(String mail) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		User u = null;

		try {
			System.out.println("   * Querying a User: " + mail);

			tx.begin();
			Query<?> query = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE email == '" + mail + "'");
			query.setUnique(true);
			u = (User) query.execute();
			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
			return null;
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return u;
	}

	@Override
	public List<Reto> getRetos(User u) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		List<Reto> l = null;

		try {
			System.out.println("   * Querying Reto List from: " + u.getEmail());

			tx.begin();
			Query<?> query = pm.newQuery("SELECT retos FROM " + User.class.getName() + " WHERE email == '" + u.getEmail() + "'");
			query.setUnique(true);
			l = (List<Reto>) query.execute();
			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
			return null;
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return l;
	}

	@Override
	public List<Sesion> getSesiones(User u) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		List<Sesion> l = null;

		try {
			System.out.println("   * Querying Reto List from: " + u.getEmail());

			tx.begin();
			Query<?> query = pm.newQuery("SELECT sesiones FROM " + User.class.getName() + " WHERE email == '" + u.getEmail() + "'");
			query.setUnique(true);
			l = (List<Sesion>) query.execute();
			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
			return null;
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return l;
	}

	@Override
	public List<Reto> getRetosAct(User u) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		List<Reto> l = null;

		try {
			System.out.println("   * Querying Reto Act. List from: " + u.getEmail());

			tx.begin();
			Query<?> query = pm.newQuery("SELECT retos FROM " + User.class.getName() + " WHERE email == '" + u.getEmail() + "'");
			query.setUnique(true);
			l = (List<Reto>) query.execute();
			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
			return null;
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return l;
	}

	@Override
	public void deleteAllUsers() {
		System.out.println("- Cleaning the DB...");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			
			Extent<User> uExtent = pm.getExtent(User.class);
			for(User u: uExtent) {
				System.out.println("- Deleted User from DB: " + u.getEmail());
				pm.deletePersistent(u);
			}
			
			tx.commit();
		} catch (Exception ex) {
			System.err.println(" $ Error cleaning the DB: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
	}

	@Override
	public void updateUser(User u) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			pm.makePersistent(u);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}

}
