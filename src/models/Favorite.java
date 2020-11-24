package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "favorites")
@NamedQueries({
        @NamedQuery(name = "getFavoritesOfAttention",
                query = "SELECT f FROM Favorite AS f WHERE f.employee=:employee AND f.report=:report"),
        //いいねの件数をカウントする
        @NamedQuery(name = "getFavoritesCount",
                query = "SELECT COUNT(f) FROM Favorite AS f WHERE f.report=:report"),
        //日報にいいねした人を表示する
        /*@NamedQuery(name="getFavoritesNames",
                query="SELECT f FROM Favorite AS f WHERE f.report=:report"),*/
        @NamedQuery(name = "getFavoritesOfAttension",
        query = "SELECT f FROM Favorite AS f WHERE f.employee=:employee AND f.report=:report")
})

@Entity
public class Favorite {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Employeeモデルと多対1で結びつく
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    // Reportモデルと多対1で結びつく
    @ManyToOne
    @JoinColumn(name = "report_id", nullable = false)
    private Report report;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

}
