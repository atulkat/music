package com.example.epaisa.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SongResponse {

        @SerializedName("resultCount")
        @Expose
        private Integer resultCount;
        @SerializedName("results")
        @Expose
        private List<Result> results = null;

        public Integer getResultCount() {
            return resultCount;
        }

        public void setResultCount(Integer resultCount) {
            this.resultCount = resultCount;
        }

        public SongResponse withResultCount(Integer resultCount) {
            this.resultCount = resultCount;
            return this;
        }

        public List<Result> getResults() {
            return results;
        }

        public void setResults(List<Result> results) {
            this.results = results;
        }

        public SongResponse withResults(List<Result> results) {
            this.results = results;
            return this;
        }


    public class Result {

        @SerializedName("wrapperType")
        @Expose
        private String wrapperType;
        @SerializedName("kind")
        @Expose
        private String kind;
        @SerializedName("artistId")
        @Expose
        private Integer artistId;
        @SerializedName("collectionId")
        @Expose
        private Integer collectionId;
        @SerializedName("trackId")
        @Expose
        private Integer trackId;
        @SerializedName("artistName")
        @Expose
        private String artistName;
        @SerializedName("collectionName")
        @Expose
        private String collectionName;
        @SerializedName("trackName")
        @Expose
        private String trackName;
        @SerializedName("collectionCensoredName")
        @Expose
        private String collectionCensoredName;
        @SerializedName("trackCensoredName")
        @Expose
        private String trackCensoredName;
        @SerializedName("artistViewUrl")
        @Expose
        private String artistViewUrl;
        @SerializedName("collectionViewUrl")
        @Expose
        private String collectionViewUrl;
        @SerializedName("trackViewUrl")
        @Expose
        private String trackViewUrl;
        @SerializedName("previewUrl")
        @Expose
        private String previewUrl;
        @SerializedName("artworkUrl30")
        @Expose
        private String artworkUrl30;
        @SerializedName("artworkUrl60")
        @Expose
        private String artworkUrl60;
        @SerializedName("artworkUrl100")
        @Expose
        private String artworkUrl100;
        @SerializedName("collectionPrice")
        @Expose
        private Float collectionPrice;
        @SerializedName("trackPrice")
        @Expose
        private Float trackPrice;
        @SerializedName("releaseDate")
        @Expose
        private String releaseDate;
        @SerializedName("collectionExplicitness")
        @Expose
        private String collectionExplicitness;
        @SerializedName("trackExplicitness")
        @Expose
        private String trackExplicitness;
        @SerializedName("discCount")
        @Expose
        private Integer discCount;
        @SerializedName("discNumber")
        @Expose
        private Integer discNumber;
        @SerializedName("trackCount")
        @Expose
        private Integer trackCount;
        @SerializedName("trackNumber")
        @Expose
        private Integer trackNumber;
        @SerializedName("trackTimeMillis")
        @Expose
        private Integer trackTimeMillis;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("currency")
        @Expose
        private String currency;
        @SerializedName("primaryGenreName")
        @Expose
        private String primaryGenreName;
        @SerializedName("isStreamable")
        @Expose
        private Boolean isStreamable;

        public String getWrapperType() {
            return wrapperType;
        }

        public void setWrapperType(String wrapperType) {
            this.wrapperType = wrapperType;
        }

        public Result withWrapperType(String wrapperType) {
            this.wrapperType = wrapperType;
            return this;
        }

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }

        public Result withKind(String kind) {
            this.kind = kind;
            return this;
        }

        public Integer getArtistId() {
            return artistId;
        }

        public void setArtistId(Integer artistId) {
            this.artistId = artistId;
        }

        public Result withArtistId(Integer artistId) {
            this.artistId = artistId;
            return this;
        }

        public Integer getCollectionId() {
            return collectionId;
        }

        public void setCollectionId(Integer collectionId) {
            this.collectionId = collectionId;
        }

        public Result withCollectionId(Integer collectionId) {
            this.collectionId = collectionId;
            return this;
        }

        public Integer getTrackId() {
            return trackId;
        }

        public void setTrackId(Integer trackId) {
            this.trackId = trackId;
        }

        public Result withTrackId(Integer trackId) {
            this.trackId = trackId;
            return this;
        }

        public String getArtistName() {
            return artistName;
        }

        public void setArtistName(String artistName) {
            this.artistName = artistName;
        }

        public Result withArtistName(String artistName) {
            this.artistName = artistName;
            return this;
        }

        public String getCollectionName() {
            return collectionName;
        }

        public void setCollectionName(String collectionName) {
            this.collectionName = collectionName;
        }

        public Result withCollectionName(String collectionName) {
            this.collectionName = collectionName;
            return this;
        }

        public String getTrackName() {
            return trackName;
        }

        public void setTrackName(String trackName) {
            this.trackName = trackName;
        }

        public Result withTrackName(String trackName) {
            this.trackName = trackName;
            return this;
        }

        public String getCollectionCensoredName() {
            return collectionCensoredName;
        }

        public void setCollectionCensoredName(String collectionCensoredName) {
            this.collectionCensoredName = collectionCensoredName;
        }

        public Result withCollectionCensoredName(String collectionCensoredName) {
            this.collectionCensoredName = collectionCensoredName;
            return this;
        }

        public String getTrackCensoredName() {
            return trackCensoredName;
        }

        public void setTrackCensoredName(String trackCensoredName) {
            this.trackCensoredName = trackCensoredName;
        }

        public Result withTrackCensoredName(String trackCensoredName) {
            this.trackCensoredName = trackCensoredName;
            return this;
        }

        public String getArtistViewUrl() {
            return artistViewUrl;
        }

        public void setArtistViewUrl(String artistViewUrl) {
            this.artistViewUrl = artistViewUrl;
        }

        public Result withArtistViewUrl(String artistViewUrl) {
            this.artistViewUrl = artistViewUrl;
            return this;
        }

        public String getCollectionViewUrl() {
            return collectionViewUrl;
        }

        public void setCollectionViewUrl(String collectionViewUrl) {
            this.collectionViewUrl = collectionViewUrl;
        }

        public Result withCollectionViewUrl(String collectionViewUrl) {
            this.collectionViewUrl = collectionViewUrl;
            return this;
        }

        public String getTrackViewUrl() {
            return trackViewUrl;
        }

        public void setTrackViewUrl(String trackViewUrl) {
            this.trackViewUrl = trackViewUrl;
        }

        public Result withTrackViewUrl(String trackViewUrl) {
            this.trackViewUrl = trackViewUrl;
            return this;
        }

        public String getPreviewUrl() {
            return previewUrl;
        }

        public void setPreviewUrl(String previewUrl) {
            this.previewUrl = previewUrl;
        }

        public Result withPreviewUrl(String previewUrl) {
            this.previewUrl = previewUrl;
            return this;
        }

        public String getArtworkUrl30() {
            return artworkUrl30;
        }

        public void setArtworkUrl30(String artworkUrl30) {
            this.artworkUrl30 = artworkUrl30;
        }

        public Result withArtworkUrl30(String artworkUrl30) {
            this.artworkUrl30 = artworkUrl30;
            return this;
        }

        public String getArtworkUrl60() {
            return artworkUrl60;
        }

        public void setArtworkUrl60(String artworkUrl60) {
            this.artworkUrl60 = artworkUrl60;
        }

        public Result withArtworkUrl60(String artworkUrl60) {
            this.artworkUrl60 = artworkUrl60;
            return this;
        }

        public String getArtworkUrl100() {
            return artworkUrl100;
        }

        public void setArtworkUrl100(String artworkUrl100) {
            this.artworkUrl100 = artworkUrl100;
        }

        public Result withArtworkUrl100(String artworkUrl100) {
            this.artworkUrl100 = artworkUrl100;
            return this;
        }

        public Float getCollectionPrice() {
            return collectionPrice;
        }

        public void setCollectionPrice(Float collectionPrice) {
            this.collectionPrice = collectionPrice;
        }

        public Result withCollectionPrice(Float collectionPrice) {
            this.collectionPrice = collectionPrice;
            return this;
        }

        public Float getTrackPrice() {
            return trackPrice;
        }

        public void setTrackPrice(Float trackPrice) {
            this.trackPrice = trackPrice;
        }

        public Result withTrackPrice(Float trackPrice) {
            this.trackPrice = trackPrice;
            return this;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public Result withReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public String getCollectionExplicitness() {
            return collectionExplicitness;
        }

        public void setCollectionExplicitness(String collectionExplicitness) {
            this.collectionExplicitness = collectionExplicitness;
        }

        public Result withCollectionExplicitness(String collectionExplicitness) {
            this.collectionExplicitness = collectionExplicitness;
            return this;
        }

        public String getTrackExplicitness() {
            return trackExplicitness;
        }

        public void setTrackExplicitness(String trackExplicitness) {
            this.trackExplicitness = trackExplicitness;
        }

        public Result withTrackExplicitness(String trackExplicitness) {
            this.trackExplicitness = trackExplicitness;
            return this;
        }

        public Integer getDiscCount() {
            return discCount;
        }

        public void setDiscCount(Integer discCount) {
            this.discCount = discCount;
        }

        public Result withDiscCount(Integer discCount) {
            this.discCount = discCount;
            return this;
        }

        public Integer getDiscNumber() {
            return discNumber;
        }

        public void setDiscNumber(Integer discNumber) {
            this.discNumber = discNumber;
        }

        public Result withDiscNumber(Integer discNumber) {
            this.discNumber = discNumber;
            return this;
        }

        public Integer getTrackCount() {
            return trackCount;
        }

        public void setTrackCount(Integer trackCount) {
            this.trackCount = trackCount;
        }

        public Result withTrackCount(Integer trackCount) {
            this.trackCount = trackCount;
            return this;
        }

        public Integer getTrackNumber() {
            return trackNumber;
        }

        public void setTrackNumber(Integer trackNumber) {
            this.trackNumber = trackNumber;
        }

        public Result withTrackNumber(Integer trackNumber) {
            this.trackNumber = trackNumber;
            return this;
        }

        public Integer getTrackTimeMillis() {
            return trackTimeMillis;
        }

        public void setTrackTimeMillis(Integer trackTimeMillis) {
            this.trackTimeMillis = trackTimeMillis;
        }

        public Result withTrackTimeMillis(Integer trackTimeMillis) {
            this.trackTimeMillis = trackTimeMillis;
            return this;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public Result withCountry(String country) {
            this.country = country;
            return this;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public Result withCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public String getPrimaryGenreName() {
            return primaryGenreName;
        }

        public void setPrimaryGenreName(String primaryGenreName) {
            this.primaryGenreName = primaryGenreName;
        }

        public Result withPrimaryGenreName(String primaryGenreName) {
            this.primaryGenreName = primaryGenreName;
            return this;
        }

        public Boolean getIsStreamable() {
            return isStreamable;
        }

        public void setIsStreamable(Boolean isStreamable) {
            this.isStreamable = isStreamable;
        }

        public Result withIsStreamable(Boolean isStreamable) {
            this.isStreamable = isStreamable;
            return this;
        }

    }
}
