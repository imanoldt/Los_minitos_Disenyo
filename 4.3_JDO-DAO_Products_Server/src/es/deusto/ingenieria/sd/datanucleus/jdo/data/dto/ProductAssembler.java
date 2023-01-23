package es.deusto.ingenieria.sd.datanucleus.jdo.data.dto;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.datanucleus.jdo.data.domain.Product;

public class ProductAssembler {

	
	public ProductDTO domainObjectToDTO(Product product) {
		ProductDTO dto = new ProductDTO();
		
		dto.setName(product.getName());
		dto.setDescription(product.getDescription());
		dto.setPrice(product.getPrice());
		
		return dto;
	}
	
	
	public List<ProductDTO> domainObjectListToDTO(List<Product> products) {
		List<ProductDTO> dtos = new ArrayList<>();
		
		for (Product product : products) {
			dtos.add(this.domainObjectToDTO(product));
		}
		
		return dtos;
	}
}