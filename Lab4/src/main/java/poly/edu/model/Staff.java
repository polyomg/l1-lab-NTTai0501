package poly.edu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Staff {
    private String id;
    private String fullname;

    @Builder.Default
    private String photo = "photo.jpg";

    private Boolean gender;

    @Builder.Default
    @DateTimeFormat(pattern = "yyyy-MM-dd")   // chuẩn với input type="date"
    private Date birthday = new Date();

    @Builder.Default
    private double salary = 12345.6789;

    @Builder.Default
    private Integer level = 0;
}
