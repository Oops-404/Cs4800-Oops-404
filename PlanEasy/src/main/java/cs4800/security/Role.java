package cs4800.security;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "role")
public class Role {
	
	//Id number of the security role
	@Id
	@Field(value = "roleId")
	private String roleId;
	
	//Name of the security role
	@Field(value = "role")
	private String role;
	
	public Role() {
		this.role = "USER";
		this.roleId = "1";
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

}
