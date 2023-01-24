package dao;

import java.util.ArrayList;
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
import domain.UserLocal;

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
	public void storeReto(Reto r) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println("   * Storing a reto: " + r.getNombre());
			pm.makePersistent(r);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error storing a reto: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}
	
	@Override
	public void storeSesion(Sesion s) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println("   * Storing a sesion: " + s.getTitulo());
			pm.makePersistent(s);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error storing a sesion: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
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
			Query<?> query = pm.newQuery("SELECT FROM " + UserLocal.class.getName() + " WHERE email == '" + mail + "'");
			query.setUnique(true);
			u = (User) query.execute();
			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error retreiving a user: " + ex.getMessage());
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
		List<Reto> l = new ArrayList<>();

		try {
			System.out.println("   * Querying Reto List from: " + u.getEmail());

			tx.begin();
			Extent<Reto> extent = pm.getExtent(Reto.class);
			for(Reto r: extent) {
				if(r.getUser().equals(u.getEmail()) && r.getIsActive() == 0) {
					l.add(r);
				}
			}
			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error retreiving retos: " + ex.getMessage());
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
		List<Sesion> l = new ArrayList<>();

		try {
			System.out.println("   * Querying Reto List from: " + u.getEmail());

			tx.begin();
			Extent<Sesion> extent = pm.getExtent(Sesion.class);
			for(Sesion s: extent) {
				if(s.getUser().equals(u.getEmail())) {
					l.add(s);
				}
			}
			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error retreiving retos: " + ex.getMessage());
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
		List<Reto> l = new ArrayList<>();

		try {
			System.out.println("   * Querying Reto List from: " + u.getEmail());

			tx.begin();
			Extent<Reto> extent = pm.getExtent(Reto.class);
			for(Reto r: extent) {
				if(r.getUser().equals(u.getEmail()) && r.getIsActive() != 0) {
					l.add(r);
				}
			}
			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error retreiving retos: " + ex.getMessage());
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
			
			Extent<UserLocal> uExtent = pm.getExtent(UserLocal.class);
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
			pm.deletePersistent(u);
			pm.makePersistent(u);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error updating a user: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}
	
	@Override
	public void updateReto(Reto r) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			pm.deletePersistent(r);
			pm.makePersistent(r);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error updating a reto: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}
	
	@Override
	public void updateSesion(Sesion s) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			pm.deletePersistent(s);
			pm.makePersistent(s);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error updating a sesion: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}

}
