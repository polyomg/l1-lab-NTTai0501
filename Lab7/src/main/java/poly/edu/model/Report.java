package poly.edu.model;

import java.io.Serializable;

public interface Report extends Serializable {
    String getGroup();
    Double getSum();
    Long getCount();
}
	