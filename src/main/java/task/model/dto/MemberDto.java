package task.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString @Builder
public class MemberDto {
    private int vno;
    private String vphone;
    private int vcount;
}
