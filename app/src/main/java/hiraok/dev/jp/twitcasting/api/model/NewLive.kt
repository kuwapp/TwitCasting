package hiraok.dev.jp.twitcasting.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NewLive(@SerializedName("id")
                           @Expose val id: String,
                   @SerializedName("user_id")
                           @Expose val user_id: String,
                   @SerializedName("title")
                           @Expose val title: String,
                   @SerializedName("subtitle")
                           @Expose val subtitle: String,
                   @SerializedName("link")
                           @Expose val is_live: Boolean,
                   @SerializedName("is_recorded")
                           @Expose val is_recorded: Boolean,
                   @SerializedName("comment_count")
                           @Expose val comment_count: Int,
                   @SerializedName("large_thumbnail")
                           @Expose val large_thumbnail: String,
                   @SerializedName("small_thumbnail")
                           @Expose val small_thumbnail: String,
                   @SerializedName("country")
                           @Expose val country: String,
                   @SerializedName("duration")
                           @Expose val duration: Int,
                   @SerializedName("created")
                           @Expose val created: Int,
                   @SerializedName("is_collabo")
                           @Expose val is_collabo: Boolean,
                   @SerializedName("is_protected")
                           @Expose val is_protected: Boolean,
                   @SerializedName("max_view_count")
                           @Expose val max_view_count: Int,
                   @SerializedName("current_view_count")
                           @Expose val current_view_count: Int,
                   @SerializedName("total_view_count")
                           @Expose val total_view_count: Int,
                   @SerializedName("hls_url")
                           @Expose val hls_url: String
) : Serializable