package co.com.doria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpreadsheetResponse implements Serializable {
    private String range;
    private String majorDimension;
    private List<String[]> values;
}
