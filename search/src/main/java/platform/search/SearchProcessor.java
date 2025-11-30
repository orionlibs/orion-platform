package platform.search;

import org.springframework.stereotype.Component;

@Component
public class SearchProcessor
{
    public SearchResponse search(SearchConfiguration configuration, SearchRequest searchRequest)
    {
        return SearchResponse.builder().build();
    }
}
