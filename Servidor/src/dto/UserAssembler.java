package dto;

import domain.User;

//This class is part of the DTO pattern. It also implements Singleton Pattern.
public class UserAssembler {
	private static UserAssembler instance;

	private UserAssembler() { }
	
	public static UserAssembler getInstance() {
		if (instance == null) {
			instance = new UserAssembler();
		}

		return instance;
	}

	public UserDTO userToDTO(User user) {
		UserDTO dto = new UserDTO();
		
		dto.setEmail(user.getEmail());
		dto.setNickname(user.getNickname());
		dto.setAltura(user.getAltura());
		dto.setfCardiacaMaxima(user.getfCardiacaMaxima());
		dto.setfCardiacaReposo(user.getfCardiacaReposo());
		dto.setfNac(user.getfNac());
		dto.setPeso(user.getPeso());
		
		return dto;
	}
}