package models;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "employees")
@NamedQueries({ @NamedQuery(name = "getAllEmployees", query = "SELECT e FROM Employee AS e ORDER BY e.id DESC"),
        @NamedQuery(name = "getEmployeesCount", query = "SELECT COUNT(e) FROM Employee AS e"),
        @NamedQuery(name = "checkRegisteredCode", query = "SELECT COUNT(e) FROM Employee AS e WHERE e.code = :code"),
        @NamedQuery(name = "checkLoginCodeAndPassword", query = "SELECT e FROM Employee AS e WHERE e.delete_flag = 0 AND e.code = :code AND e.password = :pass") })
@Entity
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", length = 64, nullable = false)
    private String password;

    @Column(name = "admin_flag", nullable = false)
    private Integer admin_flag;

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;

    @Column(name = "delete_flag", nullable = false)
    private Integer delete_flag;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="favorites", joinColumns = @JoinColumn( name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name="report_id"))
    /*@JoinTable            所有者側のエンティティに記載するアノテーション
     * (name="favorites",   結合するテーブル名？（今回は中間テーブル）
     * joinColumns = @JoinColumn( name = "employee_id"),  所有者側のエンティティに対応する中間テーブルの外部キー
     * inverseJoinColumns = @JoinColumn(name="report_id")) 非所有者側のエンティティに対応する中間テーブルの外部キー
     * */
    private List<Report> my_favorite_report_list;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Report> getMy_favorite_report_list() {
        return my_favorite_report_list;
    }

    public void setMy_favorite_report_list(List<Report> my_favorite_report_list) {
        this.my_favorite_report_list = my_favorite_report_list;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAdmin_flag() {
        return admin_flag;
    }

    public void setAdmin_flag(Integer admin_flag) {
        this.admin_flag = admin_flag;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public Integer getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(Integer delete_flag) {
        this.delete_flag = delete_flag;
    }
}
