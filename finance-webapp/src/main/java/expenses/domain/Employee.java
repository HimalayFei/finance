package expenses.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Employee implements Serializable {

	@NotNull
	@Size(min = 3)
	private String firstName;

	@NotNull
	@Size(min = 3)
	private String lastName;

	@NotNull
	@Column(unique = true)
	@Size(min = 3)
	private String username;

	@NotNull
	@Size(min = 3)
	@JsonIgnore
	private String password;

	@ManyToOne
	private expenses.domain.Employee supervisor;

	@JsonIgnore
	public boolean isSupervisor() {
		return supervisor == null;
	}

	private static final long serialVersionUID = -7243832286546823896L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

	@Version
    @Column(name = "version")
    private Integer version;

	public Long getId() {
        return this.id;
    }

	public void setId(Long id) {
        this.id = id;
    }

	public Integer getVersion() {
        return this.version;
    }

	public void setVersion(Integer version) {
        this.version = version;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	public String getFirstName() {
        return this.firstName;
    }

	public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

	public String getLastName() {
        return this.lastName;
    }

	public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	public String getUsername() {
        return this.username;
    }

	public void setUsername(String username) {
        this.username = username;
    }

	public String getPassword() {
        return this.password;
    }

	public void setPassword(String password) {
        this.password = password;
    }

	public Employee getSupervisor() {
        return this.supervisor;
    }

	public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }
}
