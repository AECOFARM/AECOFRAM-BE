package dgu.aecofarm.dto.member;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class SignupRequestDTO {
    private String email;
    private String userName;
    private String password;
    private String phone;
    private Integer schoolNum;
}
