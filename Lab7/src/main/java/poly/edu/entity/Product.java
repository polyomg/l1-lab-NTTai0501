package poly.edu.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
	
@Data
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Double price;
    
    @Column(name = "CreateDate")
    @Temporal(TemporalType.DATE)
    private Date createDate;

    private Boolean available = true;

    @ManyToOne	
    @JoinColumn(name = "CategoryId")
    private Category category;
}
