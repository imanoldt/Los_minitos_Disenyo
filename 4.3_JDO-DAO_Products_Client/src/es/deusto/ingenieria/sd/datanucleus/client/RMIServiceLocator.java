package es.deusto.ingenieria.sd.datanucleus.client;

import java.rmi.Naming;

import es.deusto.ingenieria.sd.datanucleus.jdo.remote.IProductFinder;

public class RMIServiceLocator {

	private IProductFinder pf;

	public void setService(String ip, String port, String serviceName) {
		String url = "//" + ip + ":" + port + "/" + serviceName;
		System.out.println("Client looking for service : //" + ip + ":" + port + "/" + serviceName);
		
		try {
			pf = (IProductFinder) Naming.lookup(url);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public IProductFinder getService() {
		return pf;
	}
}
