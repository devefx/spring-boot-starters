package org.devefx.spring.boot.demo.api;

import com.fasterxml.jackson.databind.JsonNode;
import org.devefx.spring.boot.autoconfigure.RetrofitClient;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * GitHubApi
 *
 * @author Yoke
 * @since 1.0
 */
@RetrofitClient(url = "${github.api.host}")
public interface GitHubApi {

    @GET("repos/{owner}/{repo}")
    Call<JsonNode> repo(@Path("owner") String owner, @Path("repo") String repo);

    /**
     * Find repositories via various criteria. This method returns up to 100 results per page.
     *
     * @param query Required. The search keywords, as well as any qualifiers.
     * @param sort The sort field. One of stars, forks, or updated. Default: results are sorted by best match.
     * @param order The sort order if sort parameter is provided. One of asc or desc. Default: desc
     * @return
     */
    @GET("search/repositories")
    Call<JsonNode> searchRepositories(@Query("q") String query, @Query("sort") String sort, @Query("order") String order);

}
