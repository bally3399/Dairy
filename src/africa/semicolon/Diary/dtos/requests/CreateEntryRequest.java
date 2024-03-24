package africa.semicolon.Diary.dtos.requests;

import lombok.Data;

@Data
public class CreateEntryRequest {
    public String title;
    public String body;
    public String author;

}
