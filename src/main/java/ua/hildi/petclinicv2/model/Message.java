package ua.hildi.petclinicv2.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import java.io.Serial;
import java.util.Calendar;

@Data
@EqualsAndHashCode(callSuper = true)
public class Message extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -4768045909580278883L;

    @Column
    private String messageText;

    @Column
    private String summary;

    private Calendar created = Calendar.getInstance();
}
