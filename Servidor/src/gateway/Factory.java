package gateway;

import domain.TipoProvedor;
import services.LoginAppService;

public class Factory {
	private static Factory instance;
	
	private Factory() {}
	
	public static Factory getInstance() {
		if(instance == null) {
			instance = new Factory();
		}
		return instance;
	}
	
	public Gateway createGateway(TipoProvedor t) {
		if(t.equals(TipoProvedor.GOOGLE)) {
			return GoogleGateway.getInstance();
		} else if(t.equals(TipoProvedor.FACEBOOK)) {
			return FacebookGateway.getInstance();
		}
		return LoginAppService.getInstance();
	}

}
