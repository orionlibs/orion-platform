package platform.search;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import platform.core.Content;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SearchableData
{
    private String name;
    private List<Content> content;
    private SearchConfiguration searchConfiguration;
    private IndexSettings indexSettings;
}
