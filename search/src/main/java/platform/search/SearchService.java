package platform.search;

import java.util.List;
import org.springframework.stereotype.Service;
import platform.core.Content;

@Service
public class SearchService
{
    public SearchableData createEmptySearchableData(String name)
    {
        SearchableData searchableData = SearchableData.builder()
                        .name(name)
                        .build();
        return searchableData;
    }


    public SearchableData createSearchableData(String name, List<Content> content, SearchConfiguration searchConfiguration, IndexSettings indexSettings)
    {
        SearchableData searchableData = SearchableData.builder()
                        .name(name)
                        .content(content)
                        .searchConfiguration(searchConfiguration)
                        .indexSettings(indexSettings)
                        .build();
        return searchableData;
    }
}
