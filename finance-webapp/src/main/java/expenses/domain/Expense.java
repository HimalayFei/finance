package expenses.domain;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Expense {

	@NotNull
	@Size(min = 3)
	private String description;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar expenseDate;

	@Min(0L)
	@NotNull
	@Digits(integer = Integer.MAX_VALUE, fraction = 2)
	private Double ammount;

	@ManyToOne
	private Employee reporter;

	private Boolean approved;

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	public String getDescription() {
        return this.description;
    }

	public void setDescription(String description) {
        this.description = description;
    }

	public Calendar getExpenseDate() {
        return this.expenseDate;
    }

	public void setExpenseDate(Calendar expenseDate) {
        this.expenseDate = expenseDate;
    }

	public Double getAmmount() {
        return this.ammount;
    }

	public void setAmmount(Double ammount) {
        this.ammount = ammount;
    }

	public Employee getReporter() {
        return this.reporter;
    }

	public void setReporter(Employee reporter) {
        this.reporter = reporter;
    }

	public Boolean getApproved() {
        return this.approved;
    }

	public void setApproved(Boolean approved) {
        this.approved = approved;
    }

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
}
