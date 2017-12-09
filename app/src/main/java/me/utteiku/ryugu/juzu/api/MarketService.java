package me.utteiku.ryugu.juzu.api;

import java.util.List;

import me.utteiku.ryugu.juzu.model.User;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by ryugu on 2017/10/25.
 */

public interface MarketService {
    

    @GET("users/298486374.json")
    Observable<List<User>> users ();

//    @GET("categories.json")
//    Observable<List<Category>> categories ();
//
//    @GET("categories/{category_id}/items.json")
//    Observable<List<Item>> categoryItems ( @Path("category_id") int category_id);
//
//    @GET("items/{id}.json")
//    Observable<Item> item ( @Path("id") int id);

}